package bankomatV2;
import javax.swing.JOptionPane;

//Klasse für die PIN
class Pinklasse 
{
	//Instantvariable
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

//Klasse für die Konten
class Kontoklasse 
{
	//Instanzvariable
	double konto;
	//Methode zum initialisieren
	double initialisieren(double standard) 
	{
		konto = standard;
		return konto;
	}
	//Methode zum Geld abheben
	double abheben(double aenderung)
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
	double einzahlen(double aenderung)
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
		
		/***********************
		 *Variablen und Klassen*
		 ***********************/
		
		//Variablen werden deklariert
		boolean bankkarte,pinGeaendert; 
		String kartenEingabe,switchEingabe,pinEingabe,pinKontrolleAlt,pinEingabeNeu,pinBestaetigungNeu,abhebenEingabe,einzahlenEingabe;
		String chfUSD,chfEUR,usdEUR,usdCHF,eurCHF,eurUSD;
		int pinAlt,pinNeu,pinKontrolle,zaehlerFOR,switchCase,switchGeldWechseln,switchHandel;
		
		//Integers
		pinKontrolle = 0;
		zaehlerFOR = 0;
		switchCase = 0;
		switchGeldWechseln = 0;
		switchHandel = 0;
		//Boolische variablen
		bankkarte = false;
		pinGeaendert = false;
		
		//Wechselkurse deklariert
		final double CHF_ZU_USD;
		final double CHF_ZU_EUR;
		final double USD_ZU_CHF; 
		final double USD_ZU_EUR; 
		final double EUR_ZU_USD; 
		final double EUR_ZU_CHF;
		//Wechselkurs Franken
		CHF_ZU_USD = 1.08;
		CHF_ZU_EUR = 1.01;
		//Wechselkurs Dollar
		USD_ZU_CHF = 0.92;
		USD_ZU_EUR = 0.93;
		//Wechselkurs Euro
		EUR_ZU_USD = 1.06;
		EUR_ZU_CHF = 0.98;
		
		//Hier werden neue Bankkonten erstellt
		Kontoklasse kontoCHF = new Kontoklasse();//Neues Konto für CHF wurde erstellt
		double kontostandCHF = kontoCHF.initialisieren(1000);//Neues Konto wurde mit 1000CHF initialisiert
		
		Kontoklasse kontoEUR = new Kontoklasse();//Neues Konto für EURO wurde erstellt
		double kontostandEUR = kontoEUR.initialisieren(1000);//Neues Konto wurde mit 1000EUR initialisiert
		
		Kontoklasse kontoUSD = new Kontoklasse();//Neues Konto für USD wurde erstellt
		double kontostandUSD = kontoUSD.initialisieren(1000);//Neues Konto wurde mit 1000USD initialisiert
		
		//Hier werden die PINs erstellt und Initialisiert
		Pinklasse pin1 = new Pinklasse(); //Variable für den alten pin
		pinAlt = pin1.initialisieren(1234); //PIN wird auf 1234 festgelegt
//		Pinklasse pin2 = new Pinklasse(); //Variable für den Neuen Pin
//		pinNeu = pin2.initialisieren(0); //Neuer PIN wird initialisiert damit man mit der Variable arbeiten kann
//		
		/***************
		 *HAUPTPROGRAMM*
		 ***************/
				
		//Schleife zur Kartenabfrage
		while (bankkarte == false) //Solange keine Karte vorhanden wird danach gefragt
		{	
				kartenEingabe = JOptionPane.showInputDialog(("Schreiben Sie 'Karte' um Ihre Bankkarte einzulegen!")); //Eingabeaufforderung
				if (kartenEingabe == null) //Das passiert, wenn Abbrechen gedrückt wird
				{
					System.out.println("Sie haben das Programm beendet.");
					System.exit(0);
				}
				if (kartenEingabe.equalsIgnoreCase("Karte")) //Das passiert wenn Eingabe ist wie gefordert 
				{
					bankkarte = true; //Bankkarte ist vorhanden
				}
				else //Das passiert wenn Eingabe nicht ist wie gefordert
				{
					System.out.println("Bitte einfach nur 'Karte' schreiben."); 		
				}
		}
		//Pin wird 3 mal abgefragt
		for (int i=3; zaehlerFOR < i; zaehlerFOR ++)
		{	
			try //Try PIN Eingabe
			{
				pinEingabe = JOptionPane.showInputDialog("Geben Sie Ihren gültigen PIN ein!"); //Eingabe des PIN
				if (pinEingabe != null) //Das passiert wenn NICHT Abbrechen gedrückt wird
				{
					pinKontrolle = Integer.parseInt(pinEingabe); //Einfrage wird in einen Integer umgewandelt 
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
			if (pinKontrolle == pinAlt) //Das passiwert wenn der PIN richtig eingegeben wurde
			{
				//Begrüssung des Kunden
				System.out.println("\nWilkommen bei der Bank Ihres vertrauens!");
				//Auswahl der Handlungen
				System.out.println("1: Pin ändern");
				System.out.println("2: Geld abheben (nur CHF)");
				System.out.println("3: Geld einzahlen (nur CHF)");
				System.out.println("4: Geld wechseln (CHF/USD/EUR)");
				System.out.println("5: Kontostände Prüfen");
				//Try Switch
				try
				{	//Abfrage der auswahl was als nächstes getan werden soll
					switchEingabe = JOptionPane.showInputDialog("Was möchten Sie als nächstes tun? (1-5)");
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
					if (pinGeaendert == false) //Kontrolliert ob der Pin schon einmal geändert wurde
					{
						//Try pinKontrolle
						try {
							pinKontrolleAlt = JOptionPane.showInputDialog("Geben Sie zunächst zur Kontrolle Ihren alten Pin ein.");//Der PIN wird abgefragt
							if (pinKontrolleAlt != null) //Das passiert wenn der Abbrechen Button NICHT gedrückt wird
							{
								int pinEingabeAlt = Integer.parseInt(pinKontrolleAlt);	//Eingabe wird in einen Integer umgewandelt					
								if (pinEingabeAlt == pinAlt) //Eingabe wird mit PIN verglichen
								{
									pinEingabeNeu = JOptionPane.showInputDialog("Geben Sie nun den neuen Pin ein. \nDer PIN muss 4 bis 6 Ziffern enthalten.");//Der neue PIN wird abgefragt
									pinNeu = Integer.parseInt(pinEingabeNeu);//Eingabe wird in einen Integer umgewandelt
									if (pinEingabeNeu != null) //Das passiert wenn der Abbrechen Button NICHT gedrückt wird
									{	
										if (pinEingabeNeu.length() > 3 && pinEingabeNeu.length() < 7)//Anzahl der eingegebenen Ziffern wird überprüft
										{
											pinBestaetigungNeu = JOptionPane.showInputDialog("Geben Sie den PIN zur Bestätigung erneut ein.");//Der neue PIN wird erneut zur Kontrolle erneut abgefragt
											int pinKontrolleNeu = Integer.parseInt(pinBestaetigungNeu); //Erneute Eingabe wird in einen Integer umgewandelt
											if (pinBestaetigungNeu != null && pinNeu == pinKontrolleNeu) //Das passiert wenn der Abbrechen Button NICHT gedrückt wurde UND wenn die neuen PINs identisch sind
											{
												System.out.println("Ihr PIN wurde erfolgreich geändert.");
												pinAlt = pin1.aendern(pinNeu);;//PIN wird geändert
												pinGeaendert = true;
											}
											else //Das passiert wenn die neuen PINs nicht miteinander übereinstimmen
											{
												System.out.println("Die PINs stimmen nicht miteinander überein.");
												System.out.println("Versuchen Sie es erneut.");
											}
										}
										else
										{
											System.out.println("Die PIN muss zwichen 4 und 6 Zahlen enthalten. Versuchen Sie es nach der Anmeldung erneut.");
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
							System.out.println("Sie haben einen ungültigen PIN eingegeben.");
							System.out.println("Bitte versuchen Sie es erneut.");
						}
					}
					else
					{
						System.out.println("Sie können den PIN nur einmal alle 7 Tage ändern.");
					}
						i ++; //Iteration von i
						break; //Verlassen des case
				case 2://Geld abheben wurde ausgewählt
					try//Try Geld abheben
					{	
						abhebenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie abheben?"); //Abfrage wie viel geld Abgehoben werden soll
						if (abhebenEingabe != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wurde
						{
							int abheben = Integer.parseInt(abhebenEingabe);//Eingabe wird in einen Integer umgewandelt
							kontostandCHF = kontoCHF.abheben(abheben); //Neuer Kontostand wird berechnet
							System.out.println("Ihr Kontostand lautet: " + String.format("%1$,.2f", kontostandCHF) + ".- CHF");//Kontostand output
						}
						else //Das passiert wenn Abbrechen gedrückt wird
						{
							System.out.println("\nSie haben das Programm beendet.");
							System.exit(0);
						}
					}
					catch (Exception e) //Catch Geld abheben
					{
						System.out.println("Ungültige Eingabe, bitte erneut versuchen.");
					}			
					i ++; //Iteration von i
					break; //Verlassen des case
				case 3://Geld einzahlen wurde ausgewählt 
					try//Try Geld einzahlen
					{
						einzahlenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie einzahlen?"); //Abfrage wie viel geld Eingezahlt werden soll
						if (einzahlenEingabe != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wurde
						{
							int einzahlen = Integer.parseInt(einzahlenEingabe);//Eingabe wird in einen Integer umgewandelt
							kontostandCHF = kontoCHF.einzahlen(einzahlen); //Neuer Kontostand wird berechnet
							System.out.println("Ihr Kontostand lautet: " + String.format("%1$,.2f", kontostandCHF) + ".- CHF"); //Kontostand output
						}
						else//Das passiert wenn Abbrechen gedrückt wird
						{
							System.out.println("\nSie haben das Programm beendet.");
							System.exit(0);
						}
					}
					catch (Exception e)//Catch Geld einzahlen
					{
						System.out.println("Ungültige Eingabe, bitte erneut versuchen.");
					}
					i ++; //Iteration von i
					break; //Verlassen des case
				case 4://Geld wechseln wurde ausgewählt
					try
					{	//Abfrage der Auswahl, welche Währung gehandelt werden soll
						switchEingabe = JOptionPane.showInputDialog("Wählen Sie zunächst die Währung aus, die Sie verkaufen möchten.\n1: CHF \n2: USD \n3: EUR");
						if (switchEingabe != null) //Das passiert wenn der Abbrechen Button NICHT gedrückt wird
						{
							switchGeldWechseln = Integer.parseInt(switchEingabe); //Eingabe wird in einen Integer umgewandelt
							if (switchGeldWechseln < 1 || switchGeldWechseln > 3) //Passiert wenn man eine ungültige Zahl eingibt
							{
								System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
							}					
						}
						else //Das passiert wenn der Abbrechen Button gedrückt wird
						{
							System.out.println("\nSie haben das Programm beendet.");
							System.exit(0);
						}
					}
					catch (Exception e)//Catch Switch
					{
						System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
					}
					switch(switchGeldWechseln) //Auswahl welche Währung man handeln möchte
					{	
						case 1://CHF handeln
								try
								{	//Abfrage welche Währung gekauft werden soll
									String switchHandelEingabe = JOptionPane.showInputDialog("Wählen Sie als nächstes die Währung, die Sie kaufen möchten.\n1: USD\n2: EUR");
									if (switchHandelEingabe != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wird
									{
										switchHandel = Integer.parseInt(switchHandelEingabe); //Eingabe wird in einen Integer umgewandelt
										if (switchHandel < 1 || switchHandel > 2) //Passiert wenn man eine ungültige Zahl eingibt
										{
											System.out.println("Bitte nur Zahlen von 1 bis 2 eingeben!");
										}
									}
									else //Das passiert wenn der Abbrechen Button gedrückt wird
									{
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);
									}
									switch(switchHandel) 
									{
									case 1: //Kauf USD für CHF
										System.out.println("Sie haben Sich entschieden USD für CHF zu kaufen.");
										chfUSD = JOptionPane.showInputDialog("Wie viel CHF möchten Sie verkaufen?"); //Abfrage wie viel CHF verkauft werden sollen
										if (chfUSD != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wird
										{
											double wechselCHFDouble = Double.parseDouble(chfUSD); //Eingabe wird in einen Double umgewandelt
											if (wechselCHFDouble > kontostandCHF) //Wird ausgeführt wenn Eingabe grösser als Kontostand ist
											{
												System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
											}
											else
											{
												kontostandCHF = kontostandCHF - wechselCHFDouble; //CHF werden verkauft
												kontostandUSD = kontostandUSD + wechselCHFDouble * CHF_ZU_USD; // USD werden gekauft
												System.out.println("Sie haben erfolgreich " + wechselCHFDouble + " CHF verkauft und " + String.format("%1$,.2f", wechselCHFDouble * CHF_ZU_USD) + " USD gekauft."); //Bestätigung des handels
												System.out.println("Ihre aktuellen Kontostände lauten: CHF: " + String.format("%1$,.2f", kontostandCHF) + "\tUSD: " + String.format("%1$,.2f", kontostandUSD)); //Kontostände ausgabe
											}
										}
										else //Das passiert wenn der Abbrechen Button gedrückt wird
										{
											System.out.println("\nSie haben das Programm beendet.");
											System.exit(0);		
										}
										break; //Verlassen des case
									case 2: //Kauf EUR für CHF
										System.out.println("Sie haben Sich entschieden EUR für CHF zu kaufen.");
										chfEUR = JOptionPane.showInputDialog("Wie viel CHF möchten Sie verkaufen?"); //Abfrage wie viel CHF verkauft werden sollen
										if (chfEUR != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wird
										{
											double wechselCHFDouble = Double.parseDouble(chfEUR);//Eingabe wird in einen Double umgewandelt
											if (wechselCHFDouble > kontostandCHF)//Wird ausgeführt wenn Eingabe grösser als Kontostand ist
											{
												System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
											}
											else
											{
												kontostandCHF = kontostandCHF - wechselCHFDouble;//CHF werden verkauft
												kontostandEUR = kontostandEUR + wechselCHFDouble * CHF_ZU_EUR;// EUR werden gekauft
												System.out.println("Sie haben erfolgreich " + wechselCHFDouble + " CHF verkauft und " + String.format("%1$,.2f", wechselCHFDouble * CHF_ZU_EUR) + " EUR gekauft.");//Bestätigung des handels
												System.out.println("CHF: " + String.format("%1$,.2f", kontostandCHF) + "\tEUR: " + String.format("%1$,.2f", kontostandEUR));//Kontostände ausgabe
											}
										}
										else //Das passiert wenn der Abbrechen Button gedrückt wird
										{
											System.out.println("\nSie haben das Programm beendet.");
											System.exit(0);		
										}
										break; //Verlassen des case
									}
								}
								catch (Exception e)//Catch Switch
								{
									System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
								}
								break; //Verlassen des case
						case 2://USD tauschen
							try
							{	//Abfrage welche Währung gekauft werden soll
								String switchHandelEingabe = JOptionPane.showInputDialog("Wählen Sie als nächstes die Währung, die Sie kaufen möchten.\n1: CHF\n2: EUR");
								if (switchHandelEingabe != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wird
								{
									switchHandel = Integer.parseInt(switchHandelEingabe); //Eingabe wird in einen Integer umgewandelt //EVENTUELL VOR DEM BREAK AUF 0 SETZEN
									if (switchHandel < 1 || switchHandel > 2) //Passiert wenn man eine ungültige Zahl eingibt
									{
										System.out.println("Bitte nur Zahlen von 1 bis 2 eingeben!");
									}
								}
								else //Das passiert wenn der Abbrechen Button gedrückt wird
								{
									System.out.println("\nSie haben das Programm beendet.");
									System.exit(0);
								}
								switch(switchHandel)
								{
								case 1: //Kauf CHF für USD
									System.out.println("Sie haben Sich entschieden CHF für USD zu kaufen.");
									usdCHF = JOptionPane.showInputDialog("Wie viel USD möchten Sie verkaufen?"); //Abfrage wie viel USD verkauft werden sollen
									if (usdCHF != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wird
									{
										double wechselUSDDouble = Double.parseDouble(usdCHF);//Eingabe wird in einen double umgewandelt
										if (wechselUSDDouble > kontostandUSD)//Wird ausgeführt wenn Eingabe grösser als Kontostand ist
										{
											System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
										}
										else
										{
											kontostandUSD = kontostandUSD - wechselUSDDouble;//USD werden verkauft
											kontostandCHF = kontostandCHF + wechselUSDDouble * USD_ZU_CHF; //CHF werden gekauft
											System.out.println("Sie haben erfolgreich " + wechselUSDDouble + " USD verkauft und " + String.format("%1$,.2f", wechselUSDDouble * USD_ZU_CHF) + " CHF gekauft."); //Bestätigung des Handels
											System.out.println("USD: " + String.format("%1$,.2f", kontostandUSD) + "\tCHF: " + String.format("%1$,.2f", kontostandCHF)); //Kontostände Ausgabe
										}
									}
									else //Das passiert wenn der Abbrechen Button gedrückt wird
									{
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);		
									}
									break;//Verlassen des case
								case 2: //Kauf EUR für USD
									System.out.println("Sie haben Sich entschieden EUR für USD zu kaufen.");
									usdEUR = JOptionPane.showInputDialog("Wie viel USD möchten Sie verkaufen?");//Abfrage wie viel USD verkauft werden sollen
									if (usdEUR != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wird
									{
										double wechselUSDDouble = Double.parseDouble(usdEUR);//Eingabe wird in einen double umgewandelt
										if (wechselUSDDouble > kontostandCHF)//Wird ausgeführt wenn Eingabe grösser als Kontostand ist
										{
											System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
										}
										else
										{
											kontostandUSD = kontostandUSD - wechselUSDDouble;//USD werden verkauft
											kontostandEUR = kontostandEUR + wechselUSDDouble * USD_ZU_EUR;//EUR werden gekauft
											System.out.println("Sie haben erfolgreich " + wechselUSDDouble + " USD verkauft und " + wechselUSDDouble * USD_ZU_EUR + " EUR gekauft.");//Bestätigung des Handels
											System.out.println("USD: " + String.format("%1$,.2f", kontostandUSD) + "\tEUR: " + String.format("%1$,.2f", kontostandEUR));//Kontostände Ausgabe
										}
									}
									else //Das passiert wenn der Abbrechen Button gedrückt wird
									{
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);		
									}
									break;//Verlassen des case
								}
							}
							catch (Exception e)//Catch Switch
							{
								System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
							}
							break; //Verlassen des case
						case 3://EUR tauschen
							try
							{	//Abfrage welche Währung gekauft werden soll
								String switchHandelEingabe = JOptionPane.showInputDialog("Wählen Sie als nächstes die Währung, die Sie kaufen möchten.\n1: CHF\n2: USD");
								if (switchHandelEingabe != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wird
								{
									switchHandel = Integer.parseInt(switchHandelEingabe); //Eingabe wird in einen Integer umgewandelt //EVENTUELL VOR DEM BREAK AUF 0 SETZEN
									if (switchHandel < 1 || switchHandel > 2) //Passiert wenn man eine ungültige Zahl eingibt
									{
										System.out.println("Bitte nur Zahlen von 1 bis 2 eingeben!");
									}
								}
								else //Das passiert wenn der Abbrechen Button gedrückt wird
								{
									System.out.println("\nSie haben das Programm beendet.");
									System.exit(0);
								}
								switch(switchHandel)
								{
								case 1: //Kauf CHF für EUR
									System.out.println("Sie haben Sich entschieden CHF für EUR zu kaufen.");
									eurCHF = JOptionPane.showInputDialog("Wie viel EUR möchten Sie verkaufen?");//Abfrage wie viel EUR verkauft werden sollen
									if (eurCHF != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wird
									{
										double wechselEURDouble = Double.parseDouble(eurCHF);//Eingabe wird in einen double umgewandelt
										if (wechselEURDouble > kontostandCHF)//Wird ausgeführt wenn Eingabe grösser als Kontostand ist
										{
											System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
										}
										else
										{
											kontostandEUR = kontostandEUR - wechselEURDouble;//EUR werden verkauft
											kontostandCHF = kontostandCHF + wechselEURDouble * EUR_ZU_CHF;//CHF werden gekauft
											System.out.println("Sie haben erfolgreich " + wechselEURDouble + " EUR verkauft und " + wechselEURDouble * EUR_ZU_CHF + " CHF gekauft.");//Bestätigung des Handels
											System.out.println("EUR: " + String.format("%1$,.2f", kontostandEUR) + "\tCHF: " + String.format("%1$,.2f", kontostandCHF));//Kontostände ausgabe
										}
									}
									else //Das passiert wenn der Abbrechen Button gedrückt wird
									{
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);		
									}
									break;//Verlassen des case
								case 2: //Kauf USD für EUR
									System.out.println("Sie haben Sich entschieden USD für EUR zu kaufen.");
									eurUSD = JOptionPane.showInputDialog("Wie viel EUR möchten Sie verkaufen?");//Abfrage wie viel EUR verkauft werden sollen
									if (eurUSD != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wird
									{
										double wechselEURDouble = Double.parseDouble(eurUSD);//Eingabe wird in einen double umgewandelt
										if (wechselEURDouble > kontostandCHF)//Wird ausgeführt wenn Eingabe grösser als Kontostand ist
										{
											System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
										}
										else
										{
											kontostandEUR = kontostandEUR - wechselEURDouble;//EUR werden verkauft
											kontostandUSD = kontostandUSD + wechselEURDouble * EUR_ZU_USD;//USD werden verkauft
											System.out.println("Sie haben erfolgreich " + wechselEURDouble + " EUR verkauft und " + wechselEURDouble * EUR_ZU_USD + " USD gekauft.");//Bestätigung des Handels
											System.out.println("EUR: " + String.format("%1$,.2f", kontostandEUR) + "\tUSD: " + String.format("%1$,.2f", kontostandUSD));//Kontostände ausgabe
										}
									}
									else //Das passiert wenn der Abbrechen Button gedrückt wird
									{
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);		
									}
									break;//Verlassen des case
								}
							}
							catch (Exception e)//Catch Switch
							{
								System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
							}
							break; //Verlassen des case
					}
					i ++; //Iteration von i
					break; //Verlassen des case
				case 5://Kontostand anzeigen wurde ausgewählt
					System.out.println("Ihr aktueller Kontostand lautet: " + String.format("%1$,.2f", kontostandCHF) + ".- CHF.");
					System.out.println("Ihr aktueller Kontostand lautet: " + String.format("%1$,.2f", kontostandEUR) + ".- EUR.");
					System.out.println("Ihr aktueller Kontostand lautet: " + String.format("%1$,.2f", kontostandUSD) + ".- USD.");
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