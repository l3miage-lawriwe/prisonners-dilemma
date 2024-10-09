package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class Strategie_pavlov extends Strategie{
    @Override
    public boolean jouer(List<PartieJouee> historique){
        if(historique.isEmpty()){
            return true;
        } else {
            if(historique.get(historique.size() -1).resultat_joueur > PartieIterative.PIEGEE){
                return historique.get(historique.size() -1).choix_joueur;
            } else {
                return !(historique.get(historique.size() -1).choix_joueur);
            }
        }
    }
}
