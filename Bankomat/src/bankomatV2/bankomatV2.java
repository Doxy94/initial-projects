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

class Pinklasse 
{
	//Instantvariable deklarieren
	int pin;
	//Methode zum initialisieren
	int initialisieren(int standard)
	{
		pin = standard; 
		return standard;
	}
	//Methode zum ändern
	void aendern(int aenderung)
	{
		pin = aenderung;
	}
}

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
		String karteVorhanden,inputSwitch,pinKontrolle,pinKontrolleNeu,pinEingabeNeu; //Kontrolle ob Bankkarte Vorhanden ist	
		char auswahl; //Deklaration der Variable mit welcher eine Aktion ausgewählt wird im Switch-Case	
		int pinAlt,pinNeu,pinAbfrage,zaehler,input,einzahlen,pinEingabeAlt;
		
		//Initialisierung
		pinAbfrage = 0;
		zaehler = 0;
		input = 0;
		einzahlen = 0;
		pinEingabeAlt = 0;
		//Hier wird ein neues Konto erstellt
		Kontoklasse konto1 = new Kontoklasse();//Neues konto wurde erstellt
		int kontostand = konto1.initialisieren(1000);//Neues konto wurde mit 1000chf initialisiert
		
		//Hier wird ein neuer PIN erstellt und Initialisiert
		Pinklasse pin1 = new Pinklasse();
		Pinklasse pin2 = new Pinklasse(); //Variable für den Neuen Pin
		pinAlt = pin1.initialisieren(1234);
		pinNeu = pin2.initialisieren(0);
		//Schleife zur Kartenabfrage
		while (bankkarte == false) //Solange keine Karte vorhanden wird danach gefragt
		{	
				karteVorhanden = JOptionPane.showInputDialog(("Schreiben Sie 'Karte' um Ihre Bankkarte einzulegen!")); // Eingabe aufforderung
				if (karteVorhanden == null)
				{
					System.out.println("Sie haben das Programm beendet.");
					System.exit(0);
				}
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
			try //Try pinabfrage
			{
				String pinEingabe = JOptionPane.showInputDialog("Geben Sie Ihren gültigen PIN ein!");
				if (pinEingabe != null)
				{
					pinAbfrage = Integer.parseInt(pinEingabe);
				}
				else
				{
					System.out.println("\nSie haben das Programm beendet");
					System.exit(0);
				}
			}
			//Catch pinabfrage
			catch (Exception e)
			{
				System.out.println("Bitte nur Zahlen eingeben.");
			}
			
			if (pinAbfrage == pinAlt)
			{
				//Begrüssung des Kunden
				System.out.println("\nWilkommen bei der Bank Ihres vertrauens!");
				//Auswahl der Handlungen
				System.out.println("1: Pin ändern");
				System.out.println("2: Geld abheben");
				System.out.println("3: Geld einzahlen");
				System.out.println("4: Geld wechseln");
				System.out.println("5: Kontostände Prüfen");
				//Try was tun
				try
				{	//Abfrage der auswahl was als nächstes getan werden soll
					inputSwitch = JOptionPane.showInputDialog("Was möchten Sie als nächstes tun?");
					if (inputSwitch != null) //Das passiert wenn der Abbrechen Button NICHT gedrückt wird
					{
						input = Integer.parseInt(inputSwitch);
						if (input < 1 || input > 5)
						{
							System.out.println("Bitte nur Zahlen von 1 bis 5 eingeben!");
						}
						
					}
					else //Das passiert wenn der Abbrechen Button gedrückt wird
					{
						System.out.println("\nSie haben das Programm beendet");
						System.exit(0);
					}
				}
				//Catch was tun --> redundant(?)
				catch (Exception ef)
				{
					System.out.println("Bitte nur Zahlen von 1 bis 5 eingeben!");
				}
				//Nach der Auswahl wird entschieden was passiert
				switch(input) 
				{
				case 1://Pin ändern wurde ausgewählt 
					//Try pinKontrolle
					try {
						pinKontrolle = JOptionPane.showInputDialog("Geben Sie zunächst zur Kontrolle Ihren alten Pin ein.");
						if (pinKontrolle != null)
						{
							pinEingabeAlt = Integer.parseInt(pinKontrolle);						
							if (pinEingabeAlt == pinAlt)
							{
								//TRY NEUER PIN EINGABE
								pinEingabeNeu = JOptionPane.showInputDialog("Geben Sie nun den neuen Pin ein");
								if (pinEingabeNeu != null)
								{	
									pinNeu = Integer.parseInt(pinEingabeNeu);
									pinKontrolleNeu = JOptionPane.showInputDialog("Geben Sie den PIN zur Bestätigung erneut ein.");
									int pinKontrolleNeuer = Integer.parseInt(pinKontrolleNeu);
									if (pinKontrolleNeu != null && pinNeu == pinKontrolleNeuer)
									{
									pinNeu = Integer.parseInt(pinEingabeNeu);
									System.out.println("Ihr PIN wurde erfolgreich geändert.");
									pinAlt = pinNeu;									
									}
									else 
									{
										System.out.println("Die PINs stimmen nicht miteinander überein.");
										System.out.println("Versuchen Sie es erneut.");
									}
								}
							}
						}
						else
						{
							System.out.println("\nSie haben das Programm beendet");
							System.exit(0);							
						}
						}
					catch (Exception e)
					{
						System.out.println("Sie haben Ihren PIN falsch eingegeben.");
						System.out.println("Bitte versuchen Sie es erneut.");
					}
						i ++;
						break;
				case 2://Geld abheben wurde ausgewählt
					try
					{	
						String abhebenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie abheben?"); //Abfrage wie viel geld Abgehoben werden soll
						if (abhebenEingabe != null)
						{
							int abheben = Integer.parseInt(abhebenEingabe);
							kontostand = konto1.abheben(abheben); //Neuer Kontostand wird berechnet
							System.out.println("Ihr neuer Kontostand lautet: " + kontostand + ".- CHF");
						}
						else
						{
							System.out.println("\nSie haben das Programm beendet");
							System.exit(0);
						}
					}
					catch (Exception e)
					{
						System.out.println("Bitte geben Sie nur den Betrag ein, den Sie abheben möchten.");
					}
						
					i ++; 
					break;
				case 3://Geld einzahlen wurde ausgewählt 
					try
					{
						String einzahlenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie einzahlen?"); //Abfrage wie viel geld Eingezahlt werden soll
						if (einzahlenEingabe != null)
						{
							einzahlen = Integer.parseInt(einzahlenEingabe);
							kontostand = konto1.einzahlen(einzahlen); //Neuer Kontostand wird berechnet
							System.out.println("Ihr neuer Kontostand lautet: " + kontostand + ".- CHF"); //Kontostand output
						}
						else
						{
							System.out.println("\nSie haben das Programm beendet");
							System.exit(0);
						}
					}
					catch (Exception e)
					{
						System.out.println("Bitte geben Sie nur den Betrag ein, den Sie einzahlen möchten.");
					}
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
					i ++;
					break;
				}
			}
			else 
			{
				if (i - zaehler == 3)
				{
					System.out.println("Falscher PIN, bitte erneut versuchen\n");
				}
				if (i - zaehler == 2)
				{
					System.out.println("ACHTUNG! Sie haben nur noch einen versuch!\n");
				}
				if (i - zaehler == 1)
				{
					System.out.println("PIN 3 mal falsch eingegeben, das System wird aus Sicherheitsgründen beendet!");
					System.exit(zaehler);
				}
			}
		}		
	}	
}
