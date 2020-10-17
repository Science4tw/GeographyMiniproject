package view;

import java.util.ArrayList;


import controller.Geography_Controller;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Country;
import model.GovernedRegion;

public class SearchPane extends GridPane {
	
	private Label lblSearch;
	private TextField txtSearch;
	private Button btnSearch;
	private Label lblSearchStatus;
	private ListView<GovernedRegion> resultList;
	
	
	public SearchPane(Geography_Controller controller) {
		// Label um das
		this.lblSearch = new Label("Searchstate");
		this.add(this.lblSearch, 1, 1);
		

		// TextField für den Suchbegriff
		this.txtSearch = new TextField();
		this.add(this.txtSearch, 2, 1);
		
		// Button der die Suche auslöst
		this.btnSearch = new Button("Search");
		this.add(this.btnSearch, 1, 3);
		
//		this.lblSearchStatus = new Label("");

	
		// ListView
		this.resultList = new ListView<GovernedRegion>();
		this.resultList.getItems().addAll();
		this.add(this.resultList, 1, 4);
		// Sortieren
//		resultList.setEditable(true);
//		ObservableList<GovernedRegion> sortedList = new SortedList((ObservableList) resultList);
//		resultList.setItems(sortedList);
		
		
	}
	public String getSearchString() { //searchString wird wieder in Methode in Controller zurück gegeben werden
		return this.txtSearch.getText();
	}
	public void setResult(ArrayList<GovernedRegion> result) {
		this.resultList.getItems().clear(); //resultlist bereits vorhanden, immer zuerst leeren
		this.resultList.getItems().addAll(result); //dann neue resultlist hinzufügen
		
		
	}
}
