package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class Strategie_toujour_coopérer extends Strategie{
    @Override
    public boolean jouer(List<PartieJouee> historique){
        return true;
    }
}
