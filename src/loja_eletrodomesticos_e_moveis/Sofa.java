package loja_eletrodomesticos_e_moveis;

public final class Sofa extends Produto {
	private int qtdLugares;
	private String tipoAssento;
	private String tipoEncosto;
	private String materialEstrutura;

	public Sofa(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade,
			int qtdLugares, String tipoAssento, String tipoEncosto, String materialEstrutura) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setQtdLugares(qtdLugares);
		this.setTipoAssento(tipoAssento);
		this.setTipoEncosto(tipoEncosto);
		this.setMaterialEstrutura(materialEstrutura);
		
	}

	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade,
			int quantidadeLugares, String tipoAssento, String tipoEncosto, String materialEstrutura) {
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(quantidadeLugares > 0) {
			this.setQtdLugares(quantidadeLugares);
		}
		if(tipoAssento != null) {
			this.setTipoAssento(tipoAssento);
		}
		if(tipoEncosto != null) {
			this.setTipoEncosto(tipoEncosto);
		}
		if(materialEstrutura != null) {
			this.setMaterialEstrutura(materialEstrutura);
		}
		
	}

	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "\nQuantidade de lugares: " + this.getQtdLugares() + "\nTipo de assento: " + 
				this.getTipoAssento() + "\nTipo de encosto: " + this.getTipoEncosto() + "\nMaterial da estrutura: " +
				this.getMaterialEstrutura();
		
	}

	public int getQtdLugares() {
		return qtdLugares;
	}

	public void setQtdLugares(int qtdLugares) {
		this.qtdLugares = qtdLugares;
	}

	public String getTipoAssento() {
		return tipoAssento;
	}

	public void setTipoAssento(String tipoAssento) {
		this.tipoAssento = tipoAssento;
	}

	public String getTipoEncosto() {
		return tipoEncosto;
	}

	public void setTipoEncosto(String tipoEncosto) {
		this.tipoEncosto = tipoEncosto;
	}

	public String getMaterialEstrutura() {
		return materialEstrutura;
	}

	public void setMaterialEstrutura(String materialEstrutura) {
		this.materialEstrutura = materialEstrutura;
	}
	
}