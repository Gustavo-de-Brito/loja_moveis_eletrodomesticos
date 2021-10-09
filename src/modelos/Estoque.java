package modelos;

import java.util.ArrayList;

/**
 * Esta classe é reponsável por armazenar e manipular os produtos
 * e suas respectivas quantidades
 * 
 * @author Gustavo de Brito Araújo
 */

public class Estoque {
	private ArrayList<Produto> produtos;
	private ArrayList<Integer> qtdProdutos;
	
	/**
	 * O construtor apenas inicia as variaveis, todos os valores
	 * serão adicionados um a um
	 */
	
	public Estoque() {
		produtos = new ArrayList<Produto>();
		qtdProdutos = new ArrayList<Integer>();
		
	}
	
	/**
	 * Este método retorna as informações de estoque são dadas pela
	 *  quantidade de modelos de produtos diferentes em estoque
	 *  
	 *  @return String com a quantidade de modelos diferentes em estoque 
	 */
	
	public String toString() {
		return "Total de modelo(s) de produtos em estoque: " + this.getProdutos().size();
		
	}
	
	/**
	 * Este método adiciona um produto e sua respectiva quantidade as 
	 * suas listas determinadas
	 * 
	 * @param produto
	 * @param qtdProduto
	 */
	
	public void cadastraProduto(Produto produto, int qtdProduto) {
		this.setProdutos(produto);
		this.setQtdProdutos(qtdProduto);
		
	}
	
	/**
	 * Este método lê todos os produtos dentro de estoque e retorna a 
	 * informação mais simples possível sobre ele
	 * 
	 * @return String com a categoria e o nome/modelo do produto
	 */
	
	public ArrayList<String> leProdutosEmEstoque() {
		ArrayList<String> inventario = new ArrayList<String>();
		
		int i = 0;
		for(i = 0; i < this.getProdutos().size(); i++) {
			inventario.add(this.getProdutos().get(i).getCategoria() + ": " + this.getProdutos().get(i).getNome());				
			
		}
		
		return inventario;
		
	}
	
	
	/**
	 * Pesquisa um produto pelo id e devolve sua posição na lista de produtos
	 * 
	 * @param id indetificador numérico do produto
	 * @return index/posição do produto determinado
	 */
	
	public int pesquisarProduto(int id) {
		int produtoEscolhido = -1;
		
		for(Produto produto : this.getProdutos()) {
			if(id == produto.getId()) {
				produtoEscolhido = this.getProdutos().indexOf(produto);
			}
		}
		
		return produtoEscolhido;
	}
	
	/**
	 * Pesquisa um produto por nome e devolve sua posição na lista de produtos
	 *  
	 * @param nome nome/modelo do produto
	 * @return index/posição do produto determinado
	 */
	
	public int pesquisarProduto(String nome) {
		int produtoEscolhido = -1;
		
		for(Produto produto : this.getProdutos()) {
			if(nome.equalsIgnoreCase(produto.getNome())) {
				produtoEscolhido = this.getProdutos().indexOf(produto);
			}
		}
		
		return produtoEscolhido;
	}
	
	/**
	 * Pesquisa e devolve os produtos com preço igual ou inferior ao passado
	 * como parâmetro
	 *  
	 * @param precoMax preço máximo que o produto pode alcançar para entrar na lista
	 * @return ArrayList de Produto contendo os produtos de acordo com a faixa de preço
	 */
	
	public ArrayList<Produto> pesquisarProdutosPreco(double precoMax) {
		ArrayList<Produto> produtosPrecoDeterminado = new ArrayList<Produto>();
		
		for(Produto produto : produtos) {
			if(Double.parseDouble(produto.getPreco().replace(",", ".")) <= precoMax) {
				produtosPrecoDeterminado.add(produto);
				
			}
		}
		
		return produtosPrecoDeterminado;
		
	}
	
	/**
	 * Pesquisa e devolve os produtos com a mesma categoria especificada
	 * 
	 * @param categoria geladeira, cama, sofá, fogão...
	 * @return ArrayList de Produto com os produtos da categoria especificada
	 */
	
	public ArrayList<Produto> pesquisarProdutosCategoria(String categoria) {
		ArrayList<Produto> produtosCategoriaEscolhida = new ArrayList<Produto>();
		
		for(Produto produto : produtos) {
			if(produto.getCategoria().equals(categoria)) {
				produtosCategoriaEscolhida.add(produto);
			}
		}
		
		return produtosCategoriaEscolhida;
		
	}
	
	/**
	 * Pesquisa e devolve os produtos com o mesmo tipo especificado 
	 * 
	 * @param tipo Móvel ou Eletrodoméstico
	 * @return ArrayList de Produto com os produtos do tipo especificado
	 */
	
	public ArrayList<Produto> pesquisarProdutosTipo(String tipo) {
		ArrayList<Produto> produtosTipoEscolhido = new ArrayList<Produto>();
		
		for(Produto produto : produtos) {
			if(produto.getTipo().equalsIgnoreCase(tipo)) {
				produtosTipoEscolhido.add(produto);
			}
			
		}
		
		return produtosTipoEscolhido;
		
	}
	
	/**
	 * Este método deve ser usado junto com pesquisarProduto() pois seleciona
	 * um produto pelo index e o retorna
	 * 
	 * @param index 
	 * @return Produto correspondente ao index especificado
	 */
	
	public Produto selecionarProduto(int index) {
		return this.getProdutos().get(index);
		
	}
	
	/**
	 * Método para ser usado junto com pesquisarProduto() corresponde com
	 * o index da lista com as respectivas quantidades em estoque do mesmo
	 * 
	 * @param index
	 * @return int referente a quantidade em estoque do produto de index passado no parâmetro
	 */
	
	public int pesquisarQtdProduto(int index) {
		return this.getQtdProdutos().get(index);
		
	}
	
	/**
	 * Este métedo deve ser usado juntamente com pesquisarProduto() para excluir
	 * um produto de acordo com um index
 	 * 
	 * @param index
	 */
	
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
