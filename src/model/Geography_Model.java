package model;

import java.util.ArrayList;




public class Geography_Model {
	
	private ArrayList<GovernedRegion> collection;
	

	public Geography_Model() {
		this.collection = new ArrayList<GovernedRegion>();
	}
	
	public void addGovernedRegion(GovernedRegion governedRegion) {
		this.collection.add(governedRegion);
	}
	// CREATE
	
	// DELETE
	
	// READ
	
	// UPDATE
	
	// SEARCH
	public ArrayList<GovernedRegion> search(String searchString) { // ArrayList wird zurück gegeben
		ArrayList<GovernedRegion> result = new ArrayList<GovernedRegion>(); // Behälter für Rückgabe
		for (GovernedRegion p : this.collection) {// durch Liste iterieren, für jedes Objekt aus DIESER collection
			if (p.containsSearchString(searchString)) { // containsSearchString = ausgelagerte Methode
				result.add(p);
			}
		}
		return result;

	}	
	// WRITE
	
	public String toString() {
		String collectionAsString = "Anzahl Karten: " + this.collection.size() + "\n";
		collectionAsString += "\nMeine Karten:\n";
		for (int i = 0; i < this.collection.size(); i++)
			collectionAsString += this.collection.get(i) + "\n";

		return collectionAsString;
	}
}
