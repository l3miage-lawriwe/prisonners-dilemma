package fr.uga.l3miage.pc.prisonersdilemma.game;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StrategiesAvecAleatoireTest {

    @Test
    void testAléatoire(){
        StrategieAleatoire strategieAleatoire = new StrategieAleatoire();
        List<PartieJouee> historique = new ArrayList<>();

        SecureRandom mockedRandom = mock(SecureRandom.class);
        when(mockedRandom.nextInt(anyInt())).thenReturn(0);
        // on mock le random pour avoir le même résultat a chaque fois
        strategieAleatoire.setRandom(mockedRandom);

        assertFalse(strategieAleatoire.jouer(historique));

    }


    @Test
    void testDonnanDonnantAléatoire() {
        StrategieDonnantDonnantAleatoire strategieDonnantDonnantAleatoire = new StrategieDonnantDonnantAleatoire();
        List<PartieJouee> historique = new ArrayList<>();
        SecureRandom mockedRandom = mock(SecureRandom.class);
        when(mockedRandom.nextInt(anyInt())).thenReturn(90);
        // on mock le random pour avoir le même résultat a chaque fois
        strategieDonnantDonnantAleatoire.setRandom(mockedRandom);

        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieDonnantDonnantAleatoire.jouer(historique));

        //change l'aleatoire
        when(mockedRandom.nextInt(anyInt())).thenReturn(9);
        strategieDonnantDonnantAleatoire.setRandom(mockedRandom);

        // ici la stratégie décide aléatoirement de trahir
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieDonnantDonnantAleatoire.jouer(historique));
    }


    @Test
    void testDonnanDonnantDeuxAléatoire() {
        StrategieDonnantDonnantDeuxAleatoire strategieDonnantDonnantDeuxAleatoire = new StrategieDonnantDonnantDeuxAleatoire();
        List<PartieJouee> historique = new ArrayList<>();


        SecureRandom mockedRandom = mock(SecureRandom.class);
        when(mockedRandom.nextInt(anyInt())).thenReturn(90);
        // on mock le random pour avoir le même résultat a chaque fois
        strategieDonnantDonnantDeuxAleatoire.setRandom(mockedRandom);


        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));


        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,false,3));
        assertFalse(strategieDonnantDonnantDeuxAleatoire.jouer(historique));

        // pas de trahison aléatoire ici
        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieDonnantDonnantDeuxAleatoire.jouer(historique));


        //change l'aleatoire
        when(mockedRandom.nextInt(anyInt())).thenReturn(9);
        strategieDonnantDonnantDeuxAleatoire.setRandom(mockedRandom);


        // ici la stratégie décide aléatoirement de trahir
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieDonnantDonnantDeuxAleatoire.jouer(historique));
    }

    @Test
    void testSondeurNaif(){
        StrategieSondeurNaif strategieSondeurNaif = new StrategieSondeurNaif();
        List<PartieJouee> historique = new ArrayList<>();

        SecureRandom mockedRandom = mock(SecureRandom.class);
        when(mockedRandom.nextInt(anyInt())).thenReturn(90);
        // on mock le random pour avoir le même résultat a chaque fois
        strategieSondeurNaif.setRandom(mockedRandom);

        assertTrue(strategieSondeurNaif.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieSondeurNaif.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieSondeurNaif.jouer(historique));

        // pas de trahison aléatoire ici

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieSondeurNaif.jouer(historique));

        //change l'aleatoire
        when(mockedRandom.nextInt(anyInt())).thenReturn(9);
        strategieSondeurNaif.setRandom(mockedRandom);


        // ici la stratégie décide aléatoirement de trahir
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategieSondeurNaif.jouer(historique));
    }

    @Test
    void testSondeurRepentant(){
        StrategieSondeurRepentant strategieSondeurRepentant = new StrategieSondeurRepentant();
        List<PartieJouee> historique = new ArrayList<>();

        SecureRandom mockedRandom = mock(SecureRandom.class);
        when(mockedRandom.nextInt(anyInt())).thenReturn(90);
        // on mock le random pour avoir le même résultat a chaque fois
        strategieSondeurRepentant.setRandom(mockedRandom);


        assertTrue(strategieSondeurRepentant.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieSondeurRepentant.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategieSondeurRepentant.jouer(historique));

        // pas de trahison aléatoire ici
        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieSondeurRepentant.jouer(historique));

        //change l'aleatoire
        when(mockedRandom.nextInt(anyInt())).thenReturn(9);
        strategieSondeurRepentant.setRandom(mockedRandom);


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


        SecureRandom mockedRandom = mock(SecureRandom.class);
        when(mockedRandom.nextInt(anyInt())).thenReturn(90);
        // on mock le random pour avoir le même résultat a chaque fois
        strategiePacificateurNaif.setRandom(mockedRandom);

        assertTrue(strategiePacificateurNaif.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategiePacificateurNaif.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategiePacificateurNaif.jouer(historique));


        // fonctionne comme donnant donnant ici
        historique.add(new PartieJouee(false,false,0));
        assertFalse(strategiePacificateurNaif.jouer(historique));

        //change l'aleatoire
        when(mockedRandom.nextInt(anyInt())).thenReturn(9);
        strategiePacificateurNaif.setRandom(mockedRandom);

        // ici la stratégie décide aléatoirement de faire la paix
        historique.add(new PartieJouee(false,false,0));
        assertTrue(strategiePacificateurNaif.jouer(historique));
    }


    @Test
    void testVraisPacificateur() {
        StrategieVraisPacificateur strategieVraisPacificateur = new StrategieVraisPacificateur();
        List<PartieJouee> historique = new ArrayList<>();


        SecureRandom mockedRandom = mock(SecureRandom.class);
        when(mockedRandom.nextInt(anyInt())).thenReturn(90);
        // on mock le random pour avoir le même résultat a chaque fois
        strategieVraisPacificateur.setRandom(mockedRandom);

        assertTrue(strategieVraisPacificateur.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategieVraisPacificateur.jouer(historique));

        // ne se venge pas encore
        historique.add(new PartieJouee(true,false,0));
        assertTrue(strategieVraisPacificateur.jouer(historique));


        historique.add(new PartieJouee(false,false,0));
        assertFalse(strategieVraisPacificateur.jouer(historique));

        //change l'aleatoire
        when(mockedRandom.nextInt(anyInt())).thenReturn(9);
        strategieVraisPacificateur.setRandom(mockedRandom);

        // ici la stratégie décide aléatoirement de faire la paix
        historique.add(new PartieJouee(false,false,0));
        assertTrue(strategieVraisPacificateur.jouer(historique));
    }

    @Test
    void testPavlovAleatoire() {
        StrategiePavlovAleatoire strategiePavlovAleatoire = new StrategiePavlovAleatoire();
        List<PartieJouee> historique = new ArrayList<>();

        SecureRandom mockedRandom = mock(SecureRandom.class);
        when(mockedRandom.nextInt(anyInt())).thenReturn(90);
        // on mock le random pour avoir le même résultat a chaque fois
        strategiePavlovAleatoire.setRandom(mockedRandom);

        assertTrue(strategiePavlovAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategiePavlovAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,false,0));
        assertFalse(strategiePavlovAleatoire.jouer(historique));

        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategiePavlovAleatoire.jouer(historique));

        // fonctionnement standart
        historique.add(new PartieJouee(true,true,3));
        assertTrue(strategiePavlovAleatoire.jouer(historique));



        //change l'aleatoire
        when(mockedRandom.nextInt(anyInt())).thenReturn(9);
        strategiePavlovAleatoire.setRandom(mockedRandom);

        //trahison aléatoire
        historique.add(new PartieJouee(true,true,3));
        assertFalse(strategiePavlovAleatoire.jouer(historique));
    }

}