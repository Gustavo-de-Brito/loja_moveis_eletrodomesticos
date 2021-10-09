package modelos;

/**
 * Esta classe herdar� de produto e incrementar� caracter�sticas pr�prias
 * de um fog�o 
 * 
 * @author Gustavo de Brito Ara�jo
 *
 */

public final class Fogao extends Produto {
	private int numeroBocas;
	private String tipoMontagem;
	private String acendimento;
	private String alimentacao;
	
	/**
	 * O construtor da classe recebe todos os valores para cria��o de um
	 * produto, mais os valores que particularizam um fog�o, � utilizado o
	 * m�todo cadastar de produto para a atribui��o dos valores aos atributos
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
	 * @param numeroBocas
	 * @param tipoMontagem de piso ou el�trico, por exemplo
	 * @param acendimento manual ou autom�tico
	 * @param alimentacao
	 */
	
	public Fogao(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int numeroBocas, 
			String tipoMontagem, String acendimento, String alimentacao) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setNumeroBocas(numeroBocas);
		this.setTipoMontagem(tipoMontagem);
		this.setAcendimento(acendimento);
		this.setAlimentacao(alimentacao);
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
	 * @param numeroBocas
	 * @param tipoMontagem
	 * @param acendimento
	 * @param alimentacao
	 */
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade,
			int numeroBocas, String tipoMontagem, String acendimento, String alimentacao) {
		
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(numeroBocas > 0) {
			this.setNumeroBocas(numeroBocas);
		}
		if(tipoMontagem != null) {
			this.setTipoMontagem(tipoMontagem);
		}
		if(acendimento != null) {
			this.setAcendimento(acendimento);
		}
		if(alimentacao != null) {
			this.setAlimentacao(alimentacao);
		}
		
	}
	
	/**
	 * O m�todo "ler" � sobreescrito e invocado, para reutiliza��o
	 * da formata��o j� feita e adi��o da formata��o dos atritutos
	 * particulares de Fogao
	 * 
	 * @return String contendo todas as informa��es de Fogao
	 */

	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>N�mero de bocas: " + this.getNumeroBocas() + "<br>Tipo de montagem: " + 
			this.getTipoMontagem() + "<br>Acendimento: " + this.getAcendimento() + "<br>Alimenta��o: " + 
			this.getAlimentacao() + "<html>";
		
	}

	public int getNumeroBocas() {
		return numeroBocas;
	}

	public void setNumeroBocas(int numeroBocas) {
		this.numeroBocas = numeroBocas;
	}

	public String getTipoMontagem() {
		return tipoMontagem;
	}

	public void setTipoMontagem(String tipoMontagem) {
		this.tipoMontagem = tipoMontagem;
	}

	public String getAcendimento() {
		return acendimento;
	}

	public void setAcendimento(String acendimento) {
		this.acendimento = acendimento;
	}

	public String getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}
	
}
