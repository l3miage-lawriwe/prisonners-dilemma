package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieRancunier extends Strategie {

    @Override
    public boolean jouer(List<PartieJouee> historique){
        
        int i = 0;

        while(i < historique.size()){
            if (!historique.get(i).isChoixAutreJoueur()) {
                return false;
            }
            i++;
        }


        return true;

    }
}
