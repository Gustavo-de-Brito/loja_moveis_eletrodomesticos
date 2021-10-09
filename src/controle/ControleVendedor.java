package controle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import modelos.Vendedor;

public class ControleVendedor {
	private ArrayList<Vendedor> vendedores;
	
	public ControleVendedor(ControleDados controleDados) {
		this.setVendedores(controleDados.getLoja().getVendedores()); 
	}

	public String[] mostraVendedores() {
		String[] totalVendedores = new String[this.getVendedores().size()];
		
		for(int i = 0; i < this.getVendedores().size(); i++) {
			totalVendedores[i] = "Nome: " + this.getVendedores().get(i).getNome();
			
		}
		
		return totalVendedores;
		
	}
	
	public int pesquisarVendedor(String nome) {
		int index = -1;
		
		for(Vendedor vendedor: this.getVendedores()) {
			if(vendedor.getNome().equalsIgnoreCase(nome)) {
				index = this.getVendedores().indexOf(vendedor);
				break;
				
			}
		}
		
		return index;
		
	}
	
	public void adicionaVendedores(ArrayList<String> novosDados) {
		try {
			DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			Vendedor vendedor = new Vendedor(novosDados.get(0), novosDados.get(1),novosDados.get(2), 
					LocalDate.parse(novosDados.get(3), formatoData), 
					Double.parseDouble(ControleVendedor.formataNumero(novosDados.get(4))));
			
			this.getVendedores().add(vendedor);			
			
		} catch(NumberFormatException n) {
			JOptionPane.showMessageDialog(null, "Erro", "Algum(ns) do(s) valor(es) numérico(s) informado(s) é(são) "
					+ "inválido(s)", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

	public void excluiVendedor(String nome) {
		for(Vendedor vendedor : vendedores) {
			if(vendedor.getNome().equals(nome)) {
				vendedores.remove(vendedor);
				break;
				
			}
			
		}
		
	}
	
	public static String formataNumero(String numero) {
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
	
	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(ArrayList<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}
}
