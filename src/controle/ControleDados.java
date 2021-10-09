package controle;

import modelos.Dados;
import modelos.Loja;

public class ControleDados {
	private Loja loja;
	
	public ControleDados() {
		this.setLoja(new Dados().getLojaMoveisEletrodomesticos());
		
	}
	
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
}
