package weekopdracht3;

public class Spin extends RisicoRijkeAttractie implements GokAttractie {

	
	Spin(String naam, double prijs) {
		naamAttractie = naam; 
		this.prijs = prijs;
		draailimiet = 5; 
		
	}
	
	void opstellingsKeuring() {
		System.out.println("Opstellingskeuring Spin\n");
	}

	@Override
	public double kansSpelBelastingReserveren(GokAttractie a) {
		double kansSpelBelasting = (((Attractie) a).omzetAtrractieBerekenen((Attractie) a) / 100) * 30;
		System.out.printf("kansspelbelasting reserveren: %.2f\n" , kansSpelBelasting);
		return kansSpelBelasting;
	}


}