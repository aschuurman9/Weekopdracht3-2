package weekopdracht3;

public class Ladderklimmen extends Attractie implements GokAttractie {

	public Ladderklimmen(String naam, double prijs) {
		naamAttractie = naam;
		this.prijs = prijs;
	}

	public double kansSpelBelastingReserveren(GokAttractie a) {
		double kansSpelBelasting = (((Attractie) a).omzetAtrractieBerekenen((Attractie) a) / 100) * 30;
		System.out.printf("kansspelbelasting reserveren ladderklimmen: %.2f\n" , kansSpelBelasting);
		return kansSpelBelasting;
	}

}