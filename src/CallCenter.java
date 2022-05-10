package src;
import java.util.ArrayList;

public class CallCenter {
	private String nombre;
	private ArrayList<Cliente>clientes;
	
	public CallCenter(String nombre) {
		this.nombre = nombre;
		clientes = new ArrayList<Cliente>();
		
	}

	public void agregarCliente(Cliente nuevo) {
		clientes.add(nuevo);
		
	}
	public String nombreClienteEnParticular (int cliente) {
		return clientes.get(cliente).getNombre();
		}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente seleccionarContacto() {
		ArrayList<Cliente>posibleCliente= new ArrayList <Cliente>();
		Integer posicionRandom = null; 
		 for (Cliente cliente : clientes) {
			if(cliente.isCliente() ==  false &&  cliente.isDeseaSerLlamado() == true ) {
				posibleCliente.add(cliente);
				
			}
				
		}
		for (Cliente cliente : posibleCliente) {
			posicionRandom = (int)(Math.random()* posibleCliente.size());
		}
		
		return posibleCliente.get(posicionRandom);
		
		
	}
	
}
