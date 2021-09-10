package loja_eletrodomesticos_e_moveis;

import java.awt.image.BufferedImage;

public final class Geladeira extends Produto {
	
	private String tipoPorta;
	private double capacidadeArmazenamento;
	private int qtdPrateleira;
	
	public Geladeira(String nome, int id, double preco, String descricao, String cor, double peso, String marca, 
			String categoria, String tipo, double altura, double largura, double profundidade, String tipoPorta, 
			double capacidadeArmazenamento, int qtdPrateleira) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipoPorta, altura, largura, profundidade);
		
		this.setTipoPorta(tipoPorta);
		this.setCapacidadeArmazenamento(capacidadeArmazenamento);
		this.setQtdPrateleira(qtdPrateleira);
	}

	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "\nTipo de porta: " + this.getTipoPorta() + "\nCapacidade de armazenamento: " 
		+ this.getCapacidadeArmazenamento() + "\nQuantidade de prateleiras: " + this.getQtdPrateleira();
	}
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca, String categoria,
			BufferedImage imagem, String tipo, double altura, double largura, double profundidade, String tipoPorta,
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
	
	public String getTipoPorta() {
		return tipoPorta;
	}

	public void setTipoPorta(String tipoPorta) {
		this.tipoPorta = tipoPorta;
	}

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
