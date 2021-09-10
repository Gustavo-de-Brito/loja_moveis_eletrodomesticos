package loja_eletrodomesticos_e_moveis;

public final class ArCondicionado extends Produto{
	private String controleRemoto;
	private String ciclo;
	private int capacidadeRefrigeracao;
	
	
	
	public ArCondicionado(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, String controleRemoto, 
			String ciclo, int capacidadeRefrigeracao) {
		super.cadastrar(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		this.setControleRemoto(controleRemoto);
		this.setCiclo(ciclo);
		this.setCapacidadeRefrigeracao(capacidadeRefrigeracao);
	}
	
	@Override
	public String ler() {
		return "Nome: " + getNome() + "\nPreço: R$" + getPreco() + "\nCategoria: " + getCategoria() +
				"\nTipo: " + getTipo() + "\nMarca: " + getMarca();
	}
	
	public void editar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade, String controleRemoto, 
			String ciclo, int capacidadeRefrigeracao) {
		
		super.alterarInformacoes(nome, id, preco, descricao, cor, peso, marca, categoria, tipo, altura, largura, profundidade);
		
		if(controleRemoto != null) {
			this.setControleRemoto(controleRemoto);
		}
		if(ciclo != null) {
			this.setCiclo(ciclo);
		}
		if(capacidadeRefrigeracao > 0) {
			this.setCapacidadeRefrigeracao(capacidadeRefrigeracao);
		}
		
	}
	
	public String getControleRemoto() {
		return controleRemoto;
	}
	public void setControleRemoto(String controleRemoto) {
		this.controleRemoto = controleRemoto;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getCapacidadeRefrigeracao() {
		return String.format("%s BTUs", capacidadeRefrigeracao);
	}
	public void setCapacidadeRefrigeracao(int capacidadeRefrigeracao) {
		this.capacidadeRefrigeracao = capacidadeRefrigeracao;
	}
	
}
