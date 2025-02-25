package fr.uga.l3miage.pc.prisonersdilemma.game;


import fr.uga.l3miage.pc.prisonersdilemma.classes.game.model.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.game.model.TypeStrategieEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class JoueurTest {
    @Test
    void testScoreTotal() {
        Joueur joueur = new Joueur();
        joueur.changerstrategies(TypeStrategieEnum.ADAPTATIF);
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
        joueur.changerstrategies(TypeStrategieEnum.COOPERER);
        assertTrue(joueur.jouer(false,false));
    }
}
