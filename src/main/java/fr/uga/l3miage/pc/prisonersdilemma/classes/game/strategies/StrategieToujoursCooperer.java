package fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;

public class StrategieToujoursCooperer implements BaseStrategie {
    @Override
    public boolean jouer(List<PartieJouee> historique){
        return true;
    }
}
