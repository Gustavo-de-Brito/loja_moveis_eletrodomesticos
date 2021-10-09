package modelos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;

/**
 * Esta classe representar� uma venda juntando algumas outras 
 * classes e alguns atributos
 * 
 * @author Gustavo de Brito Ara�jo
 *
 */

public final class Venda {
	private Produto produto;
	private String valorProduto;
	private Cliente cliente;
	private Vendedor vendedor;
	private int qtdVendida;
	private LocalDate data;
	private LocalTime horario;
	
	/**
	 * O construtor recebe todos os par�metros necess�rios para a
	 * atribui��o dos valores a seus respectivos atributos
	 * 
	 * @param produto
	 * @param cliente
	 * @param vendedor
	 * @param qtdVendida
	 * @param data
	 * @param horario
	 * @param estoque
	 */
	
	public Venda(Produto produto, Cliente cliente, Vendedor vendedor, int qtdVendida, LocalDate data, LocalTime horario, 
			Estoque estoque) {
		int indexProduto = estoque.pesquisarProduto(produto.getId());
		
			if(!(qtdVendida > estoque.pesquisarQtdProduto(indexProduto))) {
				this.setProduto(produto);
				this.setValorProduto(produto.getPreco());
				this.setCliente(cliente);
				this.setVendedor(vendedor);
				// Subtra��o da quantidade vendida pelo total em estoque
				estoque.setQtdProdutos(estoque.pesquisarQtdProduto(indexProduto) - qtdVendida);
				this.setQtdVendida(qtdVendida);
				this.setData(data);
				this.setHorario(horario);
				
			} else {
				JOptionPane.showMessageDialog(null, "A quantidade desejada est� acima da armazenada");
			}
		
	}
	
	/**
	 * Este m�todo altera os valores j� presentes nos atributos, se o novo 
	 * valor n�o for "null".
	 * 
	 * @param produto
	 * @param cliente
	 * @param vendedor
	 * @param qtdVendida
	 * @param data
	 * @param horario
	 * @param estoque
	 */
	
	public void editar(Produto produto, Cliente cliente, Vendedor vendedor, int qtdVendida, LocalDate data,
			LocalTime horario, Estoque estoque) {
		int qtdAnterior = this.getQtdVendida();
		int indexProduto = estoque.pesquisarProduto(produto.getId());
		
		if(!(qtdVendida > estoque.pesquisarQtdProduto(indexProduto))) {			
			if(produto != null) {
				this.setProduto(produto);
			}
			if(produto.getPreco() != "R$ 0.00") {
				this.setValorProduto(produto.getPreco());			
			}
			if(cliente != null) {
				this.setCliente(cliente);			
			}
			if(vendedor != null) {
				this.setVendedor(vendedor);			
			}
			if(qtdVendida > 0) {
				// Se adiciona de volta o valor retirado no primeiro registro
				estoque.setQtdProdutos(estoque.pesquisarQtdProduto(indexProduto) + qtdAnterior);
				// Subtra��o da quantidade vendida pelo total em estoque
				estoque.setQtdProdutos(estoque.pesquisarQtdProduto(indexProduto) - qtdVendida);
				this.setQtdVendida(qtdVendida);
			}
			if(data != null) {
				this.setData(data);			
			}
			if(horario != null) {
				this.setHorario(horario);			
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "A quantidade desejada est� acima da armazenada");
			
		}

		
	}
	
	/**
	 * Este m�todo formata as caracter�sticas de Venda e retorna em uma String
	 * 
	 * @return String com os valores dos atributos de Venda formatados para visualiza��o
	 */
	
	public String toString() {
		return "Produto: " + this.getProduto().getNome() + "\nPre�o: " + this.getValorProduto() + "\nCliente: " 
				+ this.getCliente().getNome() + "\nVendedor: " + this.getVendedor().getNome() + "\nQuantidade vendida: "
				+ this.getQtdVendida() + "\nData: " + this.getData() + "\nHor�rio: " + this.getHorario();
		
	}
	
	public String getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(String valorProduto) {
		this.valorProduto = valorProduto;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public int getQtdVendida() {
		return qtdVendida;
	}
	public void setQtdVendida(int qtdVendida) {
		this.qtdVendida = qtdVendida;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
}
