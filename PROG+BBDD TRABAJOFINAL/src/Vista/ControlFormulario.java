package Vista;


import Controlador.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ControlFormulario {

	 @FXML
	   private RadioButton P1;
	   @FXML
	   private RadioButton P1_2;
	   @FXML
	   private ToggleGroup UNO;
	   
	   @FXML
	   private RadioButton P2;
	   @FXML
	   private RadioButton P2_2;
	   @FXML
	   private ToggleGroup DOS;
	   
	   @FXML
	   private RadioButton P3;
	   @FXML
	   private RadioButton P3_2;
	   @FXML
	   private ToggleGroup TRES;
	   
	   @FXML
	   private RadioButton P4;
	   @FXML
	   private RadioButton P4_2;
	   @FXML
	   private ToggleGroup CUATRO;
	   
	   @FXML
	   private RadioButton P5;
	   @FXML
	   private RadioButton P5_2;
	   @FXML
	   private ToggleGroup CINCO;
	   
	   @FXML
	   private RadioButton P6;
	   @FXML
	   private RadioButton P6_2;
	   @FXML
	   private ToggleGroup SEIS;
	   
	   @FXML
	   private RadioButton P7;
	   @FXML
	   private RadioButton P7_2;
	   @FXML
	   private ToggleGroup SIETE;
	   
	   @FXML
	   private RadioButton P8;
	   @FXML
	   private RadioButton P8_2;
	   @FXML
	   private ToggleGroup OCHO;
	   
	   @FXML
	   private RadioButton P9;
	   @FXML
	   private RadioButton P9_2;
	   @FXML
	   private ToggleGroup NUEVE;
	   
	   @FXML
	   private RadioButton P10;
	   @FXML
	   private RadioButton P10_2;
	   @FXML
	   private ToggleGroup DIEZ;
	   
	   @FXML
	   private RadioButton P11;
	   @FXML
	   private RadioButton P11_2;
	   @FXML
	   private ToggleGroup ONCE;


		@FXML
		private RadioButton P12;
		@FXML
		private RadioButton P12_2;
		@FXML
		private ToggleGroup DOCE;
		
		@FXML
		private RadioButton P13;
		@FXML
		private RadioButton P13_2;
		@FXML
		private ToggleGroup TRECE;
		
		
		@FXML
		private RadioButton P14;
		@FXML
		private RadioButton P14_2;
		@FXML
		private ToggleGroup CATORCE;
		
		@FXML
		private RadioButton P15;
		@FXML
		private RadioButton P15_2;
		@FXML
		private ToggleGroup QUINCE;
		
		@FXML
		private RadioButton P16;
		@FXML
		private RadioButton P16_2;
		@FXML
		private ToggleGroup DIECISEIS;
		
		@FXML
		private RadioButton P17;
		@FXML
		private RadioButton P17_2;
		@FXML
		private ToggleGroup DIECISIETE;
		
		
		@FXML
		private RadioButton P18;
		@FXML
		private RadioButton P18_2;
		@FXML
		private ToggleGroup DIECIOCHO;
		
		@FXML
		private RadioButton P19;
		@FXML
		private RadioButton P19_2;
		@FXML
		private ToggleGroup DIECINUEVE;
		
		
		@FXML
		private RadioButton P20;
		@FXML
		private RadioButton P20_2;
		@FXML
		private ToggleGroup VEINTE;
		
		@FXML
		private RadioButton P21;
		@FXML
		private RadioButton P21_2;
		@FXML
		private ToggleGroup VEINTIUNO;
		
		
		@FXML
		private RadioButton P22;
		@FXML
		private RadioButton P22_2;
		@FXML
		private ToggleGroup VEINTIDOS;
		
		@FXML
		private RadioButton P23;
		@FXML
		private RadioButton P23_2;
		@FXML
		private ToggleGroup VEINTITRES;
		
		@FXML
		private RadioButton P24;
		@FXML
		private RadioButton P24_2;
		@FXML
		private ToggleGroup VEINTICUATRO;
		
		@FXML
		private RadioButton P25;
		@FXML
		private RadioButton P25_2;
		@FXML
		private ToggleGroup VEINTICINCO;
		
		@FXML
		private RadioButton P26;
		@FXML
		private RadioButton P26_2;
		@FXML
		private ToggleGroup VEINTISEIS;
		
		@FXML
		private RadioButton P27;
		@FXML
		private RadioButton P27_2;
		@FXML
		private ToggleGroup VEINTISIETE;
		
		@FXML
		private RadioButton P28;
		@FXML
		private RadioButton P28_2;
		@FXML
		private ToggleGroup VEINTIOCHO;
		
		@FXML
		private RadioButton P29;
		@FXML
		private RadioButton P29_2;
		@FXML
		private ToggleGroup VEINTINUEVE;
		
		@FXML
		private RadioButton P30;
		@FXML
		private RadioButton P30_2;
		@FXML
		private ToggleGroup TREINTA;
		
		@FXML
		private RadioButton P31;
		@FXML
		private RadioButton P31_2;
		@FXML
		private ToggleGroup TREINTAYUNO;
		
		@FXML
		private RadioButton P32;
		@FXML
		private RadioButton P32_2;
		@FXML
		private ToggleGroup TREINTAYDOS;
		
		
		@FXML
		private RadioButton pex1;
		@FXML
		private RadioButton pex1_2;
		@FXML
		private ToggleGroup PEX1	;
		
		
		@FXML
		private RadioButton pex2;
		@FXML
		private RadioButton pex2_2;
		@FXML
		private ToggleGroup PEX2;
		
		
		@FXML
		private RadioButton pex3;
		@FXML
		private RadioButton pex3_2;
		@FXML
		private ToggleGroup PEX3;
		
		
		@FXML
		private TextField cod_formulario;
		
		@FXML
		private TextField fecha_formulario;
		
		@FXML
		private TextField fecha_exclusion;
		
		@FXML
		private TextField num_donante;
		
		@FXML
		private RadioButton rb_apto;
		@FXML
		private RadioButton rb_excluyente;
		@FXML
		private ToggleGroup ESTADO;
		
		
		@FXML
		private Button volverMenu;
		@FXML
		private Button guardarFormulario;
		
		private Stage VentanaFormulario;
		
		
		
		private  Main MenuPrincipal;
		
		
		


		public void setStagePrincipal(Stage VentanaFormulario) {
			// TODO Auto-generated method stub
			this.VentanaFormulario = VentanaFormulario;
		}

		public void closeWindow(){
			this.VentanaFormulario.close();
		}

		
		
		public void GuardarFormulario() {
			this.MenuPrincipal.mostrarVentanaDonaciones();
			
			
			
		 }

		public void setMenuPrincipal(Main menuPrincipal) {
			MenuPrincipal = menuPrincipal;
		}
		
		
		
		
}




