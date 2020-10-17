package model;

public enum AUState {

	Wien, Niederösterreich, Burgenland, Steiermark, Kärnten, Tirol, Salzburg, Oberösterreich;

	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}
}