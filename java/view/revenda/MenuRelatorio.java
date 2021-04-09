package view.revenda;

import java.util.ArrayList;
import java.util.Scanner;

import controller.revenda.ControladoraFaturamento;
import controller.revenda.ControladoraRelatorioVendas;
import model.dto.revenda.RelatorioFaturamentoDTO;
import model.dto.revenda.RelatorioVendaDTO;

public class MenuRelatorio {
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_RELATORIO_FATURAMENTO = 1;
	private static final int OPCAO_RELATORIO_VENDA = 2;
	private static final int OPCAO_RELATORIO_VOLTAR = 3;

	public void apresentarMenuRelatorio() {
		int opcao = this.apresentarOpcoesMenu();
		while(opcao !=OPCAO_RELATORIO_VOLTAR) {
			switch(opcao) {
			case OPCAO_RELATORIO_FATURAMENTO:
				this.consultarFaturamento();
				break;
			case OPCAO_RELATORIO_VENDA:
				this.consultarRelatorioVenda();
				break;
			default:
				System.out.println("opção invalida!");
				break;
			}/*END SWITCH*/
			opcao = this.apresentarOpcoesMenu();
		}/*END WHILE*/
	}/*END METODO*/

	private void consultarRelatorioVenda() {
		ControladoraRelatorioVendas controladoraRelatorioVendas = new ControladoraRelatorioVendas();
		
		ArrayList<RelatorioVendaDTO> relatorioVendasDTO = controladoraRelatorioVendas.consultarRelatorioVendas();
		
		if (relatorioVendasDTO.isEmpty()) {
			System.out.println("lista de vendas não encontrada.");
		} else {
			System.out.println("\n---------- RELATÒRIO DE VENDA ----------");
			System.out.printf("\n%10s   %-10s   %-10s   %-10s   %-10s   %-15s   %-15s"
					,"CLIENTE","CPF","TELEFONE","VEICULO","PLACA","DATA DE VENDA","VALOR"
					);
			for (int i=0; i<relatorioVendasDTO.size(); i++) {
				relatorioVendasDTO.get(i).imprimir();
			}/*END FOR*/
		} /*END IF*/
		
	} /*END METODO*/

	private void consultarFaturamento() {
		
		ControladoraFaturamento controladoraFaturamento = new ControladoraFaturamento();
		
		ArrayList<RelatorioFaturamentoDTO> listaFaturamaneto = controladoraFaturamento.consultarFaturamento();
		
		if (listaFaturamaneto.isEmpty()) {
			System.out.println("lista de faturamento não encontrada.");
		} else {
			System.out.println("\n---------- FATURAMENTO ----------");
			System.out.printf("\n%7s   %-4s   %-10s",
					"ANO","MES","FATURAMENTO");
			for(int i=0; i< listaFaturamaneto.size(); i++) {
				listaFaturamaneto.get(i).imprimir();
			}/*END FOR*/

		} /*END IF*/
		

	}  /*END METODO*/

	private int apresentarOpcoesMenu() {
		System.out.println("\nMENU RELATÓRIO\n");
		System.out.println(OPCAO_RELATORIO_FATURAMENTO+"- Relatório de faturamento");
		System.out.println(OPCAO_RELATORIO_VENDA+"- Relatório de Vendas");
		System.out.println(OPCAO_RELATORIO_VOLTAR+"- VOLTAR");
		System.out.print("Escolha uma opção: ");
		
		return Integer.parseInt(teclado.nextLine());
	}/*END METODO*/

}
