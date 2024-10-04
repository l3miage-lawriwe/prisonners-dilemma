package fr.uga.l3miage.pc;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        PartieIterative partie = new PartieIterative(false,false,3);

        partie.jouerPartie();
    }
}