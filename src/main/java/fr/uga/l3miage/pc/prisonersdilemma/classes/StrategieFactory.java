package fr.uga.l3miage.pc.prisonersdilemma.classes;

import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.*;

public class StrategieFactory {

    private StrategieFactory() {}

    public static Strategie  createStrategie(int nbStrategie) {
        switch (nbStrategie) {
            case 1 -> {
                return new StrategieAdaptatif();
            }
            case 2 -> {
                return new StrategieAleatoire();
            }
            case 3 -> {
                return new StrategieDonnantDonnant();
            }
            case 4 -> {
                return new StrategieDonnantDonnantAleatoire();
            }
            case 5 -> {
                return new StrategieDonnantDonnantDeux();
            }
            case 6 -> {
                return new StrategieDonnantDonnantDeuxAleatoire();
            }
            case 7 -> {
                return new StrategieDonnantDonnantSoupconneux();
            }
            case 8 -> {
                return new StrategieGraduel();
            }
            case 9 -> {
                return new StrategiePacificateurNaif();
            }
            case 10 -> {
                return new StrategiePavlov();
            }
            case 11 -> {
                return new StrategiePavlovAleatoire();
            }
            case 12 -> {
                return new StrategieRancunier();
            }
            case 13 -> {
                return new StrategieRancunierDoux();
            }
            case 14 -> {
                return new StrategieSondeurNaif();
            }
            case 15 -> {
                return new StrategieSondeurRepentant();
            }
            case 16 -> {
                return new StrategieToujoursCooperer();
            }
            case 17 -> {
                return new StrategieToujoursTrahir();
            }
            case 18 -> {
                return new StrategieVraisPacificateur();
            }
            default -> {
                return new StrategieUtilisateur();
            }
        }
}
}
