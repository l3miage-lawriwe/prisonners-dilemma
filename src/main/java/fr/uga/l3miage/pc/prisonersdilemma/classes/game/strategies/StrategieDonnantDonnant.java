package fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;

public class StrategieDonnantDonnant implements BaseStrategie {
    @Override
    public boolean jouer(List<PartieJouee> historique){

        if(historique.isEmpty()){
            return true;
        } else {
            return historique.getLast().isChoixAutreJoueur();
        }
    }
}
