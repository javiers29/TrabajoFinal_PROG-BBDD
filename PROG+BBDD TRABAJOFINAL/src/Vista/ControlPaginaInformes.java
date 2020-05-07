package Vista;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControlPaginaInformes {


	@FXML
	private Button btDONANTES;
	
	@FXML
	private Button btDONACIONES;
	
	@FXML
	private Button btFORMULARIOS;
	
	@FXML
	private Button volverMenu;
	
	private Stage VentanaInformes;
	
	
	
	private  Main MenuPrincipal;
	
	
	


	public void setStagePrincipal(Stage VentanaInformes) {
		// TODO Auto-generated method stub
		this.VentanaInformes = VentanaInformes;
	}

	public void closeWindow(){
		this.VentanaInformes.close();
	}

}
