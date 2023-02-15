package bankomatV2;
/*
Funktionen:

Pin änderung möglich
Geld abgehen
Geld einzahlen
Kontostände checken
Geld wechseln in EU und USD (auf ein 2. und 3. konto)


Ablauf:
- Bankkarte eingeben
- Pin eingeben
- Begrüssung
- Auswahl was man tun möchte (1-5) 
- (1) Pin ändern // Nur 1 mal möglich innert 7 Tagen
- (2) Gelb abheben 
- (3) Gelb einzahlen
- (4) Geldwechseln
- (5) Kontostände anzeigen lassen
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
		
		if (aenderung > 5000)
		{
			System.out.println("Für eine Einzahlung über 5.000 CHF müssen Sie einen Termin in der Filiale vereinbaren.");
		}
		else 
		{
			System.out.println("Ihr Geld wurde erfolgreich eingezahlt.");
		}
		return konto = konto + aenderung;
	}
	
}
public class bankomatV2 {
	public static void main (String[] args) {	
		
		//Variablen deklaration
		boolean bankkarte = false; //Bankkarte nicht vorhanden	
		String kartenEingabe,switchEingabe,pinKontrolle,pinBestaetigung,pinEingabeNeu;	
		int pinAlt,pinNeu,pinInteger,zaehlerFOR,switchCase,einzahlen,pinEingabe;
		
		//Initialisierung
		pinInteger = 0;
		zaehlerFOR = 0;
		switchCase = 0;
		einzahlen = 0;
		pinEingabe = 0;
		
		//Hier werden neue Bankkonten erstellt
		Kontoklasse kontoCHF = new Kontoklasse();//Neues Konto für CHF wurde erstellt
		int kontostandCHF = kontoCHF.initialisieren(1000);//Neues Konto wurde mit 1000CHF initialisiert
		
		Kontoklasse kontoEUR = new Kontoklasse();//Neues Konto für EURO wurde erstellt
		int kontostandEUR = kontoEUR.initialisieren(1000);//Neues Konto wurde mit 1000EUR initialisiert
		
		Kontoklasse kontoUSD = new Kontoklasse();//Neues Konto für USD wurde erstellt
		int kontostandUSD = kontoUSD.initialisieren(1000);//Neues Konto wurde mit 1000USD initialisiert
		
		//Hier werden die PINs erstellt und Initialisiert
		Pinklasse pin1 = new Pinklasse(); //Variable für den alten pin
		pinAlt = pin1.initialisieren(1234); //PIN wird auf 1234 festgelegt
		Pinklasse pin2 = new Pinklasse(); //Variable für den Neuen Pin
		pinNeu = pin2.initialisieren(0); //Neuer PIN wird initialisiert damit man mit der Variable arbeiten kann
		
		/*
		 * HAUPTPROGRAMM
		 */
				
		//Schleife zur Kartenabfrage
		while (bankkarte == false) //Solange keine Karte vorhanden wird danach gefragt
		{	
				kartenEingabe = JOptionPane.showInputDialog(("Schreiben Sie 'Karte' um Ihre Bankkarte einzulegen!")); // Eingabe aufforderung
				if (kartenEingabe == null) //Das passiert wenn Abbrechen gedrückt wird
				{
					System.out.println("Sie haben das Programm beendet.");
					System.exit(0);
				}
				if (kartenEingabe.equalsIgnoreCase("Karte")) //Das passiert wenn Eingabe ist wie gefordert 
				{
					bankkarte = true; // Bankkarte ist vorhanden
				}
				else // Das passiert wenn Eingabe nicht ist wie gefordert
				{
					System.out.println("Bitte einfach nur 'Karte' schreiben."); 		
				}
		}
		//Pin wird 3 mal abgefragt
		for (int i=3; zaehlerFOR < i; zaehlerFOR ++)
		{	
			try //Try PIN Eingabe
			{
				String pinString = JOptionPane.showInputDialog("Geben Sie Ihren gültigen PIN ein!");//Eingabe des PIN
				if (pinString != null) //Das passiert wenn NICHT Abbrechen gedrückt wird
				{
					pinInteger = Integer.parseInt(pinString); //Einfrage wird in einen Integer umgewandelt 
				}
				else //Das passiert wenn Abbrechen gedrückt wird
				{
					System.out.println("\nSie haben das Programm beendet.");
					System.exit(0);
				}
			}
			//Catch PIN Eingabe
			catch (Exception e)//Falscheingabe wird abgefangen
			{
				System.out.println("Bitte nur Zahlen eingeben.");
			}
			
			if (pinInteger == pinAlt) //Das passiwert wenn der PIN richtig eingegeben wurde
			{
				//Begrüssung des Kunden
				System.out.println("\nWilkommen bei der Bank Ihres vertrauens!");
				//Auswahl der Handlungen
				System.out.println("1: Pin ändern");
				System.out.println("2: Geld abheben");
				System.out.println("3: Geld einzahlen");
				System.out.println("4: Geld wechseln");
				System.out.println("5: Kontostände Prüfen");
				//Try Switch
				try
				{	//Abfrage der auswahl was als nächstes getan werden soll
					switchEingabe = JOptionPane.showInputDialog("Was möchten Sie als nächstes tun?");
					if (switchEingabe != null) //Das passiert wenn der Abbrechen Button NICHT gedrückt wird
					{
						switchCase = Integer.parseInt(switchEingabe); //Eingabe wird in einen Integer umgewandelt
						if (switchCase < 1 || switchCase > 5) //Passiert wenn man eine ungültige Zahl eingibt
						{
							System.out.println("Bitte nur Zahlen von 1 bis 5 eingeben!");
						}
						
					}
					else //Das passiert wenn der Abbrechen Button gedrückt wird
					{
						System.out.println("\nSie haben das Programm beendet.");
						System.exit(0);
					}
				}
				//Catch Switch
				catch (Exception e)
				{
					System.out.println("Bitte nur Zahlen von 1 bis 5 eingeben!");
				}
				//Nach der Eingabevaledierung wird entschieden was passiert
				switch(switchCase) 
				{
				case 1://Pin ändern wurde ausgewählt 
					//Try pinKontrolle
					try {
						pinKontrolle = JOptionPane.showInputDialog("Geben Sie zunächst zur Kontrolle Ihren alten Pin ein.");//Der PIN wird abgefragt
						if (pinKontrolle != null) //Das passiert wenn der Abbrechen Button NICHT gedrückt wird
						{
							pinEingabe = Integer.parseInt(pinKontrolle);	//Eingabe wird in einen Integer umgewandelt					
							if (pinEingabe == pinAlt) //Eingabe wird mit PIN verglichen
							{
								//TRY PIN Änderung
								pinEingabeNeu = JOptionPane.showInputDialog("Geben Sie nun den neuen Pin ein.");//Der neue PIN wird abgefragt
								if (pinEingabeNeu != null) //Das passiert wenn der Abbrechen Button NICHT gedrückt wird
								{	
									pinNeu = Integer.parseInt(pinEingabeNeu);//Eingabe wird in einen Integer umgewandelt
									pinBestaetigung = JOptionPane.showInputDialog("Geben Sie den PIN zur Bestätigung erneut ein.");//Der neue PIN wird erneut zur Kontrolle erneut abgefragt
									int pinKontrolleNeu = Integer.parseInt(pinBestaetigung); //Erneute Eingabe wird in einen Integer umgewandelt
									if (pinBestaetigung != null && pinNeu == pinKontrolleNeu) //Das passiert wenn der Abbrechen Button NICHT gedrückt wurde UND wenn die neuen PINs identisch sind
									{
										System.out.println("Ihr PIN wurde erfolgreich geändert.");
										pinAlt = pinNeu;//PIN wird geändert									
									}
									else //Das passiert wenn die neuen PINs nicht miteinander übereinstimmen
									{
										System.out.println("Die PINs stimmen nicht miteinander überein.");
										System.out.println("Versuchen Sie es erneut.");
									}
								}
							}
						}
						else //Das passiert wenn der Abbrechen Button gedrückt wird
						{
							System.out.println("\nSie haben das Programm beendet.");
							System.exit(0);							
						}
						}
					catch (Exception e) //Catch pinKontrolle
					{
						System.out.println("Sie haben Ihren PIN falsch eingegeben.");
						System.out.println("Bitte versuchen Sie es erneut.");
					}
						i ++; //Iteration von i
						break; //Verlassen des case
				case 2://Geld abheben wurde ausgewählt
					try//Try Geld abheben
					{	
						String abhebenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie abheben?"); //Abfrage wie viel geld Abgehoben werden soll
						if (abhebenEingabe != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wurde
						{
							int abheben = Integer.parseInt(abhebenEingabe);//Eingabe wird in einen Integer umgewandelt
							kontostandCHF = kontoCHF.abheben(abheben); //Neuer Kontostand wird berechnet
							System.out.println("Ihr neuer Kontostand lautet: " + kontostandCHF + ".- CHF");//Kontostand output
						}
						else //Das passiert wenn Abbrechen gedrückt wird
						{
							System.out.println("\nSie haben das Programm beendet.");
							System.exit(0);
						}
					}
					catch (Exception e) //Catch Geld abheben
					{
						System.out.println("Bitte geben Sie nur ganze Zahlen ein.");
					}
						
					i ++; //Iteration von i
					break; //Verlassen des case
				case 3://Geld einzahlen wurde ausgewählt 
					try//Try Geld einzahlen
					{
						String einzahlenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie einzahlen?"); //Abfrage wie viel geld Eingezahlt werden soll
						if (einzahlenEingabe != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wurde
						{
							einzahlen = Integer.parseInt(einzahlenEingabe);//Eingabe wird in einen Integer umgewandelt
							kontostandCHF = kontoCHF.einzahlen(einzahlen); //Neuer Kontostand wird berechnet
							System.out.println("Ihr neuer Kontostand lautet: " + kontostandCHF + ".- CHF"); //Kontostand output
						}
						else//Das passiert wenn Abbrechen gedrückt wird
						{
							System.out.println("\nSie haben das Programm beendet.");
							System.exit(0);
						}
					}
					catch (Exception e)//Catch Geld einzahlen
					{
						System.out.println("Bitte geben Sie nur den Betrag ein, den Sie einzahlen möchten.");
					}
					i ++; //Iteration von i
					break; //Verlassen des case
				case 4://Geld wechseln wurde ausgewählt
					System.out.println("Sie wollen Geld wechseln");
					System.out.println("Diese Funktion steht noch nicht zur Verfügung.");
					i ++; //Iteration von i
					break; //Verlassen des case
				case 5://Kontostand anzeigen wurde ausgewählt
					System.out.println("Ihr aktueller Kontostand lautet: " + kontostandCHF + ".- CHF");
					System.out.println("Ihr aktueller Kontostand lautet: " + kontostandEUR + ".- EUR");
					System.out.println("Ihr aktueller Kontostand lautet: " + kontostandUSD + ".- USD");
					i ++; //Iteration von i
					break; //Verlassen des case
				default://Standardaktion bei ungültiger Eingabe 
					i ++; //Iteration von i
					break; //Verlassen des case
				}
			}
			else //Das passiert wenn der PIN falsch eingegeben wurde 
			{
				if (i - zaehlerFOR == 3) //Erste falsche PIN Eingabe
				{
					System.out.println("Falscher PIN, bitte erneut versuchen.\n");
				}
				if (i - zaehlerFOR == 2)//Zweite falsche PIN Eingabe
				{
					System.out.println("ACHTUNG! Sie haben nur noch einen versuch!\n");
				}
				if (i - zaehlerFOR == 1)//Dritte falsche PIN Eingabe
				{
					System.out.println("PIN 3 mal falsch eingegeben, das System wird aus Sicherheitsgründen beendet!");
					System.exit(zaehlerFOR);
				}
			}
		}		
	}	
}
