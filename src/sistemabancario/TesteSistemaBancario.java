package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistemaBancario {

	static GerenciadoraContas gerContas;
	static GerenciadoraClientes gerClientes;

	public static void main (String[] args) {
		inicializaSitemaBancario(); //inicializar dados de contas e clientes

		Scanner sc = new Scanner(System.in);
		boolean continua = true;

		while(continua) {
			printMenu();

			int opcao = sc.nextInt();

			switch(opcao) {
			case 1:
				System.out.println("Digite o id do cliente: ");
				int idCliente = sc.nextInt();				
				Cliente cliente = gerClientes.pesquisaCliente(idCliente);

				if(cliente != null) {
					System.out.println(cliente.toString());
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;
			case 2:
				System.out.println("Digite o id da conta: ");
				int idConta = sc.nextInt();
				ContaCorrente contaCorrente = gerContas.pesquisaConta(idConta);

				if(contaCorrente != null) {
					System.out.println(contaCorrente.toString());
				} else {
					System.out.println("Conta corrente não encontrado");
				}
				break;
			case 3:
				System.out.println("Digite o ID do cliente que deseja ativar: ");
				int idClienteStatus = sc.nextInt();
				Cliente clienteStatusTrue = gerClientes.pesquisaCliente(idClienteStatus);

				if(clienteStatusTrue != null) {
					clienteStatusTrue.setAtivo(true);
					System.out.println("Cliente ativado com sucesso!");
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;
			case 4:
				System.out.println("Digite o ID do cliente que deseja desativar: ");
				int idClienteStatus2 = sc.nextInt();
				Cliente clienteStatusFalse = gerClientes.pesquisaCliente(idClienteStatus2);

				if(clienteStatusFalse != null) {
					clienteStatusFalse.setAtivo(false);
					System.out.println("Cliente desativado com sucesso.");
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;
			case 5: 
				continua = false;
				System.out.println("Finalizando....");
			default:
				break;
			}	
		}
		sc.close();
	}

	private static void printMenu() {
		System.out.println("Qual operação você deseja executar?\n");
		System.out.println("1) Consultar por um cliente");
		System.out.println("2) Consultar por uma conta corrente");
		System.out.println("3) Ativar um cliente");
		System.out.println("4) Desativar um cliente");
		System.out.println("5) Sair");
		System.out.println(" ");
	}

	private static void inicializaSitemaBancario() {
		//cirar uma lista vazia de contas e clientes:
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();

		//Criar e inserir duas contas no banco
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);

		//Criar e inserir dois clientes no banco
		Cliente cliente01 = new Cliente(1, "Gilherme", 30, "guilherme@gmail.com", conta01.getId(), true);
		Cliente cliente02 = new Cliente(1, "Gabriel", 30, "gabriel@gmail.com", conta02.getId(), true);
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);

	}	
}
