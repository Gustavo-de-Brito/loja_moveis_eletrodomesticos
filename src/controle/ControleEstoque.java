package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelos.*;

public class ControleEstoque {
	private Estoque estoque;
	
	public ControleEstoque(ControleDados controleDados) {
		this.setEstoque(controleDados.getLoja().getEstoque());
		
	}
	
	public void alterarInfomacoesProduto(ArrayList<String> novosDados, int index) {
		Produto produto = this.getEstoque().selecionarProduto(index);
		
		try {			
			if(produto instanceof Geladeira) {
				((Geladeira) produto).editar(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), novosDados.get(12),
						Double.parseDouble(this.formataNumero(novosDados.get(13))), 
						Integer.parseInt(this.formataNumero(novosDados.get(14))));
				
			} else if(produto instanceof ArCondicionado) {
				((ArCondicionado) produto).editar(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), novosDados.get(12), novosDados.get(13), 
						Integer.parseInt(this.formataNumero(novosDados.get(14))));
				
			} else if(produto instanceof Cama) {
				((Cama) produto).editar(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), novosDados.get(12), novosDados.get(13),
						novosDados.get(14), novosDados.get(15));
				
			} else if(produto instanceof CoifaDepuradorDeAr) {
				((CoifaDepuradorDeAr) produto).editar(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))),
						Integer.parseInt(this.formataNumero(novosDados.get(12))),
						novosDados.get(13), Integer.parseInt(this.formataNumero(novosDados.get(14))), 
						Double.parseDouble(this.formataNumero(novosDados.get(15))));
				
			} else if(produto instanceof Fogao) {
				((Fogao) produto).editar(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), 
						Integer.parseInt(this.formataNumero(novosDados.get(12))),
						novosDados.get(13), novosDados.get(14), novosDados.get(15));
				
			} else if(produto instanceof GuardaRoupa) {
				((GuardaRoupa) produto).editar(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))),
						Integer.parseInt(this.formataNumero(novosDados.get(12))),
						Integer.parseInt(this.formataNumero(novosDados.get(13))), novosDados.get(14), novosDados.get(15));
				
			} else if(produto instanceof LavadoraRoupa) {
				((LavadoraRoupa) produto).editar(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), 
						Integer.parseInt(this.formataNumero(novosDados.get(12))),
						Integer.parseInt(this.formataNumero(novosDados.get(13))),
						Integer.parseInt(this.formataNumero(novosDados.get(14))),
						Integer.parseInt(this.formataNumero(novosDados.get(11))));
				
			} else if(produto instanceof Microondas) {
				((Microondas) produto).editar(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), 
						Double.parseDouble(this.formataNumero(novosDados.get(12))), novosDados.get(13), novosDados.get(14));
				
			} else if(produto instanceof Sofa) {
				
				((Sofa) produto).editar(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), 
						Integer.parseInt(this.formataNumero(novosDados.get(12))), novosDados.get(13), novosDados.get(14),
						novosDados.get(15));
				
			}
			
		} catch(NumberFormatException n) {
			JOptionPane.showMessageDialog(null, "Erro", "Algum(ns) do(s) valor(es) numérico(s) informado(s) é(são) "
					+ "inválido(s)", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	public void cadastraProduto(ArrayList<String> novosDados, String categoria) {
		Produto novoProduto = null;
		boolean cadastrarProduto = true;
		int qtdEstoque;
		
		try {		
			qtdEstoque = Integer.parseInt(novosDados.get(novosDados.size() - 1));
			
			if(categoria.equalsIgnoreCase("Geladeira")) {
				novoProduto = new Geladeira(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), novosDados.get(12),
						Double.parseDouble(this.formataNumero(novosDados.get(13))), 
						Integer.parseInt(this.formataNumero(novosDados.get(14))));
				
			} else if(categoria.equalsIgnoreCase("Ar condicionado")) {
				novoProduto = new ArCondicionado(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), novosDados.get(12), novosDados.get(13), 
						Integer.parseInt(this.formataNumero(novosDados.get(14))));
				
			} else if(categoria.equalsIgnoreCase("Cama")) {
				novoProduto = new Cama(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), novosDados.get(12), novosDados.get(13),
						novosDados.get(14), novosDados.get(15));
				
			} else if(categoria.equalsIgnoreCase("Coifa e Depurador de Ar")) {
				novoProduto = new CoifaDepuradorDeAr(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))),
						Integer.parseInt(this.formataNumero(novosDados.get(12))),
						novosDados.get(13), Integer.parseInt(this.formataNumero(novosDados.get(14))), 
						Double.parseDouble(this.formataNumero(novosDados.get(15))));
				
			} else if(categoria.equalsIgnoreCase("Fogão")) {
				novoProduto = new Fogao(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), 
						Integer.parseInt(this.formataNumero(novosDados.get(12))),
						novosDados.get(13), novosDados.get(14), novosDados.get(15));
				
			} else if(categoria.equalsIgnoreCase("Guarda-Roupas")) {
				novoProduto = new GuardaRoupa(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))),
						Integer.parseInt(this.formataNumero(novosDados.get(12))),
						Integer.parseInt(this.formataNumero(novosDados.get(13))), novosDados.get(14), novosDados.get(15));
				
			} else if(categoria.equalsIgnoreCase("Lavadora de Roupa")) {
				novoProduto = new LavadoraRoupa(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), 
						Integer.parseInt(this.formataNumero(novosDados.get(12))),
						Integer.parseInt(this.formataNumero(novosDados.get(13))),
						Integer.parseInt(this.formataNumero(novosDados.get(14))),
						Integer.parseInt(this.formataNumero(novosDados.get(11))));
				
			} else if(categoria.equalsIgnoreCase("Micro-ondas")) {
				novoProduto = new Microondas(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), 
						Double.parseDouble(this.formataNumero(novosDados.get(12))), novosDados.get(13), novosDados.get(14));
				
			} else if(categoria.equalsIgnoreCase("Micro-ondas")) {
				novoProduto = new Sofa(novosDados.get(0), Integer.parseInt(this.formataNumero(novosDados.get(1))),
						Double.parseDouble(this.formataNumero(novosDados.get(2))), novosDados.get(3), novosDados.get(4),
						Double.parseDouble(this.formataNumero(novosDados.get(5))), novosDados.get(6), novosDados.get(7),
						novosDados.get(8), Double.parseDouble(this.formataNumero(novosDados.get(9))),
						Double.parseDouble(this.formataNumero(novosDados.get(10))),
						Double.parseDouble(this.formataNumero(novosDados.get(11))), 
						Integer.parseInt(this.formataNumero(novosDados.get(12))), novosDados.get(13), novosDados.get(14),
						novosDados.get(15));
				
			} else {
				JOptionPane.showMessageDialog(null, "A categoria informada é inválida");
				
				cadastrarProduto = false;
				
			}
			
			if(cadastrarProduto) {
				this.getEstoque().cadastraProduto(novoProduto, qtdEstoque);
				
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
				
			}
			
		} catch(NumberFormatException n) {
			JOptionPane.showMessageDialog(null, "Erro", "Algum(ns) do(s) valor(es) numérico(s) informado(s) é(são) "
					+ "inválido(s)", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	public String formataNumero(String numero) {
		String formatacao = numero.replaceAll("[\\D]", ".");
		String numeroFormatado;
		int inicio = 0;
		int finalString = 1;
		
		for (int i = 0; i < formatacao.length(); i++){
			if(formatacao.charAt(i) != '.') {
				inicio = i;
				break;
			}
		
		}
		
		for (int x = formatacao.length() - 1; x > 0; x--) {
			if(formatacao.charAt(x) != '.') {
				finalString = x + 1;
				break;
			}
			
		}
		
		numeroFormatado = formatacao.substring(inicio, finalString);
		
		return numeroFormatado;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}
