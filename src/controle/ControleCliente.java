package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelos.Cliente;

public class ControleCliente {
	private ArrayList<Cliente> clientes;
	
	public ControleCliente(ControleDados controleDados) {
		this.setClientes(controleDados.getLoja().getClientes());
		
	}
	
	public String[] mostraClientes() {
		String[] totalClientes = new String[this.getClientes().size()];
		
		for(int i = 0; i < this.getClientes().size(); i++) {
			totalClientes[i] = "Nome: " + this.getClientes().get(i).getNome();
			
		}
		
		return totalClientes;
		
	}
	
	public int pesquisarCliente(String nome) {
		int index = -1;
		
		for(Cliente cliente: this.getClientes()) {
			if(cliente.getNome().equalsIgnoreCase(nome)) {
				index = this.getClientes().indexOf(cliente);
				break;
				
			}
		}
		
		return index;
		
	}
	
	public void adicionaClientes(ArrayList<String> dadosAtualizados) {
		try {
			Cliente novoCliente = new Cliente(dadosAtualizados.get(0), dadosAtualizados.get(0), dadosAtualizados.get(2), 
					Long.parseLong(ControleCliente.formataCpf(dadosAtualizados.get(3))));
			
			this.getClientes().add(novoCliente);
			
		} catch(NumberFormatException n) {
			JOptionPane.showMessageDialog(null, "O CPF digitado é inválido");
			
		}
		
	}
	
	public String excluiCliente(String nome) {
		String resultado = "Cliente não encontrado";
		
		for(Cliente cliente : clientes) {
			if(cliente.getNome().equalsIgnoreCase(nome)) {
				clientes.remove(cliente);
				resultado = "Cliente excluído com sucesso";
				break;
			}
		}
		
		return resultado;
		
	}
	
	public static String formataCpf(String numero) {
		String formatacao = numero.replaceAll("[\\D]", "");
		String cpfFormatado;
		
		if(formatacao.length() == 11) {
			cpfFormatado = formatacao;
			
		} else {
			cpfFormatado = formatacao + "a";
		}
		
		
		return cpfFormatado;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
