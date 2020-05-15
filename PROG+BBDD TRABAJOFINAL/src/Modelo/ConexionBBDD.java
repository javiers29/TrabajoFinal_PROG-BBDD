package Modelo;
	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

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
				System.out.println("Fallo en Conexi�n con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexi�n con ORACLE");
			e.printStackTrace();
		}
	}
		
	//PANTALLA DONANTE
	
	
		
	
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
	
	

public void NuevoDonante(Integer num_donante, String nombre,String apellido1, String apellido2, String ciclo, String DNI, String fecha_nac,  String pais_nac, String direccion, String poblacion, Integer cod_postal, Integer tlfn1,Integer tlfn2,String correo_electronico, Character sexo) throws SQLException {
	
	ConexionBBDD conn = new ConexionBBDD();
	   
	   try {
		
		String insertdonante = "INSERT INTO" + usr +".DONANTE VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = conexion.prepareStatement(insertdonante);
		
		pstmt.setInt(1, num_donante);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido1);
		pstmt.setString(4, apellido2);
		pstmt.setString(5, ciclo);
		pstmt.setString(6, DNI);
		pstmt.setString(7, fecha_nac);
		pstmt.setString(8, pais_nac);
		pstmt.setString(9, direccion);
		pstmt.setString(10, poblacion);
		pstmt.setInt(11, cod_postal);
		pstmt.setInt(12, tlfn1);
		pstmt.setInt(13, tlfn2);
		pstmt.setString(14, correo_electronico);
		pstmt.setString(15, Character.toString(sexo));
		
		
		Statement stm = conn.conexion.createStatement();
		int resultado = stm.executeUpdate(insertdonante);
		if(resultado == 1) {
			Alert alert1 = new Alert (AlertType.INFORMATION);
			  alert1.setTitle("VALORES INTRODUCIDOS CORRECTAMENTE");
			  alert1.setContentText("El nuevo donante se ha a�adido correctamente a la base de datos.");
			  alert1.showAndWait();
				}
	   }catch(SQLException sqle){
		   int pos= sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0, pos);
			if(codeErrorSQL.equals("ORA-00001")) {
				Alert alert1 = new Alert (AlertType.INFORMATION);
				  alert1.setTitle("N� DE DONANTE DUPLICADO");
				  alert1.setContentText("El N� de Donante que estas introduciendo ya figura en nuestra base de datos.");
				  alert1.showAndWait();
			}else {
				Alert alert1 = new Alert (AlertType.INFORMATION);
				  alert1.setTitle("ERROR");
				  alert1.setContentText("Se ha producido un error en la inserci�n de datos.");
				  alert1.showAndWait();
			}
	   }
		 
   }

public ObservableList<Donante> ObtenerDonante() throws SQLException{

	ObservableList<Donante> listadonantes = FXCollections.observableArrayList();

	//Preparo la conexi�n para ejecutar sentencias SQL de tipo update
	Statement stm = conexion.createStatement();

	// Preparo la sentencia SQL CrearTablaPersonas
	String selectsql = "SELECT * FROM " + usr +".DONANTE";

	//ejecuto la sentencia
	try{
		ResultSet resultado = stm.executeQuery(selectsql);

		int contador = 0;
		while(resultado.next()){
			contador++;

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

			Donante nuevo = new Donante(num_donante,nombre,apellido1,apellido2,ciclo,dni,fecha_nac,pais_nac,direccion,poblacion,cod_postal,tlfn1,tlfn2,correo_electronico,sexo);
			listadonantes.add(nuevo);
		}

		if(contador==0)
			System.out.println("no data found");

	}catch(SQLException sqle){

		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);

		System.out.println(codeErrorSQL);
	}

	return listadonantes;
}




public int BorrarDonante(int num_donante ) throws SQLException{

	// Preparo la sentencia SQL y la conexi�n para ejecutar sentencias SQL de tipo update
	String deletesql = "DELETE " + usr +".DONANTE WHERE NUM_DONANTE= ?";
	PreparedStatement pstmt = conexion.prepareStatement (deletesql);
	pstmt.setLong(1, num_donante);

	//ejecuto la sentencia
	try{
		int resultado = pstmt.executeUpdate();

		if(resultado != 1)
			System.out.println("Error en el borrado " + resultado);
		

		return 0;
	}catch(SQLException sqle){

		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);

		System.out.println("Ha habido alg�n problema con  Oracle al hacer el borrado: " + codeErrorSQL);
		return 2;
	}

}


public int EditarDonante(Integer num_donante,String nombre, String apellido1, String apellido2, String ciclo, String dni,String fecha_nac,String pais_nac,String direccion, String poblacion,Integer cod_postal, Integer tlfn1, Integer tlfn2,String correo_electronico,Character sexo) throws SQLException{


	String fecha_na;
	// Preparo la sentencia SQL CrearTablaPersonas
	
	   String mes=  fecha_nac.substring(3, 5);
	   String dia= fecha_nac.substring(0, 2);
	   String a�o= fecha_nac.substring(6, 10);
	   
	   
	   
		   if(mes.substring(0, 1).equals("0")) {
			   mes=  fecha_nac.substring(4, 5);
			   dia= fecha_nac.substring(0, 2);
			   a�o= fecha_nac.substring(6, 10);
	      	   fecha_na= dia+ "/" + mes + "/" + a�o;
				   System.out.println(fecha_na);
				   
	}else {
		fecha_na= dia+ "/" + mes + "/" + a�o;
		System.out.println(fecha_na);
	}
	   
	   
	   
			   System.out.println(fecha_na);
	String updatevalores="UPDATE " + usr + ".DONANTE SET nombre = ?,apellido1= ?,apellido2= ?,ciclo= ?, dni= ?,fecha_nac=?,pais_nac= ?, direccion= ?, poblacion= ?,cod_postal= ?,telefono1= ?,telefono2= ?,correo_electronico= ?,sexo= ? WHERE num_donante = ?";
	 PreparedStatement pstmt = conexion.prepareStatement(updatevalores);
		pstmt.setString(1, nombre);
		pstmt.setString(2, apellido1);
		pstmt.setString(3, apellido2);
		pstmt.setString(4, ciclo);
		pstmt.setString(5, dni);
		pstmt.setString(6, fecha_na);
		pstmt.setString(7, pais_nac);
		pstmt.setString(8, direccion);
		pstmt.setString(9, poblacion);
		pstmt.setInt(10, cod_postal);
		pstmt.setInt(11, tlfn1);
		pstmt.setInt(12, tlfn2);
		pstmt.setString(13, correo_electronico);
		pstmt.setString(14, Character.toString(sexo));
		pstmt.setInt(15, num_donante);

		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la actualizaci�n " + resultado);
			else
				System.out.println("Persona actualizada con �xito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una persona con  ese N� de Donante!!");
				return 1;
			}
			else{
				
				System.out.println(sqle.toString());;
				return 2;
			}

		}
	

}
	


public void CrearCarnetDonante() {
		
	}

	//PANTALLA DONACIONES
	
public  ObservableList<Donacion>  MostrarTablaDonaciones() throws SQLException {
		
		ObservableList <Donacion> listadonacion= FXCollections.observableArrayList();
		
		 
		Statement stm = conexion.createStatement();
		//Preparo la sentencia SQL 
		String selectsql= "SELECT * FROM " +usr+ ".DONACION";
		
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