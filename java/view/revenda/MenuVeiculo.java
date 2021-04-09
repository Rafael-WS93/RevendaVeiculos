package view.revenda;

import java.util.ArrayList;
import java.util.Scanner;

import controller.revenda.ControladoraVeiculo;
import model.vo.revenda.TipoVeiculo;
import model.vo.revenda.VeiculoVO;

public class MenuVeiculo {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_VEICULO_CADASTRAR = 1;
	private static final int OPCAO_VEICULO_ATUALIZAR = 2;
	private static final int OPCAO_VEICULO_EXCLUIR = 3;
	private static final int OPCAO_VEICULO_CONSULTAR = 4;
	private static final int OPCAO_VEICULO_SAIR = 5;
	
	private static final int OPCAO_VEICULO_CARRO = 1;
	private static final int OPCAO_VEICULO_MOTO= 2;
	private static final int OPCAO_VEICULO_SUV = 3;
	private static final int OPCAO_VEICULO_FIM = 99;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_VEICULOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_VEICULO = 2;
	private static final int OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR = 3;
	
	public void apresentarMenuVeiculo() {
		int opcao = this.apresentarOpcoes();
		while(opcao != OPCAO_VEICULO_SAIR) {
			switch(opcao) {
			case OPCAO_VEICULO_CADASTRAR:
				/*System.out.println("cadastrado");*/
				this.cadastrarVeiculo();
				break;
			case OPCAO_VEICULO_ATUALIZAR:
				
				this.atualizarVeiculo();
				break;
			case OPCAO_VEICULO_CONSULTAR:
				this.consultarVeiculo();
				break;
			case OPCAO_VEICULO_EXCLUIR:
				this.excluirVeiculo();
				break;
			default:
				System.out.println("opção invalida!");
				break;
			}
			opcao = this.apresentarOpcoes();
		}
		
	}


	private int apresentarOpcoes() {
		System.out.println("\nMENU VEICULO\n");
		System.out.println(OPCAO_VEICULO_CADASTRAR+" - Cadastrar Veiculo");
		System.out.println(OPCAO_VEICULO_ATUALIZAR+" - Atualizar Veiculo");
		System.out.println(OPCAO_VEICULO_CONSULTAR+" - Consultar Veiculo");
		System.out.println(OPCAO_VEICULO_EXCLUIR+" - Excluir Veiculo");
		System.out.println(OPCAO_VEICULO_SAIR+" - Voltar");
		System.out.print("Escolha uma opção: ");

		
		return Integer.parseInt(teclado.nextLine());
	}
	
	private void cadastrarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("Digite o modelo do Veiculo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.print("Digite o tipo de Veiculo: ");
		int opcao = this.apresentarOpcoesTipoVeiculo();
		while(opcao != OPCAO_VEICULO_FIM) {
			switch(opcao) {
			case OPCAO_VEICULO_CARRO:
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.CARRO);
				break;
			case OPCAO_VEICULO_MOTO:
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.MOTO);
				break;
			case OPCAO_VEICULO_SUV:
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.SUV);
				break;
			default:
				System.out.println("Opção inválida!");
				opcao= this.apresentarOpcoesTipoVeiculo();
				
			}
		}
		System.out.print("Digite o fabricante do Veículo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.print("Digite a cor do Veículo: ");
		veiculoVO.setCor(teclado.nextLine());
		System.out.print("Digite a placa do Veículo: ");
		veiculoVO.setPlaca(teclado.nextLine());
		System.out.print("Digite o ano do Veículo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.cadastrarVeiculoController(veiculoVO);
		System.out.println(resultado);
	}

	private int apresentarOpcoesTipoVeiculo() {
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_VEICULO_CARRO+" - Carro");
		System.out.println(OPCAO_VEICULO_MOTO+" - Moto");
		System.out.println(OPCAO_VEICULO_SUV+" - SUV");
		System.out.print("Digite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
	

	private void excluirVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("\nDigite o código do Veículo: ");
		veiculoVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.excluirVeiculoController(veiculoVO);
		System.out.println(resultado);
		
	}
	

	private void atualizarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("Digite o código do veículo: ");
		veiculoVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		
		System.out.print("Digite o modelo do Veiculo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.print("Digite o tipo de Veiculo: ");
		int opcao = this.apresentarOpcoesTipoVeiculo();
		while(opcao != OPCAO_VEICULO_FIM) {
			switch(opcao) {
			case OPCAO_VEICULO_CARRO:
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.CARRO);
				break;
			case OPCAO_VEICULO_MOTO:
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.MOTO);
				break;
			case OPCAO_VEICULO_SUV:
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.SUV);
				break;
			default:
				System.out.println("Opção inválida!");
				opcao= this.apresentarOpcoesTipoVeiculo();
				
			}
		}
		System.out.print("Digite o fabricante do Veículo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.print("Digite a cor do Veículo: ");
		veiculoVO.setCor(teclado.nextLine());
		System.out.print("Digite a placa do Veículo: ");
		veiculoVO.setPlaca(teclado.nextLine());
		System.out.print("Digite o ano do Veículo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.atualizarVeiculoController(veiculoVO);
		System.out.println(resultado);
	}
	
	private void consultarVeiculo() {
		int opcao = this.apresentarOpcoesMenuConsulta();
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		
		while(opcao != OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR) {
			switch(opcao) {
				case OPCAO_MENU_CONSULTAR_TODOS_VEICULOS:{
					opcao = OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR;
					ArrayList<VeiculoVO> listaVeiculosVO = controladoraVeiculo.consultarTodosVeiculosController();
					
					if(listaVeiculosVO.isEmpty()) {
						System.out.println("\nLista de Veículos não localizada.");
					} else {
						System.out.println("\n---------- RESULTADO DA CONSULTA ----------");
						System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-5s   %-10s   %-10s   \n",
								"ID", "MODELO","TIPO", "FABRICANTE", "ANO", "COR", "PLACA");
						
							for(int i=0; i< listaVeiculosVO.size(); i++) {
								listaVeiculosVO.get(i).imprimir();
							}/*END FOR*/
						
					}/*END IF*/

					break;
				}/*END CASE*/
				case OPCAO_MENU_CONSULTAR_UM_VEICULO:{
					opcao = OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR;
					
					VeiculoVO veiculoVO = new VeiculoVO();
					System.out.print("Digite o código do veiculo: ");
					veiculoVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
					
					veiculoVO = controladoraVeiculo.consultarVeiculoController(veiculoVO);
					
					if (veiculoVO == null) {
						System.out.println("\nVeículo não localizado");
					} else {
					
					System.out.println("\n---------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-5s   %-10s   %-10s   \n",
							"ID", "MODELO","TIPO", "FABRICANTE", "ANO", "COR", "PLACA");
					veiculoVO.imprimir();
					} /*END IF*/
					break;
				} /*END CASE*/
				default:
					System.out.println("Opção invalida");
					break;
			}
			
		}
	}


	private int apresentarOpcoesMenuConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_VEICULOS +"- Consultar todos os Veículos.");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_VEICULO +"- Consultar um veículo específico (por id).");
		System.out.println(OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR +"- VOLTAR");
		System.out.print("\nDigite a opção: ");
		
		return Integer.parseInt(teclado.nextLine());
	}





}
