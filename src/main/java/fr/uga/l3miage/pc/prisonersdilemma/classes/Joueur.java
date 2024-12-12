package fr.uga.l3miage.pc.prisonersdilemma.classes;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

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

    // Adaptateur pour les stratégies alternatives
    private Adapteur adapteur = new Adapteur();

    // historique, sert aux stratégie
    private final List<PartieJouee> historique = new ArrayList<>();
    // true = stratégie standard ou alternative, false = manuel
    private boolean modeStrategie;
    // true = stratégie alternative, false = standard


    public Joueur() {
        this.modeStrategie = false;
    }

    // le boolean "strategieAlternative" sert a savoir si on veut utiliser le package de strategie du groupe 1_6
    public boolean jouer(boolean strategieAlternative, boolean choixManuel) {
        if (modeStrategie) {
            return strategieAlternative
                    ? adapteur.jouerStrategiesAdapteur(historique) // Utilise le package de strategie du groupe 1_6
                    : baseStrategie.jouer(historique); // Nos stratégies
        } else {
            return choixManuel; // Choix manuel
        }
    }


    public int scoreTotal() {
        int score = 0;

        for (PartieJouee partieJouee : historique) {
            score = score + partieJouee.getResultatJoueur();
        }
        return score;
    }

    public void aJouterPartieHistorique(PartieJouee nouvellePartie) {
        historique.add(nouvellePartie);
    }

    //Pour le bot
    public void choisirStrategieAleatoire() {
        SecureRandom random = new SecureRandom();
        if (random.nextBoolean()) { // Choix aléatoire entre standard et alternative
            int strategieAleatoire = random.nextInt(18) + 1; // Stratégies standards
            changerstrategies(strategieAleatoire);
            log.info("Bot a choisi une stratégie standard : {}", strategieAleatoire);
        } else {
            int strategieAlternative = random.nextInt(18) + 1; // stratégies alternatives du groupe 1_6
            adapteur.setStrategie(strategieAlternative);
            log.info("Bot a choisi une stratégie alternative : {}", strategieAlternative);
        }
    }

    private void changerstrategies(int numeroStrategie) {
        adapteur.setStrategie(numeroStrategie);
        baseStrategie = StrategieFactory.createStrategie(numeroStrategie);
        modeStrategie = true;
    }

    public static Joueur createBot() {
        Joueur bot = new Joueur();
        bot.choisirStrategieAleatoire();
        return bot;
    }

    public List<PartieJouee> getHistorique() {
        return historique;
    }
}