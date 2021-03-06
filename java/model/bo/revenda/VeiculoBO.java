package model.bo.revenda;

import java.util.ArrayList;

import model.dao.revenda.VeiculoDAO;
import model.vo.revenda.VeiculoVO;
public class VeiculoBO {

	public String cadastrarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		if(veiculoDAO.verificarRegistroPorPlaca(veiculoVO.getPlaca())) {
			retorno = "\nVeículo já cadastrado no banco.";
		} else {
			
			int resultado = veiculoDAO.cadastrarVeiculoDAO(veiculoVO);

			
			if(resultado == 1) {
				retorno = "\nVeículo cadastrado com sucesso.";
			} else {
				retorno = "\nNão foi possível cadastrar o veículo.";
			}
			
		}

		return retorno;
	}
	
	public String atualizarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		if(veiculoDAO.verificarRegistroPorIdVeiculo(veiculoVO.getIdVeiculo())) {
			int resultado = veiculoDAO.atualizarVeiculoDAO(veiculoVO);
			if(resultado == 1) {
				retorno = "\nVeículo atualizado com sucesso.";
			} else {
				retorno = "\nNão foi possível atualizar o veículo.";
			}
			
		} else {
			retorno = "\nVeículo ainda não foi cadastrado no banco.";
			
		}
		
		return retorno;
	}
	
	public String excluirVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		if(veiculoDAO.verificarRegistroPorIdVeiculo(veiculoVO.getIdVeiculo())) {
			int resultado = veiculoDAO.excluirVeiculoDAO(veiculoVO);
			if(resultado == 1) {
				retorno = "\nVeículo excluido com sucesso.";
			} else {
				retorno = "\nNão foi possível excluir o veículo.";
			}
			
		} else {
			retorno = "\nVeículo ainda não foi cadastrado no banco.";
			
		}
		
		return retorno;
		
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosBO() {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		return veiculoDAO.consultarTodosVeiculosDAO(); 

	}

	public VeiculoVO consultarVeiculoBO(VeiculoVO veiculoVO) {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		return veiculoDAO.consultarVeiculoDAO(veiculoVO); 
	}


}
