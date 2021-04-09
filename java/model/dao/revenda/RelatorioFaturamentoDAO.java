package model.dao.revenda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dto.revenda.RelatorioFaturamentoDTO;

public class RelatorioFaturamentoDAO {

	public ArrayList<RelatorioFaturamentoDTO> consultarRelatorioFaturamentoDAO() {
		ArrayList<RelatorioFaturamentoDTO> lista = new ArrayList<RelatorioFaturamentoDTO>();
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado= null;
		
		String query = "SELECT \n" + 
				"	YEAR(VENDA.DATAVENDA)\n" + 
				"	,MONTH(VENDA.DATAVENDA)\n" + 
				"   , SUM(VENDA.valorvenda)\n" + 
				" FROM VENDA\n" + 
				"	GROUP BY\n" + 
				"		YEAR(VENDA.DATAVENDA)\n" + 
				"		,MONTH(VENDA.DATAVENDA)\n" + 
				";";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				RelatorioFaturamentoDTO faturamento = new RelatorioFaturamentoDTO();
				faturamento.setAno(Integer.parseInt(resultado.getString(1)));
				faturamento.setMes(Integer.parseInt(resultado.getString(2)));
				faturamento.setFaturamento(Double.parseDouble(resultado.getString(3)));
				lista.add(faturamento);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar Faturamento.");
			e.printStackTrace();
		}  finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		
		return lista;
	}

}
