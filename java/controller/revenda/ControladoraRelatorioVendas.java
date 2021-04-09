package controller.revenda;

import java.util.ArrayList;

import model.bo.revenda.RelatorioVendaBO;
import model.dto.revenda.RelatorioVendaDTO;

public class ControladoraRelatorioVendas {

	public ArrayList<RelatorioVendaDTO> consultarRelatorioVendas() {
		RelatorioVendaBO relatorioVendaBO = new RelatorioVendaBO();
		return relatorioVendaBO.consultarrelatorioVendaBO();
	}

}
