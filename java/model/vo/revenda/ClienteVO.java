package model.vo.revenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteVO {
	private int idCliente;
	private String nome;
	private String cpf;
	private String telefone;
	private LocalDate nascimento;
	private String cnh;
	
	DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public ClienteVO(int idCliente, String nome, String cpf, String telefone, LocalDate nascimento, String cnh) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.cnh = cnh;
	}

	public ClienteVO() {
		super();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public void imprimir() {
		System.out.printf("\n%3d   %-15s   %-15s   %-15s   %-15s   %-15s\n",
				this.getIdCliente(),
				this.getNome(),
				this.getCpf(),
				this.getNascimento().format(formatadorData),
				this.getCnh(),
				this.getTelefone());
		
	}
	
	
	
}
