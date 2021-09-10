package loja_eletrodomesticos_e_moveis;

public final class Fogao extends Produto {
	
	private int numeroBocas;
	private String tipoMontagem;
	private String acendimento;
	private String alimentacao;
	
	
	public Fogao(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, int numeroBocas, 
			String tipoMontagem, String acendimento, String alimentacao) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setNumeroBocas(numeroBocas);
		this.setTipoMontagem(tipoMontagem);
		this.setAcendimento(acendimento);
		this.setAlimentacao(alimentacao);
	}
	
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

	@Override
	public String ler() {
		String informacoes = super.ler();
		
		return informacoes + "\nNúmero de bocas: " + this.getNumeroBocas() + "\nTipo de montagem: " + this.getTipoMontagem()
				+ "\nAcendimento: " + this.getAcendimento() + "\nAlimentação: " + this.getAlimentacao();
		
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
