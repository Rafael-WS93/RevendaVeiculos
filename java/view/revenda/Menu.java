package view.revenda;

import java.util.Scanner;

public class Menu {
	private static final int OPCAO_MENU_CLIENTE =1;
	private static final int OPCAO_MENU_VEICULO =2;
	private static final int OPCAO_MENU_VENDA =3;
	private static final int OPCAO_MENU_RELATORIO =4;
	private static final int OPCAO_MENU_SAIR =9;
	
	Scanner teclado = new Scanner(System.in);
	
	public void apresentarMenu() {
		int opcao = this.apresentarOpcoesMenu();
		
		while(opcao !=OPCAO_MENU_SAIR) {
			switch(opcao) {
			case OPCAO_MENU_CLIENTE:
				MenuCliente menuCliente = new MenuCliente();
				menuCliente.apresentarMenuCliente();
				break;
			case OPCAO_MENU_VEICULO:
				MenuVeiculo menuVeiculo = new MenuVeiculo();
				menuVeiculo.apresentarMenuVeiculo();
				break;
			case OPCAO_MENU_VENDA:
				MenuVenda menuVenda = new MenuVenda();
				menuVenda.apresentarMenuVenda();
				break;
				default:
					System.out.println("Opção invalida!");
					break;
			case OPCAO_MENU_RELATORIO:
				MenuRelatorio menurelatorio = new MenuRelatorio();
				menurelatorio.apresentarMenuRelatorio();
				break;
			
			}
			opcao = this.apresentarOpcoesMenu();
		}
		
	}
	
	private int apresentarOpcoesMenu() {
		System.out.println("Revenda Ferro-Velho");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CLIENTE+" - Menu Cliente");
		System.out.println(OPCAO_MENU_VEICULO+" - Menu Veiculo");
		System.out.println(OPCAO_MENU_VENDA+" - Menu Venda");
		System.out.println(OPCAO_MENU_RELATORIO+" - Menu Relatório");
		System.out.println(OPCAO_MENU_SAIR+" - SAIR");
		System.out.print("\nDigite a opção: ");
		
		return Integer.parseInt(teclado.nextLine());
		
	}

}
