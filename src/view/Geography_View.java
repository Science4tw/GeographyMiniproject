package view;

import controller.Geography_Controller;
import exceptions.EmptyFieldException;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Country;
import model.Geography_Model;

// 0
public class Geography_View extends BorderPane {

	// 0 (abklären ob das so machbar ist)
	private Geography_Controller controller;

	// 0 View muss das Model und die Stage kennen
	private Stage stage;
	private Geography_Model model;

	// 1
	// Die Behälter um die CRUD Funktionalitäten zu implementieren + SEARCH
	private CreatePane createPane;
	private DeletePane deletePane;
	private ReadPane readPane;
	private UpdatePane updatePane;
	private SearchPane searchPane;

	// 1 TABPane um die Tabs zu organisieren
	private TabPane centerPane;

	// 1 CREATE, DELETE, READ, UPDATE TABs + SEARCH
	private Tab createTab;
	private Tab deleteTab;
	private Tab readTab;
	private Tab updateTab;
	private Tab searchTab;
	
	
	// Aktueller Status
	private Label lblStatus;

	// 0 Konstruktor
	public Geography_View(Stage stage, Geography_Model model) {
		this.stage = stage;
		this.model = model;

		// 1 TabPane for CREATE, READ, UPDATE, DELETE, SEARCH
		this.centerPane = new TabPane();
		this.centerPane.getTabs().addAll(createCreateTab(), createDeleteTab(), createReadTab(), createUpdateTab(),
				createSearchTab());
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
		this.createTab.setText("CREATE Object");
		this.createTab.setContent(this.createPane);
		return this.createTab;

	}

	// 1 DELTE
	// DeletePane
	public Tab createDeleteTab() {
		this.deletePane = new DeletePane(controller);
		this.deleteTab = new Tab();
		this.deleteTab.setClosable(false);
		this.deleteTab.setText("DELETE Object");
//		this.deleteTab.setContent(this.createPane);
		return this.deleteTab;

	}

	// 1 Read
	// ReadPane
	public Tab createReadTab() {
		this.readPane = new ReadPane(controller);
		this.readTab = new Tab();
		this.readTab.setClosable(false);
		this.readTab.setText("READ Object");
//		this.readTab.setContent(this.createPane);		
		return this.readTab;
	}

	// 1 UPDATE
	// UpdatePane
	public Tab createUpdateTab() {
		this.updatePane = new UpdatePane(controller);
		this.updateTab = new Tab();
		this.updateTab.setClosable(false);
		this.updateTab.setText("UPDATE Object");
//		this.updateTab.setContent(this.createPane);		
		return this.updateTab;
	}

	// 1 SEARCH
	// SearchPane
	public Tab createSearchTab() {
		this.searchPane = new SearchPane(controller);
		this.searchTab = new Tab();
		this.searchTab.setClosable(false);
		this.searchTab.setText("SEARCH Object");
//		this.updateTab.setContent(this.createPane);		
		return this.searchTab;
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