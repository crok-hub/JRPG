package org.cro.jrpg.mundus;

import java.util.Scanner;

import org.cro.jrpg.personnage.Monstre;
import org.cro.jrpg.personnage.Personnage;

public class Monde {
	public static String[] debutNom = {"Chevalier","Chien","Garuda","Vermine"};

	public static String[] finNom = {" agréssif"," de feu"," de la mort"," fourbe"," discret"};

	/**
	 * Créer un personnage avec tous ses attributs (10pv, 1dmg)
	 * Demande a l'utilisateur d'entrer le nom du personnage.
	 * @return une instance de la classe Personnage correctement instancié.
	 */
	public static Personnage personnageFactory() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Personnage: Choisisez un nom :");
			
		String nom = sc.next();
		
		return new Personnage(10, 1, nom);	
	}
	
	/**
	* Créer un monstre avec tous ses attributs (10pv, 1dmg)
	* Son nom est determiné par <code>Monde.debutNom</code> et <code>Monde.finNom</code>
	* @return une instance de la classe Monstre correctement instancié.
	**/
	public static Monstre monstreFactory() {
		String nom;
		int d, f;
		
		d = (int) Math.random() * Monde.debutNom.length;
		f = (int) Math.random() * Monde.finNom.length;
		nom = Monde.debutNom[d] + Monde.finNom[f];
		
		return new Monstre(10, 1, nom);	
	}
	

	/**
	 * 
	 */
	public static void afficherInformations() {
		//TODO: NIY
	}
	
}
