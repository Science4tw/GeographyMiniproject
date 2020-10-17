package model;

public class State {

	private Country myCountry;

    public Country getMyCountry() {
        return myCountry;
    }

    public void setMyCountry(Country myCountry) {
        this.myCountry = myCountry;
    }
    // TODO : Liefert bisher nur true, muss noch ausformuliert werden
	/**
	 * Gibt true zurück, wenn in einer der Instanzvariablen dieses Objektes die
	 * Zeichenkette searchString vorkommt (sonst false)
	 */   
	public boolean contains(String searchString) {
		return true;
	}
}
