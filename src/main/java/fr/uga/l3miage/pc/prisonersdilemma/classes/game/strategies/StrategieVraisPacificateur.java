package fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;

public class StrategieVraisPacificateur extends BaseStrategieAleatoire {

    // on assume que la strategie est naive (commence par coopération)
    @Override
    public boolean jouer(List<PartieJouee> historique){
        
        int tailleHist = historique.size();
        if(tailleHist < 2){
            return true;
        } else {
            if(!(historique.get(tailleHist - 1).isChoixAutreJoueur()) && !(historique.get(tailleHist - 2).isChoixAutreJoueur())){
                return this.random.nextInt(100) < 10;
            } else {
                return true;
            }
        }
    }
}
