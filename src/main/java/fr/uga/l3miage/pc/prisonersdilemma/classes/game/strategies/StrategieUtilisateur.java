package fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.service.PartieJouee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;


public class StrategieUtilisateur implements BaseStrategie {

    private static final Logger log = LogManager.getLogger(StrategieUtilisateur.class);

    @Override
    public boolean jouer(List<PartieJouee> historique){
        Scanner reader = new Scanner(System.in); // Reading from System.in
        log.info("marquer 'T' pour trahir, marquer autre chose pour coopérer");
        String reponse = reader.next();
        return !(reponse.equals("T"));
    }
}
