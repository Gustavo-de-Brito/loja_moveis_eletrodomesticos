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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controle.ControleDados;

public final class InterfaceLoja implements ActionListener {
	private ControleDados controleDados;
	private JLabel especificacao, qtdClientes, qtdVendedores;
	private JTextField informacao;
	private JPanel painel;
	private static JButton atualizar, cancelar;
	private JScrollPane scroll;
	private JFrame janela;
	private Font fonteTexto, fonteField, fonteBotao;
	private ArrayList<String> dadosAtualizados;
	
	
	public InterfaceLoja(ControleDados controleDados) {
		this.controleDados = controleDados;
		
		String dadosBrutos;
		ArrayList<String> especificacoesLoja = new ArrayList<String>();
		ArrayList<String> informacoesLoja = new ArrayList<String>();
		
		dadosBrutos = this.controleDados.getLoja().toString();
		
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
			
			informacoesLoja.add(informacao);
			especificacoesLoja.add(especificacao);
			
			indexInicial = indexFinalInformacao + 1;
			
						
		}
		
		
		painel = new JPanel();
		atualizar = new JButton("Atualizar");
		cancelar = new JButton("Cancelar");
		
		painel.setSize(800, 500);
		painel.setLayout(null);
		int distanciaTopo = 30;
		int distanciaEsquerda = 50;
		
		janela = new JFrame("Informações Loja");
		
		
		fonteTexto = new Font("Helvetica", Font.BOLD, 16);
		fonteField = new Font("Helvetica", Font.PLAIN, 14);
		fonteBotao = new Font("Helvetica", Font.BOLD, 16);
	
		
		for(int i = 0; i < 3; i++) {
			especificacao = new JLabel(especificacoesLoja.get(i));
			informacao = new JTextField(informacoesLoja.get(i));
			
			informacao.setBounds(distanciaEsquerda + 310, distanciaTopo, 380, 40);
			informacao.setFont(fonteField);
			especificacao.setBounds(distanciaEsquerda, distanciaTopo, 300, 40);
			especificacao.setFont(fonteTexto);
			
			painel.add(informacao);
			painel.add(especificacao);
			
			distanciaTopo += 65;
			
		}
		
		especificacao = new JLabel(especificacoesLoja.get(3));
		qtdVendedores = new JLabel(informacoesLoja.get(3));
		especificacao.setBounds(distanciaEsquerda, distanciaTopo, 300, 40);
		especificacao.setFont(fonteTexto);
		qtdVendedores.setBounds(distanciaEsquerda + 310, distanciaTopo, 380, 40);
		qtdVendedores.setFont(fonteTexto);
		
		painel.add(especificacao);
		painel.add(qtdVendedores);
		
		distanciaTopo += 65;
		
		especificacao = new JLabel(especificacoesLoja.get(4));
		qtdClientes = new JLabel(informacoesLoja.get(4));
		especificacao.setBounds(distanciaEsquerda, distanciaTopo, 300, 40);
		especificacao.setFont(fonteTexto);
		qtdClientes.setBounds(distanciaEsquerda + 310, distanciaTopo, 380, 40);
		qtdClientes.setFont(fonteTexto);
		
		painel.add(especificacao);
		painel.add(qtdClientes);
		
		painel.add(especificacao);
		painel.add(qtdClientes);
		
		distanciaTopo += 65;
		
		atualizar.setFont(fonteBotao);
		cancelar.setFont(fonteBotao);
		atualizar.setBounds(150, distanciaTopo, 200, 50);
		cancelar.setBounds(450, distanciaTopo, 200, 50);
		painel.add(atualizar);
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
		
		atualizar.addActionListener(this);
		cancelar.addActionListener(this);
		
		
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
						JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
						dadosValidos = false;
						
					}
				}
			}
			
			if(dadosValidos) {
				this.controleDados.getLoja().editar(dadosAtualizados.get(0), dadosAtualizados.get(1),
						dadosAtualizados.get(0), null);
				
				new InterfacePrincipal(this.controleDados);				
				
			}
			
		} else {
			new InterfacePrincipal(this.controleDados);
			
		}
		
	}
	
	
}
