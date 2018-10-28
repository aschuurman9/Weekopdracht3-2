package weekopdracht3;

import java.util.ArrayList;
import java.util.Scanner;

public class Kermis {
	Scanner scanner = new Scanner(System.in);
	Kassa kassa = new Kassa();
	Botsauto botsauto = new Botsauto("Botsauto", 2.50);
	Spin spin = new Spin("Spin", 2.25);
	Spiegelpaleis spiegelpaleis = new Spiegelpaleis("Spiegelpaleis", 2.75);
	Spookhuis spookhuis = new Spookhuis("Spookhuis", 3.20);
	Hawaii hawaii = new Hawaii("Hawaii", 2.90, 10);
	Ladderklimmen ladderklimmen = new Ladderklimmen("Ladderklimmen", 2.50);
	boolean doordraaien = true;
	boolean aantalKaartjesTonen;
	ArrayList<Attractie> kermisAttracties = new ArrayList<>();
	Belastinginspecteur inspecteur = new Belastinginspecteur();

	void starten() throws OnderhoudNodigException {
		kermisAttracties.add(botsauto);
		kermisAttracties.add(spin);
		kermisAttracties.add(spiegelpaleis);
		kermisAttracties.add(spookhuis);
		kermisAttracties.add(hawaii);
		kermisAttracties.add(ladderklimmen);
		while (doordraaien) {
			System.out.println("Welkom op de kermis. \nWat wil je doen? \n");
			System.out.println("1\tBotsauto's\n2\tSpin\n3\tSpiegelpaleis\n4\tSpookhuis\n5\tHawaii\n6\tLadderklimmen\n"
					+ "k\tAantal verkochte kaartjes\no\tOmzet\nb\tBelastinginspecteur\ns\tStoppen");
			String invoer = scanner.nextLine();
			verwerkenKeuze(invoer);
		}
	}

	void verwerkenKeuze(String invoer) throws OnderhoudNodigException {
		switch (invoer) {
		case "1":
			botsauto.draaien();
			break;
		case "2":
			if (spin.geefAantalVerkochteKaartjesAttractie() == 0) {
				spin.opstellingsKeuring();
				spin.draaien();
			} else {
				try {
					spin.draaien();
				} catch (OnderhoudNodigException e) {
					System.out.println(e.getMessage());
					spin.onderhoudsbeurt();
				} finally {
					if (spin.onderhoudsbeurtGehad) {
						spin.draaien();
						spin.onderhoudsbeurtGehad = false;
					}
				}
			}
			break;
		case "3":
			spiegelpaleis.draaien();
			break;
		case "4":
			spookhuis.draaien();
			break;
		case "5":
			if (hawaii.geefAantalVerkochteKaartjesAttractie() == 0) {
				hawaii.opstellingsKeuring();
				hawaii.draaien();
			} else {
				try {
					hawaii.draaien();
				} catch (OnderhoudNodigException e) {
					System.out.println(e.getMessage());
					hawaii.onderhoudsbeurt();
				} finally {
					if (hawaii.onderhoudsbeurtGehad) {
						hawaii.draaien();
						hawaii.onderhoudsbeurtGehad = false;
					}
				}
			}
			break;
		case "6":
			ladderklimmen.draaien();
			break;
		case "k":
			aantalKaartjesTonen = true;
			menuAantalVerkochteKaartjes();
			break;
		case "o":
			kassa.totaalOmzetEnGeldInKassaBerekenen(kermisAttracties, inspecteur);
			System.out.printf("De totaal omzet is %.2f \n", kassa.geefOmzet());
			System.out.printf("Totaal in kassa: %.2f\n\n", kassa.geefTotaalInKassa());
			break;
		case "b":
			System.out.println("belastinginspecteur");
			kassa.bezoekBelastinginspecteur = true;
			inspecteur.checkenGokAttractie(kermisAttracties);
//			inspecteur.belastingInnen(inspecteur.gokAttractiesLijst);
//			inspecteur.belastingInnen(inspecteur.checkenGokAttractie(kermisAttracties));
			break;
		case "s":
			System.out.println("Stoppen");
			doordraaien = false;
			break;
		default:
			System.out.println("Dit is geen geldige invoer. Kies opnieuw");
			break;
		}
	}

	void menuAantalVerkochteKaartjes() {
		while (aantalKaartjesTonen) {
			System.out.println("Van welke attractie wil je het aantal verkochte kaartjes zien?");
			System.out.println(
					"1\tBotsauto's\n2\tSpin\n3\tSpiegelpaleis\n4\tSpookhuis\n5\tHawaii\n6\tLadderklimmen\nt\tTotaal\n"
							+ "q\tTerug naar menu");
			String invoerKaartjes = scanner.nextLine();
			aantalVerkochteKaartjesTonen(invoerKaartjes);
		}
	}

	void aantalVerkochteKaartjesTonen(String invoer) {
		switch (invoer) {
		case "1":
			System.out.println(botsauto.naamAttractie + "\taantal kaartjes: "
					+ botsauto.geefAantalVerkochteKaartjesAttractie() + "\n");
			break;
		case "2":
			System.out.println(
					spin.naamAttractie + "\taantal kaartjes: " + spin.geefAantalVerkochteKaartjesAttractie() + "\n");
			break;
		case "3":
			System.out.println(spiegelpaleis.naamAttractie + "\taantal kaartjes: "
					+ spiegelpaleis.geefAantalVerkochteKaartjesAttractie() + "\n");
			break;
		case "4":
			System.out.println(spookhuis.naamAttractie + "\taantal kaartjes: "
					+ spookhuis.geefAantalVerkochteKaartjesAttractie() + "\n");
			break;
		case "5":
			System.out.println(hawaii.naamAttractie + "\taantal kaartjes :"
					+ hawaii.geefAantalVerkochteKaartjesAttractie() + "\n");
			break;
		case "6":
			System.out.println(ladderklimmen.naamAttractie + "\taantal kaartjes: "
					+ ladderklimmen.geefAantalVerkochteKaartjesAttractie() + "\n");
			break;
		case "t":
			System.out
					.println("Totaal aantal verkochte kaartjes is: " + Attractie.aantalVerkochteKaartjesTotaal + "\n");
			break;
		case "q":
			aantalKaartjesTonen = false;
			break;
		default:
			System.out.println("Dit is geen geldige invoer. Kies opnieuw\n");
			break;
		}
	}

}

/*
 * if (hawaii.geefAantalVerkochteKaartjesAttractie() == 0) {
 * hawaii.opstellingsKeuring(); hawaii.draaien(); } else if
 * (hawaii.geefAantalVerkochteKaartjesAttractie() != 0 &&
 * hawaii.geefAantalVerkochteKaartjesAttractie() % hawaii.draailimiet == 0) {
 * hawaii.onderhoudsbeurt(); hawaii.draaien(); } else { hawaii.draaien(); }
 * break;
 */