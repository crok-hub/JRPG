package org.cro.jrpg.archetype;

import org.cro.jrpg.personnage.attaque.IAttaque;

public interface Classe {

	/**
	 * Nom de la classe
	 * @return le nom de cette classe
	 */
	public String getNom();
	
	/**
	 * Liste de toutes les attaque de cette classe.
	 * @return un iterable d'attaques
	 */
	public Iterable<IAttaque> getAttaques();
	
}
