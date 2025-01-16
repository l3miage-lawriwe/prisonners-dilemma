package fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieIterative;
import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;

public class StrategiePavlov implements BaseStrategie {
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
