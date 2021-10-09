package modelos;

/**
 * Esta classe servir� de modelo para Cliente e Vendedor
 * 
 * @author Gustavo de Brito Ara�jo
 */

public abstract class Pessoa {
	private String nome;
	private String telefone;
	private String endereco;
	
	/**
	 * O m�todo receber� todos os valores para todos os seus
	 * atributos e agir� com o construtor nos construtores das classes
	 * que herdar�o de Pessoa, uma vez que as mesmmas tem essas mesmas 
	 * caracter�sticas e forma de declarar iguais
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
	 * Semelhante ao m�todo "cadastrar", o m�todo alterar
	 * informa��es tamb�m recebe todos os valores para seus
	 * atributos, com a diferen�a que ele pode receber um
	 * valor "null", nesse caso ele manter� seu valor anterior.
	 * Ser� utilizado juntamente com o m�todo "editar" das classes
	 * que herdam de pessoa, pois o m�todo mais uma vez altera os
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
	 * Este m�todo mostra os valores dos atributos de forma a ser mais leg�vel
	 * ao usu�rio
	 * 
	 * @return String com todas as informa��es de Pessoa
	 */
	
	public String toString() {
		return "Nome: " + this.getNome() + "\nTelefone: " + this.getTelefone() + "\nEndere�o: " + this.getEndereco();
		
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
