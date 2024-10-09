package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieToujoursCooperer implements Strategie {
    @Override
    public boolean jouer(List<PartieJouee> historique){
        return true;
    }
}
