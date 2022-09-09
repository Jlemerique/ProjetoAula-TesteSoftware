package sistemabancario;

import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class GerenciadoraClientesTeste {
	
	@Test
	public void testePesquisaCliente() {
		
		//criando clientes
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria", 10, "Maria@gmail.com", 2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("clayton@gmail.com"));
		
	}
}
