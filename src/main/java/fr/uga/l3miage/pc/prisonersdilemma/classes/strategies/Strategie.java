package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

import java.util.List;

public abstract class Strategie {

    public abstract boolean jouer(List<PartieJouee> historique);
}