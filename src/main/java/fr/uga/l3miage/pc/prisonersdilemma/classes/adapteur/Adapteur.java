package fr.uga.l3miage.pc.prisonersdilemma.classes.adapteur;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.model.TypeStrategieEnum;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.ArrayList;
import java.util.List;

public class Adapteur {

    Strategie strategie;

    public void setStrategie(TypeStrategieEnum num){
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(num);

    }

    // JOUER LES STRATEGIES DU JAR, A MODIFIER EN URGENCE
    public boolean jouerStrategiesAdapteur( List<PartieJouee> historique){

        List<Decision> decisions = new ArrayList<>();

        // ADAPTATION DE L'HISTORIQUE
        for (PartieJouee partie : historique) {
            Decision decision;
            if(partie.isChoixAutreJoueur()){
                decision = Decision.COOPERER;
            } else {
                decision = Decision.TRAHIR;
            }
            decisions.add(decision);
        }

        return strategie.faireChoix(decisions) != Decision.TRAHIR;
    }
}
