package interface_grafica;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCliente;
import controle.ControleDados;
import controle.ControleVendedor;

public final class InterfaceClienteVendedor implements ListSelectionListener, ActionListener {
	private ControleDados controleDados;
	private ControleCliente controleCliente;
	private ControleVendedor controleVendedor;
	private int index;
	private static JFrame janela;
	private static JList<String> listaClientes, listaVendedores;
	private static JButton cadastrarCliente, cadastrarVendedor, voltarPrincipal, clientes, vendedores;
	private static JButton cadastrar,atualizar, excluir, voltar, cancelar;
	private Font fonteTexto,fonteButao, fonteField;
	private JPanel painel, painelVendedor, painelCliente;
	private ArrayList<String> dadosAtualizados;
	private JScrollPane scroll, scrollSecundario;
	
	public InterfaceClienteVendedor(ControleDados controleDados) {
		this.controleDados = controleDados;
		this.controleCliente = new ControleCliente(controleDados);
		this.controleVendedor = new ControleVendedor(controleDados);
		
		fonteTexto = new Font("Helvetica", Font.PLAIN, 16);
		fonteButao = new Font("Helvetica", Font.BOLD, 16);
		janela = new JFrame("Clientes e Vendedores");
		painelCliente = new JPanel();
		painelVendedor = new JPanel();
		listaClientes = new JList<String>(this.controleCliente.mostraClientes());
		listaVendedores = new JList<String>(this.controleVendedor.mostraVendedores());
		
		cadastrarCliente = new JButton("Cadastrar Novo Cliente");
		cadastrarVendedor = new JButton("Cadastrar Novo Vendedor");
		
		voltarPrincipal = new JButton("Voltar");
		clientes = new JButton("Clientes");
		vendedores = new JButton("Vendedores");
		scroll = new JScrollPane();
		scrollSecundario = new JScrollPane();
		
		painelCliente.setBounds(20, 10, 400, 480);
		painelCliente.setLayout(null);
		painelVendedor.setBounds(20, 10, 400, 480);
		painelVendedor.setLayout(null);
		listaClientes.setBounds(0, 10, 380, 350);
		listaClientes.setFont(fonteTexto);
		listaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaClientes.addListSelectionListener(this);
		
		listaVendedores.setBounds(0, 10, 380, 350);
		listaVendedores.setFont(fonteTexto);
		listaVendedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaVendedores.addListSelectionListener(this);
		
		cadastrarCliente.setBounds(0, 380, 300, 50);
		cadastrarVendedor.setBounds(0, 380, 300, 50);
		voltarPrincipal.setBounds(560, 380, 200, 50);
		clientes.setBounds(560, 20, 200, 50);
		vendedores.setBounds(560, 90, 200, 50);
		cadastrarCliente.setFont(fonteButao);
		cadastrarVendedor.setFont(fonteButao);
		voltarPrincipal.setFont(fonteButao);
		clientes.setFont(fonteButao);
		vendedores.setFont(fonteButao);
		
		scroll.setViewportView(listaClientes);
        scroll.setBounds(0, 10, 380, 360);
        
        scrollSecundario.setViewportView(listaVendedores);
        scrollSecundario.setBounds(0, 10, 380, 360);
		
        painelCliente.add(scroll);
        painelCliente.add(cadastrarCliente);
        painelVendedor.add(scrollSecundario);
        painelVendedor.add(cadastrarVendedor);
        janela.add(painelVendedor);
		janela.add(painelCliente);
		janela.add(clientes);
		janela.add(vendedores);
		janela.add(voltarPrincipal);
		
		janela.setSize(800, 500);
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		voltarPrincipal.addActionListener(this);
		cadastrarVendedor.addActionListener(this);
		cadastrarCliente.addActionListener(this);
		clientes.addActionListener(this);
		vendedores.addActionListener(this);
		
	}
	
	public void cadastrarPessoa(int identificador) {
		String dadosBrutos;
		
		ArrayList<String> especificacoesPessoa = new ArrayList<String>();
		
		if(identificador == 1) {
			dadosBrutos = this.controleCliente.getClientes().get(index).toString();
			
		} else {
			dadosBrutos = this.controleVendedor.getVendedores().get(index).toString();
			
		}
		
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
			
			especificacoesPessoa.add(especificacao);
			
			indexInicial = indexFinalInformacao + 1;
			
						
		}
		
		
		painel = new JPanel();
		cadastrar = new JButton("Cadastar");
		cancelar = new JButton("Cancelar");
		
		painel.setSize(800, 500);
		painel.setLayout(null);
		int distanciaTopo = 20;
		int distanciaEsquerda = 50;
		
		if(identificador == 1) {
			janela = new JFrame("Cadastro Novo Cliente");
			
		} else {
			janela = new JFrame("Cadastro Novo Vendedor");
			
		}
		
		
		fonteTexto = new Font("Helvetica", Font.BOLD, 16);
		fonteField = new Font("Helvetica", Font.PLAIN, 14);
	
		
		for(int i = 0; i < especificacoesPessoa.size(); i++) {
			JLabel especificacao = new JLabel(especificacoesPessoa.get(i));
			JTextField informacao = new JTextField("");
			
			informacao.setBounds(distanciaEsquerda + 210, distanciaTopo, 480, 40);
			informacao.setFont(fonteField);
			especificacao.setBounds(distanciaEsquerda, distanciaTopo, 200, 40);
			especificacao.setFont(fonteTexto);
			
			painel.add(informacao);
			painel.add(especificacao);
			
			distanciaTopo += 60;
			
			
		}
		
		cadastrar.setBounds(150, distanciaTopo + 20, 200, 50);
		cancelar.setBounds(450, distanciaTopo + 20, 200, 50);
		painel.add(cadastrar);
		painel.add(cancelar);
		
		painel.setPreferredSize(new Dimension(800, distanciaTopo + 70));
		scroll = new JScrollPane();
		scroll.setViewportView(painel);
        scroll.setSize(800, distanciaTopo + 70);
        scroll.setVisible(true);
		
		janela.add(scroll);
		janela.setSize(800, 500);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		cadastrar.addActionListener(this);
		cancelar.addActionListener(this);
		
	}
	
	public void vizualizarPessoa(int index, int identificador) {
		this.index = index;
		String dadosBrutos;
		
		ArrayList<String> especificacoesPessoa = new ArrayList<String>();
		ArrayList<String> informacoesPessoa = new ArrayList<String>();
		
		if(identificador == 1) {
			dadosBrutos = this.controleCliente.getClientes().get(index).toString();
			
		} else {
			dadosBrutos = this.controleVendedor.getVendedores().get(index).toString();
			
		}
		
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
			
			informacoesPessoa.add(informacao);
			especificacoesPessoa.add(especificacao);
			
			indexInicial = indexFinalInformacao + 1;
			
						
		}
		
		
		painel = new JPanel();
		atualizar = new JButton("Atualizar");
		excluir = new JButton("Excluir");
		voltar = new JButton("Voltar");
		
		painel.setSize(800, 500);
		painel.setLayout(null);
		int distanciaTopo = 20;
		int distanciaEsquerda = 50;
		
		janela = new JFrame(informacoesPessoa.get(0));
		fonteTexto = new Font("Helvetica", Font.BOLD, 16);
		fonteField = new Font("Helvetica", Font.PLAIN, 14);
	
		
		for(int i = 0; i < especificacoesPessoa.size(); i++) {
			JLabel especificacao = new JLabel(especificacoesPessoa.get(i));
			JTextField informacao = new JTextField(informacoesPessoa.get(i));
			
			informacao.setBounds(distanciaEsquerda + 210, distanciaTopo, 480, 40);
			informacao.setFont(fonteField);
			especificacao.setBounds(distanciaEsquerda, distanciaTopo, 200, 40);
			especificacao.setFont(fonteTexto);
			
			painel.add(informacao);
			painel.add(especificacao);
			
			distanciaTopo += 60;
			
			
		}
		
		
		atualizar.setBounds(85, distanciaTopo + 20, 200, 50);
		excluir.setBounds(295, distanciaTopo + 20, 200, 50);
		voltar.setBounds(505, distanciaTopo + 20, 200, 50);
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
		
		if(e.getValueIsAdjusting() && src == listaClientes) {
			this.vizualizarPessoa(listaClientes.getSelectedIndex(), 1);		

		} else if(e.getValueIsAdjusting() && src == listaVendedores) {
			this.vizualizarPessoa(listaVendedores.getSelectedIndex(), 2);
			
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
			
			
		
			if (dadosAtualizados.size() == 4) {
				this.controleCliente.getClientes().get(index).editar(dadosAtualizados.get(0), dadosAtualizados.get(1), 
						dadosAtualizados.get(2), Long.parseLong(ControleCliente.formataCpf(dadosAtualizados.get(3))));
				
				
			} else {
				this.controleVendedor.getVendedores().get(index).editar(dadosAtualizados.get(0), dadosAtualizados.get(1), 
						dadosAtualizados.get(2), LocalDate.parse(dadosAtualizados.get(3)),
						Double.parseDouble(ControleVendedor.formataNumero(dadosAtualizados.get(4))));
				
			}
			
			
		} else if(src == excluir) {
			Component[] c = painel.getComponents();
			
			if(c.length == 4) {
				this.controleCliente.excluiCliente(((JTextField) c[0]).getText());
				
			} else {
				this.controleVendedor.excluiVendedor(((JTextField) c[0]).getText());
				
			}
			
		} else if(src == voltar) {
			new InterfaceClienteVendedor(this.controleDados);
			
		} else if(src == voltarPrincipal) {
			new InterfacePrincipal(this.controleDados);
			
		} else if(src == clientes) {
			this.painelCliente.setVisible(true);
			this.painelVendedor.setVisible(false);
			
		} else if(src == vendedores) {
			this.painelVendedor.setVisible(true);
			this.painelCliente.setVisible(false);
			
		} else if(src == cadastrarCliente) {
			this.cadastrarPessoa(1);
			
		} else if(src == cadastrarVendedor) {
			this.cadastrarPessoa(2);
		
		} else if(src == cancelar) {
			new InterfaceClienteVendedor(this.controleDados);
			
			
		} else if(src == cadastrar) {
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
			
			if(dadosAtualizados.size() == 4) {
				this.controleCliente.adicionaClientes(dadosAtualizados);				
				
			} else {
				this.controleVendedor.adicionaVendedores(dadosAtualizados);
				
			}
			
			new InterfaceClienteVendedor(this.controleDados);
			
		}
		
	}
	
}
