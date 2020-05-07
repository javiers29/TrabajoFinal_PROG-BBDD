package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class ControlMenuPrincipal implements Initializable {

	private  Main MenuPrincipal;
	
	
	 @FXML
	   private Button btndonante;
	 
	 @FXML
	   private Button btndonaciones;
	 
	 @FXML
	   private Button btninformes;
	
	 
	 
	public void setMenuPrincipal(Main menuPrincipal) {
		MenuPrincipal = menuPrincipal;
	}









	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    public void VentanaFormulario() {
       	this.MenuPrincipal.mostrarVentanaFormulario();
    }
	
	@FXML
    public void VentanaDonante() {
       	this.MenuPrincipal.mostrarVentanaDonantes();
    }
	
	@FXML
    public void VentanaInformes() {
       	this.MenuPrincipal.mostrarVentanaInformes();
    }
	
	

}
