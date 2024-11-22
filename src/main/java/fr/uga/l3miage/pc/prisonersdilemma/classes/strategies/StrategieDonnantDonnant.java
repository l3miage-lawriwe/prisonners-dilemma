package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieDonnantDonnant extends BaseStrategie {
    @Override
    public boolean jouer(List<PartieJouee> historique){

        if(historique.isEmpty()){
            return true;
        } else {
            return historique.getLast().isChoixAutreJoueur();
        }
    }
}
