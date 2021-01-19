package org.cro.jrpg.personnage.attaque;

import org.cro.jrpg.personnage.ICombattant;

/**
 * Une Attaque Puissance inflige 100 points de dégâts.
 * Les dommage infligés sont la somme des dégâts et de la puissance du lanceur.
 * Les chances de toucher sont de 30%
 * 
 * @author Cro
 *
 */
public class AttaqueCritique implements IAttaque {
	private final String nom = "Attaque Critique";
	private final String description = "30% de précision\nCette inflique 4 fois plus de dégâts.";
	private final int degats = 4;
	private final double chanceToucher = 70.0;
	
	private static AttaqueCritique INSTANCE = new AttaqueCritique();
	
	@Override
	public int inflige(ICombattant lanceur, ICombattant cible) {
		double precision = (Math.random() * 100);
		int dmg = this.degats * lanceur.getPuissance();
		
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
