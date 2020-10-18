package controller;

import java.util.ArrayList;

import exceptions.EmptyFieldException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import model.Country;
import model.DevelopmentStatus;
import model.FormOfGovernment;
import model.GovRegCollection;

import model.Nation;
import model.GovernedRegion;
import view.Geography_View;

// 0
public class Geography_Controller {

	// 0
	private GovRegCollection model;
	private Geography_View view;

	// 0
	public Geography_Controller(GovRegCollection model, Geography_View view) {

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
	 * Wird ausgeführt, sobald in der View eine Suche gestartet wird
	 * Den vom user im textfield eingegeben Suchbegriff speicher.
	 * Speichert in einer lokalen Liste die = In der ArrayList sucht man nach dem Suchbegriff
	 * Zeigt die Suche in der ListView an Aktualisiert den Status
	 * @param event
	 */
	public void search(Event event) {
		// 1. Speichere Suchbegriff
		String searchString = view.getSearchString();
		// 2. Loakle ArrayList um die Resultate der Suche zu speichern
		// und Suche in der Collection nach dem Suchbegriff
		ArrayList<GovernedRegion> result = this.model.search(searchString);
		// 3. Setze das Resultat
		this.view.setResult(result);
		this.view.updateStatus("Suche durchgeführt");
		// 4
	}

	/**
	 * SETTER für die View
	 */
	public void setView(Geography_View view) {
		this.view = view;
	}
}
