/**
 * 
 */
package it.unibo.oop.lab.enum1;

/**
 * Represents an enumeration for declaring sports;
 * 
 * 1) Complete the definition of the enumeration.
 * 
 */
public enum Sport {
    /*
     * declare the following sports: - basket - soccer - tennis - bike - F1 -
     * motogp - volley
     */
	BASKET("Basket"),
	SOCCER("Soccer"),
	TENNIS("Tennis"),
	BIKE("Bike"),
	F1("Formula 1"),
	MOTOGP("Moto GP"),
	VOLLEY("Volley");
	
	private final String sportName;
	
	private Sport(final String sportName) {
		this.sportName = sportName;
	}

	public String toString() {
		return this.sportName;
	}
	
}
