package model;

public enum CHState {

	Aargau, AppenzellAusserrhoden, AppenzellInnerrhoden, BaselLandschaft, BaselStadt, Bern, Freiburg, Genf, Glarus,
	Graubünden, Jura, Luzern, Neuenburg, Nidwalden, Obwalden, StGallen, Schaffhausen, Schwyz, Solothurn, Tessin,
	Thurgau, Uri, Waadt, Wallis, Zürich, Zug;

	// Überprüft ob searchString in diesem Namen vorkommt

	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}

}
