package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

import java.security.SecureRandom;
import java.util.List;

public abstract class Strategie {

    // utilisé par les stratégies qui utilisent de l'aléatoire
    SecureRandom random = new SecureRandom();

    public abstract boolean jouer(List<PartieJouee> historique);

    // setRandom permet de mettre un mock du random durant les tests
    public void setRandom(SecureRandom newRandom) {
        this.random = newRandom;
    }
}
