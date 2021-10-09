package modelos;

/**
 * Esta classe herdará de produto e incrementará características próprias
 * de um microondas
 * 
 * @author Gustavo de Brito Araújo
 *
 */

public final class Microondas extends Produto {
	private double capacidade;
	private String termostato;
	private String pratoGiratorio;
	
	/**
	 * O construtor da classe recebe todos os valores para criação de um
	 * produto, mais os valores que particularizam um microondas, é utilizado 
	 * o método cadastar de produto para a atribuição dos valores aos atributos
	 * 
	 * @param nome
	 * @param id
	 * @param preco
	 * @param descricao
	 * @param cor
	 * @param peso
	 * @param marca
	 * @param categoria
	 * @param tipo
	 * @param altura
	 * @param largura
	 * @param profundidade
	 * @param capacidade capacidade em litros
	 * @param termostato presença ou ausência de termostato
	 * @param pratoGiratorio presença ou ausência de prato giratório
	 */
	
	public Microondas(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, double capacidade,
			String termostato, String pratoGiratorio) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setCapacidade(capacidade);
		this.setTermostato(termostato);
		this.setPratoGiratorio(pratoGiratorio);
	}

	/**
	 * Este método altera os valores já presentes nos atributos, se o novo 
	 * valor não for "null". Se faz o uso do método "alterarInformacoes" da
	 * classe abstrata "Produto" que já faz a alteração dos valores dos 
	 * atributos comuns a todas as classes que herdam de "Produto"
	 * 	
	 * @param nome
	 * @param id
	 * @param preco
	 * @param descricao
	 * @param cor
	 * @param peso
	 * @param marca
	 * @param categoria
	 * @param tipo
	 * @param altura
	 * @param largura
	 * @param profundidade
	 * @param capacidade
	 * @param termostato
	 * @param pratoGiratorio
	 */
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, double capacidade,
			String termostato, String pratoGiratorio) {
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(capacidade > 0) {
			this.setCapacidade(capacidade);
		}
		if(termostato != null) {
			this.setTermostato(termostato);
		}
		if(pratoGiratorio != null) {
			this.setPratoGiratorio(pratoGiratorio);
		}
		
	}
	
	/**
	 * O método "ler" é sobreescrito e invocado, para reutilização
	 * da formatação já feita e adição da formatação dos atritutos
	 * particulares de Microondas
	 * 
	 * @return String contendo todas as informações de Microondas
	 */
	
	
	@Override
	public String ler() {
		String informacoes = super.ler();
	
		return informacoes + "<br>Capacidade: " + this.getCapacidade() + "<br>Termostato: " + this.getTermostato()
				+ "<br>Prato giratório: " + this.getPratoGiratorio() + "<html>";
		
	}
	
	/**
	 * Este get pega a capacidade e a formata em uma String com a sua
	 * respectiva medida
	 * 
	 * @return String com a capacidade em litros
	 */
	
	public String getCapacidade() {
		return String.format("%sL", capacidade);
	}

	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}

	public String getTermostato() {
		return termostato;
	}

	public void setTermostato(String termostato) {
		this.termostato = termostato;
	}

	public String getPratoGiratorio() {
		return pratoGiratorio;
	}

	public void setPratoGiratorio(String pratoGiratorio) {
		this.pratoGiratorio = pratoGiratorio;
	}

}
