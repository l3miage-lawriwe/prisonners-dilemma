package fr.uga.l3miage.pc.prisonersdilemma.classes;

public class PartieJouee {


    // pour chaque choix :
    // TRUE veut dire coopérer
    // FALSE veut dire trahir


    public boolean choix_joueur;
    public boolean choix_autre_joueur;
    public int resultat_joueur;

    public PartieJouee(boolean choix_joueur, boolean choix_autre_joueur, int resultat_joueur) {
        this.choix_joueur = choix_joueur;
        this.choix_autre_joueur = choix_autre_joueur;
        this.resultat_joueur = resultat_joueur;
    }
}
