package loja_eletrodomesticos_e_moveis;

public final class CoifaDepuradorDeAr extends Produto {
	
	private int velocidades;
	private String funcoes;
	private int capacidadeSuccao;
	private double alturaInstalacao;
	
	public CoifaDepuradorDeAr(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int velocidades, 
			String funcoes, int capacidadeSuccao, double alturaInstalacao) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setVelocidades(velocidades);
		this.setFuncoes(funcoes);
		this.setCapacidadeSuccao(capacidadeSuccao);
		this.setAlturaInstalacao(alturaInstalacao);
	}

	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int velocidades, 
			String funcoes, int capacidadeSuccao, double alturaInstalacao) {
		
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(velocidades > 0) {
			this.setVelocidades(velocidades);
		}
		if(funcoes != null) {
			this.setFuncoes(funcoes);
		}
		if(capacidadeSuccao > 0) {
			this.setCapacidadeSuccao(capacidadeSuccao);
		}
		if(alturaInstalacao > 0) {
			this.setAlturaInstalacao(alturaInstalacao);
		}
	}
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "\nVelocidades: " + this.getVelocidades() + "\nFunções: " + this.getFuncoes() 
				+ "\nCapacidade de sucção: " + this.getCapacidadeSuccao() + "\nAltura de instalação: " 
				+ this.getAlturaInstalacao();
		
	}

	public int getVelocidades() {
		return velocidades;
	}

	public void setVelocidades(int velocidade) {
		this.velocidades = velocidade;
	}

	public String getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(String funcoes) {
		this.funcoes = funcoes;
	}

	public String getCapacidadeSuccao() {
		return String.format("%s m3/h", capacidadeSuccao);
	}

	public void setCapacidadeSuccao(int capacidadeSuccao) {
		this.capacidadeSuccao = capacidadeSuccao;
	}

	public String getAlturaInstalacao() {
		return String.format("%scm", alturaInstalacao);
	}

	public void setAlturaInstalacao(double alturaInstalacao) {
		this.alturaInstalacao = alturaInstalacao;
	}
}
