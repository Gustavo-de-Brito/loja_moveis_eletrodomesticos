package testes_unitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.ControleCliente;
import controle.ControleDados;

class TesteControleCliente {
	ControleDados controleDados = new ControleDados();
	ControleCliente controleCliente = new ControleCliente(controleDados);
	
	
	@Test
	void testPesquisarCliente() {
		int indexPrimeiroCliente = controleCliente.pesquisarCliente("Roberto");
		int indexTerceiroCliente = controleCliente.pesquisarCliente("Cleiton");
		int indexClienteInvalido = controleCliente.pesquisarCliente("Mauro");
		
		assertEquals(indexPrimeiroCliente, 0);
		assertEquals(indexTerceiroCliente, 2);
		assertEquals(indexClienteInvalido, -1);
		
	}

	@Test
	void testFormataCpf() {
		String cpfValido = ControleCliente.formataCpf("423.342.342-10");
		String cpfInvalidoMais = ControleCliente.formataCpf("231.3232.123-23");
		String cpfInvalidoMenos = ControleCliente.formataCpf("231.32.123-23");
		String cpfIlogico = ControleCliente.formataCpf("234kjfldksjksj234dsljfk432jdlskjfls13");
		
		assertEquals(cpfValido, "42334234210");
		assertEquals(cpfInvalidoMais, "231323212323a");
		assertEquals(cpfInvalidoMenos, "2313212323a");
		assertEquals(cpfIlogico, "23423443213");
		
	}

}
