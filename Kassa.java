package weekopdracht3;

import java.util.ArrayList;

public class Kassa {

	private double totaalOmzet;
	private double totaalInKassa;
	protected boolean bezoekBelastinginspecteur;

	public void totaalOmzetEnGeldInKassaBerekenen(ArrayList<Attractie> kermisattracties, Belastinginspecteur b) {
		totaalOmzet = 0;
		double omzetPerAttractie = 0;
		for (Attractie a : kermisattracties) {
			omzetPerAttractie = a.geefAantalVerkochteKaartjesAttractie() * a.prijs;
			totaalOmzet = totaalOmzet + omzetPerAttractie;
		}
		if (bezoekBelastinginspecteur) {
			double nuInnen = b.totaalTeInnenBelasting - b.belastingGeind;
			System.out.printf("totaal te innen: %.2f al geind: %.2f nu innen: %.2f\n", b.totaalTeInnenBelasting, b.belastingGeind, nuInnen);
			bezoekBelastinginspecteur = false;
			totaalInKassa = totaalInKassa - nuInnen;
			b.belastingGeind = b.totaalTeInnenBelasting;
//			nuInnen = 0;
		} else {
			totaalInKassa = totaalOmzet - b.belastingGeind;
		}
	}

	public double geefOmzet() {
		return totaalOmzet;
	}

	public double geefTotaalInKassa() {
		return totaalInKassa;
	}

}
