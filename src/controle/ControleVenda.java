package controle;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelos.Cliente;
import modelos.Dados;
import modelos.Produto;
import modelos.Venda;
import modelos.Vendedor;

public class ControleVenda {
	private ArrayList<Venda> historicoVendas;
	private ControleEstoque controleEstoque;
	private ControleCliente controleCliente;
	private ControleVendedor controleVendedor;
	
	
	public ControleVenda(ControleDados controleDados) {
		this.setHistoricoVendas(controleDados.getLoja().getVendas());
		controleEstoque = new ControleEstoque(controleDados);
		controleCliente = new ControleCliente(controleDados);
		controleVendedor = new ControleVendedor(controleDados);
		
	}
	
	public void cadastraVenda(ArrayList<String> informacoes) {
		try {
			Produto produtoVenda = this.controleEstoque.getEstoque().selecionarProduto(Integer.parseInt(informacoes.get(0)));
			Cliente clienteVenda = this.controleCliente.getClientes().get(Integer.parseInt(informacoes.get(1)));
			Vendedor vendedorVenda = this.controleVendedor.getVendedores().get(Integer.parseInt(informacoes.get(2)));
			
			Venda novaVenda = new Venda(produtoVenda, clienteVenda, vendedorVenda, 
					Integer.parseInt(this.formataNumero(informacoes.get(3))), LocalDate.now(), LocalTime.now(),
					this.controleEstoque.getEstoque());	
			
			this.getHistoricoVendas().add(novaVenda);
			
			JOptionPane.showMessageDialog(null, "Venda registrada com sucesso");
			
		} catch(NumberFormatException n) {
			JOptionPane.showMessageDialog(null, "Erro", "Algum(ns) do(s) valor(es) numérico(s) informado(s) é(são) "
											+ "inválido(s)", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	public void alteraInformacoesVenda(ArrayList<String> novosDados, int index) {
		
		try {
			DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			int indexProduto = this.getControleEstoque().getEstoque().pesquisarProduto(novosDados.get(0));
			int indexCliente = this.getControleCliente().pesquisarCliente(novosDados.get(2));
			int indexVendedor = this.getControleVendedor().pesquisarVendedor(novosDados.get(3));
			
			if(indexProduto == -1) {
				JOptionPane.showMessageDialog(null, "O nome do produto não está registrado");
				
			} else if(indexCliente == -1) {
				JOptionPane.showMessageDialog(null, "O nome do cliente não está registrado");
				
			} else if(indexVendedor == -1) {
				JOptionPane.showMessageDialog(null, "O nome do vendedor não está registrado");
				
			} else {
				this.getHistoricoVendas().get(index).editar(
						this.getControleEstoque().getEstoque().selecionarProduto(indexProduto),
						this.getControleCliente().getClientes().get(indexCliente),
						this.getControleVendedor().getVendedores().get(indexVendedor),
						Integer.parseInt(this.formataNumero(novosDados.get(4))),
						LocalDate.parse(novosDados.get(5).replace("-", "/"), formatoData),
						LocalTime.parse(novosDados.get(6)), this.getControleEstoque().getEstoque());
				
			}
						
		} catch(NumberFormatException n) {
			JOptionPane.showMessageDialog(null, "Erro", "Algum(ns) do(s) valor(es) numérico(s) informado(s) é(são) "
					+ "inválido(s)", JOptionPane.ERROR_MESSAGE);
			
		}
		
		
		
	}
	
	public ArrayList<String> mostraHistoricoVendas() {
		ArrayList<String> historico = new ArrayList<String>();
		
		if(historicoVendas.size() != 0) {
			for(Venda venda : historicoVendas) {
				historico.add("<html>Produto: " + venda.getProduto().getCategoria() + " - "+ venda.getProduto().getNome() + 
						"<br>Preço: " + venda.getValorProduto() + "<br>Quantidade vendida: " + venda.getQtdVendida() +
						" <br> Cliente: " + venda.getCliente().getNome() + "<br>Vendedor: " + venda.getVendedor().getNome()
						+ "<html>");
			}			
		}
		
		return historico;
	
	}
	
	public String formataNumero(String numero) {
		String formatacao = numero.replaceAll("[\\D]", ".");
		String numeroFormatado;
		int inicio = 0;
		int finalString = 1;
		
		for (int i = 0; i < formatacao.length(); i++){
			if(formatacao.charAt(i) != '.') {
				inicio = i;
				break;
			}
		
		}
		
		for (int x = formatacao.length() - 1; x > 0; x--) {
			if(formatacao.charAt(x) != '.') {
				finalString = x + 1;
				break;
			}
			
		}
		
		numeroFormatado = formatacao.substring(inicio, finalString);
		
		return numeroFormatado;
	}
	
	public ArrayList<Venda> getHistoricoVendas() {
		return historicoVendas;
	}

	public void setHistoricoVendas(ArrayList<Venda> historicoVendas) {
		this.historicoVendas = historicoVendas;
	}

	public ControleEstoque getControleEstoque() {
		return controleEstoque;
	}

	public void setControleEstoque(ControleEstoque controleEstoque) {
		this.controleEstoque = controleEstoque;
	}

	public ControleCliente getControleCliente() {
		return controleCliente;
	}

	public void setControleCliente(ControleCliente controleCliente) {
		this.controleCliente = controleCliente;
	}

	public ControleVendedor getControleVendedor() {
		return controleVendedor;
	}

	public void setControleVendedor(ControleVendedor controleVendedor) {
		this.controleVendedor = controleVendedor;
	}
	
}
