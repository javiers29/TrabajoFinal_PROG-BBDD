package Modelo;

public class Donante {

	private Integer num_donante;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String ciclo;
	private String DNI;
	private String fecha_nac;
	private String pais_nac;
	private String direccion;
	private String poblacion;
	private Integer cod_postal;
	private Integer telefono1;
	private Integer telefono2;
	private String correo_electronico;
	private char sexo;
	
	public Donante(Integer num_donante, String nombre, String apellido1, String apellido2, String ciclo, String dNI,
			String fecha_nac, String pais_nac, String direccion, String poblacion, Integer cod_postal,
			Integer telefono1, Integer telefono2, String correo_electronico, char sexo) {
		super();
		this.num_donante = num_donante;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.ciclo = ciclo;
		DNI = dNI;
		this.fecha_nac = fecha_nac;
		this.pais_nac = pais_nac;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.cod_postal = cod_postal;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.correo_electronico = correo_electronico;
		this.sexo = sexo;
	}

	public Integer getNum_donante() {
		return num_donante;
	}

	public void setNum_donante(Integer num_donante) {
		this.num_donante = num_donante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getPais_nac() {
		return pais_nac;
	}

	public void setPais_nac(String pais_nac) {
		this.pais_nac = pais_nac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public Integer getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(Integer cod_postal) {
		this.cod_postal = cod_postal;
	}

	public Integer getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(Integer telefono1) {
		this.telefono1 = telefono1;
	}

	public Integer getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(Integer telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
	
}
