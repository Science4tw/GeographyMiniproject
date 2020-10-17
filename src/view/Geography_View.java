package view;

import controller.Geography_Controller;
import exceptions.EmptyFieldException;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Country;
import model.GovRegCollection;

// 0
public class Geography_View extends BorderPane {

	// 0 (abklären ob das so machbar ist)
	private Geography_Controller controller;

	// 0 View muss das Model und die Stage kennen
	private Stage stage;
	private GovRegCollection model;

	// 1
	// Die Behälter um die CRUD Funktionalitäten zu implementieren + SEARCH
	private CreatePane createPane;
	private ManagePane managePane;

	// 1 TABPane um die Tabs zu organisieren
	private TabPane centerPane;

	// 1 CREATE, DELETE, READ, UPDATE TABs + SEARCH
	private Tab createTab;
	private Tab manageTab;
	
	// Aktueller Status Label
	private Label lblStatus;
	

	// 0 Konstruktor
	//Kontroller der View mitgeben
	public Geography_View(Stage stage, GovRegCollection model) {
		this.stage = stage;
		this.model = model;

		// 1 TabPane for CREATE, READ, UPDATE, DELETE, SEARCH
		this.centerPane = new TabPane();
		this.centerPane.getTabs().addAll(createCreateTab(), createManageTab());
		this.setCenter(this.centerPane);

		
		// Aktueller Status
		this.lblStatus = new Label("Everything okay");
		this.setBottom(this.lblStatus);
		
		// 0 Create the scene using our layout; then display it
		Scene scene = new Scene(this);
		scene.getStylesheets().add(getClass().getResource("view.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Geography Miniproject");
		stage.setResizable(true);
	}

	// 0
	public void start() {
		stage.show();

	}

	// 1 CREATE
	// CreatePane
	public Tab createCreateTab() {
		this.createPane = new CreatePane(controller);
		this.createTab = new Tab();
		this.createTab.setClosable(false);
		this.createTab.setText("Create Country");
		this.createTab.setContent(this.createPane);
		return this.createTab;

	}

	// 1 DELTE

	// 1 Read


	// 1 UPDATE

	// 1 SEARCH
	// SearchPane
	public Tab createManageTab() {
		this.managePane = new ManagePane(controller);
		this.manageTab = new Tab();
		this.manageTab.setClosable(false);
		this.manageTab.setText("Manage Objects");
		this.manageTab.setContent(this.managePane);		
		return this.manageTab;
	}
	

	/**
	 * CREATE
	 * GETTER um das vom User konfigurierte Objekt
	 * aus der CreatePane zu holen
	 * @throws Exception 
	 */
	public Country getCountry() throws Exception{
		return this.createPane.getObject();
	}
			
	
	/**
	 * Methode um den Status zu aktualsieren
	 */
	public void updateStatus(String string) {
		this.createPane.reset();
		this.lblStatus.setText(string);
	}

	

	


}