package modelos;

import java.util.ArrayList;

/**
 * Esta classe ir� armazeanar as demais classes j� todas as outras
 * s� fazem sentido juntas com a exist�ncia desta
 * 
 * @author Gustavo de Brito Ara�jo
 *
 */

public final class Loja {
	private String nome;
	private String cnpj;
	private String endereco;
	private ArrayList<Venda> historicoVendas;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Cliente> clientes;
	private Estoque estoque;
	
	/**
	 * O construtor da classe recebe todos os valores para cria��o de uma
	 * loja
	 * 
	 * @param nome
	 * @param cnpj
	 * @param endereco
	 * @param estoque � o objeto Estoque desse mesmo pacote
	 */
	
	public Loja(String nome, String cnpj, String endereco, Estoque estoque) {
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.setEndereco(endereco);
		this.setEstoque(estoque);
		historicoVendas = new ArrayList<Venda>();
		vendedores = new ArrayList<Vendedor>();
		clientes = new ArrayList<Cliente>();
		
	}
	
	/**
	 * Este m�todo altera os valores j� presentes nos atributos, se o novo 
	 * valor n�o for "null"
	 * 
	 * @param nome
	 * @param cnpj
	 * @param endereco
	 * @param estoque
	 */
	
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
	
	/**
	 * Este m�todo formata todos os valores de Loja em uma String
	 * facilmente entendida pelo usu�rio
	 * 
	 * @return String com as caracter�sticas da Loja
	 */
	
	public String toString() {
		return "Nome da loja: " + this.getNome() + "\nCNPJ: " + this.getCnpj() + "\nEndere�o: " + this.getEndereco()
				+ "\nQuantidade de vendedores: " + this.getVendedores().size() + "\nQuantidade de clientes registrados: " 
				+ this.getClientes().size();
		
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
	public void setVendas(ArrayList<Venda> historicoVendas) {
		this.historicoVendas = historicoVendas;
		
	}
	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}
	public void setVendedores(ArrayList<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

}
