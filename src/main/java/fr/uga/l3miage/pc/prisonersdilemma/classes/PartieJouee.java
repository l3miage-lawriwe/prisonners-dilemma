package fr.uga.l3miage.pc.prisonersdilemma.classes;

public class PartieJouee {


    // pour chaque choix :
    // TRUE veut dire coopérer
    // FALSE veut dire trahir




    private boolean choixJoueur;
    private boolean choixAutreJoueur;
    private int resultatJoueur;

    public PartieJouee(boolean choixJoueur, boolean choixAutreJoueur, int resultatJoueur) {
        this.choixJoueur = choixJoueur;
        this.choixAutreJoueur = choixAutreJoueur;
        this.resultatJoueur = resultatJoueur;
    }

    public boolean isChoixJoueur() {
        return choixJoueur;
    }

    public boolean isChoixAutreJoueur() {
        return choixAutreJoueur;
    }

    public int getResultatJoueur() {
        return resultatJoueur;
    }


}
