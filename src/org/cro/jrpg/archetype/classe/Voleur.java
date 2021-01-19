package org.cro.jrpg.archetype.classe;

import org.cro.jrpg.archetype.Classe;
import org.cro.jrpg.archetype.Fripon;

public class Voleur implements Fripon {
	private final String nom = "Voleur";
	private int discretion;
	
	private static Voleur INSTANCE = new Voleur();
	
	public Voleur() {
		this.discretion = 100;
	}

	@Override
	public int discretion() {
		return this.discretion;
	}

	@Override
	public void seDissimuler() {
		//TODO: NIY
	}
	
	public static Classe getInstance() {
		return INSTANCE;
	}

	@Override
	public String getNom() {
		return this.nom;
	}
	
	public String toString() {
		return this.nom;
	}

}
