package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;


import java.security.SecureRandom;

public abstract class BaseStrategieAleatoire extends BaseStrategie {


    // utilisé par les stratégies qui utilisent de l'aléatoire
    SecureRandom random = new SecureRandom();


    // setRandom permet de mettre un mock du random durant les tests
    public void setRandom(SecureRandom newRandom) {
        this.random = newRandom;
    }
}