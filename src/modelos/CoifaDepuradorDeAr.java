package modelos;

/**
 * Esta classe herdará de produto e incrementará características próprias
 * de uma coifa/depurador de ar 
 * 
 * @author Gustavo de Brito Araújo
 *
 */

public final class CoifaDepuradorDeAr extends Produto {
	private int velocidades;
	private String funcoes;
	private int capacidadeSuccao;
	private double alturaInstalacao;
	
	/**
	 * O construtor da classe recebe todos os valores para criação de um
	 * produto, mais os valores que particularizam uma coifa/depurador de ar, 
	 * é utilizado o método cadastar de produto para a atribuição dos valores 
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
	 * @param velocidades número de velocidades
	 * @param funcoes 
	 * @param capacidadeSuccao capacidade sucção em metros cúbicos por hora
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
	 * O método "ler" é sobreescrito e invocado, para reutilização
	 * da formatação já feita e adição da formatação dos atritutos
	 * particulares de CoifaDepuradorDeAr
	 * 
	 * @return String contendo os atributos da Classe formatados
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Velocidades: " + this.getVelocidades() + "<br>Funções: " + this.getFuncoes() 
				+ "<br>Capacidade de sucção: " + this.getCapacidadeSuccao() + "<br>Altura de instalação: " 
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
	 * Este get pega a capacidade de sucção e a formata adicionando
	 * sua respectiva medida
	 * 
	 * @return String da capacidade de sucção com a sua medida
	 */
	
	public String getCapacidadeSuccao() {
		return String.format("%s m3/h", capacidadeSuccao);
	}

	public void setCapacidadeSuccao(int capacidadeSuccao) {
		this.capacidadeSuccao = capacidadeSuccao;
	}
	
	/**
	 * Este get pega a altura e atribui sua medida a mesma para 
	 * melhor leitura das informações
	 * 
	 * @return String da altura de instalação com sua medida
	 */
	
	public String getAlturaInstalacao() {
		return String.format("%scm", alturaInstalacao);
	}

	public void setAlturaInstalacao(double alturaInstalacao) {
		this.alturaInstalacao = alturaInstalacao;
	}
}
