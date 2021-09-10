package loja_eletrodomesticos_e_moveis;

import java.util.ArrayList;

public final class Loja {
	private String nome;
	private String cnpj;
	private String endereco;
	private ArrayList<Venda> historicoVendas;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Cliente> clientes;
	private Estoque estoque;
	
	public Loja(String nome, String cnpj, String endereco, Estoque estoque) {
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.setEndereco(endereco);
		this.setEstoque(estoque);
		historicoVendas = new ArrayList<Venda>();
		vendedores = new ArrayList<Vendedor>();
		clientes = new ArrayList<Cliente>();
		
	}
	
	public void editar(String nome, String cnpj, String endereco, Estoque estoque) {
		if(nome != null) {
			this.setNome(nome);
		}
		if(cnpj != null) {
			this.setCnpj(cnpj);
		}
		if(endereco != null) {
			this.setEndereco(endereco);
		}
		if(estoque != null) {
			this.setEstoque(estoque);
		}
		
	}
	
	public String excluiVendedor(String nome) {
		String resultado = "Vendedor não encontrado";
		
		for(Vendedor vendedor : vendedores) {
			if(vendedor.getNome().equals(nome)) {
				vendedores.remove(vendedor);
				resultado = "Vendedor excluído com sucesso";
				break;
			}
		}
		
		return resultado;
		
	}
	
	public String excluiCliente(String nome) {
		String resultado = "Cliente não encontrado";
		
		for(Cliente cliente : clientes) {
			if(cliente.getNome().equals(nome)) {
				clientes.remove(cliente);
				resultado = "Cliente excluído com sucesso";
				break;
			}
		}
		
		return resultado;
		
	}
	
	public String mostrarVendedores() {
		String totalVendedores = "Vendedores:\n";
		
		for(Vendedor vendedor : vendedores) {
			totalVendedores += vendedor.toString() + "\n\n";
		}
		
		return totalVendedores;
		
	}
	
	public String mostrarClientes() {
		String totalClientes = "Clientes:\n";
		
		for(Cliente cliente : clientes) {
			totalClientes += cliente.toString() + "\n\n";
			
		}
		
		return totalClientes;
		
	}
	
	public String ler() {
		return "Nome da loja: " + this.getNome() + "\nCNPJ: " + this.getCnpj() + "\nQuantidade de vendedores: "
				+ this.getVendedores().size() + "\nQuantidade de clientes registrados: " + this.getClientes().size();
		
	}
	
	public String mostrarHistoricoVendas() {
		String historico = "";
		if(historicoVendas.size() != 0) {
			for(Venda venda : historicoVendas) {
				historico += venda.toString() + "\n\n";
			}			
		} else {
			historico = "Nenhuma venda registrada";
		}
		
		return historico;
	
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<Venda> getVendas() {
		return historicoVendas;
	}
	public String setVendas(Venda venda) {
		String statusVenda;
		if(venda.isVendaValida()) {
			this.historicoVendas.add(venda);
			statusVenda = "Venda adicionada ao histórico com sucesso!";
		} else {
			statusVenda = "Venda inválida! Não pode ser adicionada ao histórico";
		}
		
		return statusVenda;
		
	}
	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}
	public void setVendedores(Vendedor vendedor) {
		this.vendedores.add(vendedor);
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(Cliente cliente) {
		this.clientes.add(cliente);
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

}
