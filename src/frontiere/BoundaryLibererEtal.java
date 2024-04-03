package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (! controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			String[] donneesVente = controlLibererEtal.libererEtal(nomVendeur);
			System.out.println("Vous avez vendu " + donneesVente[4] + " sur " + donneesVente[3] + " " + donneesVente[2]);
			System.out.println("En revoir " + donneesVente[1] + ", passez une bonne journée.");
		}
	}

}
