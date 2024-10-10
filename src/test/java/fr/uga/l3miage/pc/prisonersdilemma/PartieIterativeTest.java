package fr.uga.l3miage.pc.prisonersdilemma;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class PartieIterativeTest {
    @Test
    void testPartieEgale() {
        PartieIterative partie = new PartieIterative(1,1,10);
        assertNull(partie.jouerPartie());
    }
}