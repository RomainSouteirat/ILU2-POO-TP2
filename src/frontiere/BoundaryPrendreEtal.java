package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu;
		boolean etalDisponible;
		nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if (!nomVendeurConnu) {
			StringBuilder echecPrendreEtal = new StringBuilder();
			echecPrendreEtal.append("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.\n");
			System.out.println(echecPrendreEtal.toString());
		} else {
			StringBuilder tentativePrendreEtal = new StringBuilder();
			tentativePrendreEtal.append("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.\n");
			System.out.println(tentativePrendreEtal.toString());
			etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				StringBuilder echecTentative = new StringBuilder();
				echecTentative.append("Désolée " + nomVendeur +  "je n'ai plus d'étal qui ne soit pas déja occupé.\n");
				System.out.println(echecTentative.toString());
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder questionNomProduit = new StringBuilder();
		StringBuilder questionNombreProduit = new StringBuilder();
		String produit;
		int nbProduits = -1;
		int numeroEtal = -1;
		questionNomProduit.append("C'est parfait il me reste un étal pour vous !\n");
		questionNomProduit.append("Il me faudrait quelques renseignements :\n");
		questionNomProduit.append("Quel produit souhaitez-vous vendre ?\n");
		produit = Clavier.entrerString(questionNomProduit.toString());
		questionNombreProduit.append("Combiend souhaitez-vous en vendre ?\n");
		nbProduits = Clavier.entrerEntier(questionNombreProduit.toString());
		
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduits);
		if (numeroEtal != -1) {
			StringBuilder confirmationEtal = new StringBuilder();
			confirmationEtal.append("Le vendeur " + nomVendeur + " s'est installé à l'étal numéro " + numeroEtal + ".\n");
			System.out.println(confirmationEtal.toString());
		}
	}
}
