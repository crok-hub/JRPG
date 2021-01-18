package org.cro.jrpg.personnage.interaction;

import org.cro.jrpg.personnage.ICombattant;

public class AttaqueBasic implements IAttaque {
	private String nom;
	private String description;
	private int degats;
	private double chanceToucher; // ou précision ... du lanceur !
	
   public AttaqueBasic(String nom, String description, int degats, double chanceToucher) {
	   this.nom = nom;
	   this.description = description;
	   this.degats = degats;
	   this.chanceToucher = chanceToucher;
   }
	
	@Override
	public int attaque(ICombattant lanceur, ICombattant cible) {
		double precision = (Math.random() * 100);
		int dmg = this.degats + lanceur.getPuissance();
		
		if (this.chanceToucher >= precision ) {
			cible.defendre(dmg);
			return dmg;
		}
		
		return 0;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public int getDegats() {
		return this.degats;
	}
	
	@Override
	public double getChanceToucher() {
		return this.chanceToucher;
	}
}
