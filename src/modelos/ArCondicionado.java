package modelos;

/**
 * Esta classe herdará de produto e incrementará características próprias
 * de um ar condicionado 
 * 
 * @author Gustavo de Brito Araújo
 *
 */

public final class ArCondicionado extends Produto{
	private String controleRemoto;
	private String ciclo;
	private int capacidadeRefrigeracao;
	
	/**
	 * O construtor da classe recebe todos os valores para criação de um
	 * produto, mais os valores que particularizam um ar condicionado, é
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
	 * @param controleRemoto Descrição da presença ou ausência de um controle remoto
	 * @param ciclo Pode ser frio, quente ou ambos
	 * @param capacidadeRefrigeracao Capacidade em BTUs(600 BTUs refrigeram 1 m quadrado de ambiente
	 */
	
	public ArCondicionado(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, String controleRemoto, 
			String ciclo, int capacidadeRefrigeracao) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setControleRemoto(controleRemoto);
		this.setCiclo(ciclo);
		this.setCapacidadeRefrigeracao(capacidadeRefrigeracao);
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
	 * @param controleRemoto
	 * @param ciclo
	 * @param capacidadeRefrigeracao
	 */
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, String controleRemoto, 
			String ciclo, int capacidadeRefrigeracao) {
		
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura,
				profundidade);
		
		if(controleRemoto != null) {
			this.setControleRemoto(controleRemoto);
		}
		if(ciclo != null) {
			this.setCiclo(ciclo);
		}
		if(capacidadeRefrigeracao > 0) {
			this.setCapacidadeRefrigeracao(capacidadeRefrigeracao);
		}
		
	}
	
	/**
	 * O método "ler" é sobreescrito e invocado, para reutilização
	 * da formatação já feita e adição da formatação dos atritutos
	 * particulares de ArCondicionado
	 * 
	 * @return String contendo todas as informações de ArCondicionado
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Controle Remoto: " + this.getControleRemoto() + "<br>Ciclo: " + this.getCiclo()
		+ "<br>Capacidade de Refrigeração: " + this.getCapacidadeRefrigeracao() + "<html>";
	}
	
	public String getControleRemoto() {
		return controleRemoto;
	}
	public void setControleRemoto(String controleRemoto) {
		this.controleRemoto = controleRemoto;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	
	/**
	 * Este get além de receber o valor, o formata com a unidade para
	 * melhor visualização e compreensão da informação
	 * 
	 * @return String com a capacidade de refrigeração e sua unidade de medida
	 */
	
	public String getCapacidadeRefrigeracao() {
		return String.format("%s BTUs", capacidadeRefrigeracao);
	}
	public void setCapacidadeRefrigeracao(int capacidadeRefrigeracao) {
		this.capacidadeRefrigeracao = capacidadeRefrigeracao;
	}
	
}
