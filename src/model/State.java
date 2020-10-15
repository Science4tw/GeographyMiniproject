package model;

public enum State {
	
	Bern,
	Zurich,
	Solothurn,
	Berlin,
	Hamburg,
	Hannover,
	Paris,
	Bretagne,
	Nizza,
	Bordeaux,
	Sicily,
	Toscana,
	Lombardei,
	Steiermark,
	Tirol,
	Wien;
	
	//Überprüft ob searchString in diesem Namen vorkommt
	
	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}
	
	
}
