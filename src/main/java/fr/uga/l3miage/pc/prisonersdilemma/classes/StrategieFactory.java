package fr.uga.l3miage.pc.prisonersdilemma.classes;

import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieAleatoire;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieDonnantDonnant;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieDonnantDonnantSoupconneux;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategiePavlov;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieRancunier;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieToujoursCooperer;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieToujoursTrahir;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.StrategieUtilisateur;

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
