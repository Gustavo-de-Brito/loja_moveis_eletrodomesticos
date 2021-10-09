package modelos;

/**
 * Esta classe herdará de produto e incrementará características próprias
 * de uma lavadora de roupas
 * 
 * @author Gustavo de Brito Araújo
 *
 */

public final class LavadoraRoupa extends Produto {
	private int capacidade;
	private int niveisDeAgua;
	private int velocidadeCentrifugacao;
	private int programaDeLavagem;
	
	/**
	 * O construtor da classe recebe todos os valores para criação de um
	 * produto, mais os valores que particularizam uma lavadora de roupa, é
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
	 * @param capacidade capacidade me kg
	 * @param niveisDeAgua quantidade de níveis de água
	 * @param velocidadeCentrifugacao velocidade em RPM(Rotações por minuto)
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
	 * O método "ler" é sobreescrito e invocado, para reutilização
	 * da formatação já feita e adição da formatação dos atritutos
	 * particulares de LavadoraRoupa
	 * 
	 * @return String contendo todas as informações de LavadoraRoupa
	 */
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "<br>Capcidade: " + this.getCapacidade() + "<br>Níveis de água: " + this.getNiveisDeAgua()
				+ "<br>Velocidade de Centrifugação: " + this.getVelocidadeCentrifugacao() + "<br>Programas de Lavagem: "
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
	 * Este get pega a velocidade de centrifugação e retorna a mesma com
	 * sua respectiva medida
	 * 
	 * @return String da velocidade de centrifugação em RPM 
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
