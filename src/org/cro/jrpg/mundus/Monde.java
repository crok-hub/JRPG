package org.cro.jrpg.mundus;

import java.util.Scanner;

import org.cro.jrpg.personnage.Monstre;
import org.cro.jrpg.personnage.Personnage;

public class Monde {
	public static String[] debutNom = {"Chevalier","Chien","Garuda","Vermine"};

	public static String[] finNom = {" agréssif"," de feu"," de la mort"," fourbe"," discret"};

	/**
	 * Créer un personnage avec tous ses attributs 
	 * Demande a l'utilisateur d'entrer le nom du personnage.
	 * @return une instance de la classe Personnage correctement instancié.
	 */
	public static Personnage personnageFactory() {
		Scanner sc = new Scanner(System.in);
		String nom;
		int pv, atk;
		
		pv = (int) (Math.random() * 1324);
		atk = (int) (Math.random() * 1234);
		
		System.out.println("Personnage: Choisisez un nom :");
			
		nom = sc.next();
				
		sc.close();
		
		return new Personnage(pv, atk, nom);	
	}
	
	/**
	* Créer un monstre avec tous ses attributs
	* Son nom est determiné par {@code Monde.debutNom} et {@code Monde.finNom}
	* @return une instance de la classe Monstre correctement instancié.
	**/
	public static Monstre monstreFactory() {
		String nom;
		int d, f;
		int pv, atk;
		
		d = (int) Math.random() * Monde.debutNom.length;
		f = (int) Math.random() * Monde.finNom.length;
		nom = Monde.debutNom[d] + Monde.finNom[f];
		
		pv = (int) (Math.random() * 1324);
		atk = (int) (Math.random() * 1234);
		
		return new Monstre(pv, atk, nom);	
	}
	

	/**
	 * *Fait joué tour à tour le personnage et le monstre tant que l'un ou l'autre a encore des points de vie.
	 * @param personnage
	 * @param monstre
	 */
	public static void combat (Personnage personnage, Monstre monstre) {
		boolean tour = true;
		
		while(personnage.estVivant() && monstre.estVivant()) {
			System.out.println("______________________");
			System.out.println(personnage);
			System.out.println(monstre);
		    if (tour) {
		    	System.out.println(monstre.getNom() + " attaque !");
		        personnage.subir(monstre.getDMG());
		        System.out.println(personnage);
		    }
		    else {
		    	System.out.println(personnage.getNom() + " attaque !");
		        monstre.subir(personnage.getDMG());
		        System.out.println(monstre);
		    }
		    tour = !tour;
		}
		if (personnage.estVivant()) System.out.println(personnage.getNom() + " à gagné !");
		else if (monstre.estVivant()) System.out.println(monstre.getNom() + " à gagné !");
		else System.out.println("Match nul !");
		
	}
	
	/**
	 * 
	 */
	public static void afficherInformations() {
		//TODO: NIY
	}
	
}
