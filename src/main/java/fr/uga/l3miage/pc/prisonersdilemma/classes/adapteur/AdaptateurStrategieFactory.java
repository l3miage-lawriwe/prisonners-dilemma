package fr.uga.l3miage.pc.prisonersdilemma.classes.adapteur;

import fr.uga.l3miage.pc.prisonersdilemma.classes.TypeStrategieEnum;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.strategies.*;


public class AdaptateurStrategieFactory {

    private AdaptateurStrategieFactory() {}
    public static Strategie createStrategieAdatpateur(TypeStrategieEnum nbStrategie) {
        switch (nbStrategie) {
            // ADAPTATIF PAR DEFAUT
            case TypeStrategieEnum.ALEATOIRE -> {
                return new AleatoireStrategie();
            }
            case TypeStrategieEnum.DONNANTDONNANT, TypeStrategieEnum.GRADUEL, TypeStrategieEnum.DONNANTDONNANTSOUPCONNEUX -> {
                return new DonnantDonnantStrategie(); // GRADUEL et DONANT DONNAT SOUPCONNEUX n'existe pas dans le package de lola
            }
            case TypeStrategieEnum.DONNANTDONNANTALEATOIRE -> {
                return new DonnantDonnantAleatoireStrategie();
            }
            case TypeStrategieEnum.DONNANTDONNANTDEUX -> {
                return new DonnantPourDeuxDonnantStrategie();
            }
            case TypeStrategieEnum.DONNANTDONNANTDEUXALEATOIRE -> {
                return new DonnantPourDeuxDonnantAleatoireStrategie();
            }
            case TypeStrategieEnum.PACIFICATEURNAIF -> {
                return new PacificateurNaifStrategie();
            }
            case TypeStrategieEnum.PAVLOV -> {
                return new PavlovStrategie();
            }
            case TypeStrategieEnum.PAVLOVALEATOIRE -> {
                return new PavlovAleatoire();
            }
            case TypeStrategieEnum.RANCUNNIER, TypeStrategieEnum.RANCOUNIERDOUX -> {
                return new RancunierStrategie(); // RANCUNNIER DOUX n'existe pas dans le package de lola
            }
            case TypeStrategieEnum.SONDEURNAIF -> {
                return new SondeurNaifStrategie();
            }
            case TypeStrategieEnum.SONDEURREPENTANT -> {
                return new SondeurRepentant();
            }
            case TypeStrategieEnum.COOPERER -> {
                return new CoopererStrategie();
            }
            case TypeStrategieEnum.TRAHIR -> {
                return new TrahirStrategie();
            }
            case TypeStrategieEnum.VRAISPACIFICATEUR -> {
                return new VraiPacificateurStrategie();
            }
            default -> {
                // ADAPTATIF PAR DEFAUT
                return new Adaptatif();
            }
        }
    }


}
