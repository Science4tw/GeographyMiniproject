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
import javafx.scene.layout.Pane;
import model.Country;
import model.DevelopmentStatus;
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
		ToggleGroup fOGGroup = new ToggleGroup();
		this.democracyButton.setToggleGroup(fOGGroup);
		this.dictatorshipButton.setToggleGroup(fOGGroup);
		this.monarchyButton.setToggleGroup(fOGGroup);
		this.formOfGovernmentBox = new HBox();
		this.formOfGovernmentBox.getChildren().addAll(this.democracyButton, this.dictatorshipButton, this.monarchyButton);
		this.add(this.formOfGovernmentBox, 2, 2);
		
		// RadioButton zur Auswahl des DevelopmentStatus (in HBox organisiert)
		this.add(this.lblDevelopmentStatus, 1, 3); // Label
		this.industrialNationButton = new RadioButton(DevelopmentStatus.values()[0].name()); // Liest den ersten(0) Wert des Enums FormOfGovernment aus und speichert diesen unter democrayButton
		this.emergingNationButton = new RadioButton(DevelopmentStatus.values()[1].name());
		this.thirdworldNationButton = new RadioButton(DevelopmentStatus.values()[2].name());
		this.industrialNationButton.setSelected(true);		
		ToggleGroup dSGroup = new ToggleGroup();
		this.industrialNationButton.setToggleGroup(dSGroup);
		this.emergingNationButton.setToggleGroup(dSGroup);
		this.thirdworldNationButton.setToggleGroup(dSGroup);
		this.developmentStatusBox = new HBox();
		this.developmentStatusBox.getChildren().addAll(this.industrialNationButton, this.emergingNationButton, this.thirdworldNationButton);
		this.add(this.developmentStatusBox, 2, 3);
		
		
		// Button zum hinzufuegen der Objekte
		this.createButton = new Button("CREATE Object");
		this.add(this.createButton, 2, 8);
//		this.createButton.setOnAction(controller::createNewObject);
	}
	
	/**
	 * GETTER
	 * um die Kontrollelemente der CreatePane auszulesen
	 * und mit den ausgewählten Werten ein neues Objekt zu erstellen
	 */
	public Country getObject() throws Exception{
		Nation nation = this.nationChoiceBox.getSelectionModel().getSelectedItem();
		if (nation == null)
			throw new EmptyFieldException("No nation selected");
		
		FormOfGovernment formOfGovernment = null;
		if(this.democracyButton.isSelected())
			formOfGovernment = FormOfGovernment.DEMOCRACY;
		if(this.dictatorshipButton.isSelected())
			formOfGovernment = FormOfGovernment.DICTATORSHIP;
		if(this.monarchyButton.isSelected())
			formOfGovernment = FormOfGovernment.MONARCHY;
		
		DevelopmentStatus developmentStatus = null;
		if(this.industrialNationButton.isSelected())
			developmentStatus = DevelopmentStatus.INDUSTRIALNATION;
		if(this.emergingNationButton.isSelected())
			developmentStatus = DevelopmentStatus.EMERGINGNATION;
		if(this.thirdworldNationButton.isSelected())
			developmentStatus = DevelopmentStatus.THIRDWORLDNATION;
		Country country = new Country(nation, formOfGovernment, developmentStatus);
		return country;
	}
	
	/**
	 * RESET
	 * Setzt alle Eingaben im Behälter zurück
	 */
	public void reset() {
		this.nationChoiceBox.getSelectionModel().clearSelection();

	}
}
