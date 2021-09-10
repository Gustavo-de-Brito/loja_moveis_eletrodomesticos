package loja_eletrodomesticos_e_moveis;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// estoque est� mais alto na "hierarquia" e n�o depende de outros objetos, por isso � instanciado primeiro
		Estoque estoque = new Estoque();
		
		// loja � intanciado logo ap�s por ser mais alto na "hierarquia" e armazenar todos os objetos
		Loja lojaEletrodomesticosMoveis = new Loja("Q&A M�veis e Eletrodom�sticos", "23.121.324/2301-34", 
				"Bras�lia - DF; Rua Almedeida Norte; Quadra 32 Conjunto 24 N�mero 23", estoque);
		
		// A seguir todos os produtos s�o instaciados e adicionados a estoque
		Geladeira geladeira00000 = new Geladeira("443L com Turbo Ice BRE57 AKANA", 342324313, 4298.00, "A Geladeira"
				+ " Brastemp Inverse Frost Free BRE57 443 litros Evox possui refrigerador em cima e freezer embaixo, "
				+ "deixando os alimentos mais utilizados sempre � m�o.", "Evox", 85.0, "Brastemp", "Geladeira", 
				"Eletrodom�stico", 72.5, 184.0, 70.0, "Inverse", 443.0, 2);
		lojaEletrodomesticosMoveis.getEstoque().cadastrarProduto(geladeira00000, 50);
		
		ArCondicionado arcondicionado00000 = new ArCondicionado("Split Hi Wall Electrolux Ecoturbo 9000 BTUs Frio R410",
				32431312, 1230.80, "PR�TICO, MODERNO E ECON�MICO. O Ar Condicionado Split EcoTurbo Electrolux possui "
				+ "filtros que al�m de eliminar odores do ambiente, ret�m at� 99% das bact�rias", "Branco", 9.0,
				"Eletrolux", "Ar condicionado", "Eletrodom�stico", 28.0, 85.5, 18.1, "Sim", "Frio", 9000);
		lojaEletrodomesticosMoveis.getEstoque().cadastrarProduto(arcondicionado00000, 76);
		
		Cama cama00000 = new Cama("Box Queen �pus Plumatex", 1221121, 1439.99,  "A Base Cama Box Queen �pus Plumatex �"
				+ " produzida em madeira usinada (Pinus de Reflorestamento) com sistema de sustenta��o transversal",
				"Bege e Branco", 27.31, "Plumatex", "Cama", "M�vel", 158.0, 28.0, 198.0, "Queen", "de Mola",
				"Intermedi�rio", " Antial�rgico - Antifungo - Antimofo");
		lojaEletrodomesticosMoveis.getEstoque().cadastrarProduto(cama00000, 32);
		
		CoifaDepuradorDeAr depuradorAr00000= new CoifaDepuradorDeAr("Depurador De Ar Suggar Slim", 1112311, 289.00,
				"Depurador De Ar Suggar Slim 80cm 105W 3 Velocidades Preto DI801PT - 127VO depurador de ar Suggar DI801PT"
				+ " � perfeito para a sua cozinha.", "Preto", 4.6, "Suggar", "Coifa e Depurador de Ar", 
				"Eletrodom�stico", 8.5, 80.0, 48.0, 3, "Depura��o", 390, 70.0);
		lojaEletrodomesticosMoveis.getEstoque().cadastrarProduto(depuradorAr00000, 58);
		
		Fogao fogao00000 = new Fogao("Fog�o de Piso 4 Bocas Esmaltec Bali Acendimento Manual 0104002103", 34222223, 
				464.07, "Fog�o de Piso 4 Bocas Esmaltec Bali Acendimento Manual 0104002103", "Branco", 23.0, "Esmaltec",
				"Fog�o", "Eletrodom�stico", 86.0, 51.0, 60.0, 4, "De piso", "Manual", "a G�s");
		lojaEletrodomesticosMoveis.getEstoque().cadastrarProduto(fogao00000, 89);
		
		LavadoraRoupa lavadoraRoupa00000 = new LavadoraRoupa("Midea Storm Wash LFA11X1", 132313213, 2699.10,
				"Lavadora de Roupas economiza seu tempo e torna o ato de lavar suas roupas muito mais f�cil.",
				"Grafite Met�lico", 71.0, "Midea", "Lavadora de Roupa", "Eletrodom�stico", 59.0, 85.0, 56.5,
				11, 3, 1400, 16);
		lojaEletrodomesticosMoveis.getEstoque().cadastrarProduto(lavadoraRoupa00000, 100);
		
		Microondas microondas00000 = new Microondas("Forno Micro-Ondas Painel Seguro 20L (MTD30)", 1313421, 430.32,
				"O Micro-Ondas vem com tecla Aquecer Refei��o, que, al�m do que o nome j� afirma, ainda permite o "
				+ "reaquecimento pr�tico de pratos Os menus Dia a Dia, Descongelar, Sobremesa e Kids facilitam o "
				+ "preparo dos alimentos.", "Branco", 11.4, "Eletrolux", "Micro-ondas", "Eletrodom�stico", 
				28.9, 46.1, 34.1, 20.0, "Sim", "Sim");
		lojaEletrodomesticosMoveis.getEstoque().cadastrarProduto(microondas00000, 150);
		
		GuardaRoupa guardaRoupa00000 = new GuardaRoupa("Guarda Roupa Casal com Espelho 3 Portas de Correr", 134134143,
				883.41, "Guarda Roupa com maior resist�ncia, durabilidade e acabamento, revestimento interno e externo."
				+ " Pintura em estufas modernas com UV (ultra violeta).", "Branco", 134.1, "Espresso M�veis", 
				"Guarda-Roupas", "M�vel", 208.0, 188.0, 54.0, 3, 4, "Externo", "Sim");
		lojaEletrodomesticosMoveis.getEstoque().cadastrarProduto(guardaRoupa00000, 200);
		
		Sofa sofa00000 = new Sofa("Phormatta Evolution", 989798, 1044.99, "O sof� Phormatta Evolution 3 lugares � retr�til "
				+ "e reclin�vel, ideal para quem gosta de conforto nas suas horas de lazer.", "Caramelo", 56.5, "SMP", 
				"Sof�", "M�vel", 206.0, 98.0, 92.0, 3, "Retr�til", "Reclin�vel", "Madeira");
		lojaEletrodomesticosMoveis.getEstoque().cadastrarProduto(sofa00000, 50);
		
		
		
		// Ap�s os produtos s�o criados clientes e vendedores que ser�o adicionados a Loja
		Cliente cliente00000 = new Cliente("Roberto", " 9 0000-0000", "S�o Paulo - SP; Rua Pereira Silva; Quadra 234 "
				+ "Conjunto 23 N�mero 56", "243.134.542.12");
		lojaEletrodomesticosMoveis.setClientes(cliente00000);
		Cliente cliente00001 = new Cliente("Maria", "9 1111-1111", "Rio de Janeiro - RJ; Rua Silva Carneiro; Quadra 234 "
				+ "Conjunto 23 N�mero 56", "111.111.111.11");
		lojaEletrodomesticosMoveis.setClientes(cliente00001);
		Cliente cliente00002 = new Cliente("Roberto", "9 2222-2222", "Bras�lia - DF; Rua Ponta Fina; Quadra 234 "
				+ "Conjunto 23 N�mero 56", "222.222.222.22");
		lojaEletrodomesticosMoveis.setClientes(cliente00002);
		
		
		Vendedor vendedor00000 = new Vendedor("Robem", " 9 0000-0001", "Bras�lia - DF; Rua Arnoldo; Quadra 102 Conjunto 43"
				+ " N�mero 5", LocalDate.of(2011, 2, 7), 3000.00);
		lojaEletrodomesticosMoveis.setVendedores(vendedor00000);
		Vendedor vendedor00001 = new Vendedor("Yasmim", "9 1111-1112", "Bras�lia - DF; Rua Amorildo; Quadra 465 Conjunto "
				+ "58 N�mero 12", LocalDate.of(2002, 8, 15), 2000.00);
		lojaEletrodomesticosMoveis.setVendedores(vendedor00001);
		Vendedor vendedor00002 = new Vendedor("Fernanda", "9 2222-2223", "Bras�lia - DF; Rua Pericoviti; Quadra 852 "
				+ "Conjunto 52 N�mero 7", LocalDate.of(2020, 9, 21), 12000.00);
		lojaEletrodomesticosMoveis.setVendedores(vendedor00002);
		
		
		
		System.out.println("\nEdi��o de Dados:\n");
		
		// � poss�vel editar todos os objetos passando a mesma quantidade de par�metros que foi passada para o construtor
		geladeira00000.editar("Geladeira/Refrigerador Brastemp Frost Free Duplex - Branca 375L BRM44 HBANA", 0, 0, null,
				null, 0, null, null, null, null, 0, 0, 0, null, 0, 0);;
		// Quando os par�metros passados s�o nulos ou inferiores a zero, as informa��es anteriores s�o mantidas
		System.out.println(geladeira00000.ler());
		
		arcondicionado00000.editar(null, 54654312, 0, null, null, 0, null, null, null, 0, 0, 0, null, null, 0);;
		//System.out.println(arcondicionado00000.ler());
		
		cama00000.editar(null, 0, 1000.00, null, null, 0, null, null, null, 0, 0, 0, null, null, null, null);;
		//System.out.println(cama00000.ler());
		
		depuradorAr00000.editar(null, 0, 0, "O depurador de Parede Colormaq Cook � um produto em a�o de alta "
				+ "tecnologia, seguro e eficiente. Ele possui 60cm de largura. Sua fun��o � basicamente filtrar o ar e "
				+ "devolver limpo para o ambiente.", null, 0, null, null, null, 0, 0, 0, 0, null, 0, 0);
		//System.out.println(depuradorAr00000.ler());
		
		fogao00000.editar(null, 0, 0, null, "Amarelo", 0, null, null, null, 0, 0, 0, 0, null, null, null);
		//System.out.println(fogao00000.ler());
		
		lavadoraRoupa00000.editar(null, 0, 0, null, null, 20.0, null, null, null, 0, 0, 0, 0, 0, 0, 0);
		//System.out.println(lavadoraRoupa00000.ler());
		
		microondas00000.editar(null, 0, 0, null, null, 0, "Consul", null, null, 0, 0, 0, 0, null, null);
		//System.out.println(microondas00000.ler());
		
		guardaRoupa00000.editar(null, 0, 0, null, null, 0, null, null, null, 200.0, 0, 0, 0, 0, null, null);
		//System.out.println(guardaRoupa00000.ler());
		
		sofa00000.editar(null, 0, 0, null, null, 0, null, null, null, 0, 200.0, 0, 0, null, null, null);
		//System.out.println(sofa00000.ler());
		
		
		
		//Cliente e Vendedor
		cliente00000.editar("Cleiton", "9 1212-3434", "Bras�lia - DF; Rua Alberto Cruz; Quadra 35 Conjunto 65 N�mero 34",
				"464.446.854-54");
		System.out.println(cliente00000);
		
		vendedor00000.editar("Celeuma", "9 9999-8888", "Bras�lia - DF; Rua Gendro; Quadra 964 Conjunto 2 N�mero 1",
				LocalDate.of(2015, 1, 1), 4321.87);
		System.out.println(vendedor00000);
		
		
		
		
		// M�todos de Estoque
		System.out.println("\nM�todos de Estoque:\n");
		System.out.println(estoque.lerProdutosEmEstoque()); // Mostra de forma resumida todos os produtos em estoque
		
		String idProduto = estoque.pesquisarProduto(54654312); // Quando o produto existe retorna o index
		//System.out.println(idProduto);
		String idProdutoInexistente = estoque.pesquisarProduto(4); // Quando n�o encontrado retorna uma mensagem
		//System.out.println(idProdutoInexistente);
		String idProdutoNome = estoque.pesquisarProduto("Phormatta Evolution");
		//System.out.println(idProdutoNome);
		
		// passando um id v�lido � poss�vel selecionar um produto e sua quantidade
		System.out.println("Produto seleciona:\n" + estoque.selecionarProduto(Integer.parseInt(idProduto)).ler());
		System.out.println("Quantidade do produto:\n" + estoque.pesquisarQtdProduto(Integer.parseInt(idProduto)));
		
		ArrayList<Produto> produtosAbaixo1500 = estoque.pesquisarProdutosPreco(1000); // filtra os produots por preco
		/*
		for(Produto produto : produtosAbaixo1500) {
			System.out.println(produto.getPreco());
			
		}
		*/
		
		ArrayList<Produto> produtosGeladeira = estoque.pesquisarProdutosCategoria("Geladeira"); // filtra por categoria
		//System.out.println(produtosGeladeira.get(0).ler());
		
		
		ArrayList<Produto> moveis = estoque.pesquisarProdutosTipo("M�vel");
		/*
		for(Produto movel : moveis) {
			System.out.println(movel + "\n");
		}
		 */
		
		// tamb�m � poss�vel excluir um produto
		estoque.excluirProduto(Integer.parseInt(idProduto));
		idProduto = estoque.pesquisarProduto(54654312); // passando a antiga id do produto
		System.out.println("Situa��o:\n" + idProduto);
		
	
		// M�todos de Loja
		System.out.println("\n\nM�todos Loja:\n\n");
		
		
		// Registro e edi��o de vendas
		Venda venda00000 = new Venda(sofa00000, cliente00002, vendedor00002, 3, LocalDate.now(), LocalTime.now(), estoque);
		Venda venda00001 = new Venda(cama00000, cliente00002, vendedor00002, 5, LocalDate.now(), LocalTime.now(), estoque);
		
		venda00001.editar(geladeira00000, cliente00000, vendedor00002, 7, LocalDate.of(2021, 6, 15), LocalTime.of(15, 42),
				estoque);
		
		// adi��o de vendas a loja
		lojaEletrodomesticosMoveis.setVendas(venda00000);
		lojaEletrodomesticosMoveis.setVendas(venda00001);
		
		
		// hist�rico de vendas
		String historico = lojaEletrodomesticosMoveis.mostrarHistoricoVendas();
		//System.out.println(historico);
		
		// consulta de clientes e vendedores presentes em Loja
		String clientes = lojaEletrodomesticosMoveis.mostrarClientes();
		//System.out.println(clientes);
		
		String vendedores = lojaEletrodomesticosMoveis.mostrarVendedores();
		//System.out.println(vendedores);
		
		// Tamb�m � poss�vel retirar um vendedor ou cliente
		lojaEletrodomesticosMoveis.excluiCliente(cliente00000.getNome());
		lojaEletrodomesticosMoveis.excluiVendedor(vendedor00000.getNome());
		
		
		
	}

}
