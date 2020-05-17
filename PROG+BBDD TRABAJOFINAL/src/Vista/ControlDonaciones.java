package Vista;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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
	private ComboBox tipo;
	
	 private ObservableList <String> posiblestipos= FXCollections.observableArrayList("SANGRE","AFÉRESIS");
	 
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
	private DatePicker fecha;
	
	@FXML
	private ComboBox grupo_sang;
	
	 private ObservableList <String> posiblesgrupos= FXCollections.observableArrayList("AB+","AB-", "A+", "A-", "B+", "B-", "0+","O-");
	 
	 
	 @FXML
	 ChoiceBox<Integer> num_donante;
	 ObservableList<Integer> num_donantes = FXCollections.observableArrayList();
	
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
	
	public Stage VentanaDonaciones;
	
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
		   
		   num_donantes =conn.SelectNumDonantes();
		   num_donante.setItems(num_donantes);
		   
		   grupo_sang.setItems(posiblesgrupos);
		   tipo.setItems(posiblestipos);
		   
		   
	   }
	
	
	public void setStagePrincipal(Stage VentanaDonaciones) {
		// TODO Auto-generated method stub
		this.VentanaDonaciones = VentanaDonaciones;
	}
	
	

	public void setMenuPrincipal(Main menuPrincipal) {
		MenuPrincipal = menuPrincipal;
	}


	
	 public void GuardarDonacion(ActionEvent event) {
		 
		Integer num_don=Integer.parseInt(this.num_donacion.getText());
		Integer cod_col=Integer.parseInt(this.cod_colecta.getText().toString());
		String tipo=(String) this.tipo.getValue().toString();
		Integer pulso=Integer.parseInt(this.pulso.getText().toString());
		Integer ta_sist=Integer.parseInt(this.ta_sist.getText().toString());
		Integer ta_diast=Integer.parseInt(this.ta_diast.getText().toString());
		Integer hb_cap=Integer.parseInt(this.hb_cap.getText().toString());
		Integer hb_ven=Integer.parseInt(this.hb_ven.getText().toString());
		
		 DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
		   String fecha_d = fecha.getValue().format(isoFecha);
		   
		   //mes-dia-año
		   String mes=  fecha_d.substring(8, 10);
		   String dia= fecha_d.substring(5, 7);
		   String año= fecha_d.substring(0, 4);
		   
		   String fecha_dona= mes+ "-" + dia + "-" + año;
		
		String grupo_sang=(String) this.grupo_sang.getValue().toString();
		Integer num_donan=Integer.parseInt(num_donante.getValue().toString());
		
		 conn = new ConexionBBDD();
		 //Integer num_don,Integer cod_col,String tipo,Integer pulso,Integer ta_sist,Integer ta_diast,Integer hb_cap, Integer hb_ven,String fecha,String grupo_sang,String num_donante
		 conn.NuevaDonacion(num_don, cod_col, tipo, pulso, ta_sist, ta_diast, hb_cap, hb_ven, fecha_dona, grupo_sang, num_donan);
		
	 }

	 
	 public void VolverMenu(ActionEvent event) {
		 this.VentanaDonaciones.close();
	 }
}
