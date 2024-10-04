package fr.uga.l3miage.pc.prisonersdilemma.classes;

public class PartieIterative {

    //les valeurs donnes dans le sujet
    private final int T = 5;
    private final int D = 0;
    private final int C = 3;
    private final int P = 1;



    private Joueur joueur1;
    private Joueur joueur2;

    private int nb_iterations;

    // contructeur decide si les joueurs sont des utilisateurs ou des IA
    public PartieIterative(boolean controle_joueur1, boolean controle_joueur2,int nb_iterations) {
        this.joueur1 = new Joueur(controle_joueur1);
        this.joueur2 = new Joueur(controle_joueur2);
        this.nb_iterations = nb_iterations;
    }

    // méthode pour jouer un partie complète
    public void jouerPartie() {
        for (int iteration = 0; iteration < nb_iterations; iteration++) {
            jouerIteration();
        }
        afficherScores(nb_iterations);

    }

    public void jouerIteration(){

        // les joueurs jouent
        boolean choix_joueur1 = joueur1.jouer();
        boolean choix_joueur2 = joueur2.jouer();

        // calcul des résultats
        int resultat_Joueur1;
        int resultat_Joueur2;
        if (choix_joueur1) {
            System.out.println("joueur 1 a coopéré" );
            if (choix_joueur2) {
                System.out.println("joueur 2 a coopéré" );
                resultat_Joueur1 = C;
                resultat_Joueur2 = C;
            } else {
                System.out.println("joueur 2 a trahis" );
                resultat_Joueur1 = D;
                resultat_Joueur2 = T;
            }
        } else {
            System.out.println("joueur 1 a trahis" );
            if (choix_joueur2) {
                System.out.println("joueur 2 a coopéré" );
                resultat_Joueur1 = T;
                resultat_Joueur2 = D;

            } else {
                System.out.println("joueur 2 a trahis" );
                resultat_Joueur1 = P;
                resultat_Joueur2 = P;

            }
        }

        // affichage des resultats
        System.out.println("joueur 1 a gagné : " + resultat_Joueur1 );
        System.out.println("joueur 2 a gagné : " + resultat_Joueur2 );


        // ajout des parties a l'historique pour les IA
        joueur1.aJouterPartieHistorique(new PartieJouee(choix_joueur1,resultat_Joueur1));
        joueur2.aJouterPartieHistorique(new PartieJouee(choix_joueur2,resultat_Joueur2));

    }

    public void afficherScores(int iterations){
        System.out.println("la partie a durée " + iterations + " itérations" );
        System.out.println("joueur 1 a un score de : " + joueur1.scoreTotal());
        System.out.println("joueur 2 a un score de : " + joueur2.scoreTotal());
    }
}
