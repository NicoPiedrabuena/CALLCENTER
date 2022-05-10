package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.CallCenter;
import src.Cliente;
import src.Llamada;
import src.Provincia;

class testCallCenter {

	@Test
	void queSePuedaCrearUnCliente() {
		
		// preparacion
		String nombre = "Nicolas Piedrabuena";
		String codigoDeArea="11"; 
		String celular = "31365260";
		String mail = "wpiedrabuena@gmail.com";
		String direccion = "pujol 2633";
		Integer codigoPostal = 1765;
		Provincia provincia= Provincia.BUENOS_AIRES;
		
		final Boolean DESEA_SER_LLAMADO = true;
		
		//ejecucion
		Cliente nuevo = new Cliente (nombre,codigoDeArea,celular,mail,direccion,codigoPostal,provincia);
		
		//validacion
		assertEquals(nombre, nuevo.getNombre());
		assertFalse(nuevo.isCliente());
		assertEquals(DESEA_SER_LLAMADO, nuevo.isDeseaSerLlamado());

	}
	@Test 
	void queElMailIngresadoSeaCorrecto() {
		
		// preparacion
				String nombre = "Nicolas Piedrabuena";
				String codigoDeArea="11"; 
				String celular = "31365260";
				String mail = "wpiedrabuena@gmail.com";
				String direccion = "pujol 2633";
				Integer codigoPostal = 1765;
				Provincia provincia= Provincia.BUENOS_AIRES;
				
				String nombreCallCenter = "Oeste Cable Color";
				
				//ejecucion
			Cliente nuevo = new Cliente (nombre,codigoDeArea,celular,mail,direccion,codigoPostal,provincia);
				CallCenter oesteColor = new CallCenter("nombreCallCenter");
		
		assertTrue(nuevo.validarMail(mail));
		
		
	}
	
	@Test
	void queSePuedaAgregarUnCliente() {
		
		// preparacion
		String nombre = "Nicolas Piedrabuena";
		String codigoDeArea ="11";
		String celular = "31365260";
		String mail = "wpiedrabuena@gmail.com";
		String direccion = "pujol 2633";
		Integer codigoPostal = 1765;
		Provincia provincia= Provincia.BUENOS_AIRES;
		
		String nombreCallCenter = "Oeste Cable Color";
		
		//ejecucion
		Cliente nuevo = new Cliente (nombre,codigoDeArea,celular,mail,direccion,codigoPostal,provincia);
		CallCenter oesteColor = new CallCenter("nombreCallCenter");
		oesteColor.agregarCliente(nuevo);
		
		//validacion
		assertEquals(oesteColor.nombreClienteEnParticular(0), nombre);
	}
	@Test
	void queSePuedaElegirUnClienteAlContactoAlAzar() {
		// preparacion
				String nombre = "Nicolas Piedrabuena";
				String codigoDeArea ="11";
				String celular = "31365260";
				String mail = "wpiedrabuena@gmail.com";
				String direccion = "pujol 2633";
				Integer codigoPostal = 1765;
				Provincia provincia= Provincia.BUENOS_AIRES;
				String datosContactoSeleccionado;
				
				String nombre2 = "Nicolas Peña";
				String codigoDeArea2 ="11";
				String celular2 = "1595753";
				String mail2 = "wpeña@gmail.com";
				String direccion2 = "rivadavia 3233";
				Integer codigoPostal2 = 1065;
				Provincia provincia2= Provincia.LA_PAMPA;
				
				
				String nombreCallCenter = "Oeste Cable Color";
				
				//ejecucion
				Cliente nuevo = new Cliente (nombre,codigoDeArea,celular,mail,direccion,codigoPostal,provincia);
				Cliente nuevo2 = new Cliente (nombre2,codigoDeArea2,celular2,mail2,direccion2,codigoPostal2,provincia2);
				CallCenter oesteColor = new CallCenter("nombreCallCenter");
				oesteColor.agregarCliente(nuevo);
				oesteColor.agregarCliente(nuevo2);
				datosContactoSeleccionado= oesteColor.seleccionarContacto().toString();
				
				assertNotNull(datosContactoSeleccionado);
				System.out.println(datosContactoSeleccionado);
				
				
				
	}
	@Test 
	void queSePuedaRegistrarUnaLLamadaExitosa() {
		// preparacion
		String nombre = "Nicolas Piedrabuena";
		String codigoDeArea="11";
		String celular = "31365260";
		String mail = "wpiedrabuena@gmail.com";
		String direccion = "pujol 2633";
		Integer codigoPostal = 1765;
		Provincia provincia= Provincia.BUENOS_AIRES;
		String datosContactoSeleccionado;
		Integer cantidadDeLLamadasEsperadas = 1;
		
		Boolean esExistosa = true;
		String observaciones = "Es cliente";
		
		
		//ejecucion
		Cliente nuevo = new Cliente (nombre,codigoDeArea,celular,mail,direccion,codigoPostal,provincia);
		CallCenter oesteColor = new CallCenter("nombreCallCenter");
		Llamada llamada = new Llamada(esExistosa,observaciones);
		oesteColor.agregarCliente(nuevo);
		nuevo.registroDeLlamadas(llamada);
		
		
		assertEquals(cantidadDeLLamadasEsperadas, nuevo.getLlamadas().size());
		assertNotEquals(2,nuevo.getLlamadas().size());
	}
	
	
	
	
}
