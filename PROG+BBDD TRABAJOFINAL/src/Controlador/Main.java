package Controlador;


import java.io.IOException;

import Vista.ControlMenuPrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("AplicacionDonantes");

			 // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../Vista/MenuPrincipal.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
           } catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	//Cargamos la ventana principal del proyecto
	public void mostrarMenuPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader (Main.class.getResource("../Vista/MenuPrincipal.fxml"));
			rootLayout=(AnchorPane) loader.load();
			Scene scene = new Scene (rootLayout);
			primaryStage.setTitle ("Aplicación de Donantes y Donaciones");
			primaryStage.setScene(scene);
			
			//Añadimos las llamadas del main al controlador y del controlador al main
			ControlMenuPrincipal controller = loader.getController();
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
