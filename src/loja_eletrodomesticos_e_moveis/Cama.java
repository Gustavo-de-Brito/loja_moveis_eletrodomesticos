package loja_eletrodomesticos_e_moveis;

public final class Cama extends Produto {

	private String tamanho;
	private String tipoColchao;
	private String nivelConforto;
	private String protecao;
	
	public Cama(String nome, int id, double preco, String descricao, String cor, double peso, String marca, 
			String categoria, String tipo, double altura, double largura, double profundidade, String tamanho, 
			String tipoColchao, String nivelConforto, String protecao) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setTamanho(tamanho);
		this.setTipoColchao(tipoColchao);
		this.setNivelConforto(nivelConforto);
		this.setProtecao(protecao);
	}

	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, String tamanho, 
			String tipoColchao, String nivelConforto, String protecao) {
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(tamanho != null) {
			this.setTamanho(tamanho);
		}
		if(tipoColchao != null) {
			this.setTipoColchao(tipoColchao);
		}
		if(nivelConforto != null) {
			this.setNivelConforto(nivelConforto);
		}
		if(protecao != null) {
			this.setProtecao(protecao);
		}
	}

	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "\nTamanho: " + this.getTamanho() + "\nTipo de Colchão: " + this.getTipoColchao() + 
				"\nNível de conforto: " + this.getNivelConforto() + "\nProteção: " + this.getProtecao();
		
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipoColchao() {
		return tipoColchao;
	}

	public void setTipoColchao(String tipoColchao) {
		this.tipoColchao = tipoColchao;
	}

	public String getNivelConforto() {
		return nivelConforto;
	}

	public void setNivelConforto(String nivelConforto) {
		this.nivelConforto = nivelConforto;
	}

	public String getProtecao() {
		return protecao;
	}

	public void setProtecao(String protecao) {
		this.protecao = protecao;
	}
	
}
