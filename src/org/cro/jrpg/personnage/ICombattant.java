package org.cro.jrpg.personnage;

import java.util.List;

import org.cro.jrpg.personnage.attaque.IAttaque;

public interface ICombattant {
    public void attaquer(ICombattant adversaire, IAttaque attaque);
    public void defendre(int degats);

    // Getters et Setters
    public String getNom();
    public int getPuissance();
    public int getPDV();
    
    public boolean estVivant();
    
    public List<IAttaque> getAttaques();
}
