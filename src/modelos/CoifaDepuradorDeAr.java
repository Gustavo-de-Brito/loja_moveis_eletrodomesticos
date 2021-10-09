package modelos;

/**
 * Esta classe herdar� de produto e incrementar� caracter�sticas pr�prias
 * de uma coifa/depurador de ar 
 * 
 * @author Gustavo de Brito Ara�jo
 *
 */

public final class CoifaDepuradorDeAr extends Produto {
	private int velocidades;
	private String funcoes;
	private int capacidadeSuccao;
	private double alturaInstalacao;
	
	/**
	 * O construtor da classe recebe todos os valores para cria��o de um
	 * produto, mais os valores que particularizam uma coifa/depurador de ar, 
	 * � utilizado o m�todo cadastar de produto para a atribui��o dos valores 
	 * aos atributos
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
	 * @param velocidades n�mero de velocidades
	 * @param funcoes 
	 * @param capacidadeSuccao capacidade suc��o em metros c�bicos por hora
	 * @param alturaInstalacao
	 */
	
	public CoifaDepuradorDeAr(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int velocidades, 
			String funcoes, int capacidadeSuccao, double alturaInstalacao) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setVelocidades(velocidades);
		this.setFuncoes(funcoes);
		this.setCapacidadeSuccao(capacidadeSuccao);
		this.setAlturaInstalacao(alturaInstalacao);
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
	 * @param velocidades
	 * @param funcoes
	 * @param capacidadeSuccao
	 * @param alturaInstalacao
	 */
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int velocidades, 
			String funcoes, int capacidadeSuccao, double alturaInstalacao) {
		
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(velocidades > 0) {
			this.setVelocidades(velocidades);
		}
		if(funcoes != null) {
			this.setFuncoes(funcoes);
		}
		if(capacidadeSuccao > 0) {
			this.setCapacidadeSuccao(capacidadeSuccao);
		}
		if(alturaInstalacao > 0) {
			this.setAlturaInstalacao(alturaInstalacao);
		}
	}
	
	/**
	 * O m�todo "ler" � sobreescrito e invocado, para reutiliza��o
	 * da formata��o j� feita e adi��o da formata��o dos atritutos
	 * particulares de CoifaDepuradorDeAr
	 * 
	 * @return String contendo os atributos da Classe formatados
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Velocidades: " + this.getVelocidades() + "<br>Fun��es: " + this.getFuncoes() 
				+ "<br>Capacidade de suc��o: " + this.getCapacidadeSuccao() + "<br>Altura de instala��o: " 
				+ this.getAlturaInstalacao() + "<html>";
		
	}

	public int getVelocidades() {
		return velocidades;
	}

	public void setVelocidades(int velocidade) {
		this.velocidades = velocidade;
	}

	public String getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(String funcoes) {
		this.funcoes = funcoes;
	}
	
	/**
	 * Este get pega a capacidade de suc��o e a formata adicionando
	 * sua respectiva medida
	 * 
	 * @return String da capacidade de suc��o com a sua medida
	 */
	
	public String getCapacidadeSuccao() {
		return String.format("%s m3/h", capacidadeSuccao);
	}

	public void setCapacidadeSuccao(int capacidadeSuccao) {
		this.capacidadeSuccao = capacidadeSuccao;
	}
	
	/**
	 * Este get pega a altura e atribui sua medida a mesma para 
	 * melhor leitura das informa��es
	 * 
	 * @return String da altura de instala��o com sua medida
	 */
	
	public String getAlturaInstalacao() {
		return String.format("%scm", alturaInstalacao);
	}

	public void setAlturaInstalacao(double alturaInstalacao) {
		this.alturaInstalacao = alturaInstalacao;
	}
}
