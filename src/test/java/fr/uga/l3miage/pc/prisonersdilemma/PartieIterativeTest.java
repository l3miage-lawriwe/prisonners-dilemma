package fr.uga.l3miage.pc.prisonersdilemma;

import fr.uga.l3miage.pc.prisonersdilemma.classes.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class PartieIterativeTest {


    // outdated, a revoir
    @Test
    void testPartieEgale() {
        Joueur joueur1 = new Joueur();
        joueur1.changerstrategies(1);

        Joueur joueur2 = new Joueur();
        joueur2.changerstrategies(1);

        PartieIterative partie = new PartieIterative(joueur1,joueur2,10);
        assertNotNull(partie.jouerIteration(true,true));
    }
}