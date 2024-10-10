package fr.uga.l3miage.pc.prisonersdilemma.StrategiesTest;


import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StrategiesTest {
    @Test
    void testToujourTrahir() {
        Strategie strategieTraitre = new StrategieToujoursTrahir();
        List<PartieJouee> historique = new ArrayList<>();
        assertFalse(strategieTraitre.jouer(historique));
    }

    @Test
    void testToujourcooperer() {
        Strategie strategieNaif = new StrategieToujoursCooperer();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategieNaif.jouer(historique));
    }

    @Test
    void testDonnanDonnant() {
        Strategie strategieDonnantDonnant = new StrategieDonnantDonnant();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategieDonnantDonnant.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnant.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieDonnantDonnant.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnant.jouer(historique));
    }

    @Test
    void testDonnanDonnantSoupconneux() {
        Strategie strategieDonnantDonnantSoupconneux = new StrategieDonnantDonnantSoupconneux();
        List<PartieJouee> historique = new ArrayList<>();
        assertFalse(strategieDonnantDonnantSoupconneux.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantSoupconneux.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieDonnantDonnantSoupconneux.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantSoupconneux.jouer(historique));
    }

    @Test
    void testRancunier() {
        Strategie strategieRancunier = new StrategieRancunier();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategieRancunier.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieRancunier.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieRancunier.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieRancunier.jouer(historique));
    }
}
