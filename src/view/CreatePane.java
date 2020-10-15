package view;

import controller.Geography_Controller;
import exceptions.EmptyFieldException;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Country;
import model.DevelopmentStatus;
import model.FormOfGovernment;
import model.Nation;
import model.State;

/*
 * Rote Ränder für Pflichtfelder und Exceptions für Textfelder(nur Zahlen erlaubt)
 */

public class CreatePane extends GridPane {

	// Kontrollelemente zum hinzufuegen der Objekte
	
	// Nation
	private ChoiceBox<Nation> nationChoiceBox; 
	private Label lblNation;
	
	// State
	private ChoiceBox<State> stateChoiceBox;
	private Label lblState;

	// FormOfGovernment
	private Label lblFormGovernment;
	private RadioButton democracyButton, dictatorshipButton, monarchyButton;
	private HBox hBoxGov;
	
	// DevelopmentStatus
	private Label lblDevelopmentStatus;
	private RadioButton industrialNationButton, emergingNationButton, thirdworldNationButton;
	private HBox hBoxDev;
	
	// Area
	private Label lblArea;
	private TextField txfArea;

	// Population
	private Label lblPopulation;
	private TextField txfPopulation;

	// Button zum Hinzufuegen
	private Button createButton;


	/**
	 * Konstruktor um alle Kontrollelemente zu instanzieren und Behälter hinzuzufügen
	 */
	public CreatePane(Geography_Controller controller) {
		// ChoiceBox zur Auswahl der Nation
		this.lblNation = new Label("Nation:");
		this.add(this.lblNation, 1, 1);
		this.nationChoiceBox = new ChoiceBox<Nation>();
		Nation[] nations = Nation.values(); // Liest die Werte des Enums "Nation" aus
		for (Nation nation : nations)
			this.nationChoiceBox.getItems().add(nation);
		this.add(this.nationChoiceBox, 2, 1);

		// ChoiceBox zur Auswahl von State
		this.lblState = new Label("State:");
		this.add(this.lblState, 1, 2);
		this.stateChoiceBox = new ChoiceBox<State>();
		State[] states = State.values(); // Liest die Werte des Enums "State" aus
		for (State state : states)
			this.stateChoiceBox.getItems().add(state);
		this.add(this.stateChoiceBox, 2, 2);

		// Form of Government Label + RadioButtons hinzufügen	
		this.lblFormGovernment = new Label("Form of Government");
		this.add(this.lblFormGovernment, 1, 3);
	
		this.democracyButton = new RadioButton("Demogracy");
		this.dictatorshipButton = new RadioButton("Dictatorship");
		this.monarchyButton = new RadioButton("Monarchy");
		this.democracyButton.setSelected(true);
		ToggleGroup tgGov = new ToggleGroup();//ToggleGroup für RadioButtons
		this.democracyButton.setToggleGroup(tgGov);
		this.dictatorshipButton.setToggleGroup(tgGov);
		this.monarchyButton.setToggleGroup(tgGov);
		this.hBoxGov = new HBox(); //RadioButtons in HBox
		this.hBoxGov.getChildren().addAll(this.democracyButton, this.dictatorshipButton, this.monarchyButton);
		this.add(this.hBoxGov, 2, 3);
	

		// Developement Status Label + RadioButtons hinzufügen
		this.lblDevelopmentStatus = new Label("Developement Status");
		this.add(this.lblDevelopmentStatus, 1, 4);
		this.industrialNationButton = new RadioButton("Industrialnation");
		this.emergingNationButton = new RadioButton("Emergingnation");
		this.thirdworldNationButton = new RadioButton("Thirdworldnation");
		this.industrialNationButton.setSelected(true);
		ToggleGroup tgDev = new ToggleGroup(); //ToggleGroup für RadioButtons
		this.industrialNationButton.setToggleGroup(tgDev);
		this.emergingNationButton.setToggleGroup(tgDev);
		this.thirdworldNationButton.setToggleGroup(tgDev);
		this.hBoxDev = new HBox();//RadioButtons in HBox
		this.hBoxDev.getChildren().addAll(this.industrialNationButton, this.emergingNationButton, this.thirdworldNationButton);
		this.add(this.hBoxDev, 2, 4);
		
		//Population 
		this.lblPopulation = new Label("Population");
		this.add(this.lblPopulation, 1, 5);
		this.txfPopulation = new TextField();
		this.add(this.txfPopulation, 2, 5);
		
		//Area
		this.lblArea = new Label("Area");
		this.add(this.lblArea, 1, 6);
		this.txfArea = new TextField();
		this.add(this.txfArea, 2, 6);
		
		// Button zum hinzufuegen der Objekte
		this.createButton = new Button("Create Country");
		this.add(this.createButton, 2, 7);



		// CreateButton an Controller
		//this.createButton.setOnAction(controller::createNewCountry);
	}

	/**
	 * GETTER um die Kontrollelemente der CreatePane auszulesen und mit den
	 * ausgewählten Werten ein neues Objekt zu erstellen
	 */
	public Country getObject() throws Exception {
		Nation nation = this.nationChoiceBox.getSelectionModel().getSelectedItem();
		if (nation == null)
			throw new EmptyFieldException("No nation selected");

		State state = this.stateChoiceBox.getSelectionModel().getSelectedItem();
		if (state == null) {
			throw new EmptyFieldException("No state selected");
		}

		FormOfGovernment formOfGovernment = null;
		if (this.democracyButton.isSelected())
			formOfGovernment = FormOfGovernment.DEMOCRACY;
		if (this.dictatorshipButton.isSelected())
			formOfGovernment = FormOfGovernment.DICTATORSHIP;
		if (this.monarchyButton.isSelected())
			formOfGovernment = FormOfGovernment.MONARCHY;

		DevelopmentStatus developmentStatus = null;
		if (this.industrialNationButton.isSelected())
			developmentStatus = DevelopmentStatus.INDUSTRIALNATION;
		if (this.emergingNationButton.isSelected())
			developmentStatus = DevelopmentStatus.EMERGINGNATION;
		if (this.thirdworldNationButton.isSelected())
			developmentStatus = DevelopmentStatus.THIRDWORLDNATION;
		Country country = new Country(nation, formOfGovernment, developmentStatus);
		return country;
	}

	/**
	 * GETTER Textfield in Integer umwandeln
	 */

	// Noch Exception für Texteingaben statt Zahlen einbauen, keine Emptyfield Exception, da nicht Pflichtfeld
	public int getPopulation() {
		return Integer.parseInt(this.txfPopulation.getText());
	}

	// Noch Exception für Texteingaben einbauen
	public int getArea() {
		return Integer.parseInt(this.txfArea.getText());

	}

	/**
	 * RESET Setzt alle Eingaben im Behälter zurück
	 */
	public void reset() {
		this.nationChoiceBox.getSelectionModel().clearSelection();
		this.stateChoiceBox.getSelectionModel().clearSelection();
		this.democracyButton.setSelected(true);
		this.industrialNationButton.setSelected(true);
		this.txfArea.setText("");
		this.txfPopulation.setText("");
	}
}
