package view;

import controller.Geography_Controller;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Country;
import model.FormOfGovernment;
import model.Nation;

public class CreatePane extends GridPane {

	// Kontrollelemente zum hinzufuegen der Objekte
	private ChoiceBox<Nation> nationChoiceBox; // Auswahl für die Länder
	private Label lblNation;
	
	// FormOfGovernment
	private RadioButton democracyButton, dictatorshipButton, monarchyButton;
	private Label lblFormOfGovernment = new Label("Form of Government:");
	private HBox formOfGovernmentBox;
	
	// DevelopmentStatus
	private RadioButton industrialNationButton, emergingNationButton, thirdworldNationButton;
	private Label lblDevelopmentStatus = new Label("Development Status:");
	private HBox developmentStatusBox;
	
	// State
	private TextField txtState = new TextField();
	private Label lblState = new Label("State:");
	
	// City
	
	// Button zum Hinzufuegen
	private Button createButton;	
	
	/**
	 * Konstruktor um alle Kontrollelemente zu instanziieren
	 * und diesem Behälter hinzuzufügen
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

		
		// RadioButton zur Auswahl der FormOfGovernment (in HBox organisiert)
		// Auswahl: DEMOCRACY, DICTATORSHIP, MONARCHY
		this.add(this.lblFormOfGovernment, 1, 2);
		this.democracyButton = new RadioButton(FormOfGovernment.values()[0].name()); // Liest den ersten(0) Wert des Enums FormOfGovernment aus und speichert diesen unter democrayButton
		this.dictatorshipButton = new RadioButton(FormOfGovernment.values()[1].name());
		this.monarchyButton = new RadioButton(FormOfGovernment.values()[2].name());
		this.democracyButton.setSelected(true);
		ToggleGroup tg = new ToggleGroup();
		this.democracyButton.setToggleGroup(tg);
		this.dictatorshipButton.setToggleGroup(tg);
		this.monarchyButton.setToggleGroup(tg);
		this.formOfGovernmentBox = new HBox();
		this.formOfGovernmentBox.getChildren().addAll(this.democracyButton, this.dictatorshipButton, this.monarchyButton);
		this.add(formOfGovernmentBox, 2, 2);
		
		// RadioButton zur Auswahl des DevelopmentStatus (in HBox organisiert)
		

	}
}
