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

    public void setChoixJoueur(boolean choixJoueur) {
        this.choixJoueur = choixJoueur;
    }

    public boolean isChoixAutreJoueur() {
        return choixAutreJoueur;
    }

    public void setChoixAutreJoueur(boolean choixAutreJoueur) {
        this.choixAutreJoueur = choixAutreJoueur;
    }

    public int getResultatJoueur() {
        return resultatJoueur;
    }

    public void setResultatJoueur(int resultatJoueur) {
        this.resultatJoueur = resultatJoueur;
    }


}
