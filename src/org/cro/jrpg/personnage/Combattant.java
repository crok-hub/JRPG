package org.cro.jrpg.personnage;

public abstract class Combattant implements ICombattant {
	private int pdv; // Points de vie
	private int puissance; // Points de dommage
	private String nom;
	
	/**
	 * Un nouveau Combattant avec un nombre de points de vie, points de dégât/dommage et un nom.
	 * @param pdv - Points de vie
	 * @param dmg - Points de dommage
	 * @param nom
	 */
	public Combattant(int pdv, int dmg, String nom) {
		this.pdv = pdv;
		this.puissance = dmg;
		this.nom = nom;
	}
	
	/**
	 * Fait subir une attaque a l'adversaire.
	 */
    public void attaquer(ICombattant adversaire) {
    	adversaire.defendre(this.puissance);
    }
    
    /**
     * Subir une attaque. Soustrait {@code degats} au points de vie.
     */
    public void defendre(int degats) {
    	this.pdv -= degats;
    }
	
	/**
	 * Vérifie si le nombre de points de vie est supérieur a 0.
	 * @return {@code true} si > 0, {@code false} sinon
	 */
	public boolean estVivant() {
		return this.pdv > 0;
	}
	
	public int getPDV() {
		return this.pdv;
	}
	
	public int getPuissance() {
		return this.puissance;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String toString() {
		return this.nom + ": PV[" + this.pdv + "], DMG[" + this.puissance + "]";
	}
}
