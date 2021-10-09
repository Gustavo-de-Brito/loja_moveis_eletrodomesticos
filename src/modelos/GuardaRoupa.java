package modelos;

/**
 * Esta classe herdará de produto e incrementará características próprias
 * de um guarda roupa 
 * 
 * @author Gustavo de Brito Araújo
 *
 */

public final class GuardaRoupa extends Produto {
	private int qtdPortas;
	private int qtdGavetas;
	private String tipoPuxadores;
	private String espelho;
	
	/**
	 * O construtor da classe recebe todos os valores para criação de um
	 * produto, mais os valores que particularizam um guarda roupa, é
	 * utilizado o método cadastar de produto para a atribuição dos valores 
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
	 * @param qtdPortas
	 * @param qtdGavetas
	 * @param tipoPuxadores material de os puxadores são feitos
	 * @param espelho se há ou não espelho
	 */
	
	public GuardaRoupa(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int qtdPortas,
			int qtdGavetas, String tipoPuxadores, String espelho) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setQtdPortas(qtdPortas);
		this.setQtdGavetas(qtdGavetas);
		this.setTipoPuxadores(tipoPuxadores);
		
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
	 * @param qtdPortas
	 * @param qtdGavetas
	 * @param tipoPuxadores
	 * @param espelho
	 */
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int qtdPortas, 
			int qtdGavetas, String tipoPuxadores, String espelho) {
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(qtdPortas > 0) {
			this.setQtdPortas(qtdPortas);
		}
		if(qtdPortas > 0) {
			this.setQtdGavetas(qtdGavetas);
		}
		if(tipoPuxadores != null) {
			this.setTipoPuxadores(tipoPuxadores);
		}
		if(espelho != null) {
			this.setEspelho(espelho);
		}
		
	}
	
	/**
	 * O método "ler" é sobreescrito e invocado, para reutilização
	 * da formatação já feita e adição da formatação dos atritutos
	 * particulares de GuardaRoupa
	 * 
	 * @return String contendo todas as informações de GuardaRoupa
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Quantidade de portas: " + this.getQtdPortas() + "<br>Quantidade de Gavetas: "
				+ this.getQtdGavetas() + "<br>Tipo de puxadores: " + this.getTipoPuxadores() + "<br>Espelho: " 
				+ this.getEspelho() + "<html>";
		
	}

	public int getQtdPortas() {
		return qtdPortas;
	}

	public void setQtdPortas(int qtdPortas) {
		this.qtdPortas = qtdPortas;
	}

	public int getQtdGavetas() {
		return qtdGavetas;
	}

	public void setQtdGavetas(int qtdGavetas) {
		this.qtdGavetas = qtdGavetas;
	}

	public String getTipoPuxadores() {
		return tipoPuxadores;
	}

	public void setTipoPuxadores(String tipoPuxadores) {
		this.tipoPuxadores = tipoPuxadores;
	}

	public String getEspelho() {
		return espelho;
	}

	public void setEspelho(String espelho) {
		this.espelho = espelho;
	}

}
