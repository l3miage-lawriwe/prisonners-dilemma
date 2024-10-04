package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

import java.util.List;

public class Strategie_toujour_trahir extends Strategie{

    public boolean jouer(List<PartieJouee> historique){
        return false;
    }
}
