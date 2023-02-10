package bankomat;

import javax.swing.JOptionPane;

public class Pin {
	
	Pin()
	{
		//Variabeln
		int pinAlt,pinNeu,pinAbfrage;
		boolean abbrechen = false;
		
		//Initialisierung
		pinAlt = 1234;
		
			int pinKontrolleAlt = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie zunächst zur Kontrolle Ihren alten Pin ein!"));
			if (pinKontrolleAlt == pinAlt)
			{
				pinNeu = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie nun den Neuen Pin ein!"));
				int pinKontrolleNeu = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie den Pin zur Bestätigung erneut ein!"));
				if (pinNeu == pinKontrolleNeu)
				{
					System.out.println("Ihr Pin wurde erfolgreicht geändert");
					pinAlt = pinNeu;
				}
				else
				{
					System.out.println("Neue Pins stimmen sind nicht identisch!\nSystem wird beendet!");
					System.exit(0);
				}
			}
			else
			{
				//System.out.println("Falscher Pin! \nSystem wird beendet!");	
				//System.exit(0);
			}
	}
		
		
		
}
