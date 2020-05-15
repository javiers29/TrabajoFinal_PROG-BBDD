package Vista;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.itextpdf.text.DocumentException;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donante;
import Vista.ImprimeArchivo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControlDonantes {
	@FXML
	private TextField num_donante;
	
	@FXML
	private TextField nombre;
	
	@FXML
	private TextField apellido1;
	
	@FXML
	private TextField apellido2;
	
	@FXML
	private ComboBox ciclo;
	
	 private ObservableList <String> posiblesciclos= FXCollections.observableArrayList("DAW","DAM", "TAFAD", "E.Infantil", "TES" );
	
	@FXML
	private TextField DNI;
	
	@FXML
	private DatePicker fecha_nac;
	
	@FXML
	private TextField pais_nac;
	
	@FXML
	private TextField direccion;
	
	@FXML
	private TextField poblacion;
	
	@FXML
	private TextField cod_postal;
	
	@FXML
	private TextField tlfn1;
	
	@FXML
	private TextField tlfn2;
	
	@FXML
	private TextField correo_electronico;
	
	 @FXML
	   private RadioButton rbhombre;
	   @FXML
	   private RadioButton rbmujer;
	   @FXML
	   private ToggleGroup sexo;
	   
	@FXML
		private ImageView foto;
	
	@FXML
	private Button btGuardar;
	
	@FXML
	private Button btEliminar;
	
	@FXML
	private Button btReset;
	
	@FXML
	private Button crear_carnet;
	
	
	 @FXML
	   private TableView<Donante> tabla_donantes;
	   
	   @FXML
	   private TableColumn <Donante,Integer> colum_num_donante;
	   @FXML
	   private TableColumn <Donante,String> colum_nombre;
	   @FXML
	   private TableColumn <Donante,String> colum_apellido1;
	   @FXML
	   private TableColumn <Donante,String> colum_apellido2;
	   @FXML
	   private TableColumn <Donante,String> colum_ciclo;
	   @FXML
	   private TableColumn <Donante,String> colum_DNI;
	   @FXML
	   private TableColumn <Donante,String> colum_fecha_nac;
	   @FXML
	   private TableColumn <Donante,String> colum_pais_nac;
	   @FXML
	   private TableColumn <Donante,String> colum_direccion;
	   @FXML
	   private TableColumn <Donante,String> colum_poblacion;
	   @FXML
	   private TableColumn <Donante,Integer> colum_cod_postal;
	   @FXML
	   private TableColumn <Donante,Integer> colum_tlfn1;
	   @FXML
	   private TableColumn <Donante,Integer> colum_tlfn2;
	   @FXML
	   private TableColumn <Donante,String> colum_correo;
	   @FXML
	   private TableColumn <Donante,Character> colum_sexo;
	   
	
	
	
	
	private Stage VentanaDonantes;
	
	
	
	private  Main MenuPrincipal;
	
	ConexionBBDD conn;
	 private ObservableList <Donante> datosdonantes= FXCollections.observableArrayList();
	 
	// Atributos necesarios para codificar la edicion
		private boolean edicion;
		private int indiceedicion;
	 
	 
	 public void initialize() throws SQLException {
		   conn = new ConexionBBDD();
		   datosdonantes= conn.MostrarTablaDonantes();
		   tabla_donantes.setItems(datosdonantes);
		   
		   colum_num_donante.setCellValueFactory(new PropertyValueFactory <Donante,Integer>("num_donante"));
		   colum_nombre.setCellValueFactory(new PropertyValueFactory <Donante,String>("nombre"));
		   colum_apellido1.setCellValueFactory(new PropertyValueFactory <Donante,String>("apellido1"));
		   colum_apellido2.setCellValueFactory(new PropertyValueFactory <Donante,String>("apellido2"));
		   colum_ciclo.setCellValueFactory(new PropertyValueFactory <Donante,String>("ciclo"));
		   colum_DNI.setCellValueFactory(new PropertyValueFactory <Donante,String>("DNI"));
		   colum_fecha_nac.setCellValueFactory(new PropertyValueFactory <Donante,String>("fecha_nac"));
		   colum_pais_nac.setCellValueFactory(new PropertyValueFactory <Donante,String>("pais_nac"));
		   colum_direccion.setCellValueFactory(new PropertyValueFactory <Donante,String>("direccion"));
		   colum_poblacion.setCellValueFactory(new PropertyValueFactory <Donante,String>("poblacion"));
		   colum_cod_postal.setCellValueFactory(new PropertyValueFactory <Donante,Integer>("cod_postal"));
		   colum_tlfn1.setCellValueFactory(new PropertyValueFactory <Donante,Integer>("telefono1"));
		   colum_tlfn2.setCellValueFactory(new PropertyValueFactory <Donante,Integer>("telefono2"));
		   colum_correo.setCellValueFactory(new PropertyValueFactory <Donante,String>("correo_electronico"));
		   colum_sexo.setCellValueFactory(new PropertyValueFactory <Donante,Character>("sexo"));
		   
		   
		   
		   
		   ciclo.setValue("");
		   ciclo.setItems(posiblesciclos);
		  
		   edicion = false;
		   indiceedicion = 0;
		  
			
			
			
	   }
	 
	 public void GuardarDonante(ActionEvent event) throws SQLException {
		   
		   if(num_donante.getText().equals("")|| nombre.getText().equals("") || apellido1.getText().equals("") ||  apellido2.getText().equals("") || DNI.getText().equals("") || fecha_nac == null || pais_nac.getText().equals("") || direccion.getText().equals("") || poblacion.getText().equals("") || cod_postal.getText().equals("") || tlfn1.getText().equals("") || correo_electronico.getText().equals("") || sexo==null) {
				  Alert alert = new Alert (AlertType.INFORMATION);
				  alert.setTitle("Error en relleno de datos");
				  alert.setHeaderText("FALTAN CAMPOS POR RELLENAR:");
				  alert.setContentText("Por favor no dejes ningún campo sin rellenar(excepto TLFN2 si no se dispone)");
				  alert.showAndWait();
		   }else {
			   
			   if(edicion == true){

					// Hago la llamda al método que hace el update en la base de datos
					ConexionBBDD con = new ConexionBBDD();
					Character sexo;
					   
					 DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
					   String fecha_n = fecha_nac.getValue().format(isoFecha);
					   
					   //mes-dia-año
					   String mes=  fecha_n.substring(8, 10);
					   String dia= fecha_n.substring(5, 7);
					   String año= fecha_n.substring(0, 4);
					   
					   String fecha_na= mes+ "-" + dia + "-" + año;
		 			   
					   
					   
					   Integer num_donante=Integer.parseInt(this.num_donante.getText());
					   
					   String nombre=this.nombre.getText();
					   String apellido1= this.apellido1.getText();
					   String apellido2= this.apellido2.getText();
					   String ciclo=(String) this.ciclo.getValue();
					   String DNI= this.DNI.getText();
					  
					   String pais_nac = this.pais_nac.getText();
					   String direccion= this.direccion.getText();
					   String poblacion = this.poblacion.getText();
					 
					   Integer cod_postal=Integer.parseInt(this.cod_postal.getText());
					   Integer tlfn1=Integer.parseInt(this.tlfn1.getText());
					   Integer tlfn2_int;
					   
					   
					   
					   if(this.tlfn2.getText().equals("")) {
						   tlfn2_int=null;
					   }else {
					    tlfn2_int=Integer.parseInt(this.tlfn2.getText());
					   }
					   
					  
					   
					   
					   
					   
					   String correo_electronico= this.correo_electronico.getText();
					   
					   
					    
					  
					   
					 
					   
					   if (this.rbhombre.isSelected()==true) {
						   sexo='H';
						   
					   }else {
						   sexo='M';
					   }
					int res = con.EditarDonante(num_donante, nombre, apellido1, apellido2, ciclo, DNI, fecha_na, pais_nac, direccion, poblacion, cod_postal, tlfn1, tlfn2_int, correo_electronico, sexo);
					switch (res){

						case 0:
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("OK!");
							alert.setHeaderText("Modificación OK!");
							alert.setContentText("¡Donante modificado con éxito!");
							alert.showAndWait();

							// Actualizo los datos de la tabla
							datosdonantes = con.ObtenerDonante();
							tabla_donantes.setItems(datosdonantes);
							break;

						default:
								alert = new Alert(AlertType.ERROR);
								alert.setTitle("Error!");
								alert.setHeaderText("Modificación NOK!");
								alert.setContentText("¡Ha habido un problema al realizar la modificación!");
								alert.showAndWait();
								break;

							}




				}else {
		   
			   
			   DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
			   String fecha_n = fecha_nac.getValue().format(isoFecha);
			   
			   //mes-dia-año
			   String mes=  fecha_n.substring(8, 10);
			   String dia= fecha_n.substring(5, 7);
			   String año= fecha_n.substring(0, 4);
			   
			   String fecha_na= mes+ "-" + dia + "-" + año;
 			   
			   
			   
			   Integer num_donante=Integer.parseInt(this.num_donante.getText());
			   
			   String nombre=this.nombre.getText();
			   String apellido1= this.apellido1.getText();
			   String apellido2= this.apellido2.getText();
			   String ciclo=(String) this.ciclo.getValue();
			   String DNI= this.DNI.getText();
			  
			   String pais_nac = this.pais_nac.getText();
			   String direccion= this.direccion.getText();
			   String poblacion = this.poblacion.getText();
			 
			   Integer cod_postal=Integer.parseInt(this.cod_postal.getText());
			   Integer tlfn1=Integer.parseInt(this.tlfn1.getText());
			   Integer tlfn2_int;
			   
			   
			   
			   if(this.tlfn2.getText().equals("")) {
				   tlfn2_int=null;
			   }else {
			    tlfn2_int=Integer.parseInt(this.tlfn2.getText());
			   }
			   
			  
			   
			   
			   
			   
			   String correo_electronico= this.correo_electronico.getText();
			   
			   
			    
			   Character sexo;
			   
			 
			   
			   if (this.rbhombre.isSelected()==true) {
				   sexo='H';
				   
			   }else {
				   sexo='M';
			   }
			   
			   Donante DonanteNuevo= new Donante(num_donante, nombre, apellido1, apellido2, ciclo, DNI, fecha_na, pais_nac, direccion, poblacion, cod_postal, tlfn1, tlfn2_int, correo_electronico, sexo);
			   this.datosdonantes.add(DonanteNuevo);
			   this.tabla_donantes.setItems(this.datosdonantes);
			
				conn.NuevoDonante(num_donante, nombre, apellido1, apellido2, ciclo, DNI, fecha_na, pais_nac, direccion, poblacion, cod_postal, tlfn1, tlfn2_int, correo_electronico, sexo);
				conn.MostrarTablaDonantes();
		   }
		   }
	 
	 }
	 
	 public void reset() {
		   
		   this.num_donante.setText("");
		   this.nombre.setText("");
		   this.apellido1.setText("");
		   this.apellido2.setText("");
		   this.ciclo.setValue("");
		   this.DNI.setText("");
		   this.fecha_nac.setValue(null);
		   this.pais_nac.setText("");
		   this.direccion.setText("");
		   this.poblacion.setText("");
		   this.cod_postal.setText("");
		   this.tlfn1.setText("");
		   this.tlfn2.setText("");
		   this.correo_electronico.setText("");
		   this.sexo.selectToggle(null);
		   
		   edicion=false;
		   indiceedicion=0;
	 }
	
	
	 public void EliminarDonante() throws SQLException{
			int index = tabla_donantes.getSelectionModel().getSelectedIndex();
			if( index >= 0){

				Donante seleccionada = tabla_donantes.getSelectionModel().getSelectedItem();

				// Se abre un dialog box de confirmacion de eliminar
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("¡¡Confirmación!!");
				alert.setHeaderText("Por favor confirme el borrado");
				alert.setContentText("¿Esta seguro que desea borrar al Donante "+ seleccionada.getNombre() + " " +seleccionada.getApellido1() +" ?");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
				    // ... user chose OK

					// Llamar a un método que realice el DELETE en la base de datos
					ConexionBBDD con = new ConexionBBDD();
					int res = con.BorrarDonante(seleccionada.getNum_donante());
					switch(res){
						case 0:
							alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("OK!");
							alert.setHeaderText("Borrado OK!");
							alert.setContentText("¡Donante borrado con éxito!");
							alert.showAndWait();

							// Actualizo los datos de la tabla
							datosdonantes = con.ObtenerDonante();
							tabla_donantes.setItems(datosdonantes);
							break;

						default:
				
							break;
					}

					reset();
				}

			}else{

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error en selección de datos");
				alert.setContentText("NO HAY NINGUN DONANTE SELECCIONADO!");
				alert.showAndWait();

			}
		}
	 
	 public void EditarDonante(){


			int index = tabla_donantes.getSelectionModel().getSelectedIndex();


			if( index >= 0){

				// Activo la "funcionalidad" de editar para luego que el botón guardar sepa a qué PErsona estoy "editando"
				edicion = true;
				indiceedicion = index;


				Donante seleccionado = tabla_donantes.getSelectionModel().getSelectedItem();

			
				
				String seleccnum_don = (seleccionado.getNum_donante().toString());
				   num_donante.setText(seleccnum_don);
				   nombre.setText(seleccionado.getNombre());
				   apellido1.setText(seleccionado.getApellido1());;
				   apellido2.setText(seleccionado.getApellido2());
				   ciclo.setValue(seleccionado.getCiclo().toString());
				   DNI.setText(seleccionado.getDNI());
				  
				   pais_nac.setText(seleccionado.getPais_nac());
				   direccion.setText(seleccionado.getDireccion());
				   poblacion.setText(seleccionado.getPoblacion());
				 
				   cod_postal.setText(seleccionado.getCod_postal().toString());
				   
				   tlfn1.setText(String.valueOf(seleccionado.getTelefono1()));
				   
				   tlfn2.setText(String.valueOf(seleccionado.getTelefono2()));
				   
				   
				   
				   if(this.tlfn2.getText().equals("")) {
					   tlfn2=null;
				   }else {
				   
				   }

				   correo_electronico.setText(seleccionado.getCorreo_electronico());
				   
				   
				    
				   if(seleccionado.getSexo() == 'H')
						rbhombre.setSelected(true);
					else
						rbmujer.setSelected(true);
				   
				   
				   DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
				   LocalDate fecha_na = LocalDate.parse(seleccionado.getFecha_nac().substring(0, 10));
				   
				   
				   fecha_nac.setValue(fecha_na);
			}
		}
	 
	 public void imprimirCarnet() throws FileNotFoundException, DocumentException{

			ImprimeArchivo imprime = new ImprimeArchivo("CarnetDonante "+ nombre.getText() , "C:\\Users\\Jorge\\Desktop\\JAVIER DAW\\PROGRAMACIÓN\\DONANTES\\");
			
			
			int index = tabla_donantes.getSelectionModel().getSelectedIndex();
			if(index>=0) {
				

				Donante seleccionado = tabla_donantes.getSelectionModel().getSelectedItem();

			
				
				Integer seleccnum_don = (seleccionado.getNum_donante());
				String selecnombre= (seleccionado.getNombre());
				String selecapellido1=(seleccionado.getApellido1());;
				String selecapellido2=(seleccionado.getApellido2());
				String selecfecha=(seleccionado.getFecha_nac().substring(0, 10));
				String selecpaisna= (seleccionado.getPais_nac());
				Integer selectlfn= (seleccionado.getTelefono1());
				
				
			
			imprime.generarArchivoPDF(seleccnum_don, selecnombre, selecapellido1, selecapellido2, selecfecha, selecpaisna, selectlfn);
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Carnet creado con exito");
			alert.setHeaderText("El carnet de "+ seleccionado.getNombre() +" se ha creado");
			alert.setContentText("Carnet correctamente creado en la carpeta DONANTE");
			alert.showAndWait();
			
			}else {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("No has seleccionado ningun Donante para crear un Carnet");
				alert.setContentText("Haz click en la tabla para seleccionar un donante");
				alert.showAndWait();
				
			}
		}


	public void setStagePrincipal(Stage VentanaDonantes) {
		// TODO Auto-generated method stub
		this.VentanaDonantes = VentanaDonantes;
	}

	public void closeWindow(){
		this.VentanaDonantes.close();
	}

		
	   
	   
}
