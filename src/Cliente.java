package src;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {

	private String nombre;
	private String celular;
	private String codigoDeArea;
	private String mail;
	private Integer codigoPostal;
	private Provincia provincia;
	private boolean esCliente;
	private boolean deseaSerLlamado;
	private String direccion;
	private final String CODIGO_ARGENTINA = "+54";
	private ArrayList<Llamada>llamadas;
	private Integer[] codigosPostalesActuales;
	private Integer posicionActualIndiceCodigosPostales;
	
	
	public Cliente(String nombre, String codigoDeArea, String celular, String mail, String direccion, Integer codigoPostal,
			Provincia provincia) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.celular = CODIGO_ARGENTINA +codigoDeArea+ celular ;
		this.mail = mail;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		posicionActualIndiceCodigosPostales = 0 ;
		this.esCliente = false;
		this.deseaSerLlamado = true;
		
		llamadas = new ArrayList <Llamada>();
		codigosPostalesActuales=new Integer[10];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public String getCodigoDeArea() {
		return codigoDeArea;
	}

	public void setCodigoDeArea(String codigoDeArea) {
		this.codigoDeArea = codigoDeArea;
	}

	public boolean isEsCliente() {
		return esCliente;
	}

	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}

	public Integer[] getCodigosPostalesActuales() {
		return codigosPostalesActuales;
	}

	public void setCodigosPostalesActuales(Integer[] codigosPostalesActuales) {
		this.codigosPostalesActuales = codigosPostalesActuales;
	}

	public Integer getPosicionActualIndiceCodigosPostales() {
		return posicionActualIndiceCodigosPostales;
	}

	public void setPosicionActualIndiceCodigosPostales(Integer posicionActualIndiceCodigosPostales) {
		this.posicionActualIndiceCodigosPostales = posicionActualIndiceCodigosPostales;
	}

	public String getCODIGO_ARGENTINA() {
		return CODIGO_ARGENTINA;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public boolean isCliente() {
		return esCliente;
	}

	public void setIsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}

	public boolean isDeseaSerLlamado() {
		return deseaSerLlamado;
	}

	public void setDeseaSerLlamado(boolean deseaSerLlamado) {
		this.deseaSerLlamado = deseaSerLlamado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

	public Boolean validarMail(String mail) {
		Character clave ;
		Boolean esValida = false;
		Integer contadorArroba=0;
		Integer contadorPunto=0;
	// se puede usar conteins 
		for(int i = 0 ; i<mail.length();i++) {
			clave = mail.charAt(i);
			String evaluarContraseña = String.valueOf(clave);
			if(evaluarContraseña.matches("@")) {
				contadorArroba++;
			}
			if(evaluarContraseña.matches(".")) {
				contadorPunto++;
			}
	}
		if(contadorArroba ==1 && contadorPunto>=1) {
			esValida = true;
		}
		return esValida;
	
	}

	@Override
	public String toString() {
		return "Cliente nombre=" + nombre + ", celular=" + celular + ", mail=" + mail + ", codigoPostal="
				+ codigoPostal + ", provincia=" + provincia + ", direccion=" + direccion + "";
	}
	
	public void registroDeLlamadas(Llamada llamada) {
			llamadas.add(llamada);
	}

	public ArrayList<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(ArrayList<Llamada> llamadas) {
		this.llamadas = llamadas;
	}
	public Boolean queExistaCodigoPostal(Integer codigoPostal) {
		return true;
		
		
		
	}
	public void agregarCodigoPostal(Integer codigo) {
		
		codigosPostalesActuales[posicionActualIndiceCodigosPostales++] = codigo;
	}

	

}
