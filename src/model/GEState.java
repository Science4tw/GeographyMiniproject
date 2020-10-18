package model;

public enum GEState {

	BadenWuerttemberg, Bayern, Berlin, Brandenburg, Bremen, Hamburg, Hessen, MecklenburgVorpommern, Niedersachsen,
	NordrheinWestfalen, RheinlandPfalz, Saarland, Sachsen, SachsenAnhalt, SchleswigHolstein, Thueringen;

	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}

}
