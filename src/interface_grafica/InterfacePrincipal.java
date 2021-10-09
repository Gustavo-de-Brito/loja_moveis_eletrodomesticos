package interface_grafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controle.ControleDados;

public class InterfacePrincipal implements ActionListener {
	private static JFrame janela;
	private static JButton estoque, clienteVendedor, venda, loja;
	private JLabel titulo;
	private Font fonteTitulo, fonteBotao;
	private static ControleDados controleDados;
	
	public InterfacePrincipal(ControleDados controleDados) {
		this.controleDados = controleDados;
		
		fonteBotao = new Font("Helvetica", Font.BOLD, 16);
		fonteTitulo = new Font("Helvetica", Font.BOLD, 30);
		
		janela = new JFrame("Móveis e Eletrodomésticos");
		estoque = new JButton("Produtos em Estoque");
		clienteVendedor = new JButton("Clientes e Vendedores");
		venda = new JButton("Venda");
		loja = new JButton("Informações da Loja");
		titulo = new JLabel(this.controleDados.getLoja().getNome());
		
		janela.setSize(800, 500);
		estoque.setBounds(250, 100, 300, 50);
		estoque.setFont(fonteBotao);
		clienteVendedor.setBounds(250, 190, 300, 50);
		clienteVendedor.setFont(fonteBotao);
		venda.setBounds(250, 280, 300, 50);
		venda.setFont(fonteBotao);
		loja.setBounds(250, 370, 300, 50);
		loja.setFont(fonteBotao);
		titulo.setFont(fonteTitulo);
		titulo.setBounds(170, 20, 500, 50);
		
		janela.add(titulo);
		janela.add(estoque);
		janela.add(clienteVendedor);
		janela.add(venda);
		janela.add(loja);
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

		estoque.addActionListener(this);
		clienteVendedor.addActionListener(this);
		venda.addActionListener(this);
		loja.addActionListener(this);
		
	}
	
	public static void main(String args[]) {
		controleDados = new ControleDados();
		InterfacePrincipal janela = new InterfacePrincipal(controleDados);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == estoque) {
			new InterfaceEstoque(controleDados, -1, null);
			
		} else if (src == clienteVendedor) {
			new InterfaceClienteVendedor(controleDados);
			
		} else if (src == venda) {
			new InterfaceVenda(controleDados);
			
		} else {
			new InterfaceLoja(controleDados);
			
		}
		
	}
	
}
