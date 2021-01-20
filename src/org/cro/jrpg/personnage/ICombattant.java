package org.cro.jrpg.personnage;

import java.util.List;

import org.cro.jrpg.personnage.attaque.IAttaque;

public interface ICombattant {
	
	/**
	 * Fait subir une attaque a l'adversaire.
	 * 
	 * @param adversaire
	 * @param attaque
	 */
    public void attaquer(ICombattant adversaire, IAttaque attaque);
    
    /**
     * 
     * @param degats
     */
    public void defendre(int degats);

    // Getters et Setters
    public String getNom();
    public int getPuissance();
    public int getPDV();
    
	/**
	 * Vérifie si le combattant est en mesure de ce battre.
	 * 
	 * @return {@code true} si le combattant est vivant, {@code false} sinon
	 */
    public boolean estVivant();
    
	/**
	 * Vérifie si le combattant n'est plus en mesure de ce battre.
	 * 
	 * @return {@code true} si le combattant est mort, {@code false} sinon
	 */
    public boolean estMort();
    
    public List<IAttaque> getAttaques();
}
