package modelos;

/**
 * Esta classe herdar� de produto e incrementar� caracter�sticas pr�prias
 * de uma geladeira
 * 
 * @author Gustavo de Brito Ara�jo
 *
 */

public final class Geladeira extends Produto {
	private String tipoPorta;
	private double capacidadeArmazenamento;
	private int qtdPrateleira;
	
	/**
	 * O construtor da classe recebe todos os valores para cria��o de um
	 * produto, mais os valores que particularizam uma geladeira, � utilizado
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
	 * @param tipoPorta dupla e inverse, por exemplo
	 * @param capacidadeArmazenamento capacidade de armazenamento total em litros
	 * @param qtdPrateleira
	 */
	
	public Geladeira(String nome, int id, double preco, String descricao, String cor, double peso, String marca, 
			String categoria, String tipo, double altura, double largura, double profundidade, String tipoPorta, 
			double capacidadeArmazenamento, int qtdPrateleira) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setTipoPorta(tipoPorta);
		this.setCapacidadeArmazenamento(capacidadeArmazenamento);
		this.setQtdPrateleira(qtdPrateleira);
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
	 * @param tipoPorta
	 * @param capacidadeArmazenamento
	 * @param qtdPrateleira
	 */
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, String tipoPorta,
			double capacidadeArmazenamento, int qtdPrateleira) {
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(tipoPorta != null) {
			this.setTipoPorta(tipoPorta);
		}
		if(capacidadeArmazenamento > 0) {
			this.setCapacidadeArmazenamento(capacidadeArmazenamento);
		}
		if(qtdPrateleira > 0) {
			this.setQtdPrateleira(qtdPrateleira);
		}
	}
	
	/**
	 * O m�todo "ler" � sobreescrito e invocado, para reutiliza��o
	 * da formata��o j� feita e adi��o da formata��o dos atritutos
	 * particulares de Geladeira
	 * 
	 * @return String contendo todas as informa��es de Geladeira
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Tipo de porta: " + this.getTipoPorta() + "<br>Capacidade de armazenamento: " 
		+ this.getCapacidadeArmazenamento() + "<br>Quantidade de prateleiras: " + this.getQtdPrateleira() + "<html>";
	}
	
	public String getTipoPorta() {
		return tipoPorta;
	}

	public void setTipoPorta(String tipoPorta) {
		this.tipoPorta = tipoPorta;
	}
	
	/**
	 * Este get pega a capacidade de armazenamento e adiciona a 
	 * sua respectiva medida
	 * 
	 * @return String contendo a capacidade de armazenamento com sua medida em Litros
	 */
	
	public String getCapacidadeArmazenamento() {
		return String.format("%sL", this.capacidadeArmazenamento);
	}

	public void setCapacidadeArmazenamento(double capacidadeArmazenamento) {
		this.capacidadeArmazenamento = capacidadeArmazenamento;
	}

	public int getQtdPrateleira() {
		return qtdPrateleira;
	}

	public void setQtdPrateleira(int qtdPrateleira) {
		this.qtdPrateleira = qtdPrateleira;
	}
	
}
