package weekopdracht3;

import java.util.ArrayList;

public class Belastinginspecteur {
	// static double totaalBelasting;
	double totaalTeInnenBelasting;
	// double belastingPerAttractie;
	ArrayList<GokAttractie> gokAttractiesLijst = new ArrayList<>();
	double belastingGeind;

	public ArrayList<GokAttractie> checkenGokAttractie(ArrayList<Attractie> attractielijst) {
		totaalTeInnenBelasting = 0;
		for (int i = 0; i < attractielijst.size(); i++) {
			if (attractielijst.get(i) instanceof GokAttractie) {
				belastingInnen((GokAttractie) attractielijst.get(i));
//				gokAttractiesLijst.add((GokAttractie)attractielijst.get(i));
			}
		}
		return gokAttractiesLijst;
	}

	public double belastingInnen(GokAttractie a) {
		totaalTeInnenBelasting = totaalTeInnenBelasting + ((GokAttractie) a).kansSpelBelastingReserveren(a);
		return totaalTeInnenBelasting;
	}

}

/*
 * public ArrayList<GokAttractie> checkenGokAttractie(ArrayList<Attractie> attractielijst) { 
 * for (int i = 0; i < attractielijst.size(); i++) { 
 * if (attractielijst.get(i) instanceof GokAttractie) { 
 * //belastingInnen((GokAttractie) attractielijst.get(i));
 * gokAttractiesLijst.add((GokAttractie) attractielijst.get(i)); 
 * } 
 * } 
 * return gokAttractiesLijst; 
 * }
 */