package model;

import java.util.ArrayList;

public class Country extends GovernedRegion {

	// Globaler Zähler instanzierter COuntry Objekte
	public static int globalCountryCount = 0;

	// Arraylist um die jeweiligen States(z.B Kantone) Objekte
	// eines Country Objekts zu speichern
	private ArrayList<State> states;

	// Geerbt von GovernedRegion
	private Long population;
	private Long area;

	// Objektvariablen
	private FormOfGovernment formOfGovernment;
	private DevelopmentStatus developmentStatus;
	private int countryNumber;

	// Konstruktor für Country Objekte
	public Country(FormOfGovernment formOfGovernment, DevelopmentStatus developmentStatus) {
		this.formOfGovernment = formOfGovernment;
		this.developmentStatus = developmentStatus;
		this.population = population;
		this.area = area;
		this.countryNumber = globalCountryCount++;
	}

	/**
	 * Gibt true zurück, wenn in einer der Instanzvariablen dieses Objektes die
	 * Zeichenkette searchString vorkommt (sonst false)
	 */
	public boolean contains(String searchString) {
		String countryAsString = Integer.toString(countryNumber);
		return this.formOfGovernment.contains(searchString) || this.developmentStatus.contains(searchString)
//				|| this.population.contains(searchString) || this.area.contains(searchString)
				|| countryAsString.contains(searchString);
	}

	/**
	 * Zeichenkettenrepräsentation für PlayerCard Objekte
	 */
	public String toString() {
		return this + ", " + this.population + ", " + this.area
				+ ", " + this.formOfGovernment+", "+this.developmentStatus;
	}

	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	public void addState(State state) {
		if (states == null) {
			states = new ArrayList<State>();
		}
		states.add(state);
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}

	public FormOfGovernment getFormOfGovernment() {
		return formOfGovernment;
	}

	public void setFormOfGovernment(FormOfGovernment formOfGovernment) {
		this.formOfGovernment = formOfGovernment;
	}

	public DevelopmentStatus getDevelopmentStatus() {
		return developmentStatus;
	}

	public void setDevelopmentStatus(DevelopmentStatus developmentStatus) {
		this.developmentStatus = developmentStatus;
	}

	public int getCountryNumber() {
		return countryNumber;
	}

	public void setCountryNumber(int countryNumber) {
		this.countryNumber = countryNumber;
	}

}
