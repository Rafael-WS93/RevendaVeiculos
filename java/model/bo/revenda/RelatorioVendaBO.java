package model.bo.revenda;

import java.util.ArrayList;

import model.dao.revenda.RelatorioVendaDAO;
import model.dto.revenda.RelatorioVendaDTO;

public class RelatorioVendaBO {

	public ArrayList<RelatorioVendaDTO> consultarrelatorioVendaBO() {
		RelatorioVendaDAO relatorioVendaDAO = new RelatorioVendaDAO();
		return relatorioVendaDAO.consultarRelatorioVendaDAO();
	}

}
