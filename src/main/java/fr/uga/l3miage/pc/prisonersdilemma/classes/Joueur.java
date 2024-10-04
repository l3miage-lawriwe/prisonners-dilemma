package fr.uga.l3miage.pc.prisonersdilemma.classes;

import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.Strategie_toujour_trahir;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Joueur {

    // decide si l'IA ou l'utilisateur joue
    private boolean controle_utilisateur;

    // l'IA de decision si il n'y a pas d'utilisateur en controle
    private Strategie strategie;

    // historique, sert a l'IA pour décider
    private List<PartieJouee> historique = new ArrayList<PartieJouee>();

    public Joueur(boolean controle_utilisateur) {
        this.controle_utilisateur = controle_utilisateur;
        if(!controle_utilisateur){
            definirStrategie();
        }
    }

    // le joueur joue sont coup, si utilisateur, utilise console de commande, sinon on lnce l'IA
    public boolean jouer(){
        if (controle_utilisateur){
            Scanner reader = new Scanner(System.in); // Reading from System.in
            System.out.println("marquer 'T' pour trahir, marquer autre chose pour coopérer");
            String reponse = reader.next();

            return !(reponse.equals("T"));
        } else {
            return strategie.jouer(historique);
        }
    }

    public int scoreTotal(){
        int score = 0;

        for(PartieJouee pj : historique){
            score = score + pj.resultat_joueur;
        }
        return score;
    }

    public void aJouterPartieHistorique(PartieJouee nouvelle_partie){
        historique.add(nouvelle_partie);
    }

    private void demanderActiverIA(){
        Scanner reader = new Scanner(System.in); // Reading from System.in
        System.out.println("activer IA ? (Y/N)");
        String reponse = reader.next();

        if (reponse.equals("Y")){
            controle_utilisateur = false;
            definirStrategie();

        }
    }


    // definir la strat de L'IA
    private void definirStrategie(){
        Scanner reader = new Scanner(System.in);
        System.out.println("choisir strategie");
        int numero_strategie = reader.nextInt();

        /*
         *
         *  ICI on change la strategie affectee selon l'INT que l'utilisateur rentre
         *
         * */

        strategie = new Strategie_toujour_trahir();
    }
}
