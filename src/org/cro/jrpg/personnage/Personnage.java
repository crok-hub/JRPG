package org.cro.jrpg.personnage;

import java.util.List;

import org.cro.jrpg.archetype.Classe;
import org.cro.jrpg.personnage.attaque.IAttaque;

public class Personnage extends Combattant {
	private Classe classe;
	
	public Personnage(int pdv, int pui, String nom) {
		super(pdv, pui, nom);
	}
	
	public Personnage(int pdv, int pui, String nom, Classe classe) {
		this(pdv, pui, nom);
		this.classe = classe;
	}
	
	public Personnage(int pdv, int pui, String nom, Classe classe, List<IAttaque> attaques) {
		super(pdv, pui, nom, attaques);
		this.classe = classe;
	}

}
