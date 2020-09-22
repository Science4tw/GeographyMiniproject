package view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ADDPane extends GridPane {

	private Label countryLabel, stateLabel, cityLabel;
	private TextField countryField, stateField, cityField;
	
	
	public Pane createAddPane() {
		GridPane grid = new GridPane();
		this.countryLabel = new Label("Country : ");
		this.add(this.countryLabel, 1, 1);
		
		this.countryField = new TextField();
		this.add(this.countryField, 2, 1);
		
		return grid;
	}
}
