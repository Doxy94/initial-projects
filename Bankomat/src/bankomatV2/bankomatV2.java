package bankomatV2;
/*
Funktionen:

Pin änderung möglich
Geld abgehen
Geld einzahlen
Kontostände checken
Geld wechseln in EU und USD (auf ein 2. und 3. konto)


Ablauf:
- Bankkarte eingeben // Solange bis Karte vorhanden
- Pin eingeben // 3 Versuche danach wird das Programm beendet
- Begrüssung // 1 Mal 
- auswahl was man tun möchte (1-5) // Bis zum Abbruch immer wiederholen
- (1) Pin ändern // Nur 1 mal möglich innert 7 Tagen
- (2) Gelb abheben 
- (3) Gelb einzahlen
- (4) Geldwechseln // Danach abfrage ob EU oder USD // Nur möglich wenn Geld auf dem Konto vorhanden
- (5) Kontostände anzeigen lassen // die letzten 10 überweisungen/geldwechsel
*/

import javax.swing.JOptionPane;

//Klasse Konto erstellen
class Kontoklasse 
{
	//Instanzvariable
	int konto;
	//Methode zum initialisieren
	int initialisieren(int standard) 
	{
		konto = standard;
		return konto;
	}
	//Methode zum Geld abheben
	int abheben(int aenderung)
	{
		if (konto >= aenderung)
		{
		konto = konto - aenderung;
		}
		else 
		{
			System.out.println("Sie haben nicht genügend Geld auf dem Konto.");
		}
		return konto;
	}
	//Methode zum Geld einzahlen
	int einzahlen(int aenderung)
	{
		return konto = konto + aenderung;
	}
	
}
public class bankomatV2 {
	public static void main (String[] args) {	
		
		//Variablen deklaration
		boolean bankkarte = false; //Bankkarte nicht vorhanden	
		String karteVorhanden; //Kontrolle ob Bankkarte Vorhanden ist	
		char auswahl; //Deklaration der Variable mit welcher eine Aktion ausgewählt wird im Switch-Case	
		int pin,pinAbfrage,zaehler,input;
		
		//Initialisierung
		pin = 1234;
		pinAbfrage = 0;
		zaehler = 0;
		//Hier wird ein neues Konto erstellt
		Kontoklasse konto1 = new Kontoklasse();//Neues konto wurde erstellt
		int kontostand = konto1.initialisieren(1000);//Neues konto wurde mit 1000chf initialisiert
		
		//Schleife zur Kartenabfrage
		while (bankkarte == false) //Solange keine Karte vorhanden wird danach gefragt
		{
			karteVorhanden = JOptionPane.showInputDialog(("Schreiben Sie 'Karte' um Ihre Bankkarte einzulegen!")); // Eingabe aufforderung
			if (karteVorhanden.equalsIgnoreCase("Karte")) //Wenn eingabe wie gefordert 
			{
				bankkarte = true; // dann ist bankkarte vorhanden
			}
			else // passiert wenn karte falsche geschrieben wird
			{
				System.out.println("Bitte einfach nur 'Karte' schreiben."); 		
			}
		}
		//Pin wird 3 mal abgefragt
		for (int i=3; zaehler < i; zaehler ++)
		{
			try
			{
			pinAbfrage = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie Ihren gültigen PIN ein!"));
			}
			catch (Exception e)
			{
				System.out.println("Bitte den gültigen PIN eingeben!\n");
			}
			
			if (pinAbfrage == pin)
			{
				//Begrüssung des Kunden
				System.out.println("\nWilkommen bei der Bank Ihres vertrauens!");
				//Auswahl der Handlungen
				System.out.println("A: Pin ändern");
				System.out.println("B: Geld abheben");
				System.out.println("C: Geld einzahlen");
				System.out.println("D: Geld wechseln");
				System.out.println("E: Kontostände Prüfen\n");
				//Abfrage einer auswahl was als nächstes getan werden soll
				input = Integer.parseInt(JOptionPane.showInputDialog("Was möchten Sie als nächstes tun?"));
				//Nach der Auswahl wird entschieden was passiert
				switch(input) 
				{
				case 1://Pin ändern wurde ausgewählt 
					
					i ++;
					break;
				case 2://Geld abheben wurde ausgewählt
					int abheben = Integer.parseInt(JOptionPane.showInputDialog("Wie viel Geld möchten Sie abheben?")); //Abfrage wie viel geld Abgehoben werden soll
					kontostand = konto1.abheben(abheben); //Neuer Kontostand wird berechnet
					System.out.println("Ihr neuer Kontostand lautet: " + kontostand + ".- CHF");
					i ++; 
					break;
				case 3://Geld einzahlen wurde ausgewählt 
					int einzahlen = Integer.parseInt(JOptionPane.showInputDialog("Wie viel Geld möchten Sie einzahlen?")); //Abfrage wie viel geld Eingezahlt werden soll
					kontostand = konto1.einzahlen(einzahlen); //Neuer Kontostand wird berechnet
					System.out.println("Ihr neuer Kontostand lautet: " + kontostand + ".- CHF"); //Kontostand output
					i ++;
					break;
				case 4://Geld wechseln wurde ausgewählt
					System.out.println("Sie wollen Geld wechseln");
					i ++;
					break;
				case 5://Kontostand anzeigen wurde ausgewählt
					System.out.println("Ihr aktueller Kontostand lautet: " + kontostand + ".- CHF");
					i ++;
					break;
				default://Standardaktion bei ungültiger Eingabe 
					System.out.println("Bitte nur Zahlen von 1 bis 5 eingeben!");
					i ++;
					break;
				}
			}
			else 
			{
				if (zaehler == 0)
				{
					System.out.println("Falscher PIN, bitte erneut versuchen\n");
				}
				if (zaehler == 1)
				{
					System.out.println("ACHTUNG! Sie haben nur noch einen versuch!\n");
				}
				if (zaehler == 2)
				{
					System.out.println("PIN 3 mal falsch eingegeben, das System wird aus Sicherheitsgründen beendet!");
					System.exit(zaehler);
				}
			}
		}
		
		
		
		
		
	}	
}
