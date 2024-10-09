package fr.uga.l3miage.pc.prisonersdilemma.classes;

public class PartieIterative {


    // pour chaque choix :
    // TRUE veut dire coopérer
    // FALSE veut dire trahir


    //les valeurs de résultat donnes dans le sujet
    public static final int TRAHIT = 5;
    public static final int DUPEE = 0;
    public static final int COOPERE = 3;
    public static final int PIEGEE = 1;



    private final Joueur joueur1;
    private final Joueur joueur2;

    private final int nbIterations;

    // contructeur decide si les joueurs sont des utilisateurs ou des IA
    public PartieIterative(boolean controleJoueur1, boolean controleJoueur2,int nbIterations) {
        this.joueur1 = new Joueur(controleJoueur1);
        this.joueur2 = new Joueur(controleJoueur2);
        this.nbIterations = nbIterations;
    }

    // méthode pour jouer un partie complète
    public void jouerPartie() {
        for (int iteration = 0; iteration < nbIterations; iteration++) {
            jouerIteration();
        }
        afficherScores(nbIterations);

    }

    public void jouerIteration(){

        // les joueurs jouent
        boolean choixJoueur1 = joueur1.jouer();
        boolean choixJoueur2 = joueur2.jouer();

        // calcul des résultats
        int resultatJoueur1;
        int resultatJoueur2;
        if (choixJoueur1) {
            System.out.println("joueur 1 a coopéré" );
            if (choixJoueur2) {
                System.out.println("joueur 2 a coopéré" );
                resultatJoueur1 = COOPERE;
                resultatJoueur2 = COOPERE;
            } else {
                System.out.println("joueur 2 a trahis" );
                resultatJoueur1 = DUPEE;
                resultatJoueur2 = TRAHIT;
            }
        } else {
            System.out.println("joueur 1 a trahis" );
            if (choixJoueur2) {
                System.out.println("joueur 2 a coopéré" );
                resultatJoueur1 = TRAHIT;
                resultatJoueur2 = DUPEE;

            } else {
                System.out.println("joueur 2 a trahis" );
                resultatJoueur1 = PIEGEE;
                resultatJoueur2 = PIEGEE;

            }
        }

        // affichage des resultats
        System.out.println("joueur 1 a gagné : " + resultatJoueur1 );
        System.out.println("joueur 2 a gagné : " + resultatJoueur2 );


        // ajout des parties a l'historique pour les IA
        joueur1.aJouterPartieHistorique(new PartieJouee(choixJoueur1,choixJoueur2,resultatJoueur1));
        joueur2.aJouterPartieHistorique(new PartieJouee(choixJoueur2,choixJoueur1,resultatJoueur2));

    }

    public void afficherScores(int iterations){
        System.out.println("la partie a durée " + iterations + " itérations" );
        System.out.println("joueur 1 a un score de : " + joueur1.scoreTotal());
        System.out.println("joueur 2 a un score de : " + joueur2.scoreTotal());
    }
}
