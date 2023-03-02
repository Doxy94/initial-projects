package bankomatV2;
import javax.swing.JOptionPane;

public class Hauptklasse {
	public static void main (String[] args) {	
		
		/*######################
		 #Variablen und Klassen#
		 #######################*/
		
		//Variablen werden deklariert
		boolean bankkarte,pinGeaendert; //Bedingungen
		String kartenEingabe,switchEingabe;	//Alle Eingaben
		int pinAlt,pinNeu,pinKontrolle,zaehlerFOR,switchCase,switchGeldWechseln,switchHandel,abhebenFix;
		
		//Integers
		pinKontrolle = 0;
		zaehlerFOR = 0;
		switchCase = 0;
		switchGeldWechseln = 0;
		switchHandel = 0;
		bankkarte = false;
		pinGeaendert = false;
		
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
		
		/*##############
		 #HAUPTPROGRAMM#
		 ###############*/
				
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
				String pinEingabe = JOptionPane.showInputDialog("Geben Sie Ihren gültigen PIN ein!"); //Eingabe des PIN
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
				{	

					//Abfrage der auswahl was als nächstes getan werden soll
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
							String pinKontrolleAlt = JOptionPane.showInputDialog("Geben Sie zunächst zur Kontrolle Ihren alten Pin ein.");//Der PIN wird abgefragt
							if (pinKontrolleAlt != null) //Das passiert wenn der Abbrechen Button NICHT gedrückt wird
							{
								int pinEingabeAlt = Integer.parseInt(pinKontrolleAlt);	//Eingabe wird in einen Integer umgewandelt					
								if (pinEingabeAlt == pinAlt) //Eingabe wird mit PIN verglichen
								{
									String pinEingabeNeu = JOptionPane.showInputDialog("Geben Sie nun den neuen Pin ein. \nDer PIN muss 4 bis 6 Ziffern enthalten.");//Der neue PIN wird abgefragt
									pinNeu = Integer.parseInt(pinEingabeNeu);//Eingabe wird in einen Integer umgewandelt
									if (pinEingabeNeu != null) //Das passiert wenn der Abbrechen Button NICHT gedrückt wird
									{	
										if (pinEingabeNeu.length() > 3 && pinEingabeNeu.length() < 7)//Anzahl der eingegebenen Ziffern wird überprüft
										{
											String pinBestaetigungNeu = JOptionPane.showInputDialog("Geben Sie den PIN zur Bestätigung erneut ein.");//Der neue PIN wird erneut zur Kontrolle erneut abgefragt
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
//						//Auswahl wie viel man abheben möchte
//						System.out.println("Wählen Sie, wie viel Sie abheben möchten:");
//						System.out.println("50 CHF\t\t100 CHF");
//						System.out.println("150 CHF\t\t200 CHF");
//						System.out.println("250 CHF\t\t500 CHF");
						String abhebenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie abheben?"); //Abfrage wie viel geld Abgehoben werden soll
						if (abhebenEingabe != null)//Das passiert wenn der Abbrechen Button NICHT gedrückt wurde
						{
							int abheben = Integer.parseInt(abhebenEingabe);//Eingabe wird in einen Integer umgewandelt
							kontostandCHF = kontoCHF.abheben(abheben); //Neuer Kontostand wird berechnet
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
						String einzahlenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie einzahlen?"); //Abfrage wie viel geld Eingezahlt werden soll
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
										String chfUSD = JOptionPane.showInputDialog("Wie viel CHF möchten Sie verkaufen?"); //Abfrage wie viel CHF verkauft werden sollen
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
												kontostandUSD = kontostandUSD + Kontoklasse.CHFzuUSD(wechselCHFDouble); // USD werden gekauft
												System.out.println("Sie haben erfolgreich " + String.format("%1$,.2f", wechselCHFDouble) + " CHF verkauft und " + String.format("%1$,.2f", Kontoklasse.CHFzuUSD(wechselCHFDouble)) + " USD gekauft."); //Bestätigung des handels
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
										String chfEUR = JOptionPane.showInputDialog("Wie viel CHF möchten Sie verkaufen?"); //Abfrage wie viel CHF verkauft werden sollen
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
												kontostandEUR = kontostandEUR + Kontoklasse.CHFzuEUR(wechselCHFDouble);// EUR werden gekauft
												System.out.println("Sie haben erfolgreich " + String.format("%1$,.2f", wechselCHFDouble) + " CHF verkauft und " + String.format("%1$,.2f", Kontoklasse.CHFzuEUR(wechselCHFDouble)) + " EUR gekauft.");//Bestätigung des handels
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
									String usdCHF = JOptionPane.showInputDialog("Wie viel USD möchten Sie verkaufen?"); //Abfrage wie viel USD verkauft werden sollen
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
											kontostandCHF = kontostandCHF + Kontoklasse.USDzuCHF(wechselUSDDouble); //CHF werden gekauft
											System.out.println("Sie haben erfolgreich " + String.format("%1$,.2f", wechselUSDDouble) + " USD verkauft und " + String.format("%1$,.2f", Kontoklasse.USDzuCHF(wechselUSDDouble)) + " CHF gekauft."); //Bestätigung des Handels
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
									String usdEUR = JOptionPane.showInputDialog("Wie viel USD möchten Sie verkaufen?");//Abfrage wie viel USD verkauft werden sollen
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
											kontostandEUR = kontostandEUR + Kontoklasse.USDzuEUR(wechselUSDDouble);//EUR werden gekauft
											System.out.println("Sie haben erfolgreich " + String.format("%1$,.2f", wechselUSDDouble) + " USD verkauft und " + String.format("%1$,.2f", Kontoklasse.USDzuEUR(wechselUSDDouble)) + " EUR gekauft.");//Bestätigung des Handels
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
									String eurCHF = JOptionPane.showInputDialog("Wie viel EUR möchten Sie verkaufen?");//Abfrage wie viel EUR verkauft werden sollen
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
											kontostandCHF = kontostandCHF + Kontoklasse.EURzuCHF(wechselEURDouble);//CHF werden gekauft
											System.out.println("Sie haben erfolgreich " + String.format("%1$,.2f", wechselEURDouble) + " EUR verkauft und " + String.format("%1$,.2f", Kontoklasse.EURzuCHF(wechselEURDouble)) + " CHF gekauft.");//Bestätigung des Handels
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
									String eurUSD = JOptionPane.showInputDialog("Wie viel EUR möchten Sie verkaufen?");//Abfrage wie viel EUR verkauft werden sollen
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
											kontostandUSD = kontostandUSD + Kontoklasse.EURzuUSD(wechselEURDouble);//USD werden verkauft
											System.out.println("Sie haben erfolgreich " + String.format("%1$,.2f", wechselEURDouble) + " EUR verkauft und " + String.format("%1$,.2f", Kontoklasse.EURzuUSD(wechselEURDouble)) + " USD gekauft.");//Bestätigung des Handels
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