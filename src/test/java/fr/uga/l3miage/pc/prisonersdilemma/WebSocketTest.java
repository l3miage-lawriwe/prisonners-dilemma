package fr.uga.l3miage.pc.prisonersdilemma;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.uga.l3miage.pc.prisonersdilemma.classes.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.serveur.WebSocketHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WebSocketTest {

    private WebSocketHandler webSocketHandler;
    private WebSocketSession session1;
    private WebSocketSession session2;

    @BeforeEach
    void setUp() {
        webSocketHandler = new WebSocketHandler();
        session1 = mock(WebSocketSession.class);
        session2 = mock(WebSocketSession.class);

        when(session1.getId()).thenReturn("player1");
        when(session2.getId()).thenReturn("player2");
    }

    @Test
    void testConnectionEstablishedWithOnePlayer() throws Exception {
        webSocketHandler.afterConnectionEstablished(session1);

        verify(session1, times(1)).sendMessage(new TextMessage("Connecté en tant que joueur 1"));
        assertEquals(1, webSocketHandler.getPlayers().size());
    }

    @Test
    void testConnectionEstablishedWithTwoPlayers() throws Exception {
        webSocketHandler.afterConnectionEstablished(session1);
        webSocketHandler.afterConnectionEstablished(session2);

        verify(session1, times(1)).sendMessage(new TextMessage("Connecté en tant que joueur 1"));
        verify(session2, times(1)).sendMessage(new TextMessage("Connecté en tant que joueur 2"));
        verify(session1, times(1)).sendMessage(new TextMessage("La partie commence ! Faites vos choix : 'coopérer' ou 'trahir'."));
        verify(session2, times(1)).sendMessage(new TextMessage("La partie commence ! Faites vos choix : 'coopérer' ou 'trahir'."));

        assertEquals(2, webSocketHandler.getPlayers().size());
    }

    @Test
    void testHandleTextMessageInvalidChoice() throws Exception {
        webSocketHandler.afterConnectionEstablished(session1);
        webSocketHandler.afterConnectionEstablished(session2);

        webSocketHandler.handleTextMessage(session1, new TextMessage("invalid_choice"));

        verify(session1, times(1)).sendMessage(new TextMessage("Choix invalide. Veuillez choisir 'coopérer' ou 'trahir'."));
    }

    @Test
    void testHandleTextMessageValidChoices() throws Exception {
        webSocketHandler.afterConnectionEstablished(session1);
        webSocketHandler.afterConnectionEstablished(session2);

        webSocketHandler.handleTextMessage(session1, new TextMessage("coopérer"));
        webSocketHandler.handleTextMessage(session2, new TextMessage("trahir"));

        verify(session1, times(1)).sendMessage(new TextMessage("Votre choix : coopérer"));
        verify(session2, times(1)).sendMessage(new TextMessage("Votre choix : trahir"));

        verify(session1, atLeastOnce()).sendMessage(argThat(argument ->
                argument instanceof TextMessage && ((TextMessage) argument).getPayload().contains("Résultat de cette itération")
        ));
        verify(session2, atLeastOnce()).sendMessage(argThat(argument ->
                argument instanceof TextMessage && ((TextMessage) argument).getPayload().contains("Résultat de cette itération")
        ));
    }

    @Test
    void testProcessTurnAndGameEnd() throws Exception {
        webSocketHandler.afterConnectionEstablished(session1);
        webSocketHandler.afterConnectionEstablished(session2);

        for (int i = 0; i < 10; i++) {
            webSocketHandler.handleTextMessage(session1, new TextMessage("coopérer"));
            webSocketHandler.handleTextMessage(session2, new TextMessage("coopérer"));
        }
        verify(session1, atLeastOnce()).sendMessage(argThat(argument ->
                argument instanceof TextMessage && ((TextMessage) argument).getPayload().contains("La partie est terminée !")
        ));
        verify(session2, atLeastOnce()).sendMessage(argThat(argument ->
                argument instanceof TextMessage && ((TextMessage) argument).getPayload().contains("La partie est terminée !")
        ));

    }

    @Test
    void testPlayerDisconnects() throws Exception {
        webSocketHandler.afterConnectionEstablished(session1);
        webSocketHandler.afterConnectionEstablished(session2);

        webSocketHandler.afterConnectionClosed(session1, CloseStatus.NORMAL);

        verify(session2, times(1)).sendMessage(new TextMessage("Un joueur s'est déconnecté. La partie est annulée."));
        assertEquals(1, webSocketHandler.getPlayers().size());
    }
}
