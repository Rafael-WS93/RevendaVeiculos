package controller.revenda;

import java.util.ArrayList;

import model.bo.revenda.VeiculoBO;
import model.vo.revenda.VeiculoVO;

public class ControladoraVeiculo {

	public String cadastrarVeiculoController(VeiculoVO veiculoVO) {
		VeiculoBO veiculoBO = new VeiculoBO();
		return veiculoBO.cadastrarVeiculoBO(veiculoVO);
	}

	public String excluirVeiculoController(VeiculoVO veiculoVO) {
		VeiculoBO veiculoBO = new VeiculoBO();
		
		return veiculoBO.excluirVeiculoBO(veiculoVO);
	}

	public String atualizarVeiculoController(VeiculoVO veiculoVO) {
		VeiculoBO veiculoBO = new VeiculoBO();
		return veiculoBO.atualizarVeiculoBO(veiculoVO);
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosController() {

		VeiculoBO veiculoBO = new VeiculoBO();
				
		return veiculoBO.consultarTodosVeiculosBO();
	}

	public VeiculoVO consultarVeiculoController(VeiculoVO veiculoVO) {
		
		VeiculoBO veiculoBO = new VeiculoBO();
		
		return veiculoBO.consultarVeiculoBO(veiculoVO);
	}
	
	

}
