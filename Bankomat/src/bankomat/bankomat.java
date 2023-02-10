package bankomat;

import java.io.IOException;

import javax.swing.JOptionPane;

/* 
►* geld wechseln in EU und USD
 * geld einzahlen
 * abfrage nach beleg oder nicht
 * karten pin ändern
 * karte einführen 
 * buchungen abfragen
 * 
 * 
 * TODO:
 * classe mit methoden für die kontostand abfrage erstellen
 * pin variabeln global machen sodass sie nach der änderung aktuell sind
 * wiederholung einbauen bei pin änderung --> pinabfrage testing vollenden 
 * falsche eingaben abfangen nach der pin abfrage damit man nicht wieder einen schritt zurück geht
 * Programm läuft nach jedem durchlauf wieder auf die pinabfrage --> korriegeren
 * pinabfrage korriegieren 
 * */

class Kontoklasse {
	
	//Instanzvariable
	int konto;
	//Methode zum initialisieren
	int initialisiere(int standard) {
		return konto = standard;
	}
	//Methode zum Abheben
	int abheben(int aenderung) {
		konto = konto - aenderung;
		return aenderung;
	}
	//Methode zum Einzahlen
	void einzahlen(int aenderung) {
		konto = konto + aenderung;
	}	
}

class Pinklasse {
	
	//Instanzvariable
	int pin;
	//Methode zum initialisieren
	int initialisiere(int standard) {
		pin = standard;
		return pin;
	}
	void aendern(int aenderung) {
		pin= aenderung;
	}
}
public class bankomat {
	
	public static int kontostand, pin, pinNeu;
	
	public static void main (String [] args) {
		
		//Variable
		int pinAbfrage,wasTunAuswahl,counterKarte, counterAuswahl;
		boolean karteVorhanden = false;
		String kartenAbfrage;
		
		//Initialisierung
		counterKarte = 0;
		counterAuswahl = 0;
		
		//Konto erstellen
		Kontoklasse konto1 = new Kontoklasse(); //Neues Konto erstellen
		kontostand = konto1.initialisiere(1000); //1000 CHF sind auf dem Konto
		
		//Pin erstellen
		Pinklasse pin1 = new Pinklasse(); //Neuer Pin erstellt
		pin = pin1.initialisiere(1234); //Pin wurde auf 1234 gesetzt
		
		//Hauptprogramm
		do {
			 kartenAbfrage = JOptionPane.showInputDialog("Schreiben Sie " + "Karte " + "um Ihre Bankkarte einzuführen!");
				if(kartenAbfrage.equalsIgnoreCase("karte"))
				{ 
					karteVorhanden = true;
				}
				else
				{
					System.out.println("KARTE schreiben du Mongo -.-");
					break;
				}
		} while (karteVorhanden == false);
		
		if (karteVorhanden == true)
		{
			do {		
				pinAbfrage = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie Ihren Kartenpin ein!"));
				if (pinAbfrage == pin) 
				{	
					//Wilkommen
					System.out.println("Wilkommen bei der Bank Ihres vertrauens!");
					
					//Hier wird bestimmt was als nächstes passiert
					System.out.println("1: Pin ändern");
					System.out.println("2: Geld abheben");
					System.out.println("3: Geld einzahlen");
					System.out.println("4: Kontostand abrufen");
					wasTunAuswahl = Integer.parseInt(JOptionPane.showInputDialog("Was möchsten Sie als nächstes tun?"));
				
					//Hauptprogramm
					if (wasTunAuswahl == 1) // Pin ändern
					{
						int pinKontrolle = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie zunächst zur Kontrolle Ihren alten Pin ein!"));
						if (pinKontrolle == pin) 
						{
							pinNeu = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie nun den neuen Pin ein!"));
							int pinKontrolleNeu = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie den Pin zur Bestätigung erneut ein!"));
							if (pinNeu == pinKontrolleNeu) 
							{
								System.out.println("Ihr Pin wurde erfolgreich geändert!");
								pin = pinNeu;
							}
							else 
							{
								System.out.println("Neue Pins stimmen nicht miteinander überein!");							
							}
						}
						//Else einbauen WAS PASSIERT WENN DER ERSTE PIN FALSCH IST?
					}
					if (wasTunAuswahl == 2) // Geld abheben
					{
						//Konto output
						System.out.println("Aktueller Kontostand lautet: " + kontostand + ".- CHF"); 
						//Inputabfrage wie viel abheben
						int abhebung = Integer.parseInt(JOptionPane.showInputDialog("Wie viel Geld möchten Sie abheben?"));
						//Berechnung neuer Kontostand
						kontostand = kontostand - abhebung;
						//Output neuer Kontostand
						System.out.println("Ihr neuer Kontostand lautet: " + kontostand + ".- CHF");
					}
					if (wasTunAuswahl == 3) // Geld einzahlen
					{
						//Konto output
						System.out.println("Aktueller Kontostand lautet: " + kontostand + ".- CHF");
						//Inputabfrage wie viel einzahlen
						int einzahlung = Integer.parseInt(JOptionPane.showInputDialog("Wie viel Geld möchten Sie einzahlen?"));
						//Berechnung neuer Kontostand
						kontostand = kontostand + einzahlung;
						//Output neuer Kontostand
						System.out.println("Ihr neuer Kontostand lautet: " + kontostand + ".- CHF");
					}
					if (wasTunAuswahl == 4) // Kontostand abfragen
					{
						//kontoAbfrage();
					}
				}
				if (pinAbfrage != pin)
				{
					counterKarte ++;
					if (counterKarte == 1) {
						System.out.println("Falscher Pin. Bitte erneut versuchen!");
						
					}
					if (counterKarte == 2)
					{
						System.out.println("ACHTUNG! Du hast nur noch einen Versuch");
					}
					if (counterKarte == 3)
					{
						System.out.println("Deine Karte wurde gesperrt! Das Programm wird aus Sicherheitsgründen beendet!");
						System.exit(0);
					}
				}				
			} while (pinAbfrage != pin);


					
			
		}
	}	
}