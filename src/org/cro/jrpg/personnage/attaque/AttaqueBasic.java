package org.cro.jrpg.personnage.attaque;

import org.cro.jrpg.personnage.ICombattant;

/**
 * Attaque Basic, inflige 1 point de dégât.
 * Les dommage infligés dépendrons uniquement de la puissance du combattant lanceur.
 * Les chances de toucher sont de 50%
 * 
 * @author Cro
 *
 */
public class AttaqueBasic implements IAttaque {
	private final String nom = "Attaque";
	private final String description = "1 de dégât\n50% de précision\nUne simple attaque qui inflige 1 point de dégâts";
	private final int degats = 1;
	private final double chanceToucher = 50.0;
	
	private static AttaqueBasic INSTANCE = new AttaqueBasic();
	
	@Override
	public int inflige(ICombattant lanceur, ICombattant cible) {
		double precision = (Math.random() * 100);
		
		if (precision > this.chanceToucher) {
			return this.degats + lanceur.getPuissance();
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
