package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class Strategie_rancunier extends Strategie{

    @Override
    public boolean jouer(List<PartieJouee> historique){
        
        int i = 0;

        while(i < historique.size()){
            if (historique.get(i).choix_autre_joueur == false) {
                return false;
            }
            i++;
        }


        return true;

    }
}
