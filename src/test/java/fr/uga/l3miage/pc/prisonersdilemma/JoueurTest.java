package fr.uga.l3miage.pc.prisonersdilemma;


import fr.uga.l3miage.pc.prisonersdilemma.classes.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.TypeStrategieEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class JoueurTest {
    @Test
    void testScoreTotal() {
        Joueur joueur = new Joueur();
        joueur.changerstrategies(1);
        assertEquals(0,joueur.scoreTotal());

        joueur.aJouterPartieHistorique(new PartieJouee(true,false,0));
        assertEquals(0,joueur.scoreTotal());

        joueur.aJouterPartieHistorique(new PartieJouee(true,false,3));
        assertEquals(3,joueur.scoreTotal());

        joueur.aJouterPartieHistorique(new PartieJouee(true,false,5));
        assertEquals(8,joueur.scoreTotal());
    }

    @Test
    void testJouer() {
        Joueur joueur = new Joueur();
        joueur.changerstrategies(15);
        assertTrue(joueur.jouer(false,false));
    }
}
