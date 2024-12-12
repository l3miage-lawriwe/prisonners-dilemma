package fr.uga.l3miage.pc.prisonersdilemma;

import fr.uga.l3miage.pc.prisonersdilemma.classes.serveur.WebSocketHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.net.InetSocketAddress;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WebSocketTest {

    private WebSocketHandler webSocketHandler;
    private WebSocketSession mockSession;

    @BeforeEach
    void setUp() {
        webSocketHandler = new WebSocketHandler();
        mockSession = mock(WebSocketSession.class);
        when(mockSession.getRemoteAddress()).thenReturn(new InetSocketAddress("localhost", 8080));
    }

    @Test
    void testHandleTransportError() throws Exception {
        doNothing().when(mockSession).close();
        webSocketHandler.handleTransportError(mockSession, new Exception("Erreur de test"));

        verify(mockSession, never()).close();
    }

    @Test
    void testHandleTransportErrorWhenSessionIsClosed() throws Exception {
        when(mockSession.isOpen()).thenReturn(false);

        webSocketHandler.handleTransportError(mockSession, new Exception("Erreur de test"));

        verify(mockSession, never()).close();
    }
}