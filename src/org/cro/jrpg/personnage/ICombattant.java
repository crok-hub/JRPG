package org.cro.jrpg.personnage;

public interface ICombattant {
    public void attaquer(ICombattant adversaire);
    public void defendre(int degats);

    // Getters et Setters
    public String getNom();
    public int getDMG();
    public int getPDV();
    
    public boolean estVivant();
}
