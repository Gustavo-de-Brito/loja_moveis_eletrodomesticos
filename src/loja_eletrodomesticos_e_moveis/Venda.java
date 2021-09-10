package loja_eletrodomesticos_e_moveis;

import java.time.LocalDate;
import java.time.LocalTime;

public final class Venda {
	private Produto produto;
	private String valorProduto;
	private Cliente cliente;
	private Vendedor vendedor;
	private int qtdVendida;
	private LocalDate data;
	private LocalTime horario;
	private boolean vendaValida;
	
	public Venda(Produto produto, Cliente cliente, Vendedor vendedor, int qtdVendida, LocalDate data, LocalTime horario, 
			Estoque estoque) {
		String indexProduto = estoque.pesquisarProduto(produto.getId());
		
		if(indexProduto == "Produto n�o encontrado") {
			this.setVendaValida(false);
		} else {
			if(qtdVendida > estoque.pesquisarQtdProduto(Integer.parseInt(indexProduto))) {
				this.setVendaValida(false);
			} else {
				this.setProduto(produto);
				this.setValorProduto(produto.getPreco());
				this.setCliente(cliente);
				this.setVendedor(vendedor);
				// Subtra��o da quantidade vendida pelo total em estoque
				estoque.setQtdProdutos(estoque.pesquisarQtdProduto(Integer.parseInt(indexProduto)) - qtdVendida);
				this.setQtdVendida(qtdVendida);
				this.setData(data);
				this.setHorario(horario);
				this.setVendaValida(true);
				
			}
		}
		
	}
	
	public void editar(Produto produto, Cliente cliente, Vendedor vendedor, int qtdVendida, LocalDate data,
			LocalTime horario, Estoque estoque) {
		int qtdAnterior = this.getQtdVendida();
		String indexProduto = estoque.pesquisarProduto(produto.getId());
		
		if(indexProduto == "Produto n�o encontrado") {
			this.setVendaValida(false);
		} else {
			if(qtdVendida > estoque.pesquisarQtdProduto(Integer.parseInt(indexProduto))) {
				this.setVendaValida(false);
			} else {
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
					estoque.setQtdProdutos(estoque.pesquisarQtdProduto(Integer.parseInt(indexProduto)) + qtdAnterior);
					// Subtra��o da quantidade vendida pelo total em estoque
					estoque.setQtdProdutos(estoque.pesquisarQtdProduto(Integer.parseInt(indexProduto)) - qtdVendida);
					this.setQtdVendida(qtdVendida);
				}
				if(data != null) {
					this.setData(data);			
				}
				if(horario != null) {
					this.setHorario(horario);			
				}
				this.setVendaValida(true);
				
			}
		}
		
	}
	
	public String toString() {
		return "Produto: " + this.getProduto().getNome() + "\nPre�o: " + this.getValorProduto() + "\nClient: " 
				+ this.getCliente().getNome() + "\nvendedor: " + this.getVendedor().getNome() + "\nQuantidade vendida: "
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
	public boolean isVendaValida() {
		return vendaValida;
	}
	public void setVendaValida(boolean vendaValida) {
		this.vendaValida = vendaValida;
	}
	
}
