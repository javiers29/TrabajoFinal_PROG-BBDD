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
				System.out.println("Fallo en Conexión con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");
			e.printStackTrace();
		}
	}
		
	//PANTALLA DONANTE
	
	
		
	
	public  ObservableList<Donante>  MostrarTablaDonantes() throws SQLException {
		
		ObservableList <Donante> listadonantes= FXCollections.observableArrayList();
		
		 
		Statement stm = conexion.createStatement();
		//Preparo la sentencia SQL 
		String selectsql= "SELECT * FROM " +usr +".DONANTE";
		
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
	
	

public void NuevoDonante(Integer num_donante, String nombre,String apellido1, String apellido2, String ciclo, String DNI, String fecha_na,  String pais_nac, String direccion, String poblacion, Integer cod_postal, Integer tlfn1,Integer tlfn2,String correo_electronico, Character sexo) throws SQLException {
	
	ConexionBBDD conn = new ConexionBBDD();
	   
	   try {
		
		String insertdonante = "INSERT INTO " + usr +".DONANTE VALUES ("+num_donante+",'"+nombre+"','"+apellido1+"','"+apellido2+"','"+ciclo+"',null,'"+DNI+"','"+fecha_na+"','"+pais_nac+"','"+direccion+"','"+poblacion+"',"+cod_postal+","+tlfn1+","+tlfn2+",'"+correo_electronico+"','"+sexo+"')";
		
		/*PreparedStatement pstmt = conexion.prepareStatement(insertdonante);
		
		
		
		pstmt.setInt(1, num_donante);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido1);
		pstmt.setString(4, apellido2);
		pstmt.setString(5, ciclo);
		pstmt.setString(6, DNI);
		pstmt.setString(7, fecha_na);
		pstmt.setString(8, pais_nac);
		pstmt.setString(9, direccion);
		pstmt.setString(10, poblacion);
		pstmt.setInt(11, cod_postal);
		pstmt.setInt(12, tlfn1);
		pstmt.setInt(13, tlfn2);
		pstmt.setString(14, correo_electronico);
		pstmt.setString(15, Character.toString(sexo));*/
		
		
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
				System.out.println(sqle.toString());
				Alert alert1 = new Alert (AlertType.INFORMATION);
				  alert1.setTitle("ERROR");
				  alert1.setContentText("Se ha producido un error en la inserción de datos.");
				  alert1.showAndWait();
			}
	   }
		 
   }

public ObservableList<Donante> ObtenerDonante() throws SQLException{

	ObservableList<Donante> listadonantes = FXCollections.observableArrayList();

	//Preparo la conexión para ejecutar sentencias SQL de tipo update
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

	// Preparo la sentencia SQL y la conexión para ejecutar sentencias SQL de tipo update
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

		System.out.println("Ha habido algún problema con  Oracle al hacer el borrado: " + codeErrorSQL);
		return 2;
	}

}


public int EditarDonante(Integer num_donante,String nombre, String apellido1, String apellido2, String ciclo, String dni,String fecha_nac,String pais_nac,String direccion, String poblacion,Integer cod_postal, Integer tlfn1, Integer tlfn2,String correo_electronico,Character sexo) throws SQLException{


	String fecha_na;
	// Preparo la sentencia SQL CrearTablaPersonas
	
	   String mes=  fecha_nac.substring(3, 5);
	   String dia= fecha_nac.substring(0, 2);
	   String año= fecha_nac.substring(6, 10);
	   
	   
	   
		   if(mes.substring(0, 1).equals("0")) {
			   mes=  fecha_nac.substring(4, 5);
			   dia= fecha_nac.substring(0, 2);
			   año= fecha_nac.substring(6, 10);
	      	   fecha_na= dia+ "/" + mes + "/" + año;
				   System.out.println(fecha_na);
				   
	}else {
		fecha_na= dia+ "/" + mes + "/" + año;
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
				System.out.println("Error en la actualización " + resultado);
			else
				System.out.println("Persona actualizada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una persona con  ese Nº de Donante!!");
				
				
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

public void NuevaDonacion(Integer num_don,Integer cod_col,String tipo,Integer pulso,Integer ta_sist,Integer ta_diast,Integer hb_cap, Integer hb_ven,String fecha,String grupo_sang,Integer num_donan) {
	ConexionBBDD conn = new ConexionBBDD();
	String insertdonacion;
	try {
	insertdonacion = "INSERT INTO " + usr +".DONACION VALUES ("+num_don+","+cod_col+",'"+tipo+"',"+pulso+","+ta_sist+","+ta_diast+","+hb_cap+","+hb_ven+",'"+fecha+"','"+grupo_sang+"')";
	
	Statement stm = conn.conexion.createStatement();
	int resultado = stm.executeUpdate(insertdonacion);
	if(resultado == 1) {
		String insertRellena = "INSERT INTO " + usr +".REALIZA VALUES ("+num_donan+","+num_don+")";
		stm = conn.conexion.createStatement();
		stm.executeUpdate(insertRellena);
		/*pstmt.setInt(1, cod_form);
		pstmt.setInt(2, num_donante);
		*/
		Alert alert1 = new Alert (AlertType.INFORMATION);
		  alert1.setTitle("DONACIÓN GUARDADA CORRECTAMENTE");
		  alert1.setContentText("La nueva donación se ha añadido correctamente a la base de datos, tambien se ha actualizado la tabla relación.");
		  alert1.showAndWait();
	}else {
		
		Alert alert1 = new Alert (AlertType.INFORMATION);
		  alert1.setTitle("ERROR");
		  alert1.setContentText("Se ha producido un error en la inserción de datos.");
		  alert1.showAndWait();
	}}catch(SQLException sqle){
		System.out.println(sqle.toString());
	}
}


public ObservableList<Integer> SelectNumDonantes() throws SQLException{
	ObservableList<Integer> listaDonantes = FXCollections.observableArrayList();
	Statement stm= conexion.createStatement();
	String selectdonante= "SELECT NUM_DONANTE FROM " +usr+ ".DONANTE";
	
	ResultSet resultado = stm.executeQuery(selectdonante);
	
	try {
		while(resultado.next()) {
			int num_donante = resultado.getInt(1);
			listaDonantes.add(num_donante);
		}
	}catch(SQLException sqle){
		int pos= sqle.getMessage().indexOf(":");
		String codeErrorSQL =sqle.getMessage().substring(0, pos);
		
		System.out.println(codeErrorSQL);
	}
	
	
	
	return listaDonantes;
}

	//PANTALLA FORMULARIO
	

	public void NuevoFormulario(Integer cod_form, String UNO,String DOS, String TRES, String CUATRO, String CINCO, String SEIS,  String SIETE, String OCHO, String NUEVE, String DIEZ,  String ONCE, String DOCE, String TRECE, String CATORCE,  String QUINCE, String DIECISEIS, String DIECISIETE, String DIECIOCHO,  String DIECINUEVE, String VEINTE, String VEINTIUNO, String VEINTIDOS,  String VEINTITRES, String VEINTICUATRO, String VEINTICINCO, String VEINTISEIS,  String VEINTISIETE, String VEINTIOCHO, String VEINTINUEVE, String TREINTA,  String TREINTAYUNO, String TREINTAYDOS, String PEX1, String PEX2,  String PEX3, String fecha_formu, String fecha_excl,String ESTADO,Integer num_donante) throws SQLException {
	System.out.println(fecha_excl);
	ConexionBBDD conn = new ConexionBBDD();
	String insertformulario;
	if(ESTADO.equals("APTO")) {
		insertformulario = "INSERT INTO " + usr +".FORMULARIO VALUES ("+cod_form+",'"+UNO+"','"+DOS+"','"+TRES+"','"+CUATRO+"','"+CINCO+"','"+SEIS+"','"+SIETE+"','"+OCHO+"','"+NUEVE+"','"+DIEZ+"','"+ONCE+"','"+DOCE+"','"+TRECE+"','"+CATORCE+"','"+QUINCE+"','"+DIECISEIS+"','"+DIECISIETE+"','"+DIECIOCHO+"','"+DIECINUEVE+"','"+VEINTE+"','"+VEINTIUNO+"','"+VEINTIDOS+"','"+VEINTITRES+"','"+VEINTICUATRO+"','"+VEINTICINCO+"','"+VEINTISEIS+"','"+VEINTISIETE+"','"+VEINTIOCHO+"','"+VEINTINUEVE+"','"+TREINTA+"','"+TREINTAYUNO+"','"+TREINTAYDOS+"','"+PEX1+"','"+PEX2+"','"+PEX3+"','"+fecha_formu+"',"+null+",'"+ESTADO+"',"+num_donante+")";
	}else {
		insertformulario = "INSERT INTO " + usr +".FORMULARIO VALUES ("+cod_form+",'"+UNO+"','"+DOS+"','"+TRES+"','"+CUATRO+"','"+CINCO+"','"+SEIS+"','"+SIETE+"','"+OCHO+"','"+NUEVE+"','"+DIEZ+"','"+ONCE+"','"+DOCE+"','"+TRECE+"','"+CATORCE+"','"+QUINCE+"','"+DIECISEIS+"','"+DIECISIETE+"','"+DIECIOCHO+"','"+DIECINUEVE+"','"+VEINTE+"','"+VEINTIUNO+"','"+VEINTIDOS+"','"+VEINTITRES+"','"+VEINTICUATRO+"','"+VEINTICINCO+"','"+VEINTISEIS+"','"+VEINTISIETE+"','"+VEINTIOCHO+"','"+VEINTINUEVE+"','"+TREINTA+"','"+TREINTAYUNO+"','"+TREINTAYDOS+"','"+PEX1+"','"+PEX2+"','"+PEX3+"','"+fecha_formu+"','"+fecha_excl+"','"+ESTADO+"',"+num_donante+")";
	}
	try {
	
	
	/*PreparedStatement pstmt = conexion.prepareStatement(insertformulario);
	pstmt.setInt(1, cod_form);
	pstmt.setString(2, UNO);
	pstmt.setString(3, DOS);
	pstmt.setString(4, TRES);
	pstmt.setString(5, CUATRO);
	pstmt.setString(6, CINCO);
	pstmt.setString(7, SEIS);
	pstmt.setString(8, SIETE);
	pstmt.setString(9, OCHO);
	pstmt.setString(10, NUEVE);
	pstmt.setString(11, DIEZ);
	pstmt.setString(12, ONCE);
	pstmt.setString(13, DOCE);
	pstmt.setString(14, TRECE);
	pstmt.setString(15, CATORCE);
	pstmt.setString(16, QUINCE);
	pstmt.setString(17, DIECISEIS);
	pstmt.setString(18, DIECISIETE);
	pstmt.setString(19, DIECIOCHO);
	pstmt.setString(20, DIECINUEVE);
	pstmt.setString(21, VEINTE);
	pstmt.setString(22, VEINTIUNO);
	pstmt.setString(23, VEINTIDOS);
	pstmt.setString(24, VEINTITRES);
	pstmt.setString(25, VEINTICUATRO);
	pstmt.setString(26, VEINTICINCO);
	pstmt.setString(27, VEINTISEIS);
	pstmt.setString(28, VEINTISIETE);
	pstmt.setString(29, VEINTIOCHO);
	pstmt.setString(30, VEINTINUEVE);
	pstmt.setString(31, TREINTA);
	pstmt.setString(32, TREINTAYUNO);
	pstmt.setString(33, TREINTAYDOS);
	pstmt.setString(34, PEX1);
	pstmt.setString(35, PEX2);
	pstmt.setString(36, PEX3);
	pstmt.setString(37, fecha_formu);
	pstmt.setString(38, fecha_excl);
	pstmt.setString(39, ESTADO);
	pstmt.setInt(40, num_donante);
	*/
	
	
	Statement stm = conn.conexion.createStatement();
	int resultado = stm.executeUpdate(insertformulario);
	if(resultado == 1) {
		String insertRellena = "INSERT INTO " + usr +".RELLENA VALUES ("+num_donante+","+cod_form+")";
		stm = conn.conexion.createStatement();
		stm.executeUpdate(insertRellena);
		/*pstmt.setInt(1, cod_form);
		pstmt.setInt(2, num_donante);
		*/
		Alert alert1 = new Alert (AlertType.INFORMATION);
		  alert1.setTitle("FORMULARIO GUARDADO CORRECTAMENTE");
		  alert1.setContentText("El nuevo formulario se ha añadido correctamente a la base de datos, tambien se ha actualizado la tabla relación.");
		  alert1.showAndWait();
	}else {
		
		Alert alert1 = new Alert (AlertType.INFORMATION);
		  alert1.setTitle("ERROR");
		  alert1.setContentText("Se ha producido un error en la inserción de datos.");
		  alert1.showAndWait();
	}}catch(SQLException sqle){
		System.out.println(sqle.toString());
	}
	
	
	
	
	
	
	}
	//PANTALLA INFORMES
	
	public void MostrarInformeDonantes() {
		
	}
	
	public void MostrarInformeDonaciones() {
		
	}

	public void MostrarInformeFormularios() {
	
}
}