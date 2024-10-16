package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

public class StrategieFactory {

    private StrategieFactory(){

    }
    public static Strategie  createStrategie(int nbStrategie) {
        switch (nbStrategie) {
            case 1 -> {
                return new StrategieToujoursCooperer();
            }
            case 2 -> {
                return new StrategieToujoursTrahir();
            }
            case 3 -> {
                return new StrategieDonnantDonnantSoupconneux();
            }
            case 4 -> {
                return new StrategieDonnantDonnant();
            }
            case 5 -> {
                return new StrategiePavlov();
            }
            case 6 -> {
                return new StrategieRancunier();
            }
            case 7 -> {
                return new StrategieAleatoire();
            }

            default -> {
                return new StrategieUtilisateur();
            }
        }
}
}
