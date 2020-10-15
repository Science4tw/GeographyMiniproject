package controller;

import exceptions.EmptyFieldException;
import javafx.event.ActionEvent;
import model.Country;
import model.Geography_Model;
import view.Geography_View;

// 0
public class Geography_Controller {
	
	// 0
	private Geography_Model model;
	private Geography_View view;
	
	// 0
	public Geography_Controller(Geography_Model model, Geography_View view){
		
	}

	// CREATE
	public void createNewCountry(ActionEvent event) throws Exception {
		try {
			Country newCountry = this.view.getCountry();
			this.model.add(newCountry);
			this.view.updateStatus("Country created: " + newCountry);
		} catch (EmptyFieldException exception) {
			this.view.updateStatus(exception.getMessage());
		}
		
	}
	
	// DELETE
	
	// READ
	
	// UPDATE
	
	// SEARCH
	
	
	
	
	/**
	 * SETTER für die View
	 */
	public void setView(Geography_View view) {
		this.view = view;
	}
}
