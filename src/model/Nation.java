package model;

public enum Nation {
	
	Switzerland,
	Germany,
	France,
	Italy,
	Austria;
	
	//Überprüft ob searchString in diesem Namen vorkommt
	
	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}
	
	
}
