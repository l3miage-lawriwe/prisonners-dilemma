package fr.uga.l3miage.pc.prisonersdilemma.classes.game.util;

import fr.uga.l3miage.pc.prisonersdilemma.classes.game.model.TypeStrategieEnum;
import fr.uga.l3miage.pc.prisonersdilemma.classes.game.strategies.*;

public class StrategieFactory {

    private StrategieFactory() {}

    public static BaseStrategie createStrategie(TypeStrategieEnum strategie) {
        switch (strategie) {
            case TypeStrategieEnum.ADAPTATIF -> {
                return new StrategieAdaptatif();
            }
            case TypeStrategieEnum.ALEATOIRE -> {
                return new StrategieAleatoire();
            }
            case TypeStrategieEnum.DONNANTDONNANT -> {
                return new StrategieDonnantDonnant();
            }
            case TypeStrategieEnum.DONNANTDONNANTALEATOIRE -> {
                return new StrategieDonnantDonnantAleatoire();
            }
            case TypeStrategieEnum.DONNANTDONNANTDEUX -> {
                return new StrategieDonnantDonnantDeux();
            }
            case TypeStrategieEnum.DONNANTDONNANTDEUXALEATOIRE -> {
                return new StrategieDonnantDonnantDeuxAleatoire();
            }
            case TypeStrategieEnum.DONNANTDONNANTSOUPCONNEUX -> {
                return new StrategieDonnantDonnantSoupconneux();
            }
            case TypeStrategieEnum.GRADUEL -> {
                return new StrategieGraduel();
            }
            case TypeStrategieEnum.PACIFICATEURNAIF -> {
                return new StrategiePacificateurNaif();
            }
            case TypeStrategieEnum.PAVLOV -> {
                return new StrategiePavlov();
            }
            case TypeStrategieEnum.PAVLOVALEATOIRE -> {
                return new StrategiePavlovAleatoire();
            }
            case TypeStrategieEnum.RANCUNNIER -> {
                return new StrategieRancunier();
            }
            case TypeStrategieEnum.RANCOUNIERDOUX -> {
                return new StrategieRancunierDoux();
            }
            case TypeStrategieEnum.SONDEURNAIF -> {
                return new StrategieSondeurNaif();
            }
            case TypeStrategieEnum.SONDEURREPENTANT -> {
                return new StrategieSondeurRepentant();
            }
            case TypeStrategieEnum.COOPERER -> {
                return new StrategieToujoursCooperer();
            }
            case TypeStrategieEnum.TRAHIR -> {
                return new StrategieToujoursTrahir();
            }
            case TypeStrategieEnum.VRAISPACIFICATEUR -> {
                return new StrategieVraisPacificateur();
            }
            default -> {
                return new StrategieUtilisateur();
            }
        }
}
}
