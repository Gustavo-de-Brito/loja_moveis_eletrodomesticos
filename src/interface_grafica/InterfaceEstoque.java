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
import modelos.Produto;

public final class InterfaceEstoque implements ListSelectionListener, ActionListener {
	private ControleEstoque controleEstoque;
	private ControleDados controleDados;
	private int index;
	private static JFrame janela;
	private static JList<Object> produtos; 
	private static JList<String> produtoUnicoPesquisa;
	private static JList<String> categoriasProdutos;
	private static JButton escolherCadastrar, voltarPrincipal, cadastrar;
	private static JButton pesquisaNome, pesquisaId, pesquisaPreco;
	private static JButton atualizar, excluir, voltar, cancelar;
	private JLabel titulo, tituloSelecao, pesquisa, orientacaoPesquisa;
	private JTextField selecaoPesquisa;
	private Font fonteTexto, fonteTitulo,fonteBotao, fonteField;
	private JPanel painel, painelSecundario;
	private ArrayList<String> dadosAtualizados;
	private JScrollPane scroll;
	String[] categorias = {"Geladeira", "Ar condicionado", "Cama", "Coifa e Depurador de Ar", "Fogão", "Guarda Roupa",
			"Lavadora de Roupa", "Micro-ondas", "Sofá"};
	
	public InterfaceEstoque(ControleDados controleDados, int indexPesquisa, ArrayList<Produto> produtosPesquisa) {
		this.controleEstoque = new ControleEstoque(controleDados);
		this.controleDados = controleDados;
		
		fonteTexto = new Font("Helvetica", Font.PLAIN, 16);
		fonteBotao = new Font("Helvetica", Font.BOLD, 16);
		fonteTitulo = new Font("Helvetica", Font.BOLD, 30);
		Font fontePesquisa = new Font("Helvetica", Font.BOLD, 20);
		janela = new JFrame("Estoque");
		scroll = new JScrollPane();
		
		if(indexPesquisa != -1) {
			String[] produtoEscolhido = {controleEstoque.getEstoque().selecionarProduto(indexPesquisa).toString()};
			
			produtoUnicoPesquisa = new JList<String>(produtoEscolhido);
			
			produtoUnicoPesquisa.setBounds(50, 90, 500, 270);
			produtoUnicoPesquisa.setFont(fonteTexto);
			produtoUnicoPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			produtoUnicoPesquisa.addListSelectionListener(this);
			
			scroll.setViewportView(produtoUnicoPesquisa);
	        scroll.setBounds(30, 90, 500, 270);			
			
		} else if(produtosPesquisa != null) {
			produtos = new JList<Object>(produtosPesquisa.toArray());
			
			produtos.setBounds(50, 90, 500, 270);
			produtos.setFont(fonteTexto);
			produtos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			produtos.addListSelectionListener(this);
		
			scroll.setViewportView(produtos);
	        scroll.setBounds(30, 90, 500, 270);
	        
			
		} else {
			produtos = new JList<Object>(controleEstoque.getEstoque().leProdutosEmEstoque().toArray());			
			
			produtos.setBounds(50, 90, 500, 270);
			produtos.setFont(fonteTexto);
			produtos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			produtos.addListSelectionListener(this);
		
			scroll.setViewportView(produtos);
	        scroll.setBounds(30, 90, 500, 270);
	        
		}

		titulo = new JLabel("Produtos em Estoque", JLabel.CENTER);
		escolherCadastrar = new JButton("Cadastrar Novo Produto");
		voltarPrincipal = new JButton("Voltar");
		pesquisa = new JLabel("Pesquisar Produto");
		selecaoPesquisa = new JTextField("");
		orientacaoPesquisa = new JLabel("Pesquisar por:");
		pesquisaNome = new JButton("Nome");
		pesquisaId = new JButton("ID");
		pesquisaPreco = new JButton("Faixa de Preço");
		
		tituloSelecao = new JLabel("Escolha a categoria que deseja cadastrar o seu produto");
		painelSecundario = new JPanel();
		painelSecundario.setSize(800, 500);
		painelSecundario.setLayout(null);
		
		categoriasProdutos = new JList<String>(categorias);
		categoriasProdutos.setBounds(50, 90, 700, 270);
		categoriasProdutos.setFont(fonteTexto);
		categoriasProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoriasProdutos.addListSelectionListener(this);
		tituloSelecao.setBounds(30, 20, 750, 50);
		tituloSelecao.setFont(fonteTitulo);
		pesquisa.setBounds(580, 70, 200, 50);
		pesquisa.setFont(fontePesquisa);
		selecaoPesquisa.setBounds(580, 120, 180, 30);
		selecaoPesquisa.setFont(fonteTexto);
		orientacaoPesquisa.setBounds(580, 190, 150, 30);
		orientacaoPesquisa.setFont(fonteBotao);
		pesquisaNome.setBounds(580, 230, 150, 30);
		pesquisaNome.setFont(fonteBotao);
		pesquisaId.setBounds(580, 270, 150, 30);
		pesquisaId.setFont(fonteBotao);
		pesquisaPreco.setBounds(580, 310, 150, 30);
		pesquisaPreco.setFont(fonteBotao);
		
		painelSecundario.add(tituloSelecao);
		painelSecundario.add(categoriasProdutos);
		
		painelSecundario.setVisible(false);
		
		janela.add(painelSecundario);
		
		
		titulo.setBounds(50, 10, 500, 80);
		titulo.setFont(fonteTitulo);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		escolherCadastrar.setBounds(30, 380, 250, 50);
		voltarPrincipal.setBounds(330, 380, 200, 50);
		escolherCadastrar.setFont(fonteBotao);
		voltarPrincipal.setFont(fonteBotao);
		
		janela.add(pesquisa);
		janela.add(selecaoPesquisa);
		janela.add(orientacaoPesquisa);
		janela.add(pesquisaNome);
		janela.add(pesquisaId);
		janela.add(pesquisaPreco);
		janela.add(scroll);
		janela.add(titulo);
		janela.add(escolherCadastrar);
		janela.add(voltarPrincipal);
		
		janela.setSize(800, 500);
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		pesquisaNome.addActionListener(this);
		pesquisaId.addActionListener(this);
		pesquisaPreco.addActionListener(this);
		voltarPrincipal.addActionListener(this);
		escolherCadastrar.addActionListener(this);
		
	}
	
	public void cadastrarProduto(String tipo) {
		String dadosBrutos = "";
		ArrayList<Produto> produtos;
		ArrayList<String> especificacoesProduto = new ArrayList<String>();
		
		produtos = this.controleEstoque.getEstoque().getProdutos();
		
		for(Produto produto : produtos) {	
			if(produto.getCategoria() == tipo) {
				dadosBrutos = this.controleEstoque.getEstoque().selecionarProduto(produtos.indexOf(produto)).ler();
				break;
				
			}
			
		}
		
		
		int indexInicial = 0;
		boolean haInformacoes = true;
		int indexFinalEspecificacao;
		int indexFinalInformacao;
		
		
		while(haInformacoes) {
			
			if(dadosBrutos.indexOf("<br>", indexInicial + 4) == -1) {
				haInformacoes = false;
			}
			
			indexFinalEspecificacao = dadosBrutos.indexOf(":", indexInicial);
			if (haInformacoes) {
				indexFinalInformacao = dadosBrutos.indexOf("<br>", indexInicial);
	
			} else {
				indexFinalInformacao = dadosBrutos.length();
			}
			
			
			String especificacao = dadosBrutos.substring(indexInicial, indexFinalEspecificacao);
			
			especificacoesProduto.add(especificacao);
			
			indexInicial = indexFinalInformacao + 4;
			
						
		}
		
		
		painel = new JPanel();
		cadastrar = new JButton("Cadastar");
		cancelar = new JButton("Cancelar");
		
		painel.setSize(800, 500);
		painel.setLayout(null);
		int distanciaTopo = 20;
		int distanciaEsquerda = 50;
		
		janela = new JFrame("Cadastro Novo Produto");
		
		
		fonteTexto = new Font("Helvetica", Font.BOLD, 16);
		fonteField = new Font("Helvetica", Font.PLAIN, 14);
	
		JLabel especificacao;
		JTextField informacao;
		
		for(int i = 0; i < especificacoesProduto.size(); i++) {
			especificacao = new JLabel(especificacoesProduto.get(i));
			informacao = new JTextField("");
			
			informacao.setBounds(distanciaEsquerda + 210, distanciaTopo, 480, 40);
			informacao.setFont(fonteField);
			especificacao.setBounds(distanciaEsquerda, distanciaTopo, 200, 40);
			especificacao.setFont(fonteTexto);
			
			painel.add(informacao);
			painel.add(especificacao);
			
			distanciaTopo += 60;
			
			
		}
		
		especificacao = new JLabel("Quantidade em Estoque");
		informacao = new JTextField("");
		
		informacao.setBounds(distanciaEsquerda + 210, distanciaTopo, 480, 40);
		informacao.setFont(fonteField);
		especificacao.setBounds(distanciaEsquerda, distanciaTopo, 200, 40);
		especificacao.setFont(fonteTexto);
		
		distanciaTopo += 60;
		
		painel.add(especificacao);
		painel.add(informacao);
		
		cadastrar.setFont(fonteBotao);
		cancelar.setFont(fonteBotao);
		cadastrar.setBounds(150, distanciaTopo + 20, 200, 50);
		cancelar.setBounds(450, distanciaTopo + 20, 200, 50);
		painel.add(cadastrar);
		painel.add(cancelar);
		
		painel.setPreferredSize(new Dimension(800, distanciaTopo + 80));
		scroll = new JScrollPane();
		scroll.setViewportView(painel);
        scroll.setSize(800, distanciaTopo + 80);
        scroll.setVisible(true);
		
		janela.add(scroll);
		janela.setSize(800, 500);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		cadastrar.addActionListener(this);
		cancelar.addActionListener(this);
		
	}
	
	public void vizualizarProduto(int index) {
		this.index = index;
		
		ArrayList<String> especificacoesProduto = new ArrayList<String>();
		ArrayList<String> informacoesProduto = new ArrayList<String>();
		String dadosBrutos = controleEstoque.getEstoque().selecionarProduto(index).ler();
		int indexInicial = 0;
		boolean haInformacoes = true;
		int indexFinalEspecificacao;
		int indexFinalInformacao;
		
		
		while(haInformacoes) {
			
			if(dadosBrutos.indexOf("<br>", indexInicial + 4) == -1) {
				haInformacoes = false;
			}
			indexFinalEspecificacao = dadosBrutos.indexOf(":", indexInicial);
			if (haInformacoes) {
				indexFinalInformacao = dadosBrutos.indexOf("<br>", indexInicial);
	
			} else {
				indexFinalInformacao = dadosBrutos.length();
			}
			
			
			String especificacao = dadosBrutos.substring(indexInicial, indexFinalEspecificacao);
			String informacao = dadosBrutos.substring(indexFinalEspecificacao + 1, indexFinalInformacao).trim();
			
			informacoesProduto.add(informacao.replace("<html>", ""));
			especificacoesProduto.add(especificacao);
			
			indexInicial = indexFinalInformacao + 4;
			
						
		}
		
		
		painel = new JPanel();
		atualizar = new JButton("Atualizar");
		excluir = new JButton("Excluir");
		voltar = new JButton("Voltar");
		
		painel.setSize(800, 500);
		painel.setLayout(null);
		int distanciaTopo = 20;
		int distanciaEsquerda = 50;
		
		janela = new JFrame(informacoesProduto.get(0));
		fonteTexto = new Font("Helvetica", Font.BOLD, 16);
		fonteField = new Font("Helvetica", Font.PLAIN, 14);
	
		
		for(int i = 0; i < especificacoesProduto.size(); i++) {
			JLabel especificacao = new JLabel(especificacoesProduto.get(i));
			JTextField informacao = new JTextField(informacoesProduto.get(i));
			
			informacao.setBounds(distanciaEsquerda + 210, distanciaTopo, 480, 40);
			informacao.setFont(fonteField);
			especificacao.setBounds(distanciaEsquerda, distanciaTopo, 200, 40);
			especificacao.setFont(fonteTexto);
			
			painel.add(informacao);
			painel.add(especificacao);
			
			distanciaTopo += 60;
			
			
		}
		
		
		atualizar.setBounds(85, distanciaTopo, 200, 50);
		excluir.setBounds(295, distanciaTopo, 200, 50);
		voltar.setBounds(505, distanciaTopo, 200, 50);
		painel.add(atualizar);
		painel.add(excluir);
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
		excluir.addActionListener(this);
		voltar.addActionListener(this);
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == produtos) {
			this.vizualizarProduto(produtos.getSelectedIndex());		

		} else if(e.getValueIsAdjusting() && src == categoriasProdutos) {
			int index = categoriasProdutos.getSelectedIndex();
			this.cadastrarProduto(this.categorias[index]);
			
		} else if(e.getValueIsAdjusting() && src == produtoUnicoPesquisa) {
			this.vizualizarProduto(0);
			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == atualizar) {
			Component[] c = painel.getComponents();
			dadosAtualizados = new ArrayList<String>();
			
			for(Component a : c) {
				if(a instanceof JTextField) {
					String conteudoTextField = ((JTextField) a).getText();
					if(conteudoTextField != null && conteudoTextField != "") {
						dadosAtualizados.add(conteudoTextField);
						
					}					
				}
			}
			
			new ControleEstoque(this.controleDados).alterarInfomacoesProduto(dadosAtualizados, index);
			
			
		} else if(src == voltar) {
			new InterfaceEstoque(this.controleDados, -1, null);
		
		} else if(src == cancelar) {
			new InterfaceEstoque(this.controleDados, -1, null);
			
		} else if(src == voltarPrincipal) {
			new InterfacePrincipal(controleDados);
			
		} else if(src == escolherCadastrar) {
			InterfaceEstoque.escolherCadastrar.setVisible(false);
			InterfaceEstoque.voltarPrincipal.setVisible(false);
			this.painelSecundario.setVisible(true);;
			
		} else if(src == excluir) {
			new ControleEstoque(this.controleDados).getEstoque().excluirProduto(index);
		
		} else if(src == pesquisaNome) {
			String nomeProduto = this.selecaoPesquisa.getText();
			
			int indexProdutoEscolhido = this.controleEstoque.getEstoque().pesquisarProduto(nomeProduto);
			
			if(indexProdutoEscolhido != -1) {
				new InterfaceEstoque(this.controleDados, indexProdutoEscolhido, null);
							
			} else {
				JOptionPane.showMessageDialog(null, "O nome informado não está registrado para nenhum produto");
				
			}
			
			
		} else if(src == pesquisaId) {
			try {
				int idProduto = Integer.parseInt(this.selecaoPesquisa.getText());
				
				int indexProdutoEscolhido = this.controleEstoque.getEstoque().pesquisarProduto(idProduto);
				
				new InterfaceEstoque(this.controleDados, indexProdutoEscolhido, null);
				
			} catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro", "Algum(ns) do(s) valor(es) numérico(s) informado(s) é(são) "
						+ "inválido(s)", JOptionPane.ERROR_MESSAGE);
				
			}
			
			
		} else if(src == pesquisaPreco) {
			try {
				double faixaPreco = Double.parseDouble(this.controleEstoque.formataNumero(this.selecaoPesquisa.getText()));
				
				ArrayList<Produto> produtoFaixaPreco = this.controleEstoque.getEstoque().pesquisarProdutosPreco(faixaPreco);
				
				new InterfaceEstoque(this.controleDados, -1, produtoFaixaPreco);
				
			} catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro", "Algum(ns) do(s) valor(es) numérico(s) informado(s) é(são) "
						+ "inválido(s)", JOptionPane.ERROR_MESSAGE);
				
			}
			
			
		} else if(src == cadastrar) {
			Component[] c = painel.getComponents();
			dadosAtualizados = new ArrayList<String>();
			boolean dadosValidos = true;
			
			for(Component a : c) {
				if(a instanceof JTextField) {
					String conteudoTextField = ((JTextField) a).getText();
					if(conteudoTextField != null && conteudoTextField != "") {
						dadosAtualizados.add(conteudoTextField);
						
					} else {
						JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
						dadosValidos = false;
						
					}
				}
			}
			
			if(dadosValidos) {
				String categoria = dadosAtualizados.get(7);
				new ControleEstoque(this.controleDados).cadastraProduto(dadosAtualizados, categoria);				
				
			}
			
		}
		
	}
	
}
