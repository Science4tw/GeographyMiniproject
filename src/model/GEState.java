package model;

public enum GEState {

	BadenWürttemberg, Bayern, Berlin, Brandenburg, Bremen, Hamburg, Hessen, MecklenburgVorpommern, Niedersachsen,
	NordrheinWestfalen, RheinlandPfalz, Saarland, Sachsen, SachsenAnhalt, SchleswigHolstein, Thüringen;

	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}

}
