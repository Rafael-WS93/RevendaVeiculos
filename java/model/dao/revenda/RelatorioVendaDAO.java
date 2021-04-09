package model.dao.revenda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.dto.revenda.RelatorioVendaDTO;

public class RelatorioVendaDAO {

	public ArrayList<RelatorioVendaDTO> consultarRelatorioVendaDAO() {
		ArrayList<RelatorioVendaDTO> lista = new ArrayList<RelatorioVendaDTO>();
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT\n" + 
				"	CLIENTE.NOME\n" + 
				"    , CLIENTE.CPF\n" + 
				"    , CLIENTE.TELEFONE\n" + 
				"    , VEICULO.MODELO\n" + 
				"    , VEICULO.PLACA\n" + 
				"    , VENDA.DATAVENDA\n" + 
				"    , VENDA.VALORVENDA\n" + 
				"    FROM CLIENTE\n" + 
				"		RIGHT JOIN VENDA\n" + 
				"			ON CLIENTE.IDCLIENTE = VENDA.IDCLIENTE\n" + 
				"        INNER JOIN VEICULO\n" + 
				"			ON VEICULO.IDVEICULO = VENDA.IDVEICULO\n" + 
				"	ORDER BY VENDA.DATAVENDA ASC\n" + 
				"    ;";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				RelatorioVendaDTO venda = new RelatorioVendaDTO();
				venda.setClienteNome(resultado.getString(1));
				venda.setClienteCpf(resultado.getString(2));
				venda.setClienteTel(resultado.getString(3));
				venda.setVeiculoModelo(resultado.getString(4));
				venda.setVeiculoPlaca(resultado.getString(5));
				venda.setVendaData(LocalDate.parse(resultado.getString(6)));
				venda.setVendaValor(Double.parseDouble(resultado.getString(7)));
				lista.add(venda);
			}
		
		} catch (SQLException e) {
			System.out.println("não foi possivel executar a query de cunsulta do relatorio de vendas.");
			e.printStackTrace();
		}   finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return lista;
	}

}
