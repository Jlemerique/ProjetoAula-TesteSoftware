package sistemabancario;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTeste {
	@Test
	public void testePesquisaCliente() {
		// Definição e inicialização do cenário
		/* Criando clientes para instanciar no caso de Teste */

		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria", 10, "maria@gmail.com", 1, true);

		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);

		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		// Fim do cenário

		// Execução
		Cliente cliente = gerClientes.pesquisaCliente(1);

		// Análise de resultado esperado
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("clayton@gmail.com"));

		// Execução
		Cliente cliente2 = gerClientes.pesquisaCliente(2);

		// Análise de resultado esperado
		assertThat(cliente2.getId(), is(2));
		assertThat(cliente2.getEmail(), is("maria@gmail.com"));
	}

	@Test
	public void testeAdicionaCliente() {
		// Definição e inicialização do cenário
		/* Criando clientes para instanciar no caso de Teste */

		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria", 10, "maria@gmail.com", 1, true);

		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);

		GerenciadoraClientes gerenciadoraClientes = new GerenciadoraClientes(clientes);
		// Fim do cenário

		// Execução
		gerenciadoraClientes.adicionaCliente(cliente01);
		gerenciadoraClientes.adicionaCliente(cliente02);

		// Análise de resultado esperado
		assertThat(cliente01.getId(), is(1));
		assertThat(cliente01.getEmail(), is("clayton@gmail.com"));
		assertThat(cliente01.getNome(), is("Clayton"));

		assertThat(cliente02.getId(), is(2));
		assertThat(cliente02.getEmail(), is("maria@gmail.com"));
		assertThat(cliente02.getNome(), is("Maria"));
	}

	@Test
	public void testeRemoveCliente() {
		// Definição e inicialização do cenário
		/* Criando clientes para instanciar no caso de Teste */
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria", 10, "maria@gmail.com", 1, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerenciadoraClientes = new GerenciadoraClientes(clientes);
		//********************//
		
		//Fase de execução do teste
		boolean clienteRemovido = gerenciadoraClientes.removeCliente(1);
	
		//Análise do resultado esperado
		assertThat(clienteRemovido, is(true));
		assertThat(gerenciadoraClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerenciadoraClientes.pesquisaCliente(1));
		
		
		clienteRemovido = gerenciadoraClientes.removeCliente(2);
		assertThat(clienteRemovido, is(true));
		assertThat(gerenciadoraClientes.getClientesDoBanco().size(), is(0));
		assertNull(gerenciadoraClientes.pesquisaCliente(2));
	}
}