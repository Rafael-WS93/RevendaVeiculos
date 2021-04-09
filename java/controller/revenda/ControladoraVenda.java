package controller.revenda;

import java.util.ArrayList;

import model.bo.revenda.VendaBO;
import model.vo.revenda.VendaVO;

public class ControladoraVenda {

	public String cadastrarVenda(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.cadastrarVendaBO(vendaVO);
	}

	public String excluirVenda(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.excluirVendaBO(vendaVO);
	}

	public String atualizarVenda(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.atualizarVendaBO(vendaVO);
	}

	public ArrayList<VendaVO> consultarTodasVendas() {
	
		VendaBO vendaBO = new VendaBO();
		return vendaBO.consultarTodasVendas();
	}

	public VendaVO consultarVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();
		
		return vendaBO.consultarVenda(vendaVO);
	}

}
