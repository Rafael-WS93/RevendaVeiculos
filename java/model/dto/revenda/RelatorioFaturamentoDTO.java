package model.dto.revenda;

public class RelatorioFaturamentoDTO {
	private int mes;
	private int ano;
	private double faturamento;
	
	public RelatorioFaturamentoDTO(int mes, int ano, double faturamento) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.faturamento = faturamento;
	}
	
	
	public RelatorioFaturamentoDTO() {
		super();
	}



	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}
	
	public void imprimir() {
		System.out.printf("\n%7s   %-4s   %-10s",
				this.getAno(),
				this.getMes(),
				this.getFaturamento());
		
	}
	

}
