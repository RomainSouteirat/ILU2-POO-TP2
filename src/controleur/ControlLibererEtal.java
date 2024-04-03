package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		boolean vendeurReconnu = (etal != null);
		if (!vendeurReconnu) {
			StringBuilder notIsVendeur = new StringBuilder();
			notIsVendeur.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui ! \n");
		}
		return vendeurReconnu;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = null;
		if(isVendeur(nomVendeur)) {
			Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			donneesEtal = etal.etatEtal();
			etal.libererEtal();
		}
		return donneesEtal;
	}

}
