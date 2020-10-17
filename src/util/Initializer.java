package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Nation;
import model.DevelopmentStatus;
import model.FormOfGovernment;
import model.GovernedRegion;
import model.Country;


public class Initializer {

	// statischer Pfad zur Datei mit initialen Countrys
	private final static String pathName = "src/resources/initialCountrys.txt";

	// Liest die Datei mit initialen Einträgen ein
	
	//CountryCollection zur Zeit keine Klasse
	
	/*public static GovernedRegion readItemFile() throws FileNotFoundException {
		GovernedRegion initialCountry = new GovernedRegion(); // neue Collection eröffnen

		Scanner fileReader = new Scanner(new File(pathName));

		while (fileReader.hasNext()) {
			String line = fileReader.nextLine();
			Country c = convertStringToCountry(line);
			initialCountry.addCountry(c);
		}
		return initialCountry;
	}

	// Support-Methode, um Objekte aus Datei zu lesen
	private static Country convertStringToCountry(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");

		// String in enum Werte konvertieren
		String tempNa = lineScanner.next();
		Nation nation = Nation.valueOf(tempNa);

		String tempGo = lineScanner.next();
		FormOfGovernment formOfGovernment = FormOfGovernment.valueOf(tempGo);

		String tempDe = lineScanner.next();
		DevelopmentStatus developmentStatus = DevelopmentStatus.valueOf(tempDe);

		//Nicht in Konstuktor von Country-Objekten zur Zeit, deshalb nciht gebraucht
		int population = lineScanner.nextInt();
		String state = lineScanner.next();
		String city = lineScanner.next();

		Country country = new Country(nation, formOfGovernment, developmentStatus);
		return country;
	}
*/
}