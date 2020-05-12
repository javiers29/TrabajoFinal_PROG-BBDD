package Modelo;
	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
				System.out.println("Fallo en Conexión con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");
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
	public  ObservableList<Donante>  MostrarTablaDonantes() throws SQLException {
		
		ObservableList <Donante> listadonantes= FXCollections.observableArrayList();
		
		 
		Statement stm = conexion.createStatement();
		//Preparo la sentencia SQL 
		String selectsql= "SELECT * FROM BBDD1DAW.DONANTE";
		
		//ejecuto sentencia
		try {
			ResultSet resultado = stm.executeQuery(selectsql);
			
			
			while(resultado.next()) {
				
				Integer num_donante=(int) resultado.getLong(1);
				String nombre=resultado.getString(2);
				String apellido1=resultado.getString(3);
				String apellido2=resultado.getString(4);
				String ciclo=resultado.getString(5);
				String dni=resultado.getString(7);
				String fecha_nac=resultado.getString(8);
				String pais_nac=resultado.getString(9);
				String direccion=resultado.getString(10);
				String poblacion=resultado.getString(11);
				Integer cod_postal=(int) resultado.getLong(12);
				Integer tlfn1=(int) resultado.getLong(13);
				Integer tlfn2=(int) resultado.getLong(14);
				String correo_electronico=resultado.getString(15);
				Character sexo=resultado.getString(16).charAt(0);
				
				
				
				Donante donante = new Donante(num_donante,nombre,apellido1,apellido2,ciclo,dni,fecha_nac,pais_nac,direccion,poblacion,cod_postal,tlfn1,tlfn2,correo_electronico,sexo);
				listadonantes.add(donante);
				
				 
				 
			}
		}catch(SQLException sqle) {
			int pos= sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0, pos);
		
			System.out.println(codeErrorSQL);
			
		}
		return listadonantes;
	}
	
	
public  ObservableList<Donacion>  MostrarTablaDonaciones() throws SQLException {
		
		ObservableList <Donacion> listadonacion= FXCollections.observableArrayList();
		
		 
		Statement stm = conexion.createStatement();
		//Preparo la sentencia SQL 
		String selectsql= "SELECT * FROM BBDD1DAW.DONACION";
		
		//ejecuto sentencia
		try {
			ResultSet resultado = stm.executeQuery(selectsql);
			
			
			while(resultado.next()) {
				
				Integer num_donacion=(int) resultado.getLong(1);
				Integer cod_colecta=(int) resultado.getLong(2);
				String tipo=resultado.getString(3);
				Integer pulso=(int) resultado.getLong(4);
				Integer ta_sist=(int) resultado.getLong(5);
				Integer ta_diast=(int) resultado.getLong(6);
				Integer hb_cap=(int) resultado.getLong(7);
				Integer hb_ven=(int) resultado.getLong(8);
				String fecha=resultado.getString(9);
				
				
				
				
				Donacion donacion = new Donacion(num_donacion,cod_colecta,tipo,pulso,ta_sist,ta_diast,hb_cap,hb_ven,fecha);
				listadonacion.add(donacion);
				
				 
				 
			}
		}catch(SQLException sqle) {
			int pos= sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0, pos);
		
			System.out.println(codeErrorSQL);
			
		}
		return listadonacion;
	}




public void NuevoDonante(Integer num_donante, String nombre,String apellido1, String apellido2, String ciclo, String DNI, String fecha_nac,  String pais_nac, String direccion, String poblacion, Integer cod_postal, Integer tlfn1,Integer tlfn2,String correo_electronico, Character sexo) throws SQLException {
	
	ConexionBBDD conn = new ConexionBBDD();
	   
	   try {
		
		String insertdonante = "INSERT INTO BBDD1DAW.DONANTE VALUES ("+ num_donante +", '" + nombre + "', '"+ apellido1 + "', '" + apellido2 + "', '"+ ciclo + "',null, '"+ DNI + "', '" + fecha_nac + "', '"+ pais_nac + "', '"+ direccion + "', '" + poblacion + "', "+ cod_postal + ", "+ tlfn1 + ", " + tlfn2 + ", '"+ correo_electronico + "', '"+ sexo + "')";
		
		
		
		Statement stm = conn.conexion.createStatement();
		int resultado = stm.executeUpdate(insertdonante);
		if(resultado == 1) {
			Alert alert1 = new Alert (AlertType.INFORMATION);
			  alert1.setTitle("VALORES INTRODUCIDOS CORRECTAMENTE");
			  alert1.setContentText("El nuevo donante se ha añadido correctamente a la base de datos.");
			  alert1.showAndWait();
				}
	   }catch(SQLException sqle){
		   int pos= sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0, pos);
			if(codeErrorSQL.equals("ORA-00001")) {
				Alert alert1 = new Alert (AlertType.INFORMATION);
				  alert1.setTitle("Nº DE DONANTE DUPLICADO");
				  alert1.setContentText("El Nº de Donante que estas introduciendo ya figura en nuestra base de datos.");
				  alert1.showAndWait();
			}else {
				Alert alert1 = new Alert (AlertType.INFORMATION);
				  alert1.setTitle("ERROR");
				  alert1.setContentText("Se ha producido un error en la inserción de datos.");
				  alert1.showAndWait();
			}
	   }
		 
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