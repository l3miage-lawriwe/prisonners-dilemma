package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieSondeurRepentant extends BaseStrategieAleatoire {
    @Override
    public boolean jouer(List<PartieJouee> historique){

        int tailleHist = historique.size();

        if(tailleHist < 2){
            BaseStrategieAleatoire strat;
            strat = new StrategieSondeurNaif();
            strat.setRandom(this.random);
            return strat.jouer(historique);
        } else {
            // check si on a trahis puis l'autre joueur a trahis en réponse
            if(!(historique.get(tailleHist - 2).isChoixJoueur()) && !(historique.get(tailleHist - 1).isChoixAutreJoueur())){
                BaseStrategie strat;
                strat = new StrategieToujoursCooperer();
                return strat.jouer(historique);
            } else {
                BaseStrategieAleatoire strat;
                strat = new StrategieSondeurNaif();
                strat.setRandom(this.random);
                return strat.jouer(historique);
            }
        }

    }
}
