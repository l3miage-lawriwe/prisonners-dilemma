package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;
import java.util.Random;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieAleatoire extends Strategie{
    private final Random rand = new Random();

    @Override
    public boolean jouer(List<PartieJouee> historique){
        return this.rand.nextInt(100) > 50;
    }
}
