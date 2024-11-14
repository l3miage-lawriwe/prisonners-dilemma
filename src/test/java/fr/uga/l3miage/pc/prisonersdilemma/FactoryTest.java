package fr.uga.l3miage.pc.prisonersdilemma;


import fr.uga.l3miage.pc.prisonersdilemma.classes.StrategieFactory;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryTest {

    @Test
    void testScoreTotal() {

        Strategie strategie = StrategieFactory.createStrategie(0);
        assertThat(strategie).isExactlyInstanceOf(StrategieUtilisateur.class);
        strategie = StrategieFactory.createStrategie(1);
        assertThat(strategie).isExactlyInstanceOf(StrategieAdaptatif.class);
        strategie = StrategieFactory.createStrategie(2);
        assertThat(strategie).isExactlyInstanceOf(StrategieAleatoire.class);
        strategie = StrategieFactory.createStrategie(3);
        assertThat(strategie).isExactlyInstanceOf(StrategieDonnantDonnant.class);
        strategie = StrategieFactory.createStrategie(4);
        assertThat(strategie).isExactlyInstanceOf(StrategieDonnantDonnantAleatoire.class);
        strategie = StrategieFactory.createStrategie(5);
        assertThat(strategie).isExactlyInstanceOf(StrategieDonnantDonnantDeux.class);
        strategie = StrategieFactory.createStrategie(6);
        assertThat(strategie).isExactlyInstanceOf(StrategieDonnantDonnantDeuxAleatoire.class);
        strategie = StrategieFactory.createStrategie(7);
        assertThat(strategie).isExactlyInstanceOf(StrategieDonnantDonnantSoupconneux.class);
        strategie = StrategieFactory.createStrategie(8);
        assertThat(strategie).isExactlyInstanceOf(StrategieGraduel.class);
        strategie = StrategieFactory.createStrategie(9);
        assertThat(strategie).isExactlyInstanceOf(StrategiePacificateurNaif.class);
        strategie = StrategieFactory.createStrategie(10);
        assertThat(strategie).isExactlyInstanceOf(StrategiePavlov.class);
        strategie = StrategieFactory.createStrategie(11);
        assertThat(strategie).isExactlyInstanceOf(StrategiePavlovAleatoire.class);
        strategie = StrategieFactory.createStrategie(12);
        assertThat(strategie).isExactlyInstanceOf(StrategieRancunier.class);
        strategie = StrategieFactory.createStrategie(13);
        assertThat(strategie).isExactlyInstanceOf(StrategieRancunierDoux.class);
        strategie = StrategieFactory.createStrategie(14);
        assertThat(strategie).isExactlyInstanceOf(StrategieSondeurNaif.class);
        strategie = StrategieFactory.createStrategie(15);
        assertThat(strategie).isExactlyInstanceOf(StrategieSondeurRepentant.class);
        strategie = StrategieFactory.createStrategie(16);
        assertThat(strategie).isExactlyInstanceOf(StrategieToujoursCooperer.class);
        strategie = StrategieFactory.createStrategie(17);
        assertThat(strategie).isExactlyInstanceOf(StrategieToujoursTrahir.class);
        strategie = StrategieFactory.createStrategie(18);
        assertThat(strategie).isExactlyInstanceOf(StrategieVraisPacificateur.class);

    }
}
