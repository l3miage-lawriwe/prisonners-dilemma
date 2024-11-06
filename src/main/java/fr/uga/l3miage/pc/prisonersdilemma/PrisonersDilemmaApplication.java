package fr.uga.l3miage.pc.prisonersdilemma;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieIterative;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class PrisonersDilemmaApplication extends WebSocketServer {

    private static final Logger log = LogManager.getLogger(PrisonersDilemmaApplication.class);
    private List<WebSocket> clients = new ArrayList<>();

	public PrisonersDilemmaApplication(int port) {
		super(new InetSocketAddress(port));
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		clients.add(conn);
        log.info("Nouveau joueur connecté : {}", conn.getRemoteSocketAddress());

		if (clients.size() == 2) {
			PartieIterative partie = new PartieIterative(3);
			partie.jouerPartie();
		}
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		clients.remove(conn);
        log.info("Joueur déconnecté : {}", conn.getRemoteSocketAddress());
	}
	@Override
	public void onMessage(WebSocket webSocket, String s) {
		//Message implémenté plus tard
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();
	}
	@Override
	public void onStart() {
        log.info("Serveur démarré sur le port: {}", getPort());
	}


	public static void main(String[] args) {
		int port = 8080; // Port par défaut
		PrisonersDilemmaApplication server = new PrisonersDilemmaApplication(port);
		server.start();
	}
}