package org.cro.jrpg.personnage.attaque;

import org.cro.jrpg.personnage.ICombattant;

public interface IAttaque {

	/**
	 * Tente une attaque du lanceur sur la cible.
	 * La cible aura ses points de vie réduit du montant des dommage calculer.
	 * Les chances de touches sont prise en compte durant l'attaque.
	 * 
	 * @param lanceur le combattant qui attaque
	 * @param cible le combattant qui se defend
	 * @return {@code true} si l'attaque à réussi, {@code false} sinon.
	 */
    public int inflige(ICombattant lanceur, ICombattant cible);

    // Getters et Setters
    public String getNom();
    public String getDescription();
    public int getDegats();
    public double getChanceToucher();
    
}
