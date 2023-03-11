//package bankomatV2;
//
//import javax.swing.JOptionPane;
//	
//public class Pinklasse {
//	
//	//Instantvariable
//	static int pin;
//	//Methode zum initialisieren
//	int set(int pin){ 
//		
//		return pin;
//	}
//	//Methode zum ändern
//	int aendern(int pin){
//		try {
//			String pinKontrolle = JOptionPane.showInputDialog("Geben Sie zunächst zur Kontrolle Ihren alten PIN ein.");
//			if (pinKontrolle != null) {
//				System.out.println("test");
//			}
//			}
//		catch (NumberFormatException e) {
//			System.out.println("test");
//		}
//		return pin;
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		boolean pinGeaendert = false;
//		
//		
//		if (pinGeaendert == false) //Kontrolliert ob der Pin schon einmal geändert wurde
//		{
//			//Try pinKontrolleAlt
//			try {
//				String pinKontrolleAlt = JOptionPane.showInputDialog("Geben Sie zunächst zur Kontrolle Ihren alten Pin ein.");
//				if (pinKontrolleAlt != null) {
//					int pinEingabeAlt = Integer.parseInt(pinKontrolleAlt);
//					if (pinEingabeAlt == pin) {
//						pinEingabeNeu = JOptionPane.showInputDialog("Geben Sie nun den neuen Pin ein. \nDer PIN muss 4 bis 6 Ziffern enthalten.");
//						pinNeu = Integer.parseInt(pinEingabeNeu);
//						if (pinEingabeNeu != null) {	
//							if (pinEingabeNeu.length() > 3 && pinEingabeNeu.length() < 7){
//								pinBestaetigungNeu = JOptionPane.showInputDialog("Geben Sie den PIN zur Bestätigung erneut ein.");
//								int pinKontrolleNeu = Integer.parseInt(pinBestaetigungNeu); 
//								if (pinBestaetigungNeu != null && pinNeu == pinKontrolleNeu){
//									System.out.println("Ihr PIN wurde erfolgreich geändert.");
//									pinAlt = pin1.aendern(pinNeu);
//									pinGeaendert = true;
//								}
//								else {
//									System.out.println("Die PINs stimmen nicht miteinander überein.");
//									System.out.println("Versuchen Sie es erneut.");
//								}
//							}
//							else{
//								System.out.println("Die PIN muss zwichen 4 und 6 Zahlen enthalten. Versuchen Sie es nach der Anmeldung erneut.");
//							}
//						}
//					}
//				}
//				else {
//					System.out.println("\nSie haben das Programm beendet.");
//					System.exit(0);							
//				}
//				}
//			//Catch pinKontrolleAlt
//			catch (Exception e) {
//				System.out.println("Sie haben einen ungültigen PIN eingegeben.");
//				System.out.println("Bitte versuchen Sie es erneut.");
//			}
//		}
//		else{
//			System.out.println("Sie können den PIN nur einmal alle 7 Tage ändern.");
//		}
//		
//
//	}
//
//}
