package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategiePavlov implements Strategie {
    @Override
    public boolean jouer(List<PartieJouee> historique){
        if(historique.isEmpty()){
            return true;
        } else {
            if(historique.getLast().getResultatJoueur() > PartieIterative.PIEGEE){
                return historique.getLast().isChoixJoueur();
            } else {
                return !(historique.getLast().isChoixJoueur());
            }
        }
    }
}
