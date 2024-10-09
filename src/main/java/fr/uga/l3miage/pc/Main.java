package fr.uga.l3miage.pc;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Hello world!");


        PartieIterative partie = new PartieIterative(false,false,3);

        partie.jouerPartie();
    }
}