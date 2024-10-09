package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategiePavlov extends Strategie{
    @Override
    public boolean jouer(List<PartieJouee> historique){
        if(historique.isEmpty()){
            return true;
        } else {
            if(historique.getLast().resultat_joueur > PartieIterative.PIEGEE){
                return historique.getLast().choix_joueur;
            } else {
                return !(historique.getLast().choix_joueur);
            }
        }
    }
}
