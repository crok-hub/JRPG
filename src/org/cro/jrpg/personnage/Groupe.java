package org.cro.jrpg.personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.cro.jrpg.personnage.attaque.IAttaque;

public class Groupe implements ICombattant {
	private List<ICombattant> combattants;
	
	public Groupe(List<ICombattant> combattant) {
		this.combattants = combattant;
	}

	@Override
	public void attaquer(ICombattant adversaire, IAttaque attaque) {
		ICombattant attaquant = this.enEtatDeCombatre();
		
		if (attaquant != null) adversaire.defendre(attaque.inflige(attaquant, adversaire));
	}

	@Override
	public void defendre(int degats) {
		ICombattant defenseur = this.enEtatDeCombatre();

		defenseur.defendre(degats);
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
	public boolean estMort() {
		return !this.estVivant();
	}
	
	/** 
	 * Retourne un combattant aléatoire en etat de combattre.
	 * 
	 * @return un combattant, null sinon
	 */
	private ICombattant enEtatDeCombatre() {
		Random r = new Random();
		ICombattant combattant = null;
		
		if (this.estVivant()) {
			do {
				combattant = this.combattants.get(r.nextInt(this.combattants.size()));
			} while (combattant.estMort());
		}
		return combattant;
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
