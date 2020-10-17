package model;

public enum FormOfGovernment {
	
	DEMOCRACY,
	DICTATORSHIP,
	MONARCHY;
	// Überprüft ob searchString in diesem Namen vorkommt

	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}
}
