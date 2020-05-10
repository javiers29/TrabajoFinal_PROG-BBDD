package Vista;

import java.sql.SQLException;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControlDonaciones {

	
	@FXML
	private Button buttonclose;
	
	@FXML
	private Button volvermenu;
	
	@FXML
	private Button guardar_donacion;
	
	
	@FXML
	private TextField num_donacion;
	
	@FXML
	private TextField cod_colecta;
	
	@FXML
	private TextField tipo;
	
	@FXML
	private TextField pulso;
	
	@FXML
	private TextField ta_sist;
	
	@FXML
	private TextField ta_diast;
	
	@FXML
	private TextField hb_cap;
	
	@FXML
	private TextField hb_ven;
	
	@FXML
	private TextField num_donante;
	
	@FXML
	private DatePicker fecha;
	
	 @FXML
	   private TableView<Donacion> tabla_donaciones;
	   
	   @FXML
	   private TableColumn <Donacion,Integer> colum_num_donacion;
	   @FXML
	   private TableColumn <Donacion,Integer> colum_cod_colecta;
	   @FXML
	   private TableColumn <Donacion,String> colum_tipo;
	   @FXML
	   private TableColumn <Donacion,Integer> colum_pulso;
	   @FXML
	   private TableColumn <Donacion,Integer> colum_ta_sist;
	   @FXML
	   private TableColumn <Donacion,Integer> colum_ta_diast;
	   @FXML
	   private TableColumn <Donacion,Integer> colum_hb_cap;
	   @FXML
	   private TableColumn <Donacion,Integer> colum_hb_ven;
	   @FXML
	   private TableColumn <Donacion,String> colum_fecha;
	
	

	private Main MenuPrincipal;
	
	private Stage VentanaDonaciones;
	ConexionBBDD conn;
	 private ObservableList <Donacion> datosdonacion= FXCollections.observableArrayList();

	
	
	public void initialize() throws SQLException {
		   conn = new ConexionBBDD();
		   
		   datosdonacion= conn.MostrarTablaDonaciones();
		   tabla_donaciones.setItems(datosdonacion);
		   
		   colum_num_donacion.setCellValueFactory(new PropertyValueFactory <Donacion,Integer>("num_donacion"));
		   colum_cod_colecta.setCellValueFactory(new PropertyValueFactory <Donacion,Integer>("cod_colecta"));
		   colum_tipo.setCellValueFactory(new PropertyValueFactory <Donacion,String>("tipo"));
		   colum_pulso.setCellValueFactory(new PropertyValueFactory <Donacion,Integer>("pulso"));
		   colum_ta_sist.setCellValueFactory(new PropertyValueFactory <Donacion,Integer>("ta_sist"));
		   colum_ta_diast.setCellValueFactory(new PropertyValueFactory <Donacion,Integer>("ta_diast"));
		   colum_hb_cap.setCellValueFactory(new PropertyValueFactory <Donacion,Integer>("hb_cap"));
		   colum_hb_ven.setCellValueFactory(new PropertyValueFactory <Donacion,Integer>("hb_ven"));
		   colum_fecha.setCellValueFactory(new PropertyValueFactory <Donacion,String>("fecha"));
		   
		  
		   
	   }
	
	
	public void setStagePrincipal(Stage VentanaDonaciones) {
		// TODO Auto-generated method stub
		this.VentanaDonaciones = VentanaDonaciones;
	}
	
	

	public void setMenuPrincipal(Main menuPrincipal) {
		MenuPrincipal = menuPrincipal;
	}



	public void closeWindow(){
		this.VentanaDonaciones.close();
	}
	
	 public void GuardarDonacion(ActionEvent event) {
		 
	 }

	 
	 public void VolverMenu(ActionEvent event) {
		 
	 }
}
