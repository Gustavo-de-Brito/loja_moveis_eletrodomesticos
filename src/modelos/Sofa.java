package modelos;

/**
 * Esta classe herdará de produto e incrementará características próprias
 * de um sofá
 * 
 * @author Gustavo de Brito Araújo
 *
 */

public final class Sofa extends Produto {
	private int qtdLugares;
	private String tipoAssento;
	private String tipoEncosto;
	private String materialEstrutura;

	/**
	 * O construtor da classe recebe todos os valores para criação de um
	 * produto, mais os valores que particularizam um sofá, é utilizado o 
	 * método cadastar de produto para a atribuição dos valores aos atributos
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
	 * @param qtdLugares 
	 * @param tipoAssento reclinável, por exemplo
	 * @param tipoEncosto retrátil,por exemplo
	 * @param materialEstrutura
	 */
	
	public Sofa(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade,
			int qtdLugares, String tipoAssento, String tipoEncosto, String materialEstrutura) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setQtdLugares(qtdLugares);
		this.setTipoAssento(tipoAssento);
		this.setTipoEncosto(tipoEncosto);
		this.setMaterialEstrutura(materialEstrutura);
		
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
	 * @param quantidadeLugares
	 * @param tipoAssento
	 * @param tipoEncosto
	 * @param materialEstrutura
	 */
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade,
			int quantidadeLugares, String tipoAssento, String tipoEncosto, String materialEstrutura) {
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(quantidadeLugares > 0) {
			this.setQtdLugares(quantidadeLugares);
		}
		if(tipoAssento != null) {
			this.setTipoAssento(tipoAssento);
		}
		if(tipoEncosto != null) {
			this.setTipoEncosto(tipoEncosto);
		}
		if(materialEstrutura != null) {
			this.setMaterialEstrutura(materialEstrutura);
		}
		
	}
	
	/**
	 * O método "ler" é sobreescrito e invocado, para reutilização
	 * da formatação já feita e adição da formatação dos atritutos
	 * particulares de Sofa
	 * 
	 * @return String contendo todas as informações de Sofa
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Quantidade de lugares: " + this.getQtdLugares() + "<br>Tipo de assento: " + 
				this.getTipoAssento() + "\nTipo de encosto: " + this.getTipoEncosto() + "<br>Material da estrutura: " +
				this.getMaterialEstrutura() + "<html>";
		
	}

	public int getQtdLugares() {
		return qtdLugares;
	}

	public void setQtdLugares(int qtdLugares) {
		this.qtdLugares = qtdLugares;
	}

	public String getTipoAssento() {
		return tipoAssento;
	}

	public void setTipoAssento(String tipoAssento) {
		this.tipoAssento = tipoAssento;
	}

	public String getTipoEncosto() {
		return tipoEncosto;
	}

	public void setTipoEncosto(String tipoEncosto) {
		this.tipoEncosto = tipoEncosto;
	}

	public String getMaterialEstrutura() {
		return materialEstrutura;
	}

	public void setMaterialEstrutura(String materialEstrutura) {
		this.materialEstrutura = materialEstrutura;
	}
	
}