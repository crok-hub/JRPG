package org.cro.jrpg.mundus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.cro.jrpg.archetype.Classe;
import org.cro.jrpg.archetype.classe.Barbare;
import org.cro.jrpg.archetype.classe.Voleur;
import org.cro.jrpg.personnage.Groupe;
import org.cro.jrpg.personnage.ICombattant;
import org.cro.jrpg.personnage.Monstre;
import org.cro.jrpg.personnage.Personnage;
import org.cro.jrpg.personnage.attaque.AttaqueBasic;
import org.cro.jrpg.personnage.attaque.AttaqueCritique;
import org.cro.jrpg.personnage.attaque.AttaquePuissante;


public class Monde {
	public static String[] debutNom = {"Chevalier","Chien","Garuda","Vermine"};

	public static String[] finNom = {" agréssif"," de feu"," de la mort"," fourbe"," discret"};
	
	public static HashMap<String, Classe> classes = new HashMap<String, Classe>() {{ put("Barbare", Barbare.getInstance()); put("Voleur", Voleur.getInstance()); }};

	/**
	 * Créer un personnage avec tous ses attributs 
	 * Demande a l'utilisateur d'entrer le nom du personnage et de choisir une classe.
	 * 
	 * @return une instance de la classe Personnage correctement instancié.
	 */
	public static Personnage personnageFactory() {
		Scanner sc = new Scanner(System.in);
		String nom;
		Classe classe;
		int pv, atk;
		
		pv = (int) (Math.random() * 1324);
		atk = (int) (Math.random() * 100);
		
		System.out.println("Choisisez un nom de personnage:");
			
		nom = sc.next();
		
		System.out.println(Monde.classes.keySet());
		System.out.println("Choisir classe :");
		
		classe = Monde.getClasse(sc.next());
		
		if (classe == null) {
			System.out.println("defaut: Barbare");
			classe = Monde.getClasse("Barbare");
		}
				
		//sc.close();
		
		return new Personnage(pv, atk, nom, classe, List.of(AttaqueBasic.getInstance(), AttaquePuissante.getInstance(), AttaqueCritique.getInstance()));	
	}
	
	/**
	 * Créer un groupe de 1 à n personnage.
	 * 
	 * @param nombre
	 * @return 
	 */
	public static ICombattant groupePersonnageFactory(int nombre) {
		ArrayList<ICombattant> l = new ArrayList<ICombattant>();
		
		for (int i = 0; i != nombre; i++) {
			l.add(Monde.personnageFactory());
		}
		
		return new Groupe(l);
	}
	
	/**
	* Créer un monstre avec tous ses attributs
	* Son nom est determiné par {@code Monde.debutNom} et {@code Monde.finNom}
	* 
	* @return une instance de la classe Monstre correctement instancié.
	* 
	**/
	public static Monstre monstreFactory() {
		String nom;
		int d, f, i;
		int pv, atk;
		
		d = (int) (Math.random() * Monde.debutNom.length);
		f = (int) (Math.random() * Monde.finNom.length);
		nom = Monde.debutNom[d] + Monde.finNom[f];
		
		pv = (int) (Math.random() * 1324);
		atk = (int) (Math.random() * 100);
		
		return new Monstre(pv, atk, nom);	
	}
	
	/**
	 * Créer un groupe de 1 à n monstre.
	 * 
	 * @param nombre
	 * @return 
	 */
	public static ICombattant groupeMonstreFactory(int nombre) {
		ArrayList<ICombattant> l = new ArrayList<ICombattant>();
	
		for (int i = 0; i != nombre; i++) {
			l.add(Monde.monstreFactory());
		}
		
		return new Groupe(l);
	}
	
	/**
	 * Retourne une classe en fonction du nom.
	 * 
	 * @param nom de la classe
	 * @return une Classe, {@code null} sinon
	 */
	public static Classe getClasse(String nom) {
		return Monde.classes.get(nom);
	}
	
	/**
	 * *Fait joué tour à tour le personnage et le monstre tant-que l'un ou l'autre est encore en vie.
	 * 
	 * @param personnage
	 * @param monstre
	 */
	public static void combat (ICombattant personnage, ICombattant monstre) {
		boolean tour = true;
		Random r = new Random();
		int i;
		
		while(personnage.estVivant() && monstre.estVivant()) {
			System.out.println("______________________");
			System.out.println(personnage);
			System.out.println(monstre);
		    if (tour) {
		    	i = r.nextInt(personnage.getAttaques().size());
		    	System.out.println(personnage.getNom() + " lance " + personnage.getAttaques().get(i).getNom());
		        personnage.attaquer(monstre, personnage.getAttaques().get(i));
		        System.out.println(monstre);
		    }
		    else {
		    	i = r.nextInt(monstre.getAttaques().size());
		    	System.out.println(monstre.getNom() + " lance " + monstre.getAttaques().get(i).getNom());
		        monstre.attaquer(personnage, monstre.getAttaques().get(i));
		        System.out.println(personnage);
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
