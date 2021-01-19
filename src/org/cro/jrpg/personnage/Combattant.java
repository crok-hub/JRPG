package org.cro.jrpg.personnage;

import java.util.List;

import org.cro.jrpg.personnage.attaque.AttaqueBasic;
import org.cro.jrpg.personnage.attaque.IAttaque;

public abstract class Combattant implements ICombattant {
	private int pdv; // Points de vie
	private int puissance; // Points de dommage
	private String nom;
	
	private List<IAttaque> attaques;
	
	/**
	 * Un nouveau Combattant avec un nombre de points de vie, points de dégât/dommage et un nom.
	 * 
	 * @param pdv - Points de vie
	 * @param pui - Points de dommage
	 * @param nom
	 */
	public Combattant(int pdv, int pui, String nom) {
		this.pdv = pdv;
		this.puissance = pui;
		this.nom = nom;
		this.attaques = List.of(AttaqueBasic.getInstance());
	}
	
	public Combattant(int pdv, int pui, String nom, List<IAttaque> attaques) {
		this(pdv, pui, nom);
		this.attaques = attaques;
	}
	
	/**
	 * Fait subir une attaque a l'adversaire.
	 */
    public void attaquer(ICombattant adversaire, IAttaque attaque) {
    	adversaire.defendre(attaque.inflige(this, adversaire));
    }
    
    /**
     * Subir une attaque. Soustrait {@code degats} au points de vie.
     */
    public void defendre(int degats) {
    	this.pdv -= degats;
    }
	
	/**
	 * Vérifie si le nombre de points de vie est supérieur a 0.
	 * 
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
	
	@Override
	public List<IAttaque> getAttaques() {
		return attaques;
	}
	
	public String toString() {
		return this.nom + ": PV[" + this.pdv + "], DMG[" + this.puissance + "]";
	}
}
