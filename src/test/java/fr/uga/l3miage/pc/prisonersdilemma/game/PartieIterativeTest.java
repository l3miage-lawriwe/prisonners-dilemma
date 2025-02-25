package fr.uga.l3miage.pc.prisonersdilemma.game;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.model.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieIterative;
import fr.uga.l3miage.pc.prisonersdilemma.classes.game.model.TypeStrategieEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class PartieIterativeTest {


    // outdated, a revoir
    @Test
    void testPartieEgale() {
        Joueur joueur1 = new Joueur();
        joueur1.changerstrategies(TypeStrategieEnum.ADAPTATIF);

        Joueur joueur2 = new Joueur();
        joueur2.changerstrategies(TypeStrategieEnum.ADAPTATIF);

        PartieIterative partie = new PartieIterative(joueur1,joueur2,10);
        assertNotNull(partie.jouerIteration(true,true));
    }
}