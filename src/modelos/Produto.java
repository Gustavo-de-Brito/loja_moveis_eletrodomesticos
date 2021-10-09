package modelos;

/**
 * Esta classe servirá de modelo para os demais produtos da loja.
 * 
 * @author Gustavo de Brito Araújo
 */

public abstract class Produto {
	private String nome;
	private int id;
	private double preco; 
	private String descricao;
	private String cor;
	private double peso;
	private String marca;
	private String categoria;
	private String tipo;
	private double altura;
	private double largura;
	private double profundidade;
	
	/**
	 * O método receberá todos os valores para todos os seus
	 * atributos e agirá com o construtor nos construtores das classes
	 * que herdarão de Produto, uma vez que todos os produtos tem
	 * essas mesmas características e forma de declarar as mesmas
	 * 
	 * @param nome nome ou modelo do produto
	 * @param id indetificador numerico
	 * @param preco categoria do produto(geladeira, fogão, cama...)
	 * @param descricao
	 * @param cor
	 * @param peso
	 * @param marca
	 * @param categoria categoria do produto(geladeira, fogão, cama...)
	 * @param tipo tipo do produto(Móvel ou Eletrodoméstico)
	 * @param altura
	 * @param largura
	 * @param profundidade
	 */
	
	public void cadastrar(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade) {
		this.setNome(nome);
		this.setId(id);
		this.setPreco(preco);
		this.setDescricao(descricao);
		this.setCor(cor);
		this.setPeso(peso);
		this.setMarca(marca);
		this.setCategoria(categoria);
		this.setTipo(tipo);
		this.setAltura(altura);
		this.setLargura(largura);
		this.setProfundidade(profundidade);
		
	}
	
	/**
	 * Semelhante ao método "cadastrar", o método alterar
	 * informações também recebe todos os valores para seus
	 * atributos, com a diferença que ele pode receber um
	 * valor "null", nesse caso ele manterá seu valor anterior.
	 * Será utilizado juntamente com o método "editar" das classes
	 * que herdam de produto, pois o método mais uma vez altera os 
	 * valores dos atributos presentes em todas as classes herdadas
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
	 */
	
	public void alterarInformacoes(String nome, int id, double preco, String descricao, String cor, double peso, String marca,
			String categoria, String tipo, double altura, double largura, double profundidade) {
		
		if(nome != null) {
			this.setNome(nome);
		}
		if(id > 0) {
			this.setId(id);
		}
		if(preco > 0) {
			this.setPreco(preco);
		}
		if(descricao != null) {
			this.setDescricao(descricao);
		}
		if(cor != null) {
			this.setCor(cor);
		}
		if(peso > 0) {
			this.setPeso(peso);
		}
		if(marca != null) {
			this.setMarca(marca);
		}
		if(categoria != null) {
			this.setCategoria(categoria);
		}
		if(tipo != null) {
			this.setTipo(tipo);
		}
		if(altura > 0) {
			this.setAltura(altura);
		}
		if(largura > 0) {
			this.setLargura(largura);
		}
		if(profundidade > 0) {
			this.setProfundidade(profundidade);
		}
		
	}
	
	/**
	 * Este método formata os valores de cada atributo de forma a ser
	 * compatível com a interface(fazendo uso de elementos html para
	 * quebra de linha, por exemplo) e mais legível ao usuário, e o retorna
	 * 
	 * @return String com todas as informações da classe
	 */
	
	public String ler() {
		return "<html>Nome: " + this.getNome() + "<br>ID: " + this.getId() + "<br>Preço: R$" + this.getPreco() + 
				"<br>Descrição: " + this.getDescricao() + "<br>Cor: " + this.getCor() + "<br>Peso: " + this.getPeso() + 
				"<br>Marca: " + this.getMarca() + "<br>Categoria: " + this.getCategoria() + "<br>Tipo: " + this.getTipo() +
				"<br>Altura: " + this.getAltura() + "<br>Largura: " + this.getLargura() + "<br>Profundidade: " +
				this.getProfundidade();
	}
	
	
	/**
	 * Funciona de forma semelhante ao método "ler", mas trazendo apenas 
	 * as informações mais relevantes para um cliente
	 * 
	 * @return String com as informações mais relevantes da classe 
	 */
	
	public String toString() {
		return "<html>Nome: " + this.getNome() + "<br>ID: " + this.getId() + "<br>Preço: R$" + this.getPreco() + 
				"<br>Categoria: " + this.getCategoria() + "<br>Tipo: " + this.getTipo() + "<br>Marca: " + this.getMarca()
				+ "<html>";
		
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPreco() {
		return String.format("%.2f", preco);
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
			this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPeso() {
		return String.format("%skg", peso);
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getAltura() {
		return String.format("%scm", altura);
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getLargura() {
		return String.format("%scm", largura);
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public String getProfundidade() {
		return String.format("%scm", profundidade);
	}

	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}

}
