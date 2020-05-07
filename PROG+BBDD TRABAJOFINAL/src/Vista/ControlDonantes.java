package Vista;

import Controlador.Main;
import Modelo.Donante;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	private Button btEditar;
	
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
	
	
	


	public void setStagePrincipal(Stage VentanaDonantes) {
		// TODO Auto-generated method stub
		this.VentanaDonantes = VentanaDonantes;
	}

	public void closeWindow(){
		this.VentanaDonantes.close();
	}

		
	   
	   
}
