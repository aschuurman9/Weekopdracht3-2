package weekopdracht3;

public class Hawaii extends RisicoRijkeAttractie {
	
	Hawaii(String naam, double prijs, int draailimiet) {
		naamAttractie = naam;
		this.prijs = prijs;
		this.draailimiet = draailimiet; 
	}
	
	
	void opstellingsKeuring() {
		System.out.println("Opstellingskeuring Hawaii\n");
	}

}