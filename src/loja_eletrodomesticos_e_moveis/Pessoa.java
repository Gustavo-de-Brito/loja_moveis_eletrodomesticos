package loja_eletrodomesticos_e_moveis;

public abstract class Pessoa {
	private String nome;
	private String telefone;
	private String endereco;
	
	public void cadastrar(String nome, String telefone, String endereco) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		
	}
	
	public void editar(String nome, String telefone, String endereco) {
		if(nome != null) {
			this.setNome(nome);
		}
		if(telefone != null) {
			this.setTelefone(telefone);
		}
		if(endereco != null) {
			this.setEndereco(endereco);
		}
		
	}
	
	public String toString() {
		return "Nome: " + this.getNome() + "\nTelefone: " + this.getTelefone() + "\nEndereço: " + this.getEndereco();
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
}
