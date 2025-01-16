package fr.uga.l3miage.pc.prisonersdilemma.adapteur;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.model.TypeStrategieEnum;
import fr.uga.l3miage.pc.prisonersdilemma.classes.adapteur.AdaptateurStrategieFactory;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.strategies.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdaptateurStrategieFactoryTest {

    @Test
    void testAdaptateurFactoryTotal() {

        Strategie strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.UTILISATEUR);
        assertThat(strategie).isExactlyInstanceOf(Adaptatif.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.ADAPTATIF);
        assertThat(strategie).isExactlyInstanceOf(Adaptatif.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.ALEATOIRE);
        assertThat(strategie).isExactlyInstanceOf(AleatoireStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.DONNANTDONNANT);
        assertThat(strategie).isExactlyInstanceOf(DonnantDonnantStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.DONNANTDONNANTALEATOIRE);
        assertThat(strategie).isExactlyInstanceOf(DonnantDonnantAleatoireStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.DONNANTDONNANTDEUX);
        assertThat(strategie).isExactlyInstanceOf(DonnantPourDeuxDonnantStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.DONNANTDONNANTDEUXALEATOIRE);
        assertThat(strategie).isExactlyInstanceOf(DonnantPourDeuxDonnantAleatoireStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.DONNANTDONNANTSOUPCONNEUX);
        assertThat(strategie).isExactlyInstanceOf(DonnantDonnantStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.GRADUEL);
        assertThat(strategie).isExactlyInstanceOf(DonnantDonnantStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.PACIFICATEURNAIF);
        assertThat(strategie).isExactlyInstanceOf(PacificateurNaifStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.PAVLOV);
        assertThat(strategie).isExactlyInstanceOf(PavlovStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.PAVLOVALEATOIRE);
        assertThat(strategie).isExactlyInstanceOf(PavlovAleatoire.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.RANCUNNIER);
        assertThat(strategie).isExactlyInstanceOf(RancunierStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.RANCOUNIERDOUX);
        assertThat(strategie).isExactlyInstanceOf(RancunierStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.SONDEURNAIF);
        assertThat(strategie).isExactlyInstanceOf(SondeurNaifStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.SONDEURREPENTANT);
        assertThat(strategie).isExactlyInstanceOf(SondeurRepentant.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.COOPERER);
        assertThat(strategie).isExactlyInstanceOf(CoopererStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.TRAHIR);
        assertThat(strategie).isExactlyInstanceOf(TrahirStrategie.class);
        strategie = AdaptateurStrategieFactory.createStrategieAdatpateur(TypeStrategieEnum.VRAISPACIFICATEUR);
        assertThat(strategie).isExactlyInstanceOf(VraiPacificateurStrategie.class);

    }
}
