package weekopdracht3;

public abstract class Attractie {

	protected String naamAttractie;
	protected double prijs;
	private int oppervlakte;
	protected int aantalVerkochteKaartjesAttractie;
	protected static int aantalVerkochteKaartjesTotaal;
	private double omzetAttractie;

	public void draaien() throws OnderhoudNodigException {
		aantalVerkochteKaartjesAttractie = geefAantalVerkochteKaartjesAttractie() + 1;
		aantalVerkochteKaartjesTotaal++;
		System.out.println("De attractie " + naamAttractie + " draait.\n");
	}


	public double omzetAtrractieBerekenen(Attractie a) {
		omzetAttractie = (geefAantalVerkochteKaartjesAttractie() * prijs);
		// System.out.printf("De omzet voor de attractie %s is: %.2f \n", naamAttractie,
		// omzetAttractie);
		return omzetAttractie;
	}

	public int geefAantalVerkochteKaartjesAttractie() {
		return aantalVerkochteKaartjesAttractie;
	}

	public int geefAantalVerkochteKaartjeTotaal() {
		return aantalVerkochteKaartjesTotaal;
	}

}

/*
// public double geefOmzetAttractie() {
// return omzetAttractie;
// }
public void winstAtrractie(Attractie a, Belastinginspecteur b) {
	if (a instanceof GokAttractie) {
		omzetAttractie = (geefAantalVerkochteKaartjesAttractie() * prijs) - b.belastingPerAttractie;
	} else {
		omzetAttractie = (geefAantalVerkochteKaartjesAttractie() * prijs);
	}
	System.out.printf("De winst voor de attractie %s is: %.2f \n", naamAttractie, omzetAttractie);
}
*/