package modelos;

/**
 * Esta classe herdar� de produto e incrementar� caracter�sticas pr�prias
 * de uma cama 
 * 
 * @author Gustavo de Brito Ara�jo
 *
 */

public final class Cama extends Produto {
	private String tamanho;
	private String tipoColchao;
	private String nivelConforto;
	private String protecao;
	
	/**
	 * O construtor da classe recebe todos os valores para cria��o de um
	 * produto, mais os valores que particularizam uma cama, � utilizado 
	 * o m�todo cadastar de produto para a atribui��o dos valores 
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
	 * @param tamanho
	 * @param tipoColchao
	 * @param nivelConforto
	 * @param protecao
	 */
	
	public Cama(String nome, int id, double preco, String descricao, String cor, double peso, String marca, 
			String categoria, String tipo, double altura, double largura, double profundidade, String tamanho, 
			String tipoColchao, String nivelConforto, String protecao) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setTamanho(tamanho);
		this.setTipoColchao(tipoColchao);
		this.setNivelConforto(nivelConforto);
		this.setProtecao(protecao);
	}
	
	/**
	 * O m�todo "ler" � sobreescrito e invocado, para reutiliza��o
	 * da formata��o j� feita e adi��o da formata��o dos atritutos
	 * particulares de Cama
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Tamanho: " + this.getTamanho() + "<br>Tipo de Colch�o: " + this.getTipoColchao() + 
				"<br>N�vel de conforto: " + this.getNivelConforto() + "<br>Prote��o: " + this.getProtecao() + "<html>";
		
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
	 * @param tamanho
	 * @param tipoColchao
	 * @param nivelConforto
	 * @param protecao
	 */
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, String tamanho, 
			String tipoColchao, String nivelConforto, String protecao) {
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(tamanho != null) {
			this.setTamanho(tamanho);
		}
		if(tipoColchao != null) {
			this.setTipoColchao(tipoColchao);
		}
		if(nivelConforto != null) {
			this.setNivelConforto(nivelConforto);
		}
		if(protecao != null) {
			this.setProtecao(protecao);
		}
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipoColchao() {
		return tipoColchao;
	}

	public void setTipoColchao(String tipoColchao) {
		this.tipoColchao = tipoColchao;
	}

	public String getNivelConforto() {
		return nivelConforto;
	}

	public void setNivelConforto(String nivelConforto) {
		this.nivelConforto = nivelConforto;
	}

	public String getProtecao() {
		return protecao;
	}

	public void setProtecao(String protecao) {
		this.protecao = protecao;
	}
	
}
