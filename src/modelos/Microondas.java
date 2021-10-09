package modelos;

/**
 * Esta classe herdar� de produto e incrementar� caracter�sticas pr�prias
 * de um microondas
 * 
 * @author Gustavo de Brito Ara�jo
 *
 */

public final class Microondas extends Produto {
	private double capacidade;
	private String termostato;
	private String pratoGiratorio;
	
	/**
	 * O construtor da classe recebe todos os valores para cria��o de um
	 * produto, mais os valores que particularizam um microondas, � utilizado 
	 * o m�todo cadastar de produto para a atribui��o dos valores aos atributos
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
	 * @param termostato presen�a ou aus�ncia de termostato
	 * @param pratoGiratorio presen�a ou aus�ncia de prato girat�rio
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
	 * Este m�todo altera os valores j� presentes nos atributos, se o novo 
	 * valor n�o for "null". Se faz o uso do m�todo "alterarInformacoes" da
	 * classe abstrata "Produto" que j� faz a altera��o dos valores dos 
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
	 * O m�todo "ler" � sobreescrito e invocado, para reutiliza��o
	 * da formata��o j� feita e adi��o da formata��o dos atritutos
	 * particulares de Microondas
	 * 
	 * @return String contendo todas as informa��es de Microondas
	 */
	
	
	@Override
	public String ler() {
		String informacoes = super.ler();
	
		return informacoes + "<br>Capacidade: " + this.getCapacidade() + "<br>Termostato: " + this.getTermostato()
				+ "<br>Prato girat�rio: " + this.getPratoGiratorio() + "<html>";
		
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
