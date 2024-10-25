package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieSondeurRepentant extends Strategie {
    @Override
    public boolean jouer(List<PartieJouee> historique){

        Strategie strat;
        int tailleHist = historique.size();

        if(tailleHist < 2){
            strat = new StrategieSondeurNaif();
        } else {
            // check si on a trahis puis l'autre joueur a trahis en réponse
            if(!(historique.get(tailleHist - 2).isChoixJoueur()) && !(historique.get(tailleHist - 1).isChoixAutreJoueur())){
                strat = new StrategieToujoursCooperer();
            } else {
                strat = new StrategieSondeurNaif();
                
            }
        }
        return strat.jouer(historique);
    }
}
