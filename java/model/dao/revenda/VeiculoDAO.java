package model.dao.revenda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.revenda.TipoVeiculo;
import model.vo.revenda.VeiculoVO;

public class VeiculoDAO {

	public boolean verificarRegistroPorPlaca(String placa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String querry = "SELECT idveiculo FROM veiculo WHERE placa = '"+placa+"';";
		try {
			resultado = stmt.executeQuery(querry);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica existência de veiculo por placa.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int cadastrarVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String querry = "INSERT INTO veiculo (modelo, tipo, fabricante, ano, cor, placa) VALUES (\n'"
				+ veiculoVO.getModelo() + "',\n'"
				+ veiculoVO.getTipo() + "',\n'"
				+ veiculoVO.getFabricante() + "',\n'"
				+ veiculoVO.getAno() + "',\n'"
				+ veiculoVO.getCor() + "',\n'"
				+ veiculoVO.getPlaca() + "');"
				;
	
		try {
			resultado = stmt.executeUpdate(querry);
			}
		catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de veículo.");
			System.out.println(e.getMessage());
		} finally {

			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
	
		return resultado;
	}

	public boolean verificarRegistroPorIdVeiculo(int idVeiculo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String querry = "SELECT idveiculo FROM veiculo WHERE idveiculo = '"+idVeiculo+"';";
		
		try {
			resultado = stmt.executeQuery(querry);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica existência de veiculo por ID.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int excluirVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String querry = "DELETE from veiculo WHERE idveiculo ="+veiculoVO.getIdVeiculo() +";";
		
		try {
			resultado = stmt.executeUpdate(querry);
		} catch (SQLException e) {
			System.out.println("Erro ao executar querry de exclusão de veiculo.");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}

	public int atualizarVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String querryUpdate = "SET "
				+"modelo ='"+ veiculoVO.getModelo() + "'\n,"
				+ "tipo ='" + veiculoVO.getTipo() + "'\n,"
				+ "fabricante ='" + veiculoVO.getFabricante() + "'\n,"
				+ "ano ='" + veiculoVO.getAno() + "'\n,"
				+ "cor ='" + veiculoVO.getCor() + "'\n,"
				+ "placa='" + veiculoVO.getPlaca() + "'\n"
				;;
		
		String querry = "UPDATE veiculo\n" +querryUpdate+ "WHERE idveiculo ="+veiculoVO.getIdVeiculo()+";"
				;
	
		try {
			resultado = stmt.executeUpdate(querry);
			}
		catch (SQLException e) {
			System.out.println("Erro ao executar a query de atualização de veículo.");
			System.out.println(e.getMessage());
		} finally {

			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
	
		return resultado;
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosDAO() {
		ArrayList<VeiculoVO> lista = new ArrayList<VeiculoVO>();

		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idveiculo, modelo, fabricante, tipo, "
				+ "ano, cor, placa FROM veiculo";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				VeiculoVO veiculo = new VeiculoVO();
				veiculo.setIdVeiculo(Integer.parseInt(resultado.getString(1)));
				veiculo.setModelo(resultado.getString(2));
				veiculo.setFabricante(resultado.getString(3));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString(4)));
				veiculo.setAno(Integer.parseInt(resultado.getString(5)));
				veiculo.setCor(resultado.getString(6));
				veiculo.setPlaca(resultado.getString(7));
				lista.add(veiculo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de todos os veículos.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return lista;
	}

	public VeiculoVO consultarVeiculoDAO(VeiculoVO veiculoVO) {
		VeiculoVO veiculo = null;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idveiculo, modelo, fabricante, tipo, "
		+ "ano, cor, placa FROM veiculo WHERE idveiculo ="+veiculoVO.getIdVeiculo()+";";
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				veiculo = new VeiculoVO();
				veiculo.setIdVeiculo(Integer.parseInt(resultado.getString(1)));
				veiculo.setModelo(resultado.getString(2));
				veiculo.setFabricante(resultado.getString(3));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString(4)));
				veiculo.setAno(Integer.parseInt(resultado.getString(5)));
				veiculo.setCor(resultado.getString(6));
				veiculo.setPlaca(resultado.getString(7));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de um veículo.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return veiculo;

	}
	
	

}
