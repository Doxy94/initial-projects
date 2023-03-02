package bankomatV2;

public class Kontoklasse {

	//Instanzvariable
	double konto;
	//Methode zum initialisieren
	double initialisieren(double standard) 
	{
		konto = standard;
		return konto;
	}
	//Methode zum Geld abheben
	double abheben(double eingabe)
	{
		if (konto >= eingabe)
		{
		konto = konto - eingabe;
		}
		else 
		{
			System.out.println("Sie haben nicht genügend Geld auf dem Konto.");
		}
		return konto;
	}
	//Methode zum Geld einzahlen
	double einzahlen(double eingabe)
	{	
		if (eingabe > 5000)
		{
			System.out.println("Für eine Einzahlung über 5.000 CHF müssen Sie einen Termin in der Filiale vereinbaren.");
		}
		else 
		{
			System.out.println("Ihr Geld wurde erfolgreich eingezahlt.");
		}
		return konto = konto + eingabe;
	}

	//Geldwechselmethode von CHF auf EUR
	static double CHFzuEUR(double eingabe) {
		final double wechselkurs = 1.01;
		eingabe *= wechselkurs;
		return eingabe;
	}
	//Geldwechselmethode von CHF auf USD
	static double CHFzuUSD(double eingabe) {
		final double wechselkurs = 1.08;
		eingabe *= wechselkurs;
		return eingabe;
	}
	//Geldwechselmethode von USD auf CHF
	static double USDzuCHF(double eingabe) {
		final double wechselkurs = 0.92;
		eingabe *= wechselkurs;
		return eingabe;
	}
	//Geldwechselmethode von USD auf EUR
	static double USDzuEUR(double eingabe) {
		final double wechselkurs = 0.93;
		eingabe *= wechselkurs;
		return eingabe;
	}
	//Geldwechselmethode von EUR zu CHF
	static double EURzuCHF(double eingabe) {
		final double wechselkurs = 1.06;
		eingabe *= wechselkurs;
		return eingabe;
	}
	//Geldwechselmethode von EUR zu USD
	static double EURzuUSD(double eingabe) {
		final double wechselkurs = 0.98;
		eingabe *= wechselkurs;
		return eingabe;
	}
	
//Main Methode dient nur zum Testen der obigen Methoden	
public static void main(String []args) {
	
	}
}
