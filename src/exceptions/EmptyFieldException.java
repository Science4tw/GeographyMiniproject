package exceptions;

public class EmptyFieldException extends Exception{
	
	/**
	 * Ausnahme, falls ein Textfeld zur Eingabe von String
	 * Objekten leer war.
	 */
	public EmptyFieldException(String message) {
		super(message);
	}

}
