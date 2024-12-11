package fr.uga.l3miage.pc.prisonersdilemma.classes.strategies;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;

public class StrategieRancunierDoux implements BaseStrategie {
    // note : sequence représente une suite de coup prédéfinie que la stratégie vas éffectuer
    ArrayList<Boolean> sequence = new ArrayList<>();

    @Override
    public boolean jouer(List<PartieJouee> historique){


        // si l'historique est vide on cohopère par défaut
        if(historique.isEmpty()){
            return true;
        } else {
            
            // si séquence est vide alors comportement normal
            if (sequence.isEmpty()) {
                
                // si le dernier coup de l'autre joueur est un trahison alor trahison + on charge la séquence de punition
                if(!(historique.get(historique.size()-1).isChoixAutreJoueur())){
                    addSequence();
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

    // sert a ajouter une série de coups prédéfinis
    private void addSequence(){
        sequence.add(false);
        sequence.add(false);
        sequence.add(false);
        sequence.add(false);
        sequence.add(true);
        sequence.add(true);
    }
}
