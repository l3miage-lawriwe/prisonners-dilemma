package fr.uga.l3miage.pc.prisonersdilemma.classes.adapteur;

import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.strategies.*;


public class AdaptateurStrategieFactory {

    private AdaptateurStrategieFactory() {}
    public static Strategie createStrategieAdatpateur(int nbStrategie) {
        switch (nbStrategie) {
            // ADAPTATIF PAR DEFAUT
            case 2 -> {
                return new AleatoireStrategie();
            }
            case 3, 8, 7 -> {
                return new DonnantDonnantStrategie(); // GRADUEL et DONANT DONNAT SOUPCONNEUX n'existe pas dans le package de lola
            }
            case 4 -> {
                return new DonnantDonnantAleatoireStrategie();
            }
            case 5 -> {
                return new DonnantPourDeuxDonnantStrategie();
            }
            case 6 -> {
                return new DonnantPourDeuxDonnantAleatoireStrategie();
            }
            case 9 -> {
                return new PacificateurNaifStrategie();
            }
            case 10 -> {
                return new PavlovStrategie();
            }
            case 11 -> {
                return new PavlovAleatoire();
            }
            case 12, 13 -> {
                return new RancunierStrategie(); // RANCUNNIER DOUX n'existe pas dans le package de lola
            }
            case 14 -> {
                return new SondeurNaifStrategie();
            }
            case 15 -> {
                return new SondeurRepentant();
            }
            case 16 -> {
                return new CoopererStrategie();
            }
            case 17 -> {
                return new TrahirStrategie();
            }
            case 18 -> {
                return new VraiPacificateurStrategie();
            }
            default -> {
                // ADAPTATIF PAR DEFAUT
                return new Adaptatif();
            }
        }
    }


}
