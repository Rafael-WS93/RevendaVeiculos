package model.dao.revenda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.revenda.ClienteVO;

public class ClienteDAO {

	public boolean verificarRegistroClienteCPF(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String querry = "SELECT idcliente FROM cliente WHERE cpf ='"+cpf+"';";
		
		try {
			resultado = stmt.executeQuery(querry);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar querry de verificação de cliente por cpf.");
			System.out.println(e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}
	
	public boolean verificarRegistroClienteID(int idCliente) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String querry = "SELECT idcliente FROM cliente WHERE idcliente ="+idCliente+";";
		
		try {
			resultado = stmt.executeQuery(querry);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar querry de verificação de cliente por ID.");
			System.out.println(e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int cadastrarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String querry = "INSERT INTO CLIENTE (NOME,CPF,TELEFONE,DTNASCIMENTO,CNH) \nVALUE ("
		+"'" + clienteVO.getNome()+"'" 
		+",'" + clienteVO.getCpf() +"'"
		+",'" + clienteVO.getTelefone()+"'"
		+",'" + clienteVO.getNascimento()+"'"
		+",'" + clienteVO.getCnh()+"'"
		+");";
		
		try {
			resultado = stmt.executeUpdate(querry);
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar querry de cadastro de cliente.");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}
	
	public int atualizarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String querry = "UPDATE CLIENTE SET "
		+"nome = '" + clienteVO.getNome()+"'" 
		+",cpf = '" + clienteVO.getCpf() +"'"
		+",telefone = '" + clienteVO.getTelefone()+"'"
		+",DTNASCIMENTO = '" + clienteVO.getNascimento()+"'"
		+",CNH = '" + clienteVO.getCnh()+"'"
		+"WHERE idcliente ="+clienteVO.getIdCliente()+";";
		
		try {
			resultado = stmt.executeUpdate(querry);
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar querry de atualização de cliente.");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}

	

	public int excluirClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String querry = "DELETE FROM cliente WHERE idcliente = "+clienteVO.getIdCliente()+";";
		
		try {
			resultado = stmt.executeUpdate(querry);
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar querry de exclusão de cliente.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}

	public ClienteVO consultarClienteDAO(ClienteVO clienteVO) {
		ClienteVO cliente = new ClienteVO();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idcliente, nome, cpf, telefone,DTNASCIMENTO,CNH FROM cliente "
				+ "WHERE idcliente = "+clienteVO.getIdCliente()+";";
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				cliente = new ClienteVO();
				cliente.setIdCliente(Integer.parseInt(resultado.getString(1)));
				cliente.setNome(resultado.getString(2));
				cliente.setCpf(resultado.getString(3));
				cliente.setTelefone(resultado.getString(4));
				cliente.setNascimento(LocalDate.parse(resultado.getString(5)));
				cliente.setCnh(resultado.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao execuar query de colsulta de um cliente.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return cliente;
	}
	
	public ArrayList<ClienteVO> consultarTodosClientesDAO() {
		ArrayList<ClienteVO> lista = new ArrayList<ClienteVO>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idcliente, nome, cpf, telefone ,DTNASCIMENTO,CNH FROM cliente;";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setIdCliente(Integer.parseInt(resultado.getString(1)));
				cliente.setNome(resultado.getString(2));
				cliente.setCpf(resultado.getString(3));
				cliente.setTelefone(resultado.getString(4));
				cliente.setNascimento(LocalDate.parse(resultado.getString(5)));
				cliente.setCnh(resultado.getString(6));
				lista.add(cliente);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar query de conulta de todos os clientes.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return lista;
	}

}
