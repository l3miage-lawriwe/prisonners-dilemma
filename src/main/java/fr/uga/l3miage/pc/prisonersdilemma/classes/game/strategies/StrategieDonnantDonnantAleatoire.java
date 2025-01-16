package fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;

public class StrategieDonnantDonnantAleatoire extends BaseStrategieAleatoire {

    @Override
    public boolean jouer(List<PartieJouee> historique){



        if (this.random.nextInt(100) < 10){
            BaseStrategieAleatoire strat;
            strat = new StrategieAleatoire();
            strat.setRandom(this.random);
            return strat.jouer(historique);
        } else {
            BaseStrategie strat;
            strat = new StrategieDonnantDonnant();
            return strat.jouer(historique);
        }

    }
}
