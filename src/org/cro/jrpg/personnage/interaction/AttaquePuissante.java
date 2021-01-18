package org.cro.jrpg.personnage.interaction;

import org.cro.jrpg.personnage.ICombattant;

public class AttaquePuissante extends AttaqueBasic {
	private String nom;
	private String description;
	private int degats;
	private double chanceToucher; // ou précision ... du lanceur !
	
   public AttaquePuissante(String nom, String description, int degats, double chanceToucher) {
	   super(nom, description, degats, chanceToucher);
   }
	
	@Override
	public int attaque(ICombattant lanceur, ICombattant cible) {
		double precision = (Math.random() * 100);
		int dmg = this.degats + (lanceur.getPuissance()*2);
		
		if (this.chanceToucher >= precision ) {
			cible.defendre(dmg);
			return dmg;
		}
		
		return 0;
	}

}
