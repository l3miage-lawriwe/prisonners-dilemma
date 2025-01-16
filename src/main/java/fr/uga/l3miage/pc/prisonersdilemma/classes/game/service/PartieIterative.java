package fr.uga.l3miage.pc.prisonersdilemma.classes.game.service;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.model.Joueur;

import java.util.ArrayList;
import java.util.List;

public class PartieIterative {

    // Résultats possibles des choix des joueurs
    public static final int TRAHIT = 5;
    public static final int DUPEE = 0;
    public static final int COOPERE = 3;
    public static final int PIEGEE = 1;

    private  Joueur joueur1;
    private  Joueur joueur2;
    private final int nbIterations;
    private int iterationActuelle;
    private final List<PartieJouee> historiqueParties;

    public PartieIterative(Joueur joueur1, Joueur joueur2, int nbIterations) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.nbIterations = nbIterations;
        this.iterationActuelle = 0;
        this.historiqueParties = new ArrayList<>();
    }

    // Méthode pour jouer une itération et retourner les résultats
    public PartieJouee jouerIteration(boolean choixJoueur1, boolean choixJoueur2) {
        iterationActuelle++;

        // Calcul des résultats
        int resultatJoueur1;
        int resultatJoueur2;
        if (choixJoueur1) {
            if (choixJoueur2) {
                resultatJoueur1 = COOPERE;
                resultatJoueur2 = COOPERE;
            } else {
                resultatJoueur1 = DUPEE;
                resultatJoueur2 = TRAHIT;
            }
        } else {
            if (choixJoueur2) {
                resultatJoueur1 = TRAHIT;
                resultatJoueur2 = DUPEE;
            } else {
                resultatJoueur1 = PIEGEE;
                resultatJoueur2 = PIEGEE;
            }
        }

        // Création de l'instance de PartieJouee
        PartieJouee partieJouee = new PartieJouee(choixJoueur1, choixJoueur2, resultatJoueur1);

        // Mise à jour de l'historique
        joueur1.aJouterPartieHistorique(partieJouee);
        joueur2.aJouterPartieHistorique(new PartieJouee(choixJoueur2, choixJoueur1, resultatJoueur2));
        historiqueParties.add(partieJouee);

        return partieJouee;
    }

    public boolean estTerminee() {
        return iterationActuelle >= nbIterations;
    }

    public int getScoreJoueur1() {
        return joueur1.scoreTotal();
    }

    public int getScoreJoueur2() {
        return joueur2.scoreTotal();
    }

    public int getNbIterations() {
        return nbIterations;
    }

    public int getIterationActuelle() {
        return iterationActuelle;
    }

    public static int convertResultForOpponent(int result) {
        return switch (result) {
            case TRAHIT -> DUPEE; // Si un joueur a trahi (5), l'autre est dupé (0)
            case DUPEE -> TRAHIT; // Si un joueur est dupé (0), l'autre a trahi (5)
            case COOPERE -> COOPERE; // Si les deux coopèrent, les deux obtiennent 3
            case PIEGEE -> PIEGEE; // Si les deux trahissent, les deux obtiennent 1
            default -> throw new IllegalArgumentException("Résultat invalide: " + result);
        };
    }

    public void remplacerJoueur(int numeroJoueur, Joueur bot) {
        if (numeroJoueur == 1) {
            joueur1 = bot;
        } else if (numeroJoueur == 2) {
            joueur2 = bot;
        }
    }


    public Joueur getJoueur2() {
        return joueur2;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }
}
