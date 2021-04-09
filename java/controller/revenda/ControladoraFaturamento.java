package controller.revenda;

import java.util.ArrayList;

import model.bo.revenda.RelatorioFaturamentoBO;
import model.dto.revenda.RelatorioFaturamentoDTO;

public class ControladoraFaturamento {

	public ArrayList<RelatorioFaturamentoDTO> consultarFaturamento() {
		RelatorioFaturamentoBO relatoriofaturamentoBO = new RelatorioFaturamentoBO();
		
		return relatoriofaturamentoBO.consultarRelatorioFaturamentoBO();
	}

}
