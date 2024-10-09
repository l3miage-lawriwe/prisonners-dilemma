package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.security.SecureRandom;
import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieAleatoire extends Strategie{
    SecureRandom random = new SecureRandom();

    @Override
    public boolean jouer(List<PartieJouee> historique){
        return this.random.nextInt(100) > 50;
    }
}
