package modelos;

/**
 * Esta classe herdar� de produto e incrementar� caracter�sticas pr�prias
 * de uma lavadora de roupas
 * 
 * @author Gustavo de Brito Ara�jo
 *
 */

public final class LavadoraRoupa extends Produto {
	private int capacidade;
	private int niveisDeAgua;
	private int velocidadeCentrifugacao;
	private int programaDeLavagem;
	
	/**
	 * O construtor da classe recebe todos os valores para cria��o de um
	 * produto, mais os valores que particularizam uma lavadora de roupa, �
	 * utilizado o m�todo cadastar de produto para a atribui��o dos valores 
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
	 * @param capacidade capacidade me kg
	 * @param niveisDeAgua quantidade de n�veis de �gua
	 * @param velocidadeCentrifugacao velocidade em RPM(Rota��es por minuto)
	 * @param programaDeLavagem quantidade de programas de lavagem
	 */
	
	public LavadoraRoupa(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int capacidade, 
			int niveisDeAgua, int velocidadeCentrifugacao, int programaDeLavagem) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setCapacidade(capacidade);
		this.setNiveisDeAgua(niveisDeAgua);
		this.setVelocidadeCentrifugacao(velocidadeCentrifugacao);
		this.setProgramaDeLavagem(programaDeLavagem);
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
	 * @param niveisDeAgua
	 * @param velocidadeCentrifugacao
	 * @param programaDeLavagem
	 */
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int capacidade, 
			int niveisDeAgua, int velocidadeCentrifugacao, int programaDeLavagem) {
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(capacidade > 0) {
			this.setCapacidade(capacidade);
		}
		if(niveisDeAgua > 0) {
			this.setNiveisDeAgua(niveisDeAgua);
		}
		if(velocidadeCentrifugacao > 0) {
			this.setVelocidadeCentrifugacao(velocidadeCentrifugacao);
		}
		if(programaDeLavagem > 0) {
			this.setProgramaDeLavagem(programaDeLavagem);
		}
		
	}
	
	/**
	 * O m�todo "ler" � sobreescrito e invocado, para reutiliza��o
	 * da formata��o j� feita e adi��o da formata��o dos atritutos
	 * particulares de LavadoraRoupa
	 * 
	 * @return String contendo todas as informa��es de LavadoraRoupa
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Capcidade: " + this.getCapacidade() + "<br>N�veis de �gua: " + this.getNiveisDeAgua()
				+ "<br>Velocidade de Centrifuga��o: " + this.getVelocidadeCentrifugacao() + "<br>Programas de Lavagem: "
				+ this.getProgramaDeLavagem() + "<html>";

	}
	
	/**
	 * Este get pega a capacidade e retorna a mesma com sua respectiva
	 * medida
	 * 
	 * @return String da capacidade em kg
	 */
	
	public String getCapacidade() {
		return String.format("%skg", capacidade);
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getNiveisDeAgua() {
		return niveisDeAgua;
	}

	public void setNiveisDeAgua(int niveisDeAgua) {
		this.niveisDeAgua = niveisDeAgua;
	}

	/**
	 * Este get pega a velocidade de centrifuga��o e retorna a mesma com
	 * sua respectiva medida
	 * 
	 * @return String da velocidade de centrifuga��o em RPM 
	 */
	
	public String getVelocidadeCentrifugacao() {
		return String.format("%s RPM", velocidadeCentrifugacao);
	}

	public void setVelocidadeCentrifugacao(int velocidadeCentrifugacao) {
		this.velocidadeCentrifugacao = velocidadeCentrifugacao;
	}

	public int getProgramaDeLavagem() {
		return programaDeLavagem;
	}

	public void setProgramaDeLavagem(int programaDeLavagem) {
		this.programaDeLavagem = programaDeLavagem;
	}

}
