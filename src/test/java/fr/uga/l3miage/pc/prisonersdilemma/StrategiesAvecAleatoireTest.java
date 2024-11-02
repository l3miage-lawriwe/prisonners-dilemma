package fr.uga.l3miage.pc.prisonersdilemma;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StrategiesAvecAleatoireTest {

    @Test
    void testAléatoire(){
        StrategieAleatoire strategieAleatoire = new StrategieAleatoire();
        List<PartieJouee> historique = new ArrayList<>();
        // on seed le random pour avoir le même résultat a chaque fois
        strategieAleatoire.setSeed(1);

        assertFalse(strategieAleatoire.jouer(historique));

    }


    @Test
    void testDonnanDonnantAléatoire() {
        StrategieDonnantDonnantAleatoire strategieDonnantDonnantAleatoire = new StrategieDonnantDonnantAleatoire();
        List<PartieJouee> historique = new ArrayList<>();
        // on seed le random pour avoir le même résultat a chaque fois
        strategieDonnantDonnantAleatoire.setSeed(1);

        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieDonnantDonnantAleatoire.jouer(historique));


        // pas de trahison aléatoire ici
        for (int i = 0; i < 7; i++) {
            historique.add(new PartieJouee(true,true,3));
            assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));
        }


        // ici la stratégie décide aléatoirement de trahir
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieDonnantDonnantAleatoire.jouer(historique));
    }


    @Test
    void testDonnanDonnantDeuxAléatoire() {
        StrategieDonnantDonnantDeuxAleatoire strategieDonnantDonnantDeuxAleatoire = new StrategieDonnantDonnantDeuxAleatoire();
        List<PartieJouee> historique = new ArrayList<>();
        strategieDonnantDonnantDeuxAleatoire.setSeed(1);
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));


        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,false,3));
        assertFalse(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        // pas de trahison aléatoire ici
        for (int i = 0; i < 6; i++) {
            historique.add(new PartieJouee(true,true,3));
            assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));
        }

        // ici la stratégie décide aléatoirement de trahir
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieDonnantDonnantDeuxAleatoire.jouer(historique));
    }

    @Test
    void testSondeurNaif(){
        StrategieSondeurNaif strategieSondeurNaif = new StrategieSondeurNaif();
        List<PartieJouee> historique = new ArrayList<>();
        // on seed le random pour avoir le même résultat a chaque fois
        strategieSondeurNaif.setSeed(1);

        assertTrue(strategieSondeurNaif.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieSondeurNaif.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieSondeurNaif.jouer(historique));

        // pas de trahison aléatoire ici
        for (int i = 0; i < 7; i++) {
            historique.add(new PartieJouee(true,true,3));
            assertTrue(strategieSondeurNaif.jouer(historique));
        }

        // ici la stratégie décide aléatoirement de trahir
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieSondeurNaif.jouer(historique));
    }

    @Test
    void testSondeurRepentant(){
        StrategieSondeurRepentant strategieSondeurRepentant = new StrategieSondeurRepentant();
        List<PartieJouee> historique = new ArrayList<>();
        // on seed le random pour avoir le même résultat a chaque fois
        strategieSondeurRepentant.setSeed(1);

        assertTrue(strategieSondeurRepentant.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieSondeurRepentant.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieSondeurRepentant.jouer(historique));

        // pas de trahison aléatoire ici
        for (int i = 0; i < 5; i++) {
            historique.add(new PartieJouee(true,true,3));
            assertTrue(strategieSondeurRepentant.jouer(historique));
        }

        // ici la stratégie décide aléatoirement de trahir
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieSondeurRepentant.jouer(historique));

        // reprent le fonctionnement normal
        historique.add(new PartieJouee(false,false,3));
        assertFalse(strategieSondeurRepentant.jouer(historique));

        // essaie de se repentir car l'autre joueur a trahis en réponse
        historique.add(new PartieJouee(false,false,3));
        assertTrue(strategieSondeurRepentant.jouer(historique));
    }
    @Test
    void testPacificateurNaif() {
        StrategiePacificateurNaif strategiePacificateurNaif = new StrategiePacificateurNaif();
        List<PartieJouee> historique = new ArrayList<>();
        // on seed le random pour avoir le même résultat a chaque fois
        strategiePacificateurNaif.setSeed(1);

        assertTrue(strategiePacificateurNaif.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategiePacificateurNaif.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategiePacificateurNaif.jouer(historique));


        // fonctionne comme donnant donnant ici
        for (int i = 0; i < 7; i++) {
            historique.add(new PartieJouee(false,false,0));
            assertFalse(strategiePacificateurNaif.jouer(historique));
        }


        // ici la stratégie décide aléatoirement de faire la paix
        historique.add(new PartieJouee(false,false,0));
        assertTrue(strategiePacificateurNaif.jouer(historique));
    }


    @Test
    void testVraisPacificateur() {
        StrategieVraisPacificateur strategieVraisPacificateur = new StrategieVraisPacificateur();
        List<PartieJouee> historique = new ArrayList<>();
        // on seed le random pour avoir le même résultat a chaque fois
        strategieVraisPacificateur.setSeed(1);

        assertTrue(strategieVraisPacificateur.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieVraisPacificateur.jouer(historique));

        // ne se venge pas encore
        historique.add(new PartieJouee(true,false,0));
        assertTrue(strategieVraisPacificateur.jouer(historique));


        for (int i = 0; i < 10; i++) {
            historique.add(new PartieJouee(false,false,0));
            assertFalse(strategieVraisPacificateur.jouer(historique));
        }

        // ici la stratégie décide aléatoirement de faire la paix
        historique.add(new PartieJouee(false,false,0));
        assertTrue(strategieVraisPacificateur.jouer(historique));
    }

    @Test
    void testPavlovAleatoire() {
        StrategiePavlovAleatoire strategiePavlovAleatoire = new StrategiePavlovAleatoire();
        List<PartieJouee> historique = new ArrayList<>();
        strategiePavlovAleatoire.setSeed(1);

        assertTrue(strategiePavlovAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategiePavlovAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategiePavlovAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategiePavlovAleatoire.jouer(historique));

        // fonctionnement standart
        for (int i = 0; i < 6; i++) {
            historique.add(new PartieJouee(true,true,3));
            assertTrue(strategiePavlovAleatoire.jouer(historique));
        }

        //trahison aléatoire
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategiePavlovAleatoire.jouer(historique));
    }

}