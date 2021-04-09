package view.revenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.revenda.ControladoraCliente;
import model.vo.revenda.ClienteVO;

public class MenuCliente {
	
	Scanner teclado = new Scanner(System.in);
	
	DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_CLIENTE_CADASTRAR = 1;
	private static final int OPCAO_CLIENTE_ATUALIZAR = 2;
	private static final int OPCAO_CLIENTE_CONSULTAR = 3;
	private static final int OPCAO_CLIENTE_EXCLUIR = 4;
	private static final int OPCAO_CLIENTE_SAIR = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_CLIENTES = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_CLIENTE = 2;
	private static final int OPCAO_MENU_CONSULTAR_VOLTAR = 3;
	
	public void apresentarMenuCliente() {
		int opcao = this.apresentarOpcoes();
		while(opcao != OPCAO_CLIENTE_SAIR) {
			switch(opcao) {
			case OPCAO_CLIENTE_CADASTRAR:
				this.cadastrarCliente();
				break;
			case OPCAO_CLIENTE_ATUALIZAR:
				this.atualizarCliente();
				break;
			case OPCAO_CLIENTE_CONSULTAR:
				this.consultarCliente();
				break;
			case OPCAO_CLIENTE_EXCLUIR:
				this.excluirCliente();
				break;
			default:
				System.out.println("opção invalida!");
				break;
			}
			opcao = this.apresentarOpcoes();
		}
		
	}


	private int apresentarOpcoes() {
		System.out.println("\nMENU CLIENTE\n");
		System.out.println(OPCAO_CLIENTE_CADASTRAR+" - Cadastrar Cliente");
		System.out.println(OPCAO_CLIENTE_ATUALIZAR+" - Atualizar Cliente");
		System.out.println(OPCAO_CLIENTE_CONSULTAR+" - Consultar Cliente");
		System.out.println(OPCAO_CLIENTE_EXCLUIR+" - Excluir Cliente");
		System.out.println(OPCAO_CLIENTE_SAIR+" - Voltar");
		System.out.print("Escolha uma opão: ");

		
		return Integer.parseInt(teclado.nextLine());
	}
	
	private void cadastrarCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.print("Digite o nome do Cliente: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.print("Digite o CPF: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.print("Digite o telefone: ");
		clienteVO.setTelefone(teclado.nextLine());
		System.out.print("Digite a data de nascimento: ");
		clienteVO.setNascimento(LocalDate.parse(teclado.nextLine(), formatadorData));
		System.out.print("Digite o CNH: ");
		clienteVO.setCnh(teclado.nextLine());
		
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		
		String resultado = controladoraCliente.cadastrarCliente(clienteVO);
		System.out.println(resultado);
		
	}
	
	
	private void excluirCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.println("\nDigite o codigo do Cliente: ");
		clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		
		ControladoraCliente controladoCliente = new ControladoraCliente();
		String resultado = controladoCliente.excluirClienteController(clienteVO);
		System.out.println(resultado);
		
	}
	
	private void atualizarCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.print("Digite o codigo do Cliente: ");
		clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		
		System.out.print("Digite o nome do Cliente: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.print("Digite o CPF: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.print("Digite o telefone: ");
		clienteVO.setTelefone(teclado.nextLine());
		System.out.print("Digite a data de nascimento: ");
		clienteVO.setNascimento(LocalDate.parse(teclado.nextLine(), formatadorData));
		System.out.print("Digite o CNH: ");
		clienteVO.setCnh(teclado.nextLine());
		
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		String resultado = controladoraCliente.atualizarCliente(clienteVO);
		System.out.println(resultado);
	}
	


	private void consultarCliente() {
		int opcao = this.apresentarOpcoesMenuClienteConsulta();
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		
		while(opcao !=OPCAO_MENU_CONSULTAR_VOLTAR) {
			switch(opcao) {
				case OPCAO_MENU_CONSULTAR_TODOS_CLIENTES:{
					ArrayList<ClienteVO> listaClienteVOs = ControladoraCliente.consultarTodosClientesController();
					System.out.println("\n---------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s   %-15s   %-15s   %-15s   %-15s   %-15s\n",
							"ID","NOME","CPF","NASCIMENTO","CNH","TELEFONE");
					
					for(int i =0;i<listaClienteVOs.size(); i++) {
						listaClienteVOs.get(i).imprimir();
					}
					
					opcao = OPCAO_MENU_CONSULTAR_VOLTAR;
					break;
				}
				case OPCAO_MENU_CONSULTAR_UM_CLIENTE:{
					ClienteVO clienteVO = new ClienteVO();
					
					System.out.print("Digite o código do Cliente: ");
					clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
					
					clienteVO = controladoraCliente.consultarClienteController(clienteVO);
					if (clienteVO == null) {
						System.out.println("\nNão foix possivel localizar cliente.");
					} else {
						System.out.println("\n---------- RESULTADO DA CONSULTA ----------");
						System.out.printf("\n%3s   %-15s   %-15s   %-15s   %-15s   %-15s\n",
								"ID","NOME","CPF","NASCIMENTO","CNH","TELEFONE");
						clienteVO.imprimir();
					}

					opcao = OPCAO_MENU_CONSULTAR_VOLTAR;
					break;
				}
				default:
					System.out.println("Opção invalida");
					break;
		}
		}
			
		
	}


	private int apresentarOpcoesMenuClienteConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_CLIENTES +" - Consultar todos os Clientes");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_CLIENTE+"- Consultar um Cliente (por id)");
		System.out.println(OPCAO_MENU_CONSULTAR_VOLTAR +" - VOLTAR");
		
		System.out.print("Digite a opcao: ");
		return Integer.parseInt(teclado.nextLine());
	}
	


}
