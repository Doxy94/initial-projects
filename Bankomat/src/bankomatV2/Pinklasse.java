package bankomatV2;

public class Pinklasse {
	//Instantvariable deklarieren
	int pin;
	//Methode zum initialisieren
	int initialisieren(int standard)
	{
		pin = standard; 
		return standard;
	}
	//Methode zum ändern
	int aendern(int pinBestaetigung)
	{
		pin = pinBestaetigung;
		return pin;
	}
}
