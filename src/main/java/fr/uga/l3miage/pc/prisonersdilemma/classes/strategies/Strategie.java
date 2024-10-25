package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

import java.security.SecureRandom;
import java.util.List;

public abstract class Strategie {

    // utilisé par les stratégies qui utilisent de l'aléatoires
    SecureRandom random = new SecureRandom();

    public abstract boolean jouer(List<PartieJouee> historique);

    // seed manuel pour les tests de stratégies aléatoires
    public void setSeed(long seed){
        random.setSeed(seed);
    }
}
