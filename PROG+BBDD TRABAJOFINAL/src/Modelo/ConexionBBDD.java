package Modelo;
	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConexionBBDD {

	private String url= "";
	private   String user = "";
	private String pwd = "";
	private   String usr = "";
	private   Connection conexion;

	public ConexionBBDD()  {


		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/Modelo/datos.ini");
			if (miFichero.exists()){
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("url");
				user=propiedades.getProperty("user");
				pwd=propiedades.getProperty("pwd");
				usr=propiedades.getProperty("usr");
			}

			else
				System.out.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, user, pwd);

			if(conexion.isClosed())
				System.out.println("Fallo en Conexi�n con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexi�n con ORACLE");
			e.printStackTrace();
		}
	}
		
	//PANTALLA DONANTE
	
	public void GuardarDonante() {
		
	}
	
	
	public void EliminarDonante() {
		
	}
	
	public void EditarDonante() {
		
	}
	
	public void CrearCarnetDonante() {
		
	}

	//PANTALLA DONACIONES
	
	public void MostrarDonaciones() {
		
	}
	
	//PANTALLA FORMULARIO
	
	public void GuardarDonacion() {
		
	}
	
	
	//PANTALLA INFORMES
	
	public void MostrarInformeDonantes() {
		
	}
	
	public void MostrarInformeDonaciones() {
		
	}

	public void MostrarInformeFormularios() {
	
}
}