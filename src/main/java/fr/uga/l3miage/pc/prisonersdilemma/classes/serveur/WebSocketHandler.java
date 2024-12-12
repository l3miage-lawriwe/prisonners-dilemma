package fr.uga.l3miage.pc.prisonersdilemma.classes.serveur;

import fr.uga.l3miage.pc.prisonersdilemma.classes.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebSocketHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> players = new HashMap<>();
    private final Map<String, Boolean> playerChoices = new HashMap<>();
    private PartieIterative partie;

    static final String TRAHIR="trahir";
    static final String COOPERER="coopérer";

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        if (players.size() < 2) {
            players.put(session.getId(), session);
            session.sendMessage(new TextMessage("Connecté en tant que joueur " + (players.size())));
            if (players.size() == 2) {
                startGame();
            } else {
                session.sendMessage(new TextMessage("En attente d'un autre joueur..."));
            }
        } else {
            session.sendMessage(new TextMessage("La partie est pleine."));
            session.close();
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        if (partie == null || partie.estTerminee()) {
            session.sendMessage(new TextMessage("La partie est terminée ou non initialisée."));
            return;
        }

        String sessionId = session.getId();
        String payload = message.getPayload().trim().toLowerCase();

        // Valider l'entrée du joueur
        if (!payload.equals(COOPERER) && !payload.equals(TRAHIR)) {
            session.sendMessage(new TextMessage("Choix invalide. Veuillez choisir 'coopérer' ou 'trahir'."));
            return;
        }

        boolean choix = payload.equals(COOPERER);
        playerChoices.put(sessionId, choix);
        session.sendMessage(new TextMessage("Votre choix : " + (choix ? COOPERER : TRAHIR)));

        // Vérifier si les deux joueurs ont joué
        if (playerChoices.size() == 2) {
            processTurn();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        players.remove(session.getId());
        playerChoices.remove(session.getId());
        broadcast("Un joueur s'est déconnecté. La partie est annulée.");
        partie = null; // Réinitialiser la partie si un joueur quitte
    }

        private void startGame() throws BroadcastException {
            Joueur joueur1 = new Joueur();
            Joueur joueur2 = new Joueur();
            partie = new PartieIterative(joueur1, joueur2, 10);

            broadcast("La partie commence ! Faites vos choix : 'coopérer' ou 'trahir'.");
        }

        private void processTurn() throws EnvoiMessageException,BroadcastException {
            String[] playerIds = players.keySet().toArray(new String[0]);
            boolean choixJoueur1 = playerChoices.get(playerIds[0]);
            boolean choixJoueur2 = playerChoices.get(playerIds[1]);

            // Jouer une itération
            PartieJouee resultat = partie.jouerIteration(choixJoueur1, choixJoueur2);

            // Envoyer les résultats aux joueurs
            try {
                players.get(playerIds[0]).sendMessage(new TextMessage("Vous avez choisi : " + (choixJoueur1 ? COOPERER : TRAHIR)));
                players.get(playerIds[0]).sendMessage(new TextMessage("Votre adversaire a choisi : " + (choixJoueur2 ? COOPERER : TRAHIR)));
                players.get(playerIds[0]).sendMessage(new TextMessage("Résultat de cette itération : " + resultat.getResultatJoueur()));

                players.get(playerIds[1]).sendMessage(new TextMessage("Vous avez choisi : " + (choixJoueur2 ? COOPERER : TRAHIR)));
                players.get(playerIds[1]).sendMessage(new TextMessage("Votre adversaire a choisi : " + (choixJoueur1 ? COOPERER : TRAHIR)));
                players.get(playerIds[1]).sendMessage(new TextMessage("Résultat de cette itération : " + resultat.getResultatJoueur()));
            } catch (Exception e) {
                throw new EnvoiMessageException("Erreur d'envoi de résultat");
            }


            sendHistoriqueUpdate(players.get(playerIds[0]), partie.getJoueur1(), partie.getIterationActuelle());
            sendHistoriqueUpdate(players.get(playerIds[1]), partie.getJoueur2(), partie.getIterationActuelle());

            // Réinitialiser les choix des joueurs
            playerChoices.clear();

            // Vérifier si la partie est terminée
            if (partie.estTerminee()) {
                broadcast("La partie est terminée !");
                broadcast("Score Joueur 1 : " + partie.getScoreJoueur1());
                broadcast("Score Joueur 2 : " + partie.getScoreJoueur2());
                partie = null; // Réinitialiser la partie
            } else {
                broadcast("Itération " + partie.getIterationActuelle() + "/" + partie.getNbIterations() + " terminée. Faites vos prochains choix !");
            }
        }

    private void sendHistoriqueUpdate(WebSocketSession session, Joueur joueur, int tour) throws EnvoiMessageException {
        PartieJouee dernierePartie = joueur.getHistorique().getLast();

        String updateMessage = String.format(
                "HISTORIQUE:%d,%s,%s",
                tour,
                dernierePartie.isChoixJoueur() ? COOPERER : TRAHIR,
                dernierePartie.isChoixAutreJoueur() ? COOPERER : TRAHIR
        );

        try {
            session.sendMessage(new TextMessage(updateMessage));
        } catch (Exception e) {
            throw new EnvoiMessageException("Erreur d'envoi d'historique: " + updateMessage, e);
        }
    }



    private void broadcast(String message) throws BroadcastException {
        try {
            for (WebSocketSession session : players.values()) {
                session.sendMessage(new TextMessage(message));
            }
        } catch (Exception e) {
            throw new BroadcastException("Erreur d'envoi de message: " + message, e);
        }
    }

    public Map<String, WebSocketSession> getPlayers() {
        return players;
    }
}
