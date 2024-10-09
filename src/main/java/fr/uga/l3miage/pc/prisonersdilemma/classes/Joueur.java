package fr.uga.l3miage.pc.prisonersdilemma.classes;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieAleatoire;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieDonnantDonnant;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieDonnantDonnantSoupconneux;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategiePavlov;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieRancunier;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieToujoursCooperer;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieToujoursTrahir;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Joueur {
    private static final Logger log = LogManager.getLogger(Joueur.class);

    // pour chaque choix :
    // TRUE veut dire coopérer
    // FALSE veut dire trahir

    // decide si l'IA ou l'utilisateur joue
    private final boolean controleUtilisateur;

    // l'IA de decision si il n'y a pas d'utilisateur en controle
    private Strategie strategie;

    // historique, sert a l'IA pour décider
    private final List<PartieJouee> historique = new ArrayList<>();

    public Joueur(boolean controleUtilisateur) {
        this.controleUtilisateur = controleUtilisateur;
        if(!controleUtilisateur){
            definirStrategie();
        }
    }

    // le joueur joue sont coup, si utilisateur, utilise console de commande, sinon on lance l'IA
    public boolean jouer(){
        if (controleUtilisateur){
            Scanner reader = new Scanner(System.in); // Reading from System.in
            log.info("marquer 'T' pour trahir, marquer autre chose pour coopérer");
            String reponse = reader.next();

            return !(reponse.equals("T"));
        } else {
            return strategie.jouer(historique);
        }
    }

    public int scoreTotal(){
        int score = 0;

        for(PartieJouee partieJouee : historique){
            score = score + partieJouee.getResultatJoueur();
        }
        return score;
    }

    public void aJouterPartieHistorique(PartieJouee nouvellePartie){
        historique.add(nouvellePartie);
    }


    // definir la strat de L'IA
    private void definirStrategie(){
        Scanner reader = new Scanner(System.in);
        log.info("choisir strategie");

        int numeroStrategie = reader.nextInt();

        switch(numeroStrategie) {
            case 0:
                strategie = new StrategieToujoursTrahir();
                break;
            case 1:
                strategie = new StrategieRancunier();
                break;
            case 2:
                strategie = new StrategieAleatoire();
                break;
            case 3:
                strategie = new StrategieDonnantDonnantSoupconneux();
                break;
            case 4:
                strategie = new StrategieDonnantDonnant();
                break;
            case 5:
                strategie = new StrategiePavlov();
                break;
            default:
                strategie = new StrategieToujoursCooperer();
          }
          

        /*
         *
         *  ICI on change la strategie affectee selon l'INT que l'utilisateur rentre
         *  
         * A IMPLEMENTER DE MANIERE PLUS LISIBLE PAR L'UTILISATEUR DANS LE FUTUR
         *
         * */

        
    }
}
