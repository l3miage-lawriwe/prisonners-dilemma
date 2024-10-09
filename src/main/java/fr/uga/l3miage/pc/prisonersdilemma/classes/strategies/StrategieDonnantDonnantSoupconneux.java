package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieDonnantDonnantSoupconneux extends Strategie{
    @Override
    public boolean jouer(List<PartieJouee> historique){

        if(historique.isEmpty()){
            return false;
        } else {
            return historique.getLast().choix_autre_joueur;
        }
    }
}
