package modelos;

/**
 * Esta classe herdará de produto e incrementará características próprias
 * de uma cama 
 * 
 * @author Gustavo de Brito Araújo
 *
 */

public final class Cama extends Produto {
	private String tamanho;
	private String tipoColchao;
	private String nivelConforto;
	private String protecao;
	
	/**
	 * O construtor da classe recebe todos os valores para criação de um
	 * produto, mais os valores que particularizam uma cama, é utilizado 
	 * o método cadastar de produto para a atribuição dos valores 
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
	 * O método "ler" é sobreescrito e invocado, para reutilização
	 * da formatação já feita e adição da formatação dos atritutos
	 * particulares de Cama
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Tamanho: " + this.getTamanho() + "<br>Tipo de Colchão: " + this.getTipoColchao() + 
				"<br>Nível de conforto: " + this.getNivelConforto() + "<br>Proteção: " + this.getProtecao() + "<html>";
		
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
