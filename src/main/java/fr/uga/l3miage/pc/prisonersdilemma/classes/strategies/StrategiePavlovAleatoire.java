package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategiePavlovAleatoire extends BaseStrategieAleatoire {
    @Override
    public boolean jouer(List<PartieJouee> historique){



        if (this.random.nextInt(100) < 10){
            BaseStrategieAleatoire strat;
            strat = new StrategieAleatoire();
            strat.setRandom(this.random);
            return strat.jouer(historique);
        } else {
            BaseStrategie strat;
            strat = new StrategiePavlov ();
            return strat.jouer(historique);
        }

    }
}
