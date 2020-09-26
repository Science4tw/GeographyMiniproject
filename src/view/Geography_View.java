package view;

import controller.Geography_Controller;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CountryCollection;

// 0
public class Geography_View extends BorderPane {
	// 0 (abklären ob das so machbar ist)
	private Geography_Controller controller;

	// 0 View muss das Model und die Stage kennen
	private Stage stage;
	private CountryCollection model;

	// 1
	// Die Behälter um die CRUD Funktionalitäten zu implementieren
	private CreatePane createPane;
	private DeletePane deletePane;
	private ReadPane readPane;
	private UpdatePane updatePane;

	// 1 TABPane um die Tabs zu organisieren
	private TabPane centerPane;
	
	// CREATE
	private Tab createTab;

	// 0 Konstruktor
	public Geography_View(Stage stage, CountryCollection model) {
		this.stage = stage;
		this.model = model;
		

		// 1
		// CreatePane
		this.createPane = new CreatePane(controller);
		this.createTab = new Tab();
		this.createTab.setClosable(false);
		this.createTab.setText("Create Country");
		this.createTab.setContent(this.createPane);

		// 1 TabPane
		this.centerPane = new TabPane();
		this.centerPane.getTabs().addAll(this.createTab);
		this.setCenter(this.centerPane);
		
		// 0 Create the scene using our layout; then display it
		Scene scene = new Scene(this);
//		scene.getStylesheets().add(getClass().getResource("SummaryCSS.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Geography Miniproject");
		stage.setResizable(true);
	}

	// 0
	public void start() {
		stage.show();

	}
}
