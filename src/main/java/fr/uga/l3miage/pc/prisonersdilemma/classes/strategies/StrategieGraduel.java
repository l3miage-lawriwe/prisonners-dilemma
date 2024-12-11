package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieGraduel implements BaseStrategie {
    // note : sequence représente une suite de coup prédéfinie que la stratégie vas éffectuer
    ArrayList<Boolean> sequence = new ArrayList<>();
    @Override
    public boolean jouer(List<PartieJouee> historique){
        

        int nbTrahisonAutreJoueur = 0;

        // si l'historique est vide on cohopère par défaut
        if(historique.isEmpty()){
            return true;
        } else {
            // si séquence est vide alors comportement normal
            if (sequence.isEmpty()) {
                // ici on vérifie le nb de trahisons que l'autre joueur a fait
                nbTrahisonAutreJoueur = getNbTrahisonsAutreJoueur(historique);
                // si le dernier coup de l'autre joueur est un trahison alor trahison + on charge la séquence de punition
                if(!(historique.getLast().isChoixAutreJoueur())){
                    addSequence(nbTrahisonAutreJoueur);
                    return false;
                } else{
                    return true;
                }
            } else {
                // si sequence n'est pas vide alors la séquence de punition est en cour
                return sequence.removeFirst();
            }
        }

    }

    //sert a vérifer combient de fois l'autre joueur a trahis
    private int getNbTrahisonsAutreJoueur(List<PartieJouee> historique){
        int i = 0;
        int nbTrahisonAutreJoueur = 0;
        while(i < historique.size()) {
            if (!(historique.get(i).isChoixAutreJoueur())) {
                nbTrahisonAutreJoueur++;
            }
            i++;
        }
        return nbTrahisonAutreJoueur;
    }

    // sert a ajouter une série de coups prédéfinis
    private void addSequence(int nbTrahisonAutreJoueur){
        for (int j = 1; j < nbTrahisonAutreJoueur; j++) {
            sequence.add(false);
        }
        sequence.add(true);
        sequence.add(true);
    }
}
