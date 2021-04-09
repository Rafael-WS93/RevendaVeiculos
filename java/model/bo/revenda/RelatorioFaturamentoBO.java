package model.bo.revenda;

import java.util.ArrayList;

import model.dao.revenda.RelatorioFaturamentoDAO;
import model.dto.revenda.RelatorioFaturamentoDTO;

public class RelatorioFaturamentoBO {

	public ArrayList<RelatorioFaturamentoDTO> consultarRelatorioFaturamentoBO() {
		RelatorioFaturamentoDAO relatorioFaturamentoDAO = new RelatorioFaturamentoDAO();
		
		return relatorioFaturamentoDAO.consultarRelatorioFaturamentoDAO();
	}

}
