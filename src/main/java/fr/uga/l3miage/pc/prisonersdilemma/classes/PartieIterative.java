package fr.uga.l3miage.pc.prisonersdilemma.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PartieIterative {


    // pour chaque choix :
    // TRUE veut dire coopérer
    // FALSE veut dire trahir


    //les valeurs de résultat donnes dans le sujet
    public static final int TRAHIT = 5;
    public static final int DUPEE = 0;
    public static final int COOPERE = 3;
    public static final int PIEGEE = 1;
    private static final Logger log = LogManager.getLogger(PartieIterative.class);


    private final Joueur joueur1;
    private final Joueur joueur2;

    private final int nbIterations;


    public PartieIterative(int nbIterations) {
        this.joueur1 = new Joueur();
        this.joueur2 = new Joueur();
        this.nbIterations = nbIterations;
    }

    public PartieIterative(int stratJoueur1, int stratJoueur2,int nbIterations) {
        this.joueur1 = new Joueur(stratJoueur1);
        this.joueur2 = new Joueur(stratJoueur2);
        this.nbIterations = nbIterations;
    }

    // méthode pour jouer un partie complète
    public Joueur jouerPartie() {
        for (int iteration = 0; iteration < nbIterations; iteration++) {
            jouerIteration();
        }
        afficherScores(nbIterations);

        if(joueur1.scoreTotal() > joueur2.scoreTotal()) {
            return joueur1;
        } else if(joueur2.scoreTotal() > joueur1.scoreTotal()) {
            return joueur2;
        } else {
            return null;
        }
    }

    public void jouerIteration(){

        // les joueurs jouent
        boolean choixJoueur1 = joueur1.jouer();
        boolean choixJoueur2 = joueur2.jouer();

        // calcul des résultats
        int resultatJoueur1;
        int resultatJoueur2;
        if (choixJoueur1) {
            log.info("joueur 1 a coopéré");
            if (choixJoueur2) {
                log.info("joueur 2 a coopéré");
                resultatJoueur1 = COOPERE;
                resultatJoueur2 = COOPERE;
            } else {
                log.info("joueur 2 a trahis");
                resultatJoueur1 = DUPEE;
                resultatJoueur2 = TRAHIT;
            }
        } else {
            log.info("joueur 1 a trahis");
            if (choixJoueur2) {
                log.info("joueur 2 a coopéré");
                resultatJoueur1 = TRAHIT;
                resultatJoueur2 = DUPEE;

            } else {
                log.info("joueur 2 a trahis");
                resultatJoueur1 = PIEGEE;
                resultatJoueur2 = PIEGEE;

            }
        }

        // affichage des resultats
        log.info("joueur 1 a gagné : {}", resultatJoueur1);
        log.info("joueur 2 a gagné : {}", resultatJoueur2);


        // ajout des parties a l'historique pour les IA
        joueur1.aJouterPartieHistorique(new PartieJouee(choixJoueur1,choixJoueur2,resultatJoueur1));
        joueur2.aJouterPartieHistorique(new PartieJouee(choixJoueur2,choixJoueur1,resultatJoueur2));

    }

    public void afficherScores(int iterations){
        log.info("la partie a durée {} itérations", iterations);
        log.info("joueur 1 a un score de : {}", joueur1.scoreTotal());
        log.info("joueur 2 a un score de : {}", joueur2.scoreTotal());
    }
}
