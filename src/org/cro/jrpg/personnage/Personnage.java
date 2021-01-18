package org.cro.jrpg.personnage;

public class Personnage {
	private int pdv; // Points de vie
	private int dmg; // Points de dommage
	private String nom;
	
	/**
	 * Un nouveau personnage avec un nombre de points de vie, points de dégât/dommage et un nom.
	 * @param pdv - Points de vie
	 * @param dmg - Points de dommage
	 * @param nom
	 */
	public Personnage(int pdv, int dmg, String nom) {
		this.pdv = pdv;
		this.dmg = dmg;
		this.nom = nom;
	}
	
	public String toString() {
		return this.nom + ", PV[" + this.pdv + "], DMG[" + this.dmg + "]";
	}
}
