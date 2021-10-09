package testes_unitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.ControleDados;
import controle.ControleVendedor;

class TesteControleVendedor {
	ControleDados controleDados = new ControleDados();
	ControleVendedor controleVendedor = new ControleVendedor(controleDados);
	
	
	@Test
	void testPesquisarVendedor() {
		int indexPrimeiroVendedor = controleVendedor.pesquisarVendedor("Robem");
		int indexTerceiroVendedor = controleVendedor.pesquisarVendedor("Fernanda");
		int indexVendedorInexistente = controleVendedor.pesquisarVendedor("Renato");
		
		assertEquals(indexPrimeiroVendedor, 0);
		assertEquals(indexTerceiroVendedor, 2);
		assertEquals(indexVendedorInexistente, -1);
		
	}

	@Test
	void testFormataNumero() {
		String numeroDecimal = ControleVendedor.formataNumero("sdkjl2342.2423434kjgkljlksdj");
		String numeroDecimal2 = ControleVendedor.formataNumero("djf 2343.23423.3423.324 jdfkjkf");
		String numeroInteiro = ControleVendedor.formataNumero("lkdjkjsdfk342342jdlksjsdlfkjk");
		
		assertEquals(numeroDecimal, "2342.2423434");
		assertEquals(numeroInteiro, "342342");
		assertEquals(numeroDecimal2, "2343.23423.3423.324");
		
	}

}
