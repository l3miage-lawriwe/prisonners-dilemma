package fr.uga.l3miage.pc.prisonersdilemma;


import fr.uga.l3miage.pc.prisonersdilemma.classes.StrategieFactory;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryTest {

    @Test
    void testScoreTotal() {

        BaseStrategie baseStrategie = StrategieFactory.createStrategie(0);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieUtilisateur.class);
        baseStrategie = StrategieFactory.createStrategie(1);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieAdaptatif.class);
        baseStrategie = StrategieFactory.createStrategie(2);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieAleatoire.class);
        baseStrategie = StrategieFactory.createStrategie(3);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnant.class);
        baseStrategie = StrategieFactory.createStrategie(4);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnantAleatoire.class);
        baseStrategie = StrategieFactory.createStrategie(5);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnantDeux.class);
        baseStrategie = StrategieFactory.createStrategie(6);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnantDeuxAleatoire.class);
        baseStrategie = StrategieFactory.createStrategie(7);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnantSoupconneux.class);
        baseStrategie = StrategieFactory.createStrategie(8);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieGraduel.class);
        baseStrategie = StrategieFactory.createStrategie(9);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategiePacificateurNaif.class);
        baseStrategie = StrategieFactory.createStrategie(10);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategiePavlov.class);
        baseStrategie = StrategieFactory.createStrategie(11);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategiePavlovAleatoire.class);
        baseStrategie = StrategieFactory.createStrategie(12);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieRancunier.class);
        baseStrategie = StrategieFactory.createStrategie(13);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieRancunierDoux.class);
        baseStrategie = StrategieFactory.createStrategie(14);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieSondeurNaif.class);
        baseStrategie = StrategieFactory.createStrategie(15);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieSondeurRepentant.class);
        baseStrategie = StrategieFactory.createStrategie(16);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieToujoursCooperer.class);
        baseStrategie = StrategieFactory.createStrategie(17);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieToujoursTrahir.class);
        baseStrategie = StrategieFactory.createStrategie(18);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieVraisPacificateur.class);

    }
}
