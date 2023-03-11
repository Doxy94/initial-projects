package bankomatV2;

public class Kontoklasse {

	final private static double CHF_ZU_USD = 1.08;
	final private static double CHF_ZU_EUR = 1.01;
	final private static double USD_ZU_CHF = 0.92; 
	final private static double USD_ZU_EUR = 0.93;
	final private static double EUR_ZU_USD = 1.06; 
	final private static double EUR_ZU_CHF = 0.98;
	
	//Instanzvariable
	double konto;
	
	//Methode zum wechseln von CHF auf USD
	public static double CHFUSD(double konto) {
		konto = konto * CHF_ZU_USD;
		return konto;
	}
	//Methode zum wechseln von CHF auf EUR
	public static double CHFEUR(double konto) {
		konto = konto * CHF_ZU_EUR;
		return konto;
	}
	//Methode zum wechseln von USD auf CHF
	public static double USDCHF(double konto) {
		konto = konto * USD_ZU_CHF;
		return konto;
	}
	//Methode zum wechseln von USD auf EUR
	public static double USDEUR(double konto) {
		konto = konto * USD_ZU_EUR;
		return konto;
	}
	//Methode zum wechseln von EUR auf USD
	public static double EURUSD(double konto) {
		konto = konto * EUR_ZU_USD;
		return konto;
	}
	//Methode zum wechseln von EUR auf CHF
	public static double EURCHF(double konto) {
		konto = konto * EUR_ZU_CHF;
		return konto;
	}
	
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

