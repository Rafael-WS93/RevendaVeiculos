package view.revenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.revenda.ControladoraVenda;
import model.vo.revenda.VendaVO;

public class MenuVenda {
	Scanner teclado = new Scanner(System.in);
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_VENDA_CADASTRAR = 1;
	private static final int OPCAO_VENDA_ATUALIZAR = 2;
	private static final int OPCAO_VENDA_CONSULTAR = 3;
	private static final int OPCAO_VENDA_EXCLUIR = 4;
	private static final int OPCAO_VENDA_SAIR = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_VENDAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_VENDAS = 2;
	private static final int OPCAO_MENU_CONSULTAR_VENDA_VOLTAR = 3;
	
	public void apresentarMenuVenda() {
		int opcao = this.apresentarOpcoes();
		while(opcao != OPCAO_VENDA_SAIR) {
			switch(opcao) {
			case OPCAO_VENDA_CADASTRAR:
				this.cadastrarVenda();
				break;
			case OPCAO_VENDA_ATUALIZAR:
				this.atualizarVenda();
				break;
			case OPCAO_VENDA_CONSULTAR:
				this.consultarVenda();
				break;
			case OPCAO_VENDA_EXCLUIR:
				this.excluirVenda();
				break;
			default:
				System.out.println("opção invalida!");
				break;
			}
			opcao = this.apresentarOpcoes();
		}
		
	}


	private int apresentarOpcoes() {
		System.out.println("\nMENU VENDA\n");
		System.out.println(OPCAO_VENDA_CADASTRAR+" - Cadastrar Venda");
		System.out.println(OPCAO_VENDA_ATUALIZAR+" - Atualizar Venda");
		System.out.println(OPCAO_VENDA_CONSULTAR+" - Consultar Venda");
		System.out.println(OPCAO_VENDA_EXCLUIR+" - Excluir Venda");
		System.out.println(OPCAO_VENDA_SAIR+" - Voltar");
		System.out.print("Escolha uma opão: ");

		
		return Integer.parseInt(teclado.nextLine());
	}
	
	private void cadastrarVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.print("Digite o código do Cliente: ");
		vendaVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o código do Veículo: ");
		vendaVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o valor da Venda: ");
		vendaVO.setValorVenda(Integer.parseInt(teclado.nextLine()));
		System.out.print("Data:");
		vendaVO.setDataVenda(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.println(vendaVO.getDataVenda());
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		
		String resultado = controladoraVenda.cadastrarVenda(vendaVO);
		System.out.println(resultado);
	}
	

	private void excluirVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.print("\nDigite o código da Venda: ");
		vendaVO.setIdVenda(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.excluirVenda(vendaVO);
		System.out.println(resultado);
		
	}
	
	private void atualizarVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.print("Digite o código da venda: ");
		vendaVO.setIdVenda(Integer.parseInt(teclado.nextLine()));

		System.out.print("Digite o código do Cliente: ");
		vendaVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o código do Veículo: ");
		vendaVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o valor da Venda: ");
		vendaVO.setValorVenda(Integer.parseInt(teclado.nextLine()));
		System.out.print("Data:");
		vendaVO.setDataVenda(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.println(vendaVO.getDataVenda());
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.atualizarVenda(vendaVO);
		System.out.println(resultado);
		
		
	}
	
	private void consultarVenda() {
		int opcao = apresentarOpcoesConultarVenda();
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		
		while(opcao != OPCAO_MENU_CONSULTAR_VENDA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTAR_TODAS_VENDAS:
				ArrayList<VendaVO> listaVendaVO = controladoraVenda.consultarTodasVendas();
				
				if(listaVendaVO == null) {
					System.out.println("\nVenda não localizada");
				}
				System.out.println("\n---------- RESULTADO DA CONSULTA ----------");
				System.out.printf("\n%7s   %-10s   %-10s  %-10s   %-10s\n",
						"IDVENDA", "IDCLIENTE","IDVEICULO", "VALOR","DATA");
				System.out.println();
				for(int i=0; i<listaVendaVO.size();i++) {
					listaVendaVO.get(i).imprimir();
				}
				
				opcao = OPCAO_MENU_CONSULTAR_VENDA_VOLTAR;
				break;
			case OPCAO_MENU_CONSULTAR_UMA_VENDAS:
				VendaVO vendaVO = new VendaVO();
				System.out.print("Digite o código da Venda: ");
				vendaVO.setIdVenda(Integer.parseInt(teclado.nextLine()));
				
				vendaVO = controladoraVenda.consultarVendaController(vendaVO);
				
				if (vendaVO == null) {
					System.out.println("\nVenda não localizada");					
				} else {
					System.out.printf("\n%7s   %-10s   %-10s  %-10s   %-10s\n",
							"IDVENDA", "IDCLIENTE","IDVEICULO", "VALOR","DATA");
					vendaVO.imprimir();
					
				}

				
				opcao = OPCAO_MENU_CONSULTAR_VENDA_VOLTAR;
				break;

			default:
				System.out.println("Opcao invalida!");
				break;
			}
		}
		
	}


	private int apresentarOpcoesConultarVenda() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_VENDAS+" - consultar todas as vendas");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_VENDAS+" - consultar uma venda(por id)");
		System.out.println(OPCAO_MENU_CONSULTAR_VENDA_VOLTAR+" - VOLTAR");
		System.out.print("\nDigite a opção: ");
		
		return Integer.parseInt(teclado.nextLine());
	}




}
