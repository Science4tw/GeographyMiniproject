package model;

import java.util.ArrayList;

public class GovRegCollection {
	
	private ArrayList<GovernedRegion> collection;
	

	public GovRegCollection() {
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
		for (GovernedRegion govReg : this.collection) {
			if (govReg.contains(searchString)) {
				result.add(govReg);
			}
		}
		if (result.size() > 0)
			return result;
		else
			return null;
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
