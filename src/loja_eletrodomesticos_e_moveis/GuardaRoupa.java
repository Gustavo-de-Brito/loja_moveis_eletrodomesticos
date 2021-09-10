package loja_eletrodomesticos_e_moveis;

public final class GuardaRoupa extends Produto {
	private int qtdPortas;
	private int qtdGavetas;
	private String tipoPuxadores;
	private String espelho;
	
	public GuardaRoupa(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int qtdPortas,
			int qtdGavetas, String tipoPuxadores, String espelho) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setQtdPortas(qtdPortas);
		this.setQtdGavetas(qtdGavetas);
		this.setTipoPuxadores(tipoPuxadores);
		
	}

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
	
	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "\nQuantidade de portas: " + this.getQtdPortas() + "\nQuantidade de Gavetas: "
				+ this.getQtdGavetas() + "\nTipo de puxadores: " + this.getTipoPuxadores() + "\nEspelho: " 
				+ this.getEspelho();
		
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
