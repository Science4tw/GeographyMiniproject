package model;

public enum DevelopmentStatus {
	
	INDUSTRIALNATION,
	EMERGINGNATION,
	THIRDWORLDNATION;
	// Überprüft ob searchString in diesem Namen vorkommt

	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}
}
