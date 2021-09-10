package loja_eletrodomesticos_e_moveis;

import java.util.ArrayList;

public class Estoque {
	private ArrayList<Produto> produtos;
	private ArrayList<Integer> qtdProdutos;
	
	public Estoque() {
		produtos = new ArrayList<Produto>();
		qtdProdutos = new ArrayList<Integer>();
		
	}
	
	public String toString() {
		return "Total de categoria(s) de produtos em estoque: " + this.getProdutos().size();
		
	}
	
	public void cadastrarProduto(Produto produto, int qtdProduto) {
		this.setProdutos(produto);
		this.setQtdProdutos(qtdProduto);
		
	}
	
	public String lerProdutosEmEstoque() {
		String inventario = "";
		for(int i = 0; i < this.getProdutos().size(); i++) {
			if(i != this.getProdutos().size() - 1) {
				inventario += this.getProdutos().get(i).toString() + "\nQuantidade em estoque: " + 
						this.getQtdProdutos().get(i) + "\n\n";				
			} else {
				inventario += this.getProdutos().get(i).toString() + "\nQuantidade em estoque: " + 
						this.getQtdProdutos().get(i) + "\n";
			}
		}
		
		return inventario;
		
	}
	
	public String pesquisarProduto(int id) {
		String produtoEscolhido = "Produto não encontrado";
		
		for(Produto produto : this.getProdutos()) {
			if(id == produto.getId()) {
				produtoEscolhido = Integer.toString(this.getProdutos().indexOf(produto));
			}
		}
		
		return produtoEscolhido;
	}
	
	// Pesquisa um produto por nome e devolve o índice para ser selecionado posteiriormente
	public String pesquisarProduto(String nome) {
		String produtoEscolhido = "Produto não encontrado";
		
		for(Produto produto : this.getProdutos()) {
			if(nome == produto.getNome()) {
				produtoEscolhido = Integer.toString(this.getProdutos().indexOf(produto));
			}
		}
		
		return produtoEscolhido;
	}
	
	
	// pesquisa e devolve vários produtos por preco
	public ArrayList<Produto> pesquisarProdutosPreco(double precoMax) {
		ArrayList<Produto> produtosPrecoDeterminado = new ArrayList<Produto>();
		
		for(Produto produto : produtos) {
			String[] precoNaoFormatado = produto.getPreco().split(" ");
			
			if(Double.parseDouble(precoNaoFormatado[1].replace(",", ".")) <= precoMax) {
				produtosPrecoDeterminado.add(produto);
			}
		}
		
		return produtosPrecoDeterminado;
		
	}
	
	// pesquisa e devolve vários produtos por categoria
	public ArrayList<Produto> pesquisarProdutosCategoria(String categoria) {
		ArrayList<Produto> produtosCategoriaEscolhida = new ArrayList<Produto>();
		
		for(Produto produto : produtos) {
			if(produto.getCategoria().equals(categoria)) {
				produtosCategoriaEscolhida.add(produto);
			}
		}
		
		return produtosCategoriaEscolhida;
		
	}
	
	// pesquisa e devolve vários produtos por tipo
	public ArrayList<Produto> pesquisarProdutosTipo(String tipo) {
		ArrayList<Produto> produtosTipoEscolhido = new ArrayList<Produto>();
		
		for(Produto produto : produtos) {
			if(produto.getTipo().equals(tipo)) {
				produtosTipoEscolhido.add(produto);
			}
		}
		
		return produtosTipoEscolhido;
		
	}
	
	// para ser usada juntamente com pesquisarProduto()
	public Produto selecionarProduto(int index) {
		return this.getProdutos().get(index);
		
	}
	
	// para ser usada juntamente com pesquisarProduto()
	public int pesquisarQtdProduto(int index) {
		return this.getQtdProdutos().get(index);
		
	}
	
	// para ser usada juntamente com pesquisarProduto()
	public void excluirProduto(int index) {
		this.getProdutos().remove(index);
		
	}
	
	public ArrayList<Integer> getQtdProdutos() {
		return qtdProdutos;
	}
		
	public void setQtdProdutos(Integer qtdProduto) {
		this.qtdProdutos.add(qtdProduto);
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Produto produto) {
		this.produtos.add(produto);
	}
	
}
