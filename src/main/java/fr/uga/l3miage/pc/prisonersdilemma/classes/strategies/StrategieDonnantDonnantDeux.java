package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieDonnantDonnantDeux extends BaseStrategie {

    // on assume que la strategie est naive (commence par coopération)
    @Override
    public boolean jouer(List<PartieJouee> historique){
        int tailleHist = historique.size();

        if(tailleHist < 2){
            return true;
        } else {

            // si l'autre joueur effectue le même coup deux fois, alors la stratégie réciproque
            // sinon la stratégie coopère (parce qu'elle est sympa)

            if(historique.get(tailleHist - 1).isChoixAutreJoueur() == historique.get(tailleHist - 2).isChoixAutreJoueur()){
                return historique.get(tailleHist - 1).isChoixAutreJoueur();
            } else {
                return true;
            }
        }
    }
}
