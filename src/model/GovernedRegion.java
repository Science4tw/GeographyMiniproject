package model;

public abstract class GovernedRegion {

	private FormOfGovernment formOfGovernment;
	private DevelopmentStatus developmentStatus;
	
	protected abstract boolean contains(String searchString);
	

}
