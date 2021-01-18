package org.cro.jrpg.personnage;

public abstract class Combattant {
	private int pdv; // Points de vie
	private int dmg; // Points de dommage
	private String nom;
	
	/**
	 * Un nouveau Combattant avec un nombre de points de vie, points de dégât/dommage et un nom.
	 * @param pdv - Points de vie
	 * @param dmg - Points de dommage
	 * @param nom
	 */
	public Combattant(int pdv, int dmg, String nom) {
		this.pdv = pdv;
		this.dmg = dmg;
		this.nom = nom;
	}
	
	public int getPDV() {
		return this.pdv;
	}
	
	public int getDMG() {
		return this.dmg;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void subir(int dmg) {
		this.pdv -= dmg;
	}
	
	/**
	 * Vérifie si le nombre de points de vie est supérieur a 0.
	 * @return {@code true} si > 0, {@code false} sinon
	 */
	public boolean estVivant() {
		return this.pdv > 0;
		
	}
	
	public String toString() {
		return this.nom + ": PV[" + this.pdv + "], DMG[" + this.dmg + "]";
	}
}
