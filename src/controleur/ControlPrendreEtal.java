package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		int numeroEtal = -1;
		Gaulois gaulois = village.trouverHabitant(nomVendeur);
		numeroEtal = village.installerVendeur(gaulois, produit, nbProduit);
		return numeroEtal + 1;
	}

	public boolean verifierIdentite(String nomVendeur) {
		Gaulois gaulois = village.trouverHabitant(nomVendeur);
		return gaulois!= null;
	}
}
