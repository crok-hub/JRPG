package org.cro.jrpg.mundus;

import java.util.Scanner;

import org.cro.jrpg.personnage.Personnage;

public class Monde {

	/**
	* Créer un personnage avec tous ses attributs (10pv, 1dmg)
	* Demande a l'utilisateur d'entrer le nom du personnage.
	* retour: une instance de la classe Personnage correctement instancié.
	**/
	public static Personnage personnageFactory() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choisisez un nom :");
			
		String nom = sc.next();
		
		return new Personnage(10, 1, nom);	
	}
	
	
	/**
	 * 
	 */
	public static void afficherInformations() {
		//TODO: NIY
	}
	
}
