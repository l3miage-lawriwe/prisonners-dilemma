package fr.uga.l3miage.pc.prisonersdilemma.classes.serveur;

import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebSocketHandler extends TextWebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger(WebSocketHandler.class);
    private final List<WebSocketSession> joueurs = new ArrayList<>();
    private final Map<WebSocketSession, Integer> strategieJoueurs = new HashMap<>();

    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
        joueurs.add(session);
        log.info("Nouveau joueur connecté : {}", session.getRemoteAddress());
        session.sendMessage(new TextMessage("Veuillez choisir votre stratégie : "));


    }

    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session,@NonNull CloseStatus status)  {
        joueurs.remove(session);
        log.info("Joueur déconnecté : {}", session.getRemoteAddress());
    }



    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        log.error("Erreur de communication : {}", exception.getMessage());
        if (session.isOpen()) {
            try {
                session.close();
            } catch (IOException e) {
                log.error("Erreur de fermeture de session: {}", e.getMessage(), e);
            }
        }
    }
    @Override
    protected void handleTextMessage(@NonNull WebSocketSession session, TextMessage message) throws Exception {
        try {
            int nbStrat = Integer.parseInt(message.getPayload());
            strategieJoueurs.put(session, nbStrat);
            log.info("Stratégie : {} selectionné par le joueur :  {}",  nbStrat,session.getRemoteAddress());

            if (strategieJoueurs.size() == 2) {
                int strategieJ1 = strategieJoueurs.get(joueurs.get(0));
                int strategieJ2 = strategieJoueurs.get(joueurs.get(1));

                PartieIterative partie = new PartieIterative(strategieJ1,strategieJ2,3);
                partie.jouerPartie();

                strategieJoueurs.clear();
                for (WebSocketSession joueur : joueurs) {
                    joueur.sendMessage(new TextMessage("Veuillez choisir votre stratégie pour la prochaine partie : "));
                }
            }
        } catch (NumberFormatException e) {
            log.warn("Mauvaise valeur : {}", message.getPayload());
        }
    }
    public List<WebSocketSession> getJoueurs() {
        return joueurs;
    }
}