package model;

public enum AUState {

	Wien, Niederoesterreich, Burgenland, Steiermark, Kärnten, Tirol, Salzburg, Oberoesterreich;

	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}
}