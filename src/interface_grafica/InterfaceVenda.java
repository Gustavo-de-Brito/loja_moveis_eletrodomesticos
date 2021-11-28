package interface_grafica;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleDados;
import controle.ControleEstoque;
import controle.ControleVenda;
import modelos.Cliente;
import modelos.Produto;
import modelos.Vendedor;

public class InterfaceVenda implements ListSelectionListener, ActionListener {
	private ControleDados controleDados;
	private ControleVenda controleVenda;
	private int index, indexProduto, indexCliente, indexVendedor;
	private static JFrame janela;
	private static JList<Object> vendas;
	private static JList<Object> produtosDisponiveis, clientesCadastrados, vendedoresCadastrados;
	private static JButton escolherCadastrar, voltarPrincipal, cadastrar;
	private static JButton atualizar, excluir, voltar, cancelar;
	private JLabel titulo, tituloProduto, tituloCliente, tituloVendedor;
	private Font fonteTexto, fonteTitulo,fonteButao, fonteField;
	private JPanel painel, painelProduto, painelCliente, painelVendedor;
	private ArrayList<String> dadosAtualizados;
	private JScrollPane scroll, scrollProduto, scrollCliente, scrollVendedor;
	private JTextField informacaoProduto, informacaoPreco, informacaoCliente, informacaoVendedor, informacaoQtdVendida;
	
	public InterfaceVenda(ControleDados controleDados) {
		this.controleDados = controleDados;
		this.controleVenda = new ControleVenda(controleDados);
		
		
		fonteTexto = new Font("Helvetica", Font.PLAIN, 16);
		fonteButao = new Font("Helvetica", Font.BOLD, 16);
		fonteTitulo = new Font("Helvetica", Font.BOLD, 30);
		janela = new JFrame("Estoque");
		vendas = new JList<Object>(this.controleVenda.mostraHistoricoVendas().toArray());
		titulo = new JLabel("Histórico de Vendas", JLabel.CENTER);
		escolherCadastrar = new JButton("Cadastrar Nova Venda");
		voltarPrincipal = new JButton("Voltar");
		scroll = new JScrollPane();
		
		
		titulo.setBounds(50, 10, 700, 80);
		titulo.setFont(fonteTitulo);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		vendas.setBounds(50, 90, 700, 270);
		vendas.setFont(fonteTexto);
		vendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vendas.addListSelectionListener(this);
		escolherCadastrar.setBounds(95, 380, 300, 50);
		voltarPrincipal.setBounds(405, 380, 300, 50);
		escolherCadastrar.setFont(fonteButao);
		voltarPrincipal.setFont(fonteButao);
		scroll.setViewportView(vendas);
        scroll.setBounds(50, 90, 700, 270);
		
		
		janela.add(scroll);
		janela.add(titulo);
		janela.add(escolherCadastrar);
		janela.add(voltarPrincipal);
		
		janela.setSize(800, 500);
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		voltarPrincipal.addActionListener(this);
		escolherCadastrar.addActionListener(this);
		
	}
	
	public void cadastraVenda() {
	
		ArrayList<String> especificacoesVenda = new ArrayList<String>();
		String dadosBrutos = this.controleVenda.getHistoricoVendas().get(index).toString();
		
		int indexInicial = 0;
		boolean haInformacoes = true;
		int indexFinalEspecificacao;
		int indexFinalInformacao;
		
		
		while(haInformacoes) {
			
			if(dadosBrutos.indexOf("\n", indexInicial + 1) == -1) {
				haInformacoes = false;
			}
			
			indexFinalEspecificacao = dadosBrutos.indexOf(":", indexInicial);
			if (haInformacoes) {
				indexFinalInformacao = dadosBrutos.indexOf("\n", indexInicial);
	
			} else {
				indexFinalInformacao = dadosBrutos.length();
			}
			
			
			String especificacao = dadosBrutos.substring(indexInicial, indexFinalEspecificacao);
			
			especificacoesVenda.add(especificacao);
			
			indexInicial = indexFinalInformacao + 1;
			
						
		}
		
		ArrayList<String> tiposProduto = new ArrayList<String>();
		ArrayList<String> informacoesClientes = new ArrayList<String>();
		ArrayList<String> informacoesVendedores = new ArrayList<String>();
		
		ArrayList<Produto> produtos;
		ArrayList<Cliente> clientes;
		ArrayList<Vendedor> vendedores;
		
		produtos = controleVenda.getControleEstoque().getEstoque().getProdutos();
		clientes = controleVenda.getControleCliente().getClientes();
		vendedores = controleVenda.getControleVendedor().getVendedores();
		
		for(Produto produto : produtos) {
			tiposProduto.add(produto.getCategoria() + ": " + produto.getNome());
			
		}
		
		String clienteExibicao;
		
		for(Cliente cliente : clientes) {
			clienteExibicao = "<html>Nome: " + cliente.getNome() + "<br>CPF: " + cliente.getCpf();
			informacoesClientes.add(clienteExibicao);
			
		}
		
		for(Vendedor vendedor : vendedores) {
			informacoesVendedores.add(vendedor.getNome());
			
		}
		
		produtosDisponiveis = new JList<Object>(tiposProduto.toArray());
		clientesCadastrados = new JList<Object>(informacoesClientes.toArray());
		vendedoresCadastrados = new JList<Object>(informacoesVendedores.toArray());
		
		tituloProduto = new JLabel("Escolha um Produto");
		tituloCliente = new JLabel("Escolha um Cliente");
		tituloVendedor = new JLabel("Escolha um Vendedor");
		
		scrollProduto = new JScrollPane();
		scrollCliente = new JScrollPane();
		scrollVendedor = new JScrollPane();
		
		tituloProduto.setBounds(250, 10, 700, 80);
		tituloProduto.setFont(fonteTitulo);
		tituloProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		produtosDisponiveis.setBounds(50, 90, 700, 270);
		produtosDisponiveis.setFont(fonteTexto);
		produtosDisponiveis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		produtosDisponiveis.addListSelectionListener(this);
		tituloCliente.setBounds(250, 10, 700, 80);
		tituloCliente.setFont(fonteTitulo);
		tituloCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		clientesCadastrados.setBounds(50, 90, 700, 270);
		clientesCadastrados.setFont(fonteTexto);
		clientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clientesCadastrados.addListSelectionListener(this);
		tituloVendedor.setBounds(250, 10, 700, 80);
		tituloVendedor.setFont(fonteTitulo);
		tituloVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		vendedoresCadastrados.setBounds(50, 90, 700, 270);
		vendedoresCadastrados.setFont(fonteTexto);
		vendedoresCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vendedoresCadastrados.addListSelectionListener(this);
		
		
		painelProduto = new JPanel();
		painelCliente = new JPanel();
		painelVendedor = new JPanel();
		
		painelProduto.setSize(800, 500);
		painelProduto.setLayout(null);
		painelCliente.setSize(800, 500);
		painelCliente.setLayout(null);
		painelVendedor.setSize(800, 500);
		painelVendedor.setLayout(null);
		
		scrollProduto.setViewportView(produtosDisponiveis);
		scrollProduto.setBounds(50, 90, 700, 270);
		scrollCliente.setViewportView(clientesCadastrados);
		scrollCliente.setBounds(50, 90, 700, 270);
		scrollVendedor.setViewportView(vendedoresCadastrados);
		scrollVendedor.setBounds(50, 90, 700, 270);
		
		int distanciaEsquerda = 50;
		
		janela = new JFrame("Cadastro Nova Venda");
		
		
		fonteTexto = new Font("Helvetica", Font.BOLD, 16);
		fonteField = new Font("Helvetica", Font.PLAIN, 14);
		
		painel = new JPanel();
		
		painel.setSize(800, 500);
		painel.setLayout(null);
		
		JLabel produto = new JLabel("Produto");
		JLabel preco = new JLabel("Preço");
		JLabel cliente = new JLabel("Cliente");
		JLabel vendedor = new JLabel("Vendedor");
		JLabel qtdVendida = new JLabel("Quantidade vendida");
		
		produto.setBounds(distanciaEsquerda, 20, 200, 40);
		produto.setFont(fonteTexto);
		preco.setBounds(distanciaEsquerda, 70, 200, 40);
		preco.setFont(fonteTexto);
		cliente.setBounds(distanciaEsquerda, 120, 200, 40);
		cliente.setFont(fonteTexto);
		vendedor.setBounds(distanciaEsquerda, 170, 200, 40);
		vendedor.setFont(fonteTexto);
		qtdVendida.setBounds(distanciaEsquerda, 220, 200, 40);
		qtdVendida.setFont(fonteTexto);
		
		informacaoQtdVendida = new JTextField("");

		informacaoQtdVendida.setBounds(distanciaEsquerda + 220, 220, 480, 40);
		informacaoQtdVendida.setFont(fonteField);
		
		painel.add(produto);
		painel.add(preco);
		painel.add(cliente);
		painel.add(vendedor);
		painel.add(qtdVendida);
		painel.add(informacaoQtdVendida);
		
		cadastrar = new JButton("Cadastar");
		cadastrar.setBounds(100, 380, 200, 50);
		cadastrar.setFont(fonteButao);
		painel.add(cadastrar);
		cancelar = new JButton("Cancelar");
		cancelar.setBounds(500, 380, 200, 50);
		cancelar.setFont(fonteButao);
		
		painel.setPreferredSize(new Dimension(800, 390 + 80));
		scroll = new JScrollPane();
		scroll.setViewportView(painel);
        scroll.setSize(800, 390 + 80);
        scroll.setVisible(true);

		painelProduto.add(tituloProduto);
		painelCliente.add(tituloCliente);
		painelVendedor.add(tituloVendedor);
		
		painelProduto.add(scrollProduto);
		painelCliente.add(scrollCliente);
		painelVendedor.add(scrollVendedor);
		
		janela.add(cancelar);
		janela.add(painelProduto);
		janela.add(painelCliente);
		janela.add(painelVendedor);
		janela.add(scroll);
		janela.setSize(800, 500);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		cancelar.addActionListener(this);
		cadastrar.addActionListener(this);
		
	}
	
	public void vizualizarVenda(int index) {
		this.index = index;
		
		ArrayList<String> especificacoesVenda = new ArrayList<String>();
		ArrayList<String> informacoesVenda = new ArrayList<String>();
		String dadosBrutos = this.controleVenda.getHistoricoVendas().get(index).toString();
		int indexInicial = 0;
		boolean haInformacoes = true;
		int indexFinalEspecificacao;
		int indexFinalInformacao;
		
		
		while(haInformacoes) {
			
			if(dadosBrutos.indexOf("\n", indexInicial + 1) == -1) {
				haInformacoes = false;
			}
			indexFinalEspecificacao = dadosBrutos.indexOf(":", indexInicial);
			if (haInformacoes) {
				indexFinalInformacao = dadosBrutos.indexOf("\n", indexInicial);
	
			} else {
				indexFinalInformacao = dadosBrutos.length();
			}
			
			
			String especificacao = dadosBrutos.substring(indexInicial, indexFinalEspecificacao);
			String informacao = dadosBrutos.substring(indexFinalEspecificacao + 1, indexFinalInformacao).trim();
			
			informacoesVenda.add(informacao);
			especificacoesVenda.add(especificacao);
			
			indexInicial = indexFinalInformacao + 1;
			
						
		}
		
		
		painel = new JPanel();
		atualizar = new JButton("Atualizar");
		voltar = new JButton("Voltar");
		
		painel.setSize(800, 500);
		painel.setLayout(null);
		int distanciaTopo = 20;
		int distanciaEsquerda = 50;
		
		janela = new JFrame(informacoesVenda.get(0));
		fonteTexto = new Font("Helvetica", Font.BOLD, 16);
		fonteField = new Font("Helvetica", Font.PLAIN, 14);
	
		
		for(int i = 0; i < especificacoesVenda.size(); i++) {
			JLabel especificacao = new JLabel(especificacoesVenda.get(i));
			JTextField informacao = new JTextField(informacoesVenda.get(i));
			
			informacao.setBounds(distanciaEsquerda + 210, distanciaTopo, 480, 40);
			informacao.setFont(fonteField);
			especificacao.setBounds(distanciaEsquerda, distanciaTopo, 200, 40);
			especificacao.setFont(fonteTexto);
			
			painel.add(informacao);
			painel.add(especificacao);
			
			distanciaTopo += 60;
			
			
		}
		
		
		atualizar.setBounds(150, distanciaTopo, 200, 50);
		voltar.setBounds(450, distanciaTopo, 200, 50);
		painel.add(atualizar);
		painel.add(voltar);
		
		painel.setPreferredSize(new Dimension(800, distanciaTopo + 70));
		scroll = new JScrollPane();
		scroll.setViewportView(painel);
        scroll.setSize(800, distanciaTopo + 70);
        scroll.setVisible(true);
		
		janela.add(scroll);
		janela.setSize(800, 500);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		atualizar.addActionListener(this);
		voltar.addActionListener(this);
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == vendas) {
			this.vizualizarVenda(vendas.getSelectedIndex());		

		} else if(e.getValueIsAdjusting() && src == produtosDisponiveis) {
			this.indexProduto = produtosDisponiveis.getSelectedIndex();
			Produto produtoVenda = this.controleVenda.getControleEstoque().getEstoque().selecionarProduto(index);
			
			
			this.informacaoProduto = new JTextField(produtoVenda.getNome());
			this.informacaoPreco = new JTextField(produtoVenda.getPreco());
			
			informacaoProduto.setBounds(270, 20, 480, 40);
			informacaoProduto.setFont(fonteField);
			this.painel.add(this.informacaoProduto);
			informacaoPreco.setBounds(270, 70, 480, 40);
			informacaoPreco.setFont(fonteField);
			this.painel.add(this.informacaoPreco);
			
			this.painelProduto.setVisible(false);
			this.painelCliente.setVisible(true);
			
			
		} else if(e.getValueIsAdjusting() && src == clientesCadastrados) {
			this.indexCliente = clientesCadastrados.getSelectedIndex();
			Cliente clienteVenda = this.controleVenda.getControleCliente().getClientes().get(index);
			
			this.informacaoCliente = new JTextField(clienteVenda.getNome());
			informacaoCliente.setBounds(270, 120, 480, 40);
			informacaoCliente.setFont(fonteField);
			this.painel.add(this.informacaoCliente);
			
			this.painelCliente.setVisible(false);
			this.painelVendedor.setVisible(true);
			
			
		}  else if(e.getValueIsAdjusting() && src == vendedoresCadastrados) {
			this.indexVendedor = vendedoresCadastrados.getSelectedIndex();
			Vendedor vendedorVenda = this.controleVenda.getControleVendedor().getVendedores().get(index);
			
			this.informacaoVendedor = new JTextField(vendedorVenda.getNome());
			informacaoVendedor.setBounds(270, 170, 480, 40);
			informacaoVendedor.setFont(fonteField);
			this.painel.add(this.informacaoVendedor);
			
			this.painelVendedor.setVisible(false);
			this.scroll.setVisible(true);
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == atualizar) {
			Component[] c = painel.getComponents();
			dadosAtualizados = new ArrayList<String>();
			boolean dadosValidos = true;
			
			for(Component a : c) {
				if(a instanceof JTextField) {
					String conteudoTextField = ((JTextField) a).getText();
					if(conteudoTextField != null && conteudoTextField != "") {
						dadosAtualizados.add(conteudoTextField);
						
					} else {
						JOptionPane.showMessageDialog(null, "Todos os campos devem ser preechidos");
						dadosValidos = false;
						
					}
					
				}
			}
			
			if(dadosValidos) {
				new ControleVenda(this.controleDados).alteraInformacoesVenda(dadosAtualizados, index);				
				
			}
			
			
		} else if(src == excluir) {
			new ControleEstoque(this.controleDados).getEstoque().excluirProduto(index);
			
		} else if(src == voltar) {
			new InterfaceVenda(this.controleDados);
			
		} else if(src == voltarPrincipal) {
			new InterfacePrincipal(this.controleDados);
			
		} else if(src == escolherCadastrar) {
			this.cadastraVenda();
			this.scroll.setVisible(false);
			
		} else if(src == cancelar) {
			new InterfaceVenda(controleDados);
					
		} else if(src == cadastrar) {
			try {
				ArrayList<String> novasInformacoes = new ArrayList<String>();
				novasInformacoes.add(Integer.toString(this.indexProduto));
				novasInformacoes.add(Integer.toString(this.indexCliente));
				novasInformacoes.add(Integer.toString(this.indexVendedor));
				novasInformacoes.add(this.informacaoQtdVendida.getText());
				
				new ControleVenda(this.controleDados).cadastraVenda(novasInformacoes);
				new InterfaceVenda(this.controleDados);
								
			} catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro", "Algum(ns) do(s) valor(es) numérico(s) informado(s) é(são) "
						+ "inválido(s)", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		
	}
	
}
