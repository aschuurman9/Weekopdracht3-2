package weekopdracht3;

public abstract class RisicoRijkeAttractie extends Attractie {
	
	int draailimiet;

	abstract void opstellingsKeuring(); 
	boolean onderhoudsbeurtGehad = false;
	int aantalKeerGedraaidNaOnderHoudsbeurt;
	
	public void onderhoudsbeurt() {
		System.out.println("Onderhoudsbeurt");
		onderhoudsbeurtGehad = true;
		aantalKeerGedraaidNaOnderHoudsbeurt = 0;
		
	}
	
	@Override
	public void draaien() throws OnderhoudNodigException {
		if (aantalKeerGedraaidNaOnderHoudsbeurt != 0 && aantalKeerGedraaidNaOnderHoudsbeurt % draailimiet == 0) {
			throw new OnderhoudNodigException("Monteur moet komen");
		} else {
			aantalVerkochteKaartjesAttractie = geefAantalVerkochteKaartjesAttractie() + 1;
			aantalVerkochteKaartjesTotaal++;
			System.out.println("De attractie " + naamAttractie + " draait.\n");
			aantalKeerGedraaidNaOnderHoudsbeurt++;
		}
	}

}

class OnderhoudNodigException extends Exception{
	public OnderhoudNodigException(String msg) {
		super(msg);
	}
}

/*
if (hawaii.geefAantalVerkochteKaartjesAttractie() == 0) {
				hawaii.opstellingsKeuring();
				hawaii.draaien();
			} else if (hawaii.geefAantalVerkochteKaartjesAttractie() != 0 && hawaii.geefAantalVerkochteKaartjesAttractie() % hawaii.draailimiet == 0) {
				hawaii.onderhoudsbeurt();
				hawaii.draaien();
			} else {
				hawaii.draaien();
			}



*/