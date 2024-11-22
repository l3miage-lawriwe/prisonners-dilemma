package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieAdaptatif extends BaseStrategie {

    // note : sequence représente une suite de coup prédéfinie que la stratégie vas éffectuer
    ArrayList<Boolean> sequence = new ArrayList<>();

    @Override
    public boolean jouer(List<PartieJouee> historique){
        
        int i = 0;

        int resultatThrahison = 0;
        int resultatCooperer = 0;



        // si l'historique est vide on charge la séquence de début
        if(historique.isEmpty()){
            sequence.add(true);
            sequence.add(true);
            sequence.add(true);
            sequence.add(true);
            sequence.add(true);
            sequence.add(false);
            sequence.add(false);
            sequence.add(false);
            sequence.add(false);
            sequence.add(false);
            sequence.add(false);
            return true;
        } else {
            // si séquence est vide alors comportement normal
            if (sequence.isEmpty()) {
                // ici ont fait les comptes de résultat pour trahir et coopérer
                while(i < historique.size()){
                    if (historique.get(i).isChoixJoueur()) {
                        resultatCooperer = resultatCooperer + historique.get(i).getResultatJoueur();
                    } else{
                        resultatThrahison = resultatThrahison + historique.get(i).getResultatJoueur();
                    }
                    i++;                   
                }
                return (resultatCooperer >= resultatThrahison);
            } else {
                // si sequence n'est pas vide alors la séquence de punition est en cour
                return sequence.removeFirst();
            }
        }
    }
}
