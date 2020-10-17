package controller;

import java.util.ArrayList;

import exceptions.EmptyFieldException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import model.Country;
import model.DevelopmentStatus;
import model.FormOfGovernment;
import model.Geography_Model;

import model.Nation;
import model.GovernedRegion;
import view.Geography_View;

// 0
public class Geography_Controller {

	// 0
	private Geography_Model model;
	private Geography_View view;

	// 0
	public Geography_Controller(Geography_Model model, Geography_View view) {

	}

	// CREATE
	public void createNewCountry(ActionEvent event) throws Exception {
		try {
			Country newCountry = this.view.getCountry();
//			this.model.add(newCountry);
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
	 * Den vom user im textfield eingegeben Suchbegriff speichern Speichert in einer
	 * lokalen Liste die = In der ArrayList sucht man nach dem Suchbegriff Zeigt die
	 * Suche in der ListView an Aktualisiert den Status
	 * 
	 * @param event
	 */

	/*
	 * public void searchGovernedRegion(Event event) { String searchString =
	 * view.searchPane.getSearchString(); ArrayList<GovernedRegion> result =
	 * model.collection.search(searchString); // Search = methode in
	 * playcardcollection, erwartet ArrayList<PlayerCard>
	 * this.searchPane.setResult(result); // setResult = neue Methode in
	 * SearchPlayerView this.view.setStatus("Suche durchgeführt"); // setStatus =
	 * neue Methode in PlayerCardMainView }
	 * 
	 */

	/**
	 * SETTER für die View
	 */
	public void setView(Geography_View view) {
		this.view = view;
	}
}
