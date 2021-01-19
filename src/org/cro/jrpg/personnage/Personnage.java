package org.cro.jrpg.personnage;

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

	@Override
	public void attaquer(ICombattant adversaire, IAttaque attaque) {
		// TODO Auto-generated method stub
		
	}

}
