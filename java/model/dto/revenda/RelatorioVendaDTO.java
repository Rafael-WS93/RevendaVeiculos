package model.dto.revenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RelatorioVendaDTO {
	private String clienteNome;
	private String clienteCpf;
	private String clienteTel;
	private String veiculoModelo;
	private String veiculoPlaca;
	private LocalDate vendaData;
	private double vendaValor;
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioVendaDTO(String clienteNome, String clienteCpf, String clienteTel, String veiculoModelo,
			String veiculoPlaca, LocalDate vendaData, double vendaValor) {
		super();
		this.clienteNome = clienteNome;
		this.clienteCpf = clienteCpf;
		this.clienteTel = clienteTel;
		this.veiculoModelo = veiculoModelo;
		this.veiculoPlaca = veiculoPlaca;
		this.vendaData = vendaData;
		this.vendaValor = vendaValor;
	}

	public RelatorioVendaDTO() {
		super();
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getClienteCpf() {
		return clienteCpf;
	}

	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}

	public String getClienteTel() {
		return clienteTel;
	}

	public void setClienteTel(String clienteTel) {
		this.clienteTel = clienteTel;
	}

	public String getVeiculoModelo() {
		return veiculoModelo;
	}

	public void setVeiculoModelo(String veiculoModelo) {
		this.veiculoModelo = veiculoModelo;
	}

	public String getVeiculoPlaca() {
		return veiculoPlaca;
	}

	public void setVeiculoPlaca(String veiculoPlaca) {
		this.veiculoPlaca = veiculoPlaca;
	}

	public LocalDate getVendaData() {
		return vendaData;
	}

	public void setVendaData(LocalDate vendaData) {
		this.vendaData = vendaData;
	}

	public double getVendaValor() {
		return vendaValor;
	}

	public void setVendaValor(double vendaValor) {
		this.vendaValor = vendaValor;
	}
	
	public void imprimir() {
		System.out.printf("\n%10s   %-10s   %-10s   %-10s   %-10s   %-15s   %-15s\n"
				,this.getClienteNome()
				,this.getClienteCpf()
				,this.getClienteTel()
				,this.getVeiculoModelo()
				,this.getVeiculoPlaca()
				,this.getVendaData().format(dataFormatter)
				,this.getVendaValor());
	}
	
	

}
