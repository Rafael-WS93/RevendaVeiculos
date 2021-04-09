package model.bo.revenda;

import java.util.ArrayList;

import model.dao.revenda.VendaDAO;
import model.vo.revenda.VendaVO;

public class VendaBO {

	public String cadastrarVendaBO(VendaVO vendaVO) {
		String retorno;
		
		VendaDAO vendaDAO = new VendaDAO();
		
		if(vendaDAO.verificarVendaVeiculo(vendaVO.getIdVeiculo())) {
			retorno = "\nVeiculo já foi vendido.";
		} else {
			
			int resultado = vendaDAO.cadastrarVenda(vendaVO);
			
			if (resultado == 1) {
				retorno = "\nVenda concluída con sucesso.";
			} else {
				retorno = "\nNão foi possível registar a venda";
			}

		}
		
		return retorno;
	}

	public ArrayList<VendaVO> consultarTodasVendas() {
		VendaDAO vendaDAO = new VendaDAO();
		
		return vendaDAO.consultarTodasVendas();
	}

	public VendaVO consultarVenda(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		
		return vendaDAO.consultarVendaDAO(vendaVO);
	}

	public String excluirVendaBO(VendaVO vendaVO) {
		String retorno;
		VendaDAO vendaDAO = new VendaDAO();
		
		if(vendaDAO.verificarRegistroPorIdVenda(vendaVO.getIdVenda())) {
			int resultado = vendaDAO.excluirVendaDAO(vendaVO);
			if(resultado == 1) {
				retorno = "\nVenda excluida com sucesso.";
			} else {
				retorno = "\nNão foi possível excluir a venda.";
			}
			
		} else {
			retorno = "\nVenda ainda não foi cadastrada no banco.";
			
		}
		
		return retorno;
	}

	public String atualizarVendaBO(VendaVO vendaVO) {
		String retorno = null;
		VendaDAO vendaDAO = new VendaDAO();
		
		int resultado = vendaDAO.atualizarVendaDAO(vendaVO);
		
		if (resultado == 1) {
			retorno = "\nVenda atualizada com sucesso.";
		} else {
			retorno = "\nNão foi possível atualizar Venda.";
		}
			
		
		return retorno;
	}

}
