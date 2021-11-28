package testes_unitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelos.Dados;
import modelos.Estoque;

class TesteEstoque {
	Dados dados = new Dados();
	Estoque estoque = dados.getLojaMoveisEletrodomesticos().getEstoque();
	
	// Teste da pesquisa da posição de um produto pelo id com um valor válido e um um inválido
	@Test
	void testPesquisarProdutoInt() {
		int indexProdutoValido = estoque.pesquisarProduto(1221121); //Deverá ser encontrada posição 2
		int indexProdutoInvalido = estoque.pesquisarProduto(2465454); //Não é um ID registrado nos dados
		
		assertEquals(indexProdutoValido, 2);
		assertEquals(indexProdutoInvalido, -1);
		
	}
	
	// Teste de pesquisa da posição de um produto pelo nome
	@Test
	void testPesquisarProdutoString() {
		int indexProdutoValido = estoque.pesquisarProduto("Fogão de Piso 4 Bocas Esmaltec Bali Acendimento "
															+ "Manual 0104002103");
		int indexProdutoInvalido = estoque.pesquisarProduto("Produto inexistente");
		
		assertEquals(indexProdutoValido, 4);
		assertEquals(indexProdutoInvalido, -1);
		
	}
	
	// Teste de pesquisa de produtos por uma faixa de preço
	@Test
	void testPesquisarProdutoPreco() {
		// A função devolve uma ArrayList de valores que devem ter um determinada quantidade de elementos
		int qtdProdutosPreco = estoque.pesquisarProdutosPreco(1000.00).size(); 
		int qtdProdutosPrecoInexistente = estoque.pesquisarProdutosPreco(100).size();
		
		assertEquals(qtdProdutosPreco, 4);
		assertEquals(qtdProdutosPrecoInexistente, 0);
		
	}
	
	// Teste de pesquisa de produtos por categoria(Geladeira, Sofá, Cama...)
	@Test
	void testPesquisarProdutosCategoria() {
		int qtdProdutosCategoria1 = estoque.pesquisarProdutosCategoria("Geladeira").size();
		int qtdProdutosCategoria2 = estoque.pesquisarProdutosCategoria("Cama").size();
		
		assertEquals(qtdProdutosCategoria1, 1);
		assertEquals(qtdProdutosCategoria2, 1);
		
	}
	
	@Test
	void testPesquisarProdutoTipo() {
		int qtdProdutosMoveis = estoque.pesquisarProdutosTipo("Móvel").size();
		int qtdProdutosEletrodomesticos = estoque.pesquisarProdutosTipo("Eletrodoméstico").size();
		
		assertEquals(qtdProdutosMoveis, 3);
		assertEquals(qtdProdutosEletrodomesticos, 6);
		
	}

}
