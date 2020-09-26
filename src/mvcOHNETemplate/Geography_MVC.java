package mvcOHNETemplate;

import controller.Geography_Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Geography_Model;
import view.Geography_View;

//Stufe 0 = Basis MVC Struktur
//Stufe 1 = Die View
//Stufe 1.1 Kontrollelemente - Controls used for data processing
//Stufe 2 = Geschäftslogik
//Stufe 2.1 Instanzvariabelen
//Stufe 2.2 Methoden des Models
//Stufe 3 = EventHandling und die dazu erforderlichen Methoden
//Stufe 3.1 Kontrollelemente unter Action setzen und Data Binding vornehmen
//Stufe 3.2 Methoden um die Events im Model und View zu bearbeiten

// 0
public class Geography_MVC extends Application {
	
	// 0
	private Geography_Model model; // Model
	private Geography_View view; // View
	private Geography_Controller controller; // controller

	// 0
	public static void main(String[] args) {
		launch(args);

	}

	// 0
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Initialize the three MVC components
		this.model = new Geography_Model();
		this.view = new Geography_View(primaryStage, model);
		this.controller = new Geography_Controller(model, view);
		
		// Zeigt GUI an sobald alles initialisiert ist
		view.start();
		
	}

}
