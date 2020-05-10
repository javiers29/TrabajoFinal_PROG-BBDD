package Controlador;


import java.io.IOException;

import Vista.ControlDonaciones;
import Vista.ControlDonantes;
import Vista.ControlFormulario;
import Vista.ControlMenuPrincipal;
import Vista.ControlPaginaInformes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	
	private AnchorPane rootPane;
	private Stage MenuPrincipal;
	
	
	

	@Override
	public void start(Stage MenuPrincipal) {
		
			this.MenuPrincipal = MenuPrincipal;
			mostrarMenuPrincipal();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	//Cargamos la ventana principal del proyecto
	public void mostrarMenuPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader (Main.class.getResource("../Vista/MenuPrincipal.fxml"));
			rootPane=(AnchorPane) loader.load();
			Scene scene = new Scene (rootPane);
			MenuPrincipal.setTitle ("Aplicación de Donantes y Donaciones");
			MenuPrincipal.setScene(scene);
			
			//Añadimos las llamadas del main al controlador y del controlador al main
			ControlMenuPrincipal controller = loader.getController();
			controller.setMenuPrincipal(this);
			
			MenuPrincipal.show();
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	
	public void mostrarVentanaDonaciones() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/PaginaDonaciones.fxml"));
            SplitPane ventanaDonaciones = (SplitPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage PaginaDonaciones = new Stage();
            PaginaDonaciones.setTitle("Ventana Donaciones");
            /* Le decimos a la ventana quién es la ventana original */
            PaginaDonaciones.initOwner(MenuPrincipal);
            Scene scene = new Scene(ventanaDonaciones);
            PaginaDonaciones.setScene(scene);

            ControlDonaciones controller3 = loader.getController();
            controller3.setStagePrincipal(PaginaDonaciones);
            controller3.setMenuPrincipal(this);

            PaginaDonaciones.show();

        } catch (Exception e) {
        	System.out.println(e);
        }
    }
	
	
	public void mostrarVentanaFormulario() {
		 try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/Formulario.fxml"));
	            AnchorPane ventanaFormulario = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage PaginaFormulario = new Stage();
	            PaginaFormulario.setTitle("Ventana Donaciones");
	            /* Le decimos a la ventana quién es la ventana original */
	            PaginaFormulario.initOwner(MenuPrincipal);
	            Scene scene = new Scene(ventanaFormulario);
	            PaginaFormulario.setScene(scene);

	            ControlFormulario controller2 = loader.getController();
	            controller2.setStagePrincipal(PaginaFormulario);
	            controller2.setMenuPrincipal(this);

	            PaginaFormulario.show();

	        } catch (Exception e) {
	        	System.out.println(e);
	        }
	}
	
	
	
	public void mostrarVentanaDonantes() {
		 try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/PaginaDonantes.fxml"));
	            SplitPane ventanaDonantes = (SplitPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage PaginaDonantes = new Stage();
	            PaginaDonantes.setTitle("Ventana Donantes");
	            /* Le decimos a la ventana quién es la ventana original */
	            PaginaDonantes.initOwner(MenuPrincipal);
	            Scene scene = new Scene(ventanaDonantes);
	            PaginaDonantes.setScene(scene);

	            ControlDonantes controller4 = loader.getController();
	            controller4.setStagePrincipal(PaginaDonantes);

	            PaginaDonantes.show();

	        } catch (Exception e) {
	        	System.out.println(e);
	        }
	}
	
	
	
	
	public void mostrarVentanaInformes() {
		 try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/PaginaInformes.fxml"));
	            AnchorPane ventanaInformes = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage PaginaInformes = new Stage();
	            PaginaInformes.setTitle("Ventana Informes");
	            /* Le decimos a la ventana quién es la ventana original */
	            PaginaInformes.initOwner(MenuPrincipal);
	            Scene scene = new Scene(ventanaInformes);
	            PaginaInformes.setScene(scene);

	            ControlPaginaInformes controller5 = loader.getController();
	            controller5.setStagePrincipal(PaginaInformes);

	            PaginaInformes.show();

	        } catch (Exception e) {
	        	System.out.println(e);
	        }
	}
	
}
