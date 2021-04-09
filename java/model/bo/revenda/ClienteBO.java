package model.bo.revenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import model.dao.revenda.ClienteDAO;
import model.vo.revenda.ClienteVO;

public class ClienteBO {

	public String cadastrarClienteBO(ClienteVO clienteVO) {
		String retorno;
		ClienteDAO clienteDAO = new ClienteDAO();
		
		int idade = (int) ChronoUnit.YEARS.between(clienteVO.getNascimento(), LocalDate.now());
		
		if(idade < 18) {
			retorno = "\nCliente não é maior de idade.";
		} else {
			if(clienteDAO.verificarRegistroClienteCPF(clienteVO.getCpf())) {
				retorno = "\nCliente já cadastrado no banco.";

			} else {
				int resultado = clienteDAO.cadastrarClienteDAO(clienteVO);
				
				if (resultado == 1) {
					retorno = "\nCliente cadastrado com sucesso.";
				} else {
					retorno = "\nNão foi possível cadastrar o Cliente.";
				}
			} // END IF
			
		}//END IF
		
		
		return retorno;
	}

	public String excluirClienteBO(ClienteVO clienteVO) {
		String retorno;
		ClienteDAO clienteDAO = new ClienteDAO();
		
		if(clienteDAO.verificarRegistroClienteID(clienteVO.getIdCliente())) {
			
			int resultado = clienteDAO.excluirClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\nCliente excluido com sucesso.";
			} else {
				retorno = "\nNão foi possível excluir o Cliente.";
			}
		} else {
			retorno = "\nCliente não localizado.";
		}

		return retorno;
	}

	public ArrayList<ClienteVO> consultarTodosClientesBO() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultarTodosClientesDAO();
	}

	public String atualizarClienteBO(ClienteVO clienteVO) {
		String retorno = null;
		ClienteDAO clienteDAO = new ClienteDAO();
		
		if(clienteDAO.verificarRegistroClienteID(clienteVO.getIdCliente())) {
			int resultado = clienteDAO.atualizarClienteDAO(clienteVO);
			
			if (resultado == 1) {
				retorno = "\nCliente atualizado com sucesso.";
			} else {
				retorno = "\nNão foi possível atualizar o cliente.";				
			}
			
		} else {
			retorno = "\nCliente não localizado.";
		}
			
		
		return retorno;
	}

	public ClienteVO consultarClienteBO(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		return clienteDAO.consultarClienteDAO(clienteVO);
	}
		



}
