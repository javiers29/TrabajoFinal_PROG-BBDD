package Vista;


import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donante;
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
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
		private DatePicker fecha_formulario;
		
		@FXML
		private DatePicker fecha_exclusion;
		
		@FXML
		private TextField num_donante;
		 
		
		
		
		
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

		
		
		
		public void GuardarFormulario() throws SQLException {
			
			
			
				String fecha=this.fecha_exclusion.getValue().toString();
				System.out.println(fecha);
		
			String ESTADO="APTO";
			 Integer cod_formulario=Integer.parseInt(this.cod_formulario.getText().toString());
			String UNO;
			if (this.P1.isSelected()==true) {
				   UNO="SI";
				   
			   }else {
				   UNO="NO";
				   ESTADO="EXCL_TEMP";
					
			   }
			
			String DOS;
			if (this.P2.isSelected()==true) {
				   DOS="SI";
				   
			   }else {
				   DOS="NO";
			   }
			String TRES;
			if (this.P3.isSelected()==true) {
				   TRES="SI";
				   
			   }else {
				   TRES="NO";
				   ESTADO="EXCL_TEMP";
					
			   }
			String CUATRO;
			if (this.P4.isSelected()==true) {
				   CUATRO="SI";
				   
			   }else {
				   CUATRO="NO";
			   }
			String CINCO;
			if (this.P5.isSelected()==true) {
				   CINCO="SI";
				   Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("!ATENCIÓN!");
					alert.setHeaderText("Al contestar en la pregunta nº5 que ha realizado una donacion en los últimos 12 meses como 'SI' es necesario que responda a la siguiente cuestión");
					alert.setContentText("¿Han transcurrido más de dos meses desde su última donación?");

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK){
						
					}else {
						
						ESTADO="EXCL_TEMP";
						
					}
				   
			   }else {
				   CINCO="NO";
			   }
			String SEIS;
			if (this.P6.isSelected()==true) {
				   SEIS="SI";
				   
			   }else {
				   SEIS="NO";
			   }
			String SIETE;
			if (this.P7.isSelected()==true) {
				   SIETE="SI";
				   
			   }else {
				   SIETE="NO";
			   }
			String OCHO;
			if (this.P8.isSelected()==true) {
				   OCHO="SI";
				   
			   }else {
				   OCHO="NO";
			   }
			String NUEVE;
			if (this.P9.isSelected()==true) {
				   NUEVE="SI";
				   
			   }else {
				   NUEVE="NO";
			   }
			String DIEZ;
			if (this.P10.isSelected()==true) {
				   DIEZ="SI";
				   
			   }else {
				   DIEZ="NO";
			   }
			String ONCE;
			if (this.P11.isSelected()==true) {
				   ONCE="SI";
				   
			   }else {
				   ONCE="NO";
			   }
			String DOCE;
			if (this.P12.isSelected()==true) {
				   DOCE="SI";
				   ESTADO="EXCL_TEMP";
					
			   }else {
				   DOCE="NO";
			   }
			String TRECE;
			if (this.P13.isSelected()==true) {
				   TRECE="SI";
				   
			   }else {
				   TRECE="NO";
			   }
			String CATORCE;
			if (this.P14.isSelected()==true) {
				   CATORCE="SI";
				   ESTADO="EXCL_TEMP";
					
			   }else {
				   CATORCE="NO";
			   }
			String QUINCE;
			if (this.P15.isSelected()==true) {
				   QUINCE="SI";
				   
			   }else {
				   QUINCE="NO";
			   }
			String DIECISEIS;
			if (this.P16.isSelected()==true) {
				   DIECISEIS="SI";
				   ESTADO="EXCL_TEMP";
					
			   }else {
				   DIECISEIS="NO";
			   }
			String DIECISIETE;
			if (this.P17.isSelected()==true) {
				   DIECISIETE="SI";
				   ESTADO="EXCL_TEMP";
					
			   }else {
				   DIECISIETE="NO";
			   }
			String DIECIOCHO;
			if (this.P18.isSelected()==true) {
				   DIECIOCHO="SI";
				   
			   }else {
				   DIECIOCHO="NO";
			   }
			String DIECINUEVE;
			if (this.P19.isSelected()==true) {
				   DIECINUEVE="SI";
				   
			   }else {
				   DIECINUEVE="NO";
			   }
			String VEINTE;
			if (this.P20.isSelected()==true) {
				   VEINTE="SI";
				   
			   }else {
				   VEINTE="NO";
			   }
			String VEINTIUNO;
			if (this.P21.isSelected()==true) {
				   VEINTIUNO="SI";
				   
			   }else {
				   VEINTIUNO="NO";
			   }
			String VEINTIDOS;
			if (this.P22.isSelected()==true) {
				VEINTIDOS="SI";
				   
			   }else {
				   VEINTIDOS="NO";
			   }
			String VEINTITRES;
			if (this.P23.isSelected()==true) {
				   VEINTITRES="SI";
				   
			   }else {
				   VEINTITRES="NO";
			   }
			String VEINTICUATRO;
			if (this.P24.isSelected()==true) {
				  VEINTICUATRO="SI";
				   
			   }else {
				   VEINTICUATRO="NO";
			   }
			String VEINTICINCO;
			if (this.P25.isSelected()==true) {
				   VEINTICINCO="SI";
				   
			   }else {
				   VEINTICINCO="NO";
			   }
			String VEINTISEIS;
			if (this.P26.isSelected()==true) {
				   VEINTISEIS="SI";
				   
			   }else {
				   VEINTISEIS="NO";
			   }
			String VEINTISIETE;
			if (this.P27.isSelected()==true) {
				VEINTISIETE="SI";
				   
			   }else {
				VEINTISIETE="NO";
			   }
			String VEINTIOCHO;
			if (this.P28.isSelected()==true) {
				   VEINTIOCHO="SI";
				   
			   }else {
				   VEINTIOCHO="NO";
			   }
			String VEINTINUEVE;
			if (this.P29.isSelected()==true) {
				   VEINTINUEVE="SI";
				   
			   }else {
				   VEINTINUEVE="NO";
			   }
			String TREINTA;
			if (this.P30.isSelected()==true) {
				   TREINTA="SI";
				   
			   }else {
				   TREINTA="NO";
			   }
			String TREINTAYUNO;
			if (this.P31.isSelected()==true) {
				   TREINTAYUNO="SI";
				   
			   }else {
				   TREINTAYUNO="NO";
			   }
			String TREINTAYDOS;
			if (this.P32.isSelected()==true) {
				   TREINTAYDOS="SI";
				   
			   }else {
				   TREINTAYDOS="NO";
			   }
			
			
			String PEX1;
			if (this.pex1.isSelected()==true) {
				   PEX1="SI";
				   ESTADO="EXCLUYENTE";
			   }else {
				   PEX1="NO";
			   }
			String PEX2;
			if (this.pex1.isSelected()==true) {
				   PEX2="SI";
				   ESTADO="EXCLUYENTE";
			   }else {
				   PEX2="NO";
			   }
			String PEX3;
			if (this.pex1.isSelected()==true) {
				   PEX3="SI";
				   ESTADO="EXCLUYENTE";
			   }else {
				   PEX3="NO";
			   }
			
			DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
			   String fecha_form = fecha_formulario.getValue().format(isoFecha);
			   
			   //mes-dia-año
			   String mes=  fecha_form.substring(8, 10);
			   String dia= fecha_form.substring(5, 7);
			   String año= fecha_form.substring(0, 4);
			   
			   String fecha_formu= mes+ "-" + dia + "-" + año;
			   
			   
			   String fecha_exc = fecha_exclusion.getValue().format(isoFecha);
			   
			   //mes-dia-año
			   String mesex=  fecha_exc.substring(8, 10);
			   String diaex= fecha_exc.substring(5, 7);
			   String añoex= fecha_exc.substring(0, 4);
			   
			   String fecha_excl= mesex+ "-" + diaex + "-" + añoex;
			
			   
			   
				
			
				Integer num_donan=Integer.parseInt(num_donante.getText().toString());
				ConexionBBDD con = new ConexionBBDD();
				con.NuevoFormulario(cod_formulario, UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, ONCE, DOCE, TRECE, CATORCE, QUINCE, DIECISEIS, DIECISIETE, DIECIOCHO, DIECINUEVE, VEINTE, VEINTIUNO, VEINTIDOS, VEINTITRES, VEINTICUATRO, VEINTICINCO, VEINTISEIS, VEINTISIETE, VEINTIOCHO, VEINTINUEVE, TREINTA, TREINTAYUNO, TREINTAYDOS, PEX1, PEX2, PEX3, fecha_formu, fecha_excl, ESTADO,num_donan);
					if(ESTADO.equals("APTO")) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("APTO");
						alert.setHeaderText("Su estado para la donación es APTO");
						alert.setContentText("");
						alert.showAndWait();
					}else {
						if(ESTADO.equals("EXCL_TEMP")) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("EXCLUYENTE TEMPORAL");
							alert.setHeaderText("Su estado para la donación es EXCLUYENTE TEMPORAL");
							alert.setContentText("Lo sentimos, pero no puede realizar ninguna donación de manera temporal");
							alert.showAndWait();
						}else {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("EXCLUYENTE");
							alert.setHeaderText("Su estado para la donación es EXCLUYENTE");
							alert.setContentText("Lo sentimos, pero no puede realizar ninguna donación");
							alert.showAndWait();
						}
					}
			
			this.VentanaFormulario.close();
			this.MenuPrincipal.mostrarVentanaDonaciones();
			
			
			
		 }

		public void setMenuPrincipal(Main menuPrincipal) {
			MenuPrincipal = menuPrincipal;
		}
		
		
		
		
		
		
}




