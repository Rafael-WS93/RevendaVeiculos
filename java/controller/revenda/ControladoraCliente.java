package controller.revenda;

import java.util.ArrayList;

import model.bo.revenda.ClienteBO;
import model.vo.revenda.ClienteVO;

public class ControladoraCliente {

	public String cadastrarCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.cadastrarClienteBO(clienteVO);
	}

	public String excluirClienteController(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.excluirClienteBO(clienteVO);
	}

	public static ArrayList<ClienteVO> consultarTodosClientesController() {

		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.consultarTodosClientesBO();
	}
	
	public ClienteVO consultarClienteController(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		
		return clienteBO.consultarClienteBO(clienteVO);
	}

	public String atualizarCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.atualizarClienteBO(clienteVO);
	}

}
