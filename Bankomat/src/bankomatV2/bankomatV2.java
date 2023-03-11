package bankomatV2;
import javax.swing.JOptionPane;

//Klasse für die PIN
class Pinklasse 
{
	//InstanZvariable
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

public class bankomatV2 {
	public static void main (String[] args) {	
		
		/***********
		 *Variablen*
		 ***********/
		
		//Variablen werden deklariert
		boolean bankkarte,pinGeaendert; 
		String kartenEingabe,switchEingabe,pinEingabe,pinKontrolleAlt,pinEingabeNeu,pinBestaetigungNeu,abhebenEingabe,einzahlenEingabe;
		String chfUSD,chfEUR,usdEUR,usdCHF,eurCHF,eurUSD; //Anpassen mit Methodenaufrufen von Kontoklasse
		int pinAlt,pinNeu,pinKontrolle,zaehlerFOR,switchCase,switchGeldWechseln,switchHandel;
		
		//Integers
		pinKontrolle = 0;
		zaehlerFOR = 0;
		switchCase = 0;
		switchGeldWechseln = 0;
		switchHandel = 0;
		
		//Boolische Variablen
		bankkarte = false;
		pinGeaendert = false;
		
		/**************
		 *Wechselkurse*
		 **************/
		//Franken
		final double CHF_ZU_USD = 1.08;
		final double CHF_ZU_EUR = 1.01;
		//Dollar
		final double USD_ZU_CHF = 0.92; 
		final double USD_ZU_EUR = 0.93;
		//Euro
		final double EUR_ZU_USD = 1.06; 
		final double EUR_ZU_CHF = 0.98;
		
		//Hier werden neue Bankkonten erstellt
		Kontoklasse kontoCHF = new Kontoklasse();
		Kontoklasse kontoEUR = new Kontoklasse();
		Kontoklasse kontoUSD = new Kontoklasse();
		double kontostandCHF = kontoCHF.initialisieren(1000);
		double kontostandEUR = kontoEUR.initialisieren(1000);
		double kontostandUSD = kontoUSD.initialisieren(1000);
		
		//PIN wird erstellt und Initialisiert
		Pinklasse pin1 = new Pinklasse(); 
		pinAlt = pin1.initialisieren(1234); 
		
		/***************
		 *HAUPTPROGRAMM*
		 ***************/
				
		//Schleife zur Kartenabfrage
		while (bankkarte == false) {	
				kartenEingabe = JOptionPane.showInputDialog("Schreiben Sie 'Karte' um Ihre Bankkarte einzulegen!"); 
				if (kartenEingabe != null) {
					if (kartenEingabe.equalsIgnoreCase("Karte")) {
					bankkarte = true; 
					//Begrüssung des Kunden + Auswahl der Handlungen
					System.out.println("\nWilkommen bei der Bank Ihres vertrauens!");
					System.out.println("Ihnen stehen 3 verschiedene Konten mit 3 verschiedenen Währungen zur Verfügung: \nFranken \nDollar \nEuro");
					}
					else{
						System.out.println("Bitte einfach nur 'Karte' schreiben."); 
					}
				}
				else {
					System.out.println("Sie haben das Programm beendet.");
					System.exit(0);
				}
		}
		//Pin wird abgefragt (3 Versuche)
		for (int i=3; zaehlerFOR < i; zaehlerFOR ++){	
			//Try pinEingabe
			try {
				pinEingabe = JOptionPane.showInputDialog("Geben Sie Ihren gültigen PIN ein!"); 
				if (pinEingabe != null) {
					pinKontrolle = Integer.parseInt(pinEingabe); 
				}
				else {
					System.out.println("\nSie haben das Programm beendet.");
					System.exit(0);
				}
			}
			//Catch pinEingabe
			catch (NumberFormatException e){
				System.out.println("Bitte nur Zahlen eingeben.");
			}			
			if (pinKontrolle == pinAlt){
				//Auswahl der möglichen Aktionen
				System.out.println("1: Pin ändern");
				System.out.println("2: Geld abheben (nur CHF)");
				System.out.println("3: Geld einzahlen (nur CHF)");
				System.out.println("4: Geld wechseln (CHF/USD/EUR)");
				System.out.println("5: Kontostände Prüfen");
				//Try switchEingabe
				try
				{	//Abfrage der Auswahl, was als nächstes passieren soll
					switchEingabe = JOptionPane.showInputDialog("Was möchten Sie als nächstes tun? (1-5)");
					if (switchEingabe != null) {
						switchCase = Integer.parseInt(switchEingabe); 
						if (switchCase < 1 || switchCase > 5) {
							System.out.println("Bitte nur Zahlen von 1 bis 5 eingeben!");
						}
					}
					else {
						System.out.println("\nSie haben das Programm beendet.");
						System.exit(0);
					}
				}
				//Catch switchEingabe
				catch (NumberFormatException e){
					System.out.println("Bitte nur Zahlen von 1 bis 5 eingeben!");
				}
				switch(switchCase) {
				//Pin ändern wurde ausgewählt 
				case 1:
					if (pinGeaendert == false) //Kontrolliert ob der Pin schon einmal geändert wurde
					{
						//Try pinKontrolleAlt
						try {
							pinKontrolleAlt = JOptionPane.showInputDialog("Geben Sie zunächst zur Kontrolle Ihren alten Pin ein.");
							if (pinKontrolleAlt != null) {
								int pinEingabeAlt = Integer.parseInt(pinKontrolleAlt);
								if (pinEingabeAlt == pinAlt) {
									pinEingabeNeu = JOptionPane.showInputDialog("Geben Sie nun den neuen Pin ein. \nDer PIN muss 4 bis 6 Ziffern enthalten.");
									pinNeu = Integer.parseInt(pinEingabeNeu);
									if (pinEingabeNeu != null) {	
										if (pinEingabeNeu.length() > 3 && pinEingabeNeu.length() < 7){
											pinBestaetigungNeu = JOptionPane.showInputDialog("Geben Sie den PIN zur Bestätigung erneut ein.");
											int pinKontrolleNeu = Integer.parseInt(pinBestaetigungNeu); 
											if (pinBestaetigungNeu != null && pinNeu == pinKontrolleNeu){
												System.out.println("Ihr PIN wurde erfolgreich geändert.");
												pinAlt = pin1.aendern(pinNeu);
												pinGeaendert = true;
											}
											else {
												System.out.println("Die PINs stimmen nicht miteinander überein.");
												System.out.println("Versuchen Sie es erneut.");
											}
										}
										else{
											System.out.println("Die PIN muss zwichen 4 und 6 Zahlen enthalten. Versuchen Sie es nach der Anmeldung erneut.");
										}
									}
								}
							}
							else {
								System.out.println("\nSie haben das Programm beendet.");
								System.exit(0);							
							}
							}
						//Catch pinKontrolleAlt
						catch (NumberFormatException e) {
							System.out.println("Sie haben einen ungültigen PIN eingegeben.");
							System.out.println("Bitte versuchen Sie es erneut.");
						}
					}
					else{
						System.out.println("Sie können den PIN nur einmal alle 7 Tage ändern.");
					}
						i ++; 
						break;
				//Geld abheben wurde ausgewählt
				case 2:
					//Try abhebenEingabe
					try{	
						abhebenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie abheben?"); 
						if (abhebenEingabe != null){
							int abheben = Integer.parseInt(abhebenEingabe);
							kontostandCHF = kontoCHF.abheben(abheben); 
							System.out.println("Ihr Kontostand lautet: " + String.format("%1$,.2f", kontostandCHF) + ".- CHF");
						}
						else {
							System.out.println("\nSie haben das Programm beendet.");
							System.exit(0);
						}
					}
					//Catch abhebenEingabe
					catch (NumberFormatException e){
						System.out.println("Ungültige Eingabe, bitte erneut versuchen.");
					}
					i ++;
					break;
				//Geld einzahlen wurde ausgewählt 
				case 3:
					//Try einzahlenEingabe
					try{
						einzahlenEingabe = JOptionPane.showInputDialog("Wie viel Geld möchten Sie einzahlen?"); 
						if (einzahlenEingabe != null){
							int einzahlen = Integer.parseInt(einzahlenEingabe);
							kontostandCHF = kontoCHF.einzahlen(einzahlen);
							System.out.println("Ihr Kontostand lautet: " + String.format("%1$,.2f", kontostandCHF) + ".- CHF"); 
						}
						else{
							System.out.println("\nSie haben das Programm beendet.");
							System.exit(0);
						}
					}
					//Catch einzahlenEingabe
					catch (NumberFormatException e){
						System.out.println("Ungültige Eingabe, bitte erneut versuchen.");
					}
					i ++;
					break;
				//Geld wechseln wurd ausgewählt	
				case 4:
					//Try switchEingabe
					try{	
						//Abfrage der Auswahl, welche Währung gehandelt werden soll
						switchEingabe = JOptionPane.showInputDialog("Wählen Sie zunächst die Währung aus, die Sie verkaufen möchten.\n1: CHF \n2: USD \n3: EUR");
						if (switchEingabe != null){
							switchGeldWechseln = Integer.parseInt(switchEingabe); 
							if (switchGeldWechseln < 1 || switchGeldWechseln > 3) {
								System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
							}					
						}
						else {
							System.out.println("\nSie haben das Programm beendet.");
							System.exit(0);
						}
					}
					//Catch switchEingabe
					catch (NumberFormatException e){
						System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
					}
					//Auswahl welche Währung man handeln möchte
					switch(switchGeldWechseln) 
					{	
						//CHF handeln
						case 1:
								//Try switchHandelEingabe
								try
								{	//Abfrage welche Währung gekauft werden soll
									String switchHandelEingabe = JOptionPane.showInputDialog("Wählen Sie als nächstes die Währung, die Sie kaufen möchten.\n1: USD\n2: EUR");
									if (switchHandelEingabe != null){
										switchHandel = Integer.parseInt(switchHandelEingabe); 
										if (switchHandel < 1 || switchHandel > 2) {
											System.out.println("Bitte nur Zahlen von 1 bis 2 eingeben!");
										}
									}
									else {
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);
									}
									switch(switchHandel) 
									{
									//Kauf USD für CHF
									case 1: 
										System.out.println("Sie haben Sich entschieden USD für CHF zu kaufen.");
										chfUSD = JOptionPane.showInputDialog("Wie viel CHF möchten Sie verkaufen?"); 
										if (chfUSD != null){
											double wechselCHFDouble = Double.parseDouble(chfUSD); 
											if (wechselCHFDouble > kontostandCHF) {
												System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
											}
											else{
												kontostandCHF = kontostandCHF - wechselCHFDouble; 
												kontostandUSD = kontostandUSD + wechselCHFDouble * CHF_ZU_USD; 
												System.out.println("Sie haben erfolgreich " + wechselCHFDouble + " CHF verkauft und " + String.format("%1$,.2f", wechselCHFDouble * CHF_ZU_USD) + " USD gekauft."); 
												System.out.println("Ihre aktuellen Kontostände lauten: CHF: " + String.format("%1$,.2f", kontostandCHF) + "\tUSD: " + String.format("%1$,.2f", kontostandUSD)); 
											}
										}
										else {
											System.out.println("\nSie haben das Programm beendet.");
											System.exit(0);		
										}
										break; 
									//Kauf EUR für CHF
									case 2: 
										System.out.println("Sie haben Sich entschieden EUR für CHF zu kaufen.");
										chfEUR = JOptionPane.showInputDialog("Wie viel CHF möchten Sie verkaufen?");
										if (chfEUR != null){
											double wechselCHFDouble = Double.parseDouble(chfEUR);
											if (wechselCHFDouble > kontostandCHF){
												System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
											}
											else{
												kontostandCHF = kontostandCHF - wechselCHFDouble;
												kontostandEUR = kontostandEUR + wechselCHFDouble * CHF_ZU_EUR;
												System.out.println("Sie haben erfolgreich " + wechselCHFDouble + " CHF verkauft und " + String.format("%1$,.2f", wechselCHFDouble * CHF_ZU_EUR) + " EUR gekauft.");
												System.out.println("CHF: " + String.format("%1$,.2f", kontostandCHF) + "\tEUR: " + String.format("%1$,.2f", kontostandEUR));
											}
										}
										else{
											System.out.println("\nSie haben das Programm beendet.");
											System.exit(0);		
										}
										break; 
									}
								}
								//Catch switchHandelEingabe
								catch (NumberFormatException e){
									System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
								}
								break;
						//USD tauschen
						case 2:
							//Try switchHandelEingabe
							try{	
								String switchHandelEingabe = JOptionPane.showInputDialog("Wählen Sie als nächstes die Währung, die Sie kaufen möchten.\n1: CHF\n2: EUR");
								if (switchHandelEingabe != null){
									switchHandel = Integer.parseInt(switchHandelEingabe);
									if (switchHandel < 1 || switchHandel > 2) {
										System.out.println("Bitte nur Zahlen von 1 bis 2 eingeben!");
									}
								}
								else {
									System.out.println("\nSie haben das Programm beendet.");
									System.exit(0);
								}
								switch(switchHandel){
								//Kauf CHF für USD
								case 1: 
									System.out.println("Sie haben Sich entschieden CHF für USD zu kaufen.");
									usdCHF = JOptionPane.showInputDialog("Wie viel USD möchten Sie verkaufen?"); 
									if (usdCHF != null){
										double wechselUSDDouble = Double.parseDouble(usdCHF);
										if (wechselUSDDouble > kontostandUSD){
											System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
										}
										else{
											kontostandUSD = kontostandUSD - wechselUSDDouble;
											kontostandCHF = kontostandCHF + wechselUSDDouble * USD_ZU_CHF; 
											System.out.println("Sie haben erfolgreich " + wechselUSDDouble + " USD verkauft und " + String.format("%1$,.2f", wechselUSDDouble * USD_ZU_CHF) + " CHF gekauft.");
											System.out.println("USD: " + String.format("%1$,.2f", kontostandUSD) + "\tCHF: " + String.format("%1$,.2f", kontostandCHF));
										}
									}
									else {
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);		
									}
									break;
								//Kauf EUR für USD
								case 2: 
									System.out.println("Sie haben Sich entschieden EUR für USD zu kaufen.");
									usdEUR = JOptionPane.showInputDialog("Wie viel USD möchten Sie verkaufen?");
									if (usdEUR != null){
										double wechselUSDDouble = Double.parseDouble(usdEUR);
										if (wechselUSDDouble > kontostandCHF){
											System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
										}
										else{
											kontostandUSD = kontostandUSD - wechselUSDDouble;
											kontostandEUR = kontostandEUR + wechselUSDDouble * USD_ZU_EUR;
											System.out.println("Sie haben erfolgreich " + wechselUSDDouble + " USD verkauft und " + wechselUSDDouble * USD_ZU_EUR + " EUR gekauft.");
											System.out.println("USD: " + String.format("%1$,.2f", kontostandUSD) + "\tEUR: " + String.format("%1$,.2f", kontostandEUR));
										}
									}
									else{
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);		
									}
									break;
								}
							}
							//Catch switchHandelEingabe
							catch (NumberFormatException e){
								System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
							}
							break;
						//EUR tauschen		
						case 3:
							//Try switchHandelEingabe
							try{	
								String switchHandelEingabe = JOptionPane.showInputDialog("Wählen Sie als nächstes die Währung, die Sie kaufen möchten.\n1: CHF\n2: USD");
								if (switchHandelEingabe != null){
									switchHandel = Integer.parseInt(switchHandelEingabe);
									if (switchHandel < 1 || switchHandel > 2){
										System.out.println("Bitte nur Zahlen von 1 bis 2 eingeben!");
									}
								}
								else {
									System.out.println("\nSie haben das Programm beendet.");
									System.exit(0);
								}
								switch(switchHandel){
								//Kauf CHF für EUR
								case 1: 
									System.out.println("Sie haben Sich entschieden CHF für EUR zu kaufen.");
									eurCHF = JOptionPane.showInputDialog("Wie viel EUR möchten Sie verkaufen?");
									if (eurCHF != null){
										double wechselEURDouble = Double.parseDouble(eurCHF);
										if (wechselEURDouble > kontostandCHF){
											System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
										}
										else{
											kontostandEUR = kontostandEUR - wechselEURDouble;
											kontostandCHF = kontostandCHF + wechselEURDouble * EUR_ZU_CHF;
											System.out.println("Sie haben erfolgreich " + wechselEURDouble + " EUR verkauft und " + wechselEURDouble * EUR_ZU_CHF + " CHF gekauft.");
											System.out.println("EUR: " + String.format("%1$,.2f", kontostandEUR) + "\tCHF: " + String.format("%1$,.2f", kontostandCHF));
										}
									}
									else {
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);		
									}
									break;
								//Kauf USD für EUR
								case 2: 
									System.out.println("Sie haben Sich entschieden USD für EUR zu kaufen.");
									eurUSD = JOptionPane.showInputDialog("Wie viel EUR möchten Sie verkaufen?");
									if (eurUSD != null){
										double wechselEURDouble = Double.parseDouble(eurUSD);
										if (wechselEURDouble > kontostandCHF){
											System.out.println("Sie können nicht mehr Geld handeln, als auf Ihrem Konto vorhanden ist.");
										}
										else{
											kontostandEUR = kontostandEUR - wechselEURDouble;
											kontostandUSD = kontostandUSD + wechselEURDouble * EUR_ZU_USD;
											System.out.println("Sie haben erfolgreich " + wechselEURDouble + " EUR verkauft und " + wechselEURDouble * EUR_ZU_USD + " USD gekauft.");
											System.out.println("EUR: " + String.format("%1$,.2f", kontostandEUR) + "\tUSD: " + String.format("%1$,.2f", kontostandUSD));
										}
									}
									else{
										System.out.println("\nSie haben das Programm beendet.");
										System.exit(0);		
									}
									break;
								}
							}
							//Catch switchHandelEingabe
							catch (NumberFormatException e){
								System.out.println("Bitte nur Zahlen von 1 bis 3 eingeben!");
							}
							break; 
					}
					i ++; 
					break;
				//Kontostand anzeigen wurde ausgewählt
				case 5:
					System.out.println("Ihr aktueller Kontostand lautet: " + String.format("%1$,.2f", kontostandCHF) + ".- CHF.");
					System.out.println("Ihr aktueller Kontostand lautet: " + String.format("%1$,.2f", kontostandEUR) + ".- EUR.");
					System.out.println("Ihr aktueller Kontostand lautet: " + String.format("%1$,.2f", kontostandUSD) + ".- USD.");
					i ++; 
					break;
				}
			}
			else {
				if (i - zaehlerFOR == 3){
					System.out.println("Falscher PIN, bitte erneut versuchen.\n");
				}
				if (i - zaehlerFOR == 2){
					System.out.println("ACHTUNG! Sie haben nur noch einen versuch!\n");
				}
				if (i - zaehlerFOR == 1){
					System.out.println("PIN 3 mal falsch eingegeben, das System wird aus Sicherheitsgründen beendet!");
					System.exit(zaehlerFOR);
				}
			}
		}		
	}	
}