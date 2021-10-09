package modelos;

/**
 * Esta classe servirá de modelo para Cliente e Vendedor
 * 
 * @author Gustavo de Brito Araújo
 */

public abstract class Pessoa {
	private String nome;
	private String telefone;
	private String endereco;
	
	/**
	 * O método receberá todos os valores para todos os seus
	 * atributos e agirá com o construtor nos construtores das classes
	 * que herdarão de Pessoa, uma vez que as mesmmas tem essas mesmas 
	 * características e forma de declarar iguais
	 * 
	 * @param nome
	 * @param telefone
	 * @param endereco
	 */
	
	public void cadastrar(String nome, String telefone, String endereco) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		
	}
	
	/**
	 * Semelhante ao método "cadastrar", o método alterar
	 * informações também recebe todos os valores para seus
	 * atributos, com a diferença que ele pode receber um
	 * valor "null", nesse caso ele manterá seu valor anterior.
	 * Será utilizado juntamente com o método "editar" das classes
	 * que herdam de pessoa, pois o método mais uma vez altera os
	 * valores dos atributos presentes em todas as classes herdadas
	 * 
	 * @param nome
	 * @param telefone
	 * @param endereco
	 */
	
	public void editar(String nome, String telefone, String endereco) {
		if(nome != null) {
			this.setNome(nome);
		}
		if(telefone != null) {
			this.setTelefone(telefone);
		}
		if(endereco != null) {
			this.setEndereco(endereco);
		}
		
	}
	
	/**
	 * Este método mostra os valores dos atributos de forma a ser mais legível
	 * ao usuário
	 * 
	 * @return String com todas as informações de Pessoa
	 */
	
	public String toString() {
		return "Nome: " + this.getNome() + "\nTelefone: " + this.getTelefone() + "\nEndereço: " + this.getEndereco();
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
}
