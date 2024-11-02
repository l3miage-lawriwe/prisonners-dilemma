package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategiePavlovAleatoire extends Strategie {
    @Override
    public boolean jouer(List<PartieJouee> historique){

        Strategie strat;

        if (this.random.nextInt(100) > 90){
            strat = new StrategieAleatoire();
            strat.setSeed(this.seed);
        } else {
            strat = new StrategiePavlov ();
        }
        return strat.jouer(historique);
    }
}
