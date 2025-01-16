package fr.uga.l3miage.pc.prisonersdilemma.serveur;

import fr.uga.l3miage.pc.prisonersdilemma.PrisonersDilemmaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ServeurTest {


    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void testMain() {
        PrisonersDilemmaApplication.main(new String[] {});
        assertThat(applicationContext).isNotNull();

    }
}