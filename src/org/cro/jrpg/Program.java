package org.cro.jrpg;

import org.cro.jrpg.mundus.Monde;

public class Program {
	
	public static void main(String[] args) {
		Monde.combat(Monde.personnageFactory(), Monde.monstreFactory());
	}

}
