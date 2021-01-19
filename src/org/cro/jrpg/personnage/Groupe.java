package org.cro.jrpg.personnage;

import java.util.ArrayList;
import java.util.List;

import org.cro.jrpg.personnage.attaque.IAttaque;

public class Groupe implements ICombattant {
	private List<ICombattant> combattants;
	
	public Groupe(List<ICombattant> combattant) {
		this.combattants = combattant;
	}

	@Override
	public void attaquer(ICombattant adversaire, IAttaque attaque) {
		int i = (int) Math.random() * this.combattants.size();
		
		adversaire.defendre(attaque.inflige(this.combattants.get(i), adversaire));
	}

	@Override
	public void defendre(int degats) {
		int i = (int) Math.random() * this.combattants.size();

		this.combattants.get(i).defendre(degats);
	}

	@Override
	public String getNom() {
		return "Goupe";
	}

	@Override
	public int getPuissance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPDV() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estVivant() {
		for (ICombattant combattant : combattants) {
			if (combattant.estVivant()) return true;
		}
		return false;
	}

	@Override
	public List<IAttaque> getAttaques() {
		ArrayList<IAttaque> l = new ArrayList<IAttaque>();
		for (ICombattant combattant : this.combattants) {
			l.addAll(combattant.getAttaques());
		}
		return l;
	}
	
	@Override
	public String toString() {
		return this.combattants.toString();
	}

}
