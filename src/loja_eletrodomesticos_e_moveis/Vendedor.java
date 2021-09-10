package loja_eletrodomesticos_e_moveis;

import java.time.LocalDate;

public final class Vendedor extends Pessoa {
	private LocalDate dataInicio;
	private double salario;
	
	public Vendedor(String nome, String telefone, String endereco, LocalDate dataInicio, double Salario) {
		super.cadastrar(nome, telefone, endereco);
		
		this.setDataInicio(dataInicio);
		this.setSalario(Salario);
		
	}
	
	public void editar(String nome, String telefone, String endereco, LocalDate dataInicio, double salario) {
		super.editar(nome, telefone, endereco);
		
		if(dataInicio != null) {
			this.setDataInicio(dataInicio);
		}
		if(salario > 0) {
			this.setSalario(salario);
		}
		
	}
	
	public String toString() {
		return super.toString() + "\nData de início: " + this.getDataInicio() + "\nSalário: " + this.getSalario();
		
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getSalario() {
		return String.format("R$ %.2f", salario);
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
