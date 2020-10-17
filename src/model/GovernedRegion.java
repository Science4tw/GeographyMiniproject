package model;

public abstract class GovernedRegion {

	private FormOfGovernment formOfGovernment;
	private DevelopmentStatus developmentStatus;
	
	
	// Gross/Kleinschreibung wäre mit toLowerCase möglich
	public boolean containsSearchString(String searchString) { // durchsucht alle Parameter
//		String cardnumberasString = Integer.toString(this.cardNumber);// int in string umwandeln
//		if (this.player.getName().contains(searchString) || this.clubName.contains(searchString) || // clubname kein getter nötig
//				this.player.getNationality().contains(searchString) || // enum
//				this.player.getPosition().contains(searchString) || cardnumberasString.equals(searchString))

			return true;
//		else
//			return false;
	}
}
