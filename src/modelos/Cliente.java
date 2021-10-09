package modelos;

/**
 * Esta classe representa um cliente que herda da classe "Pessoa"
 * 
 * @author Gustavo de Brito Araújo
 */

public final class Cliente extends Pessoa {
	private long cpf;
	
	/**
	 * O construtor possui os valores para so atributos de "Pessoa" mais
	 * o atributo cpf, por isso o método "cadastrar" de sua classe mãe é
	 * utilizado com o construtor
	 * 
	 * @param nome
	 * @param telefone
	 * @param endereco
	 * @param cpf
	 */
	
	public Cliente(String nome, String telefone, String endereco, long cpf) {
		super.cadastrar(nome, telefone, endereco);
		
		this.setCpf(cpf);
		
	}
	
	/**
	 * Este método altera os valores dos atritutos anteriormente atribuídos,
	 * caso o novo valor seja "null" o valor anterior não é substituído. Mais
	 * uma vez, é utilizado um método da classe mãe, nesse caso, "editar"
	 * 
	 * @param nome
	 * @param telefone
	 * @param endereco
	 * @param cpf
	 */
	
	public void editar(String nome, String telefone, String endereco, long cpf) {
		super.editar(nome, telefone, endereco);
		
		if(cpf != 0) {
			this.setCpf(cpf);
		}
		
	}
	
	/**
	 * Este método mostra todos os valores dos atributos de forma
	 * mais legível para o usuário
	 * 
	 * @return String contendo os dados da Classe relevantes ao usuário
	 */
	
	@Override
	public String toString() {
		return super.toString() + "\nCPF: " + this.getCpf();
	}
	
	/**
	 * Este get pega o long que representa o CPF e o formata para
	 * ser mais adepto ao usuário
	 * 
	 * @return
	 */
	
	public String getCpf() {
		String cpfString = Long.toString(cpf);
		cpfString = cpfString.substring(0, 3) + "." + cpfString.substring(3, 6) + "." + cpfString.substring(6, 9) + "-" +
				cpfString.substring(9);
		
		return cpfString;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

}
