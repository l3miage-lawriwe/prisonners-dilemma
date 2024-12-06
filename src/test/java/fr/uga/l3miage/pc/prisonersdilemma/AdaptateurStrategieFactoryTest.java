package fr.uga.l3miage.pc.prisonersdilemma;

import fr.uga.l3miage.pc.prisonersdilemma.classes.adapteur.AdaptateurStrategieFactory;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.strategies.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdaptateurStrategieFactoryTest {

    @Test
    void testAdaptateurFactoryTotal() {

        Strategie strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(0);
        assertThat(strategie).isExactlyInstanceOf(Adaptatif.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(1);
        assertThat(strategie).isExactlyInstanceOf(Adaptatif.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(2);
        assertThat(strategie).isExactlyInstanceOf(AleatoireStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(3);
        assertThat(strategie).isExactlyInstanceOf(DonnantDonnantStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(4);
        assertThat(strategie).isExactlyInstanceOf(DonnantDonnantAleatoireStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(5);
        assertThat(strategie).isExactlyInstanceOf(DonnantPourDeuxDonnantStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(6);
        assertThat(strategie).isExactlyInstanceOf(DonnantPourDeuxDonnantAleatoireStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(7);
        assertThat(strategie).isExactlyInstanceOf(DonnantDonnantStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(8);
        assertThat(strategie).isExactlyInstanceOf(DonnantDonnantStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(9);
        assertThat(strategie).isExactlyInstanceOf(PacificateurNaifStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(10);
        assertThat(strategie).isExactlyInstanceOf(PavlovStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(11);
        assertThat(strategie).isExactlyInstanceOf(PavlovAleatoire.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(12);
        assertThat(strategie).isExactlyInstanceOf(RancunierStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(13);
        assertThat(strategie).isExactlyInstanceOf(RancunierStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(14);
        assertThat(strategie).isExactlyInstanceOf(SondeurNaifStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(15);
        assertThat(strategie).isExactlyInstanceOf(SondeurRepentant.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(16);
        assertThat(strategie).isExactlyInstanceOf(CoopererStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(17);
        assertThat(strategie).isExactlyInstanceOf(TrahirStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(18);
        assertThat(strategie).isExactlyInstanceOf(VraiPacificateurStrategie.class);

    }
}
