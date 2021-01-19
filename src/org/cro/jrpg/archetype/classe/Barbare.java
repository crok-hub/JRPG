package org.cro.jrpg.archetype.classe;

import org.cro.jrpg.archetype.Classe;
import org.cro.jrpg.archetype.Guerrier;

public class Barbare implements Guerrier {
	private final String nom = "Barbare";
	private int vigueur;
	
	private static Barbare INSTANCE = new Barbare();
	
	public Barbare() {
		this.vigueur = 100;
	}
	
	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public int getVigueur() {
		return this.vigueur;
	}
	
	public static Classe getInstance() {
		return INSTANCE;
	}

}
