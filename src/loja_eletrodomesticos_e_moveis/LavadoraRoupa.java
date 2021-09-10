package loja_eletrodomesticos_e_moveis;

public final class LavadoraRoupa extends Produto {
	
	private int capacidade;
	private int niveisDeAgua;
	private int velocidadeCentrifugacao;
	private int programaDeLavagem;
	
	public LavadoraRoupa(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int capacidade, 
			int niveisDeAgua, int velocidadeCentrifugacao, int programaDeLavagem) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setCapacidade(capacidade);
		this.setNiveisDeAgua(niveisDeAgua);
		this.setVelocidadeCentrifugacao(velocidadeCentrifugacao);
		this.setProgramaDeLavagem(programaDeLavagem);
	}
	
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
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "\nCapcidade: " + this.getCapacidade() + "\nNíveis de água: " + this.getNiveisDeAgua()
				+ "\nVelocidade de Centrifugação: " + this.getVelocidadeCentrifugacao() + "\nProgramas de Lavagem: "
				+ this.getProgramaDeLavagem();

	}

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
