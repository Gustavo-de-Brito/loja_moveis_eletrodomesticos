package loja_eletrodomesticos_e_moveis;

public final class Cliente extends Pessoa {
	private String cpf;
	
	public Cliente(String nome, String telefone, String endereco, String cpf) {
		super.cadastrar(nome, telefone, endereco);
		
		this.setCpf(cpf);
		
	}
	
	public void editar(String nome, String telefone, String endereco, String cpf) {
		super.editar(nome, telefone, endereco);
		
		if(cpf != null) {
			this.setCpf(cpf);
		}
	}
	
	public String toString() {
		return super.toString() + "\nCPF: " + this.getCpf();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
