package fr.uga.l3miage.pc.prisonersdilemma;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.adapteur.Adapteur;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AdapateurTest {


    @Test
    void testadaptateur() {
        Adapteur adapteur = new Adapteur();
        adapteur.setStrategie(16);

        List<PartieJouee> historique = new ArrayList<>();
        historique.add(new PartieJouee(true,true,3));
        historique.add(new PartieJouee(false,false,3));



        assertTrue(adapteur.jouerStrategiesAdapteur(historique));
    }
}
