package fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;

public class StrategieRancunier implements BaseStrategie {

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
