package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategiePacificateurNaif extends BaseStrategieAleatoire {
    @Override
    public boolean jouer(List<PartieJouee> historique){

        BaseStrategie strat;

        if (this.random.nextInt(100) < 10){
            strat = new StrategieToujoursCooperer();
        } else {
            strat = new StrategieDonnantDonnant();
        }
        return strat.jouer(historique);
    }
}
