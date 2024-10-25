package fr.uga.l3miage.pc.prisonersdilemma;


import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StrategiesTest {

    @Test
    void testAdaptatif(){
        StrategieAdaptatif strategieAdaptative = new StrategieAdaptatif();
        List<PartieJouee> historique = new ArrayList<>();

        // test de la séquence prédéfinie de début
        assertTrue(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(false,false,1));
        assertFalse(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(false,false,1));
        assertFalse(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(false,false,1));
        assertFalse(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(false,false,1));
        assertFalse(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(false,false,1));
        assertFalse(strategieAdaptative.jouer(historique));
        historique.add(new PartieJouee(false,false,1));

        //ici la stratégie calcule que coopérer est plus avantageux que trahir
        assertTrue(strategieAdaptative.jouer(historique));

        //ici la stratégie calcule que trahir est plus avantageuc que trahir basé sur le faut historique donné
        List<PartieJouee> fauxHistorique = new ArrayList<>();
        fauxHistorique.add(new PartieJouee(false,true,5));
        fauxHistorique.add(new PartieJouee(true,false,0));

        assertFalse(strategieAdaptative.jouer(fauxHistorique));


    }

    /*@Test
    void testAléatoire(){
        StrategieAleatoire strategieAleatoire = new StrategieAleatoire();
        List<PartieJouee> historique = new ArrayList<>();
        // on seed le random pour avoir le même résultat a chaque fois
        strategieAleatoire.setSeed(1);

        assertFalse(strategieAleatoire.jouer(historique));

    }*/


    @Test
    synchronized void testDonnanDonnant() {
        StrategieDonnantDonnant strategieDonnantDonnant = new StrategieDonnantDonnant();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategieDonnantDonnant.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnant.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieDonnantDonnant.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnant.jouer(historique));
    }


    /*@Test
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

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        // ici la stratégie décide aléatoirement de trahir
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieDonnantDonnantAleatoire.jouer(historique));
    }*/

    @Test
    void testDonnanDonnantDeux() {
        StrategieDonnantDonnantDeux strategieDonnantDonnantDeux = new StrategieDonnantDonnantDeux();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategieDonnantDonnantDeux.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeux.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertTrue(strategieDonnantDonnantDeux.jouer(historique));

        historique.add(new PartieJouee(true,false,3));
        assertFalse(strategieDonnantDonnantDeux.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeux.jouer(historique));
    }

    /*@Test
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

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        // ici la stratégie décide aléatoirement de trahir
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieDonnantDonnantDeuxAleatoire.jouer(historique));
    }*/


    @Test
    void testDonnanDonnantSoupconneux() {
        StrategieDonnantDonnantSoupconneux strategieDonnantDonnantSoupconneux = new StrategieDonnantDonnantSoupconneux();
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
    void testGraduel() {
        StrategieGraduel strategieGraduel = new StrategieGraduel();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategieGraduel.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieGraduel.jouer(historique));

        //trahison en réponse
        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieGraduel.jouer(historique));

        historique.add(new PartieJouee(false,true,3));
        assertTrue(strategieGraduel.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieGraduel.jouer(historique));

        //double trahison en réponse
        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieGraduel.jouer(historique));

        historique.add(new PartieJouee(false,true,0));
        assertFalse(strategieGraduel.jouer(historique));

        historique.add(new PartieJouee(false,false,3));
        assertTrue(strategieGraduel.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieGraduel.jouer(historique));
    }



    @Test
    void testPavlov() {
        StrategiePavlov strategiePavlov = new StrategiePavlov();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategiePavlov.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategiePavlov.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategiePavlov.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategiePavlov.jouer(historique));
    }

    @Test
    void testRancunier() {
        StrategieRancunier strategieRancunier = new StrategieRancunier();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategieRancunier.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieRancunier.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieRancunier.jouer(historique));

        historique.add(new PartieJouee(false,true,3));
        assertFalse(strategieRancunier.jouer(historique));
    }

    @Test
    void testRancunierDoux(){
        StrategieRancunierDoux strategieRancunierDoux = new StrategieRancunierDoux();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategieRancunierDoux.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieRancunierDoux.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieRancunierDoux.jouer(historique));

        historique.add(new PartieJouee(false,true,5));
        assertFalse(strategieRancunierDoux.jouer(historique));

        historique.add(new PartieJouee(false,true,5));
        assertFalse(strategieRancunierDoux.jouer(historique));

        historique.add(new PartieJouee(false,true,5));
        assertFalse(strategieRancunierDoux.jouer(historique));

        historique.add(new PartieJouee(false,true,5));
        assertFalse(strategieRancunierDoux.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieRancunierDoux.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieRancunierDoux.jouer(historique));

    }


    @Test
    void testToujourTrahir() {
        StrategieToujoursTrahir strategieTraitre = new StrategieToujoursTrahir();
        List<PartieJouee> historique = new ArrayList<>();
        assertFalse(strategieTraitre.jouer(historique));
    }

    @Test
    void testToujourcooperer() {
        StrategieToujoursCooperer strategieNaif = new StrategieToujoursCooperer();
        List<PartieJouee> historique = new ArrayList<>();
        assertTrue(strategieNaif.jouer(historique));
    }

}
