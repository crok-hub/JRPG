package org.cro.jrpg.personnage.attaque;

import org.cro.jrpg.personnage.ICombattant;

/**
 * Une Attaque Puissance inflige 100 points de dégâts.
 * Les dommage infligés sont la somme des dégâts et de la puissance du lanceur.
 * Les chances de toucher sont de 70%
 * 
 * @author Cro
 *
 */
public class AttaquePuissante extends AttaqueBasic {
	private final String nom = "Attaque Puissante";
	private final String description = "100 de dégâts\n70% de précision\nCette attaque dépend de votre puissance.";
	private final int degats = 100;
	private final double chanceToucher = 70.0;
	
	private static AttaqueBasic INSTANCE = new AttaquePuissante();
	
	@Override
	public int inflige(ICombattant lanceur, ICombattant cible) {
		double precision = (Math.random() * 100);
		int dmg = this.degats + lanceur.getPuissance();
		
		if (precision > this.chanceToucher) {
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
	
	public static IAttaque getInstance() {
		return INSTANCE;
	}

}
