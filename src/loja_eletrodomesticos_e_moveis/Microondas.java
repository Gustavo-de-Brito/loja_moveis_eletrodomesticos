package loja_eletrodomesticos_e_moveis;

public final class Microondas extends Produto {
	private double capacidade;
	private String termostato;
	private String pratoGiratorio;
	
	public Microondas(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, double capacidade,
			String termostato, String pratoGiratorio) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setCapacidade(capacidade);
		this.setTermostato(termostato);
		this.setPratoGiratorio(pratoGiratorio);
	}

	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, double capacidade,
			String termostato, String pratoGiratorio) {
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(capacidade > 0) {
			this.setCapacidade(capacidade);
		}
		if(termostato != null) {
			this.setTermostato(termostato);
		}
		if(pratoGiratorio != null) {
			this.setPratoGiratorio(pratoGiratorio);
		}
		
	}
	
	@Override
	public String ler() {
		String informacoes = super.ler();
	
		return informacoes + "\nCapacidade: " + this.getCapacidade() + "\nTermostato: " + this.getTermostato()
				+ "\nPrato giratório: " + this.getPratoGiratorio();
		
	}
	
	public String getCapacidade() {
		return String.format("%sL", capacidade);
	}

	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}

	public String getTermostato() {
		return termostato;
	}

	public void setTermostato(String termostato) {
		this.termostato = termostato;
	}

	public String getPratoGiratorio() {
		return pratoGiratorio;
	}

	public void setPratoGiratorio(String pratoGiratorio) {
		this.pratoGiratorio = pratoGiratorio;
	}

}
