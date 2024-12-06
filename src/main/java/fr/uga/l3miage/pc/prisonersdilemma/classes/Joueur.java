package fr.uga.l3miage.pc.prisonersdilemma.classes;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.uga.l3miage.pc.prisonersdilemma.classes.adapteur.Adapteur;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Joueur {
    private static final Logger log = LogManager.getLogger(Joueur.class);

    // pour chaque choix :
    // TRUE veut dire coopérer
    // FALSE veut dire trahir

    // decide si l'IA ou l'utilisateur joue

    // l'IA de decision si il n'y a pas d'utilisateur en controle
    private BaseStrategie baseStrategie;

    private Adapteur adapteur = new Adapteur();

    // historique, sert a l'IA pour décider
    private final List<PartieJouee> historique = new ArrayList<>();

    public Joueur(int strategie) {
        this.baseStrategie = StrategieFactory.createStrategie(strategie);
        this.adapteur.setStrategie(strategie);
    }

    public Joueur() {
        definirStrategie();
    }

    // le joueur joue sont coup, si utilisateur, utilise console de commande, sinon on lance l'IA
    // le boolean "strategieAlternative" sert a savoir si on veut utiliser le package de strategie du groupe 1_6
    public boolean jouer(boolean strategieAlternative){
        if (!strategieAlternative){
            return baseStrategie.jouer(historique);
        } else {

            // faire appel a la classe adaptateur
            return adapteur.jouerStrategiesAdapteur(historique);

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


    private void definirStrategie(){
        Scanner reader = new Scanner(System.in);
        log.info("choisir strategie");

        int numeroStrategie = reader.nextInt();
        changerstrategies(numeroStrategie);

    }

    private void changerstrategies(int numeroStrategie){
        adapteur.setStrategie(numeroStrategie);
        baseStrategie = StrategieFactory.createStrategie(numeroStrategie);
    }


}
