package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;
import java.util.Random;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class Strategie_aleatoire extends Strategie{
    @Override
    public boolean jouer(List<PartieJouee> historique){
        Random rand = new Random();
        return rand.nextInt(100) > 50;
    }
}
