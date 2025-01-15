package fr.uga.l3miage.pc.prisonersdilemma;


import fr.uga.l3miage.pc.prisonersdilemma.classes.StrategieFactory;
import fr.uga.l3miage.pc.prisonersdilemma.classes.TypeStrategieEnum;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryTest {

    @Test
    void testFactoryTotal() {

        BaseStrategie baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.UTILISATEUR);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieUtilisateur.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.ADAPTATIF);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieAdaptatif.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.ALEATOIRE);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieAleatoire.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.DONNANTDONNANT);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnant.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.DONNANTDONNANTALEATOIRE);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnantAleatoire.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.DONNANTDONNANTDEUX);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnantDeux.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.DONNANTDONNANTDEUXALEATOIRE);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnantDeuxAleatoire.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.DONNANTDONNANTSOUPCONNEUX);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieDonnantDonnantSoupconneux.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.GRADUEL);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieGraduel.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.PACIFICATEURNAIF);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategiePacificateurNaif.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.PAVLOV);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategiePavlov.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.PAVLOVALEATOIRE);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategiePavlovAleatoire.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.RANCUNNIER);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieRancunier.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.RANCOUNIERDOUX);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieRancunierDoux.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.SONDEURNAIF);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieSondeurNaif.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.SONDEURREPENTANT);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieSondeurRepentant.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.COOPERER);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieToujoursCooperer.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.TRAHIR);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieToujoursTrahir.class);
        baseStrategie = StrategieFactory.createStrategie(TypeStrategieEnum.VRAISPACIFICATEUR);
        assertThat(baseStrategie).isExactlyInstanceOf(StrategieVraisPacificateur.class);

    }
}
