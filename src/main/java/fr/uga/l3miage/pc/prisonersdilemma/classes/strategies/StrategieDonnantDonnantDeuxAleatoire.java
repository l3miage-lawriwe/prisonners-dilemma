package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieDonnantDonnantDeuxAleatoire extends Strategie {


    @Override
    public boolean jouer(List<PartieJouee> historique){

        Strategie strat;

        if (this.random.nextInt(100) < 10){
            strat = new StrategieAleatoire();
            strat.setRandom(this.random);
        } else {
            strat = new StrategieDonnantDonnantDeux();
        }
        return strat.jouer(historique);
    }
}
