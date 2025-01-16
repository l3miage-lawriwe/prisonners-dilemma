package fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;

import java.util.List;

public interface BaseStrategie {


    public abstract boolean jouer(List<PartieJouee> historique);


}
