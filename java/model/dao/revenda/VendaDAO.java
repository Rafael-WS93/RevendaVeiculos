package model.dao.revenda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.revenda.VendaVO;

public class VendaDAO {

	public boolean verificarVendaVeiculo(int idVeiculo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String querry = "SELECT idvenda FROM venda WHERE idvenda = '"+idVeiculo+"';";
		try {
			resultado = stmt.executeQuery(querry);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica existência de (ID)veiculo em venda.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}
	
	public boolean verificarRegistroPorIdVenda(int idVenda) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String querry = "SELECT idvenda FROM venda WHERE idvenda = '"+idVenda+"';";
		try {
			resultado = stmt.executeQuery(querry);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica existência de (ID)venda.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int cadastrarVenda(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String querry = "INSERT INTO venda (idveiculo, idcliente, valorvenda, datavenda) VALUES (\n"
				+ vendaVO.getIdVeiculo() + ","
				+ vendaVO.getIdCliente() + ","
				+ vendaVO.getValorVenda() + ",'"
				+ vendaVO.getDataVenda() + "'"
				+ ");"
				;
	
		try {
			resultado = stmt.executeUpdate(querry);
			}
		catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de venda.");
			System.out.println(e.getMessage());
		} finally {

			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
	
		return resultado;
	}

	public ArrayList<VendaVO> consultarTodasVendas() {
		ArrayList<VendaVO> lista = new ArrayList<VendaVO>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idvenda, idcliente, idveiculo, valorvenda, datavenda "
				+ "FROM venda;";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				VendaVO venda = new VendaVO();
				venda.setIdVenda(Integer.parseInt(resultado.getString(1)));
				venda.setIdCliente(Integer.parseInt(resultado.getString(2)));
				venda.setIdVeiculo(Integer.parseInt(resultado.getString(3)));
				venda.setValorVenda(Double.parseDouble(resultado.getString(4)));
				venda.setDataVenda(LocalDate.parse(resultado.getString(5)));
				lista.add(venda);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar query de consulta de venda.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
	
		return lista;
	}

	public VendaVO consultarVendaDAO(VendaVO vendaVO) {
		VendaVO venda = new VendaVO();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idvenda, idcliente, idveiculo, valorvenda, datavenda "
				+ "FROM venda WHERE idvenda ="+ vendaVO.getIdVenda()+";";
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				venda = new VendaVO();
				venda.setIdVenda(Integer.parseInt(resultado.getString(1)));
				venda.setIdCliente(Integer.parseInt(resultado.getString(2)));
				venda.setIdVeiculo(Integer.parseInt(resultado.getString(3)));
				venda.setValorVenda(Double.parseDouble(resultado.getString(4)));
				venda.setDataVenda(LocalDate.parse(resultado.getString(5)));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar query de consulta de uma venda.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return venda;
	}


	public int excluirVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String querry = "DELETE from venda WHERE idvenda ="+vendaVO.getIdVenda() +";";
		
		try {
			resultado = stmt.executeUpdate(querry);
		} catch (SQLException e) {
			System.out.println("Erro ao executar querry de exclusão de venda.");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}

	public int atualizarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String querry = "UPDATE venda SET "
				+ "idveiculo = "+vendaVO.getIdVeiculo()
				+", idcliente ="+vendaVO.getIdCliente()
				+", valorvenda ="+  vendaVO.getValorVenda() 
				+", datavenda ='"+ vendaVO.getDataVenda()
				+ "WHERE idvenda ="+vendaVO.getIdVenda()+";"
				;
	
		try {
			resultado = stmt.executeUpdate(querry);
			}
		catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de venda.");
			System.out.println(e.getMessage());
		} finally {

			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
	
		return resultado;
	}

}
