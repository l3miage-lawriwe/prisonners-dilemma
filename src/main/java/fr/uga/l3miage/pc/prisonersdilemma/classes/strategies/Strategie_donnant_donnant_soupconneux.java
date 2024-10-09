package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class Strategie_donnant_donnant_soupconneux extends Strategie{
    @Override
    public boolean jouer(List<PartieJouee> historique){

        if(historique.isEmpty()){
            return false;
        } else {
            return historique.get(historique.size() -1).choix_autre_joueur;
        }
    }
}
