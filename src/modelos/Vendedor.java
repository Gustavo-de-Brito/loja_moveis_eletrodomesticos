package modelos;

import java.time.LocalDate;

/**
 * Esta classe representa um vendedor que herda da classe "Pessoa"
 * 
 * @author Gustavo de Brito Araújo
 */

public final class Vendedor extends Pessoa {
	private LocalDate dataInicio;
	private double salario;
	
	/**
	 * O construtor possui os valores para so atributos de "Pessoa" mais
	 * os atributos salario e dataInicio, por isso o método "cadastrar" de
	 * sua classe mãe é utilizado com o construtor
	 * 
	 * @param nome
	 * @param telefone
	 * @param endereco
	 * @param dataInicio
	 * @param Salario
	 */
	
	public Vendedor(String nome, String telefone, String endereco, LocalDate dataInicio, double Salario) {
		super.cadastrar(nome, telefone, endereco);
		
		this.setDataInicio(dataInicio);
		this.setSalario(Salario);
		
	}
	
	/**
	 * Este método altera os valores dos atritutos anteriormente atribuídos,
	 * caso o novo valor seja "null" o valor anterior não é substituído. Mais
	 * uma vez, é utilizado um método da classe mãe, nesse caso, "editar"
	 * 
	 * @param nome
	 * @param telefone
	 * @param endereco
	 * @param dataInicio
	 * @param salario
	 */
	
	public void editar(String nome, String telefone, String endereco, LocalDate dataInicio, double salario) {
		super.editar(nome, telefone, endereco);
		
		if(dataInicio != null) {
			this.setDataInicio(dataInicio);
		}
		if(salario > 0) {
			this.setSalario(salario);
		}
		
	}
	
	/**
	 * Este método mostra todos os valores dos atributos de forma
	 * mais legível para o usuário
	 * 
	 * @return String contendo os dados da Classe relevantes ao usuário
	 */
	
	public String toString() {
		return super.toString() + "\nData de início: " + this.getDataInicio() + "\nSalário: " + this.getSalario();
		
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	/**
	 * Este get pega o valor salário e o concatena a uma medida
	 * para melhor leitura e entendimento
	 * 
	 * @return String com o valor do salário e sua medida
	 */
	
	public String getSalario() {
		return String.format("R$ %.2f", salario);
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
