package modelos;

import java.time.LocalDate;

/**
 * Esta classe representa um vendedor que herda da classe "Pessoa"
 * 
 * @author Gustavo de Brito Ara�jo
 */

public final class Vendedor extends Pessoa {
	private LocalDate dataInicio;
	private double salario;
	
	/**
	 * O construtor possui os valores para so atributos de "Pessoa" mais
	 * os atributos salario e dataInicio, por isso o m�todo "cadastrar" de
	 * sua classe m�e � utilizado com o construtor
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
	 * Este m�todo altera os valores dos atritutos anteriormente atribu�dos,
	 * caso o novo valor seja "null" o valor anterior n�o � substitu�do. Mais
	 * uma vez, � utilizado um m�todo da classe m�e, nesse caso, "editar"
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
	 * Este m�todo mostra todos os valores dos atributos de forma
	 * mais leg�vel para o usu�rio
	 * 
	 * @return String contendo os dados da Classe relevantes ao usu�rio
	 */
	
	public String toString() {
		return super.toString() + "\nData de in�cio: " + this.getDataInicio() + "\nSal�rio: " + this.getSalario();
		
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	/**
	 * Este get pega o valor sal�rio e o concatena a uma medida
	 * para melhor leitura e entendimento
	 * 
	 * @return String com o valor do sal�rio e sua medida
	 */
	
	public String getSalario() {
		return String.format("R$ %.2f", salario);
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
