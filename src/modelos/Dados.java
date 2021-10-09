package modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public final class Dados {
	private Loja lojaMoveisEletrodomesticos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Venda> vendas;
	
	
	public Dados() {
		Estoque estoque = new Estoque();
		clientes = new ArrayList<Cliente>();
		vendedores = new ArrayList<Vendedor>();
		vendas = new ArrayList<Venda>();
		
		// loja � intanciado logo ap�s por ser mais alto na "hierarquia" e armazenar todos os objetos
		this.setLojaMoveisEletrodomesticos(new Loja("Q&A M�veis e Eletrodom�sticos", "23.121.324/2301-34", 
				"Bras�lia - DF; Rua Almedeida Norte; Quadra 32 Conjunto 24 N�mero 23", estoque));
		
		// A seguir todos os produtos s�o instaciados e adicionados a estoque
		Geladeira geladeira00000 = new Geladeira("443L com Turbo Ice BRE57 AKANA", 342324313, 4298.00, "A Geladeira"
				+ " Brastemp Inverse Frost Free BRE57 443 litros Evox possui refrigerador em cima e freezer embaixo, "
				+ "deixando os alimentos mais utilizados sempre � m�o.", "Evox", 85.0, "Brastemp", "Geladeira", 
				"Eletrodom�stico", 72.5, 184.0, 70.0, "Inverse", 443.0, 2);
		lojaMoveisEletrodomesticos.getEstoque().cadastraProduto(geladeira00000, 50);
		
		ArCondicionado arcondicionado00000 = new ArCondicionado("Split Hi Wall Electrolux Ecoturbo 9000 BTUs Frio R410",
				32431312, 1230.80, "PR�TICO, MODERNO E ECON�MICO. O Ar Condicionado Split EcoTurbo Electrolux possui "
				+ "filtros que al�m de eliminar odores do ambiente, ret�m at� 99% das bact�rias", "Branco", 9.0,
				"Eletrolux", "Ar condicionado", "Eletrodom�stico", 28.0, 85.5, 18.1, "Sim", "Frio", 9000);
		lojaMoveisEletrodomesticos.getEstoque().cadastraProduto(arcondicionado00000, 76);
		
		Cama cama00000 = new Cama("Box Queen �pus Plumatex", 1221121, 1439.99,  "A Base Cama Box Queen �pus Plumatex �"
				+ " produzida em madeira usinada (Pinus de Reflorestamento) com sistema de sustenta��o transversal",
				"Bege e Branco", 27.31, "Plumatex", "Cama", "M�vel", 158.0, 28.0, 198.0, "Queen", "de Mola",
				"Intermedi�rio", " Antial�rgico - Antifungo - Antimofo");
		lojaMoveisEletrodomesticos.getEstoque().cadastraProduto(cama00000, 32);
		
		CoifaDepuradorDeAr depuradorAr00000= new CoifaDepuradorDeAr("Depurador De Ar Suggar Slim", 1112311, 289.00,
				"Depurador De Ar Suggar Slim 80cm 105W 3 Velocidades Preto DI801PT - 127VO depurador de ar Suggar DI801PT"
				+ " � perfeito para a sua cozinha.", "Preto", 4.6, "Suggar", "Coifa e Depurador de Ar", 
				"Eletrodom�stico", 8.5, 80.0, 48.0, 3, "Depura��o", 390, 70.0);
		lojaMoveisEletrodomesticos.getEstoque().cadastraProduto(depuradorAr00000, 58);
		
		Fogao fogao00000 = new Fogao("Fog�o de Piso 4 Bocas Esmaltec Bali Acendimento Manual 0104002103", 34222223, 
				464.07, "Fog�o de Piso 4 Bocas Esmaltec Bali Acendimento Manual 0104002103", "Branco", 23.0, "Esmaltec",
				"Fog�o", "Eletrodom�stico", 86.0, 51.0, 60.0, 4, "De piso", "Manual", "a G�s");
		lojaMoveisEletrodomesticos.getEstoque().cadastraProduto(fogao00000, 89);
		
		LavadoraRoupa lavadoraRoupa00000 = new LavadoraRoupa("Midea Storm Wash LFA11X1", 132313213, 2699.10,
				"Lavadora de Roupas economiza seu tempo e torna o ato de lavar suas roupas muito mais f�cil.",
				"Grafite Met�lico", 71.0, "Midea", "Lavadora de Roupa", "Eletrodom�stico", 59.0, 85.0, 56.5,
				11, 3, 1400, 16);
		lojaMoveisEletrodomesticos.getEstoque().cadastraProduto(lavadoraRoupa00000, 100);
		
		Microondas microondas00000 = new Microondas("Forno Micro-Ondas Painel Seguro 20L (MTD30)", 1313421, 430.32,
				"O Micro-Ondas vem com tecla Aquecer Refei��o, que, al�m do que o nome j� afirma, ainda permite o "
				+ "reaquecimento pr�tico de pratos Os menus Dia a Dia, Descongelar, Sobremesa e Kids facilitam o "
				+ "preparo dos alimentos.", "Branco", 11.4, "Eletrolux", "Micro-ondas", "Eletrodom�stico", 
				28.9, 46.1, 34.1, 20.0, "Sim", "Sim");
		lojaMoveisEletrodomesticos.getEstoque().cadastraProduto(microondas00000, 150);
		
		GuardaRoupa guardaRoupa00000 = new GuardaRoupa("Guarda Roupa Casal com Espelho 3 Portas de Correr", 134134143,
				883.41, "Guarda Roupa com maior resist�ncia, durabilidade e acabamento, revestimento interno e externo."
				+ " Pintura em estufas modernas com UV (ultra violeta).", "Branco", 134.1, "Espresso M�veis", 
				"Guarda-Roupas", "M�vel", 208.0, 188.0, 54.0, 3, 4, "Externo", "Sim");
		lojaMoveisEletrodomesticos.getEstoque().cadastraProduto(guardaRoupa00000, 200);
		
		Sofa sofa00000 = new Sofa("Phormatta Evolution", 989798, 1044.99, "O sof� Phormatta Evolution 3 lugares � retr�til "
				+ "e reclin�vel, ideal para quem gosta de conforto nas suas horas de lazer.", "Caramelo", 56.5, "SMP", 
				"Sof�", "M�vel", 206.0, 98.0, 92.0, 3, "Retr�til", "Reclin�vel", "Madeira");
		lojaMoveisEletrodomesticos.getEstoque().cadastraProduto(sofa00000, 50);
		
		
		
		// Ap�s os produtos s�o criados clientes e vendedores que ser�o adicionados a Loja
		Cliente cliente00000 = new Cliente("Roberto", " 9 0000-0000", "S�o Paulo - SP; Rua Pereira Silva; Quadra 234 "
				+ "Conjunto 23 N�mero 56", 24313454212L);
		clientes.add(cliente00000);
		
		Cliente cliente00001 = new Cliente("Maria", "9 1111-1111", "Rio de Janeiro - RJ; Rua Silva Carneiro; Quadra 234 "
				+ "Conjunto 23 N�mero 56", 11111111111L);
		clientes.add(cliente00001);
		
		Cliente cliente00002 = new Cliente("Cleiton", "9 2222-2222", "Bras�lia - DF; Rua Ponta Fina; Quadra 234 "
				+ "Conjunto 23 N�mero 56", 22222222222L);
		clientes.add(cliente00002);
		lojaMoveisEletrodomesticos.setClientes(clientes);
		
		Vendedor vendedor00000 = new Vendedor("Robem", " 9 0000-0001", "Bras�lia - DF; Rua Arnoldo; Quadra 102 Conjunto 43"
				+ " N�mero 5", LocalDate.of(2011, 2, 7), 3000.00);
		vendedores.add(vendedor00000);
		
		Vendedor vendedor00001 = new Vendedor("Yasmim", "9 1111-1112", "Bras�lia - DF; Rua Amorildo; Quadra 465 Conjunto "
				+ "58 N�mero 12", LocalDate.of(2002, 8, 15), 2000.00);
		vendedores.add(vendedor00001);
		
		Vendedor vendedor00002 = new Vendedor("Fernanda", "9 2222-2223", "Bras�lia - DF; Rua Pericoviti; Quadra 852 "
				+ "Conjunto 52 N�mero 7", LocalDate.of(2020, 9, 21), 12000.00);
		vendedores.add(vendedor00002);
		lojaMoveisEletrodomesticos.setVendedores(vendedores);
		
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Venda venda0000 = new Venda(sofa00000, cliente00002, vendedor00002, 5, LocalDate.parse("11/05/2016", formatoData),
				LocalTime.parse("10:15:30"), estoque);
		
		this.vendas.add(venda0000);
		
		lojaMoveisEletrodomesticos.setVendas(this.vendas);
		
	}


	public Loja getLojaMoveisEletrodomesticos() {
		return lojaMoveisEletrodomesticos;
	}


	public void setLojaMoveisEletrodomesticos(Loja lojaMoveisEletrodomesticos) {
		this.lojaMoveisEletrodomesticos = lojaMoveisEletrodomesticos;
	}
}
