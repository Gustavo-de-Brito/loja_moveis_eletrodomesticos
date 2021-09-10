package loja_eletrodomesticos_e_moveis;

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
	
	/*
	 *  São criados dois métodos para ler as informações, um para informações mais genéricas
	 *  e outro para mostrar informações com mais precisão
	 */
	
	public String ler() {
		return "Nome: " + this.getNome() + "\nID: " + this.getId() + "\nPreço: R$" + this.getPreco() + "\nDescrição: " 
				+ this.getDescricao() + "\nCor: " + this.getCor() + "\nPeso: " + this.getPeso() + "\nMarca: " 
				+ this.getMarca() + "\nCategoria: " + this.getCategoria() + "\nTipo: " + this.getTipo() + "\nALtura: "
				+ this.getAltura() + "\nLargura: " + this.getLargura() + "\nProfundidade: " + this.getProfundidade();
	}
	
	public String toString() {
		return "Nome: " + this.getNome() + "\nID: " + this.getId() + "\nPreço: R$" + this.getPreco() + "\nCategoria: "
				+ this.getCategoria() + "\nTipo: " + this.getTipo() + "\nMarca: " + this.getMarca();
		
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
		return String.format("R$ %.2f", preco);
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if(descricao != null && descricao != "") {			
			String fraseFormatada = "";
			
			int y = 0;
			int vezes = 0;
			int espacosAMais = 11;
			
			for(int i = 50; i < descricao.length(); i += y) {
				String fraseNaoFormatada = descricao.substring(y, i);
				String[] lista = fraseNaoFormatada.split(" ");
				
				for(int x = 0; x < lista.length - 1; x++) {
					if(!(x == lista.length - 2)) {
						fraseFormatada += lista[x] + " ";					
					} else {
						fraseFormatada += lista[x] + "\n";
					}
				}
				
				fraseFormatada += "           ";
				
				if(vezes != 0) {
					y = fraseFormatada.lastIndexOf(" ") - espacosAMais + 1;
				} else {
					y = fraseFormatada.lastIndexOf("\n") + 1;
				}
				
				i = 50;
				vezes += 1;
				espacosAMais += 11;
				
			}
			
			fraseFormatada += descricao.substring(y, descricao.length());
			
			this.descricao = fraseFormatada;
			
		} else {
			this.descricao = descricao;
		}
		
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
