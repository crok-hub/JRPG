package org.cro.jrpg.archetype.classe;

import java.util.ArrayList;

import org.cro.jrpg.archetype.Guerrier;
import org.cro.jrpg.personnage.attaque.AttaqueBasic;
import org.cro.jrpg.personnage.attaque.AttaquePuissante;
import org.cro.jrpg.personnage.attaque.IAttaque;

public class Barbare implements Guerrier {
	private final String nom = "Chevalier";
	private int vigueur;
	private Iterable<IAttaque> attaques;
	
	public Barbare() {
		this.attaques = new ArrayList<IAttaque>(new AttaqueBasic(), new AttaquePuissante());
	}
	
	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public Iterable<IAttaque> getAttaques() {
		return this.attaques;
	}

	@Override
	public int getVigueur() {
		return this.vigueur;
	}

}
