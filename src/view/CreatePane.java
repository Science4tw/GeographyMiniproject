package view;


import controller.Geography_Controller;
import exceptions.EmptyFieldException;
import exceptions.IllegalCharacterException;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Country;
import model.DevelopmentStatus;
import model.FormOfGovernment;
import model.GEState;
import model.Nation;
import model.CHState;
import model.AUState;

public class CreatePane extends GridPane {

	// Kontrollelemente zum hinzufuegen der Objekte
	
	// Nation
	private ComboBox<Nation> nationComboBox; 
	private Label lblNation;
	
	// States
	private Label lblState;
	
	private ComboBox<CHState> CHStateComboBox;
	private ComboBox<GEState> GEStateComboBox;
	private ComboBox<AUState> AUStateComboBox;


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
		// ComboBox zur Auswahl der Nation
		this.lblNation = new Label("Nation:");
		this.add(this.lblNation, 1, 1);
		this.nationComboBox = new ComboBox<Nation>();
		Nation[] nations = Nation.values(); // Liest die Werte des Enums "Nation" aus
		for (Nation nation : nations)
			this.nationComboBox.getItems().add(nation);
		this.add(this.nationComboBox, 2, 1);

		// ChoiceBox zur Auswahl von State
		this.lblState = new Label("State:");
		this.add(this.lblState, 1, 2);
		
		this.CHStateComboBox = new ComboBox<CHState>();
		this.GEStateComboBox = new ComboBox<GEState>();
		this.AUStateComboBox = new ComboBox<AUState>();
	/*			
		Nation selection = this.nationComboBox.getSelectionModel().getSelectedItem();
		switch (selection) {
		case Switzerland:
			CHState[] chStates = CHState.values(); // Liest die Werte des Enums "CHstates" aus
			for (CHState chState : chStates)
				this.CHStateComboBox.getItems().add(chState);
			this.add(this.CHStateComboBox, 2, 1);
			break;
		case Germany:
			GEState[] geStates = GEState.values(); // Liest die Werte des Enums "GEStates" aus
			for (GEState geState : geStates)
				this.GEStateComboBox.getItems().add(geState);
			this.add(this.GEStateComboBox, 2, 1);
			break;
		case Austria:
			AUState[] auStates = AUState.values(); // Liest die Werte des Enums "AuStates" aus
			for (AUState auState : auStates)
				this.AUStateComboBox.getItems().add(auState);
			this.add(this.AUStateComboBox, 2, 1);
			break;
		default:
			break;
			
		}
		*/
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
		Nation nation = this.nationComboBox.getSelectionModel().getSelectedItem();
		if (nation == null)
			//this.nationComboBox.setBorder(Color.RED);
			throw new EmptyFieldException("No nation selected");
/*
		CHState state = this.CHStateComboBox.getSelectionModel().getSelectedItem();
		if (state == null) {
			this.CHstateComboBox.setBorder(Color.RED);
			throw new EmptyFieldException("No state selected");
		}
*/
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
	 * @throws IllegalCharacterException 
	 */

	
	// Noch Exception für Texteingaben statt Zahlen einbauen, keine Emptyfield Exception, da nicht Pflichtfeld
	public int getPopulation() throws IllegalCharacterException {
		if (this.txfPopulation.getText() != "[0-9]") {
			//this.lblPopulation.setTextFill(Color.RED);
			throw new IllegalCharacterException("Wrong Character, only digits");
			}
		return Integer.parseInt(this.txfPopulation.getText());
	}

	// Noch Exception für Texteingaben einbauen, Farbe ROT
	public int getArea() throws IllegalCharacterException {
		
		if (this.txfArea.getText() != "[0-9]") {
		//	this.lblArea.setTextFill(Color.RED);
			throw new IllegalCharacterException("Wrong Character, only digits");
			}
		return Integer.parseInt(this.txfArea.getText());

	}

	/**
	 * RESET Setzt alle Eingaben im Behälter zurück
	 */
	public void reset() {
		this.nationComboBox.getSelectionModel().clearSelection();
		this.CHStateComboBox.getSelectionModel().clearSelection();
		this.GEStateComboBox.getSelectionModel().clearSelection();
		this.AUStateComboBox.getSelectionModel().clearSelection();
		this.democracyButton.setSelected(true);
		this.industrialNationButton.setSelected(true);
		this.txfArea.setText("");
		this.txfPopulation.setText("");
	}
}
