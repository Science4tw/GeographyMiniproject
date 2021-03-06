package model;

public enum Nation {

	Switzerland("Berne"), Germany("Berlin"), France("Paris"), Italy("Rome"), Austria("Vienna");

	private String capital;
	private String nation;

	private Nation(String capital) {
		this.capital = capital;
	}

	public String getCapital() {
		return this.capital;
	}

	public String getNation() {
		return this.nation;
	}

	public String toString() {
		return this.name() + " " + this.getCapital();

	}

	// Überprüft ob searchString in diesem Enum vorkommt
	public boolean containsState(String searchString) {
		return (this.getCapital().contains(searchString));
	}

	public boolean contains(String searchString) { // contains Methode aus String
		return (this.name().contains(searchString) || (this.getCapital().contains(searchString)));
		// this.name gleich automatisch vorhandene Methode von enum (Vererbung) 
	}

}
