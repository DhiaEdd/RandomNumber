package com.inti.formation.metier;

import com.inti.formation.imetier.ImetierJeu;

public class MetierJeu implements ImetierJeu {

	private int nombreSecret;
	private boolean fin;

	@Override
	public void genererNbSecret() {

		nombreSecret = (int) (Math.random() * 1000);

	}

	@Override
	public String jouer(int nb) {
		 if(fin==false) {
			if(nb>nombreSecret)
			
			return "Votre nombre "+nb+" est plus grand";
			
			else if(nb<nombreSecret)
				return "Votre nombre "+nb+" est plus petit ";
			
			else
			{ fin=true;
			  return "Bravo , vous avez gagné";	
			}
			
		 }
		 else {
			fin=true;
			return "Le jeu est terminé , le nombre aléatoire est "+nombreSecret;
		 }
		 
		
}

	public int getNombreSecret() {
		return nombreSecret;
	}

	public void setNombreSecret(int nombreSecret) {
		this.nombreSecret = nombreSecret;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	
}
