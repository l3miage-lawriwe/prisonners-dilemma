package fr.uga.l3miage.pc.prisonersdilemma.classes.serveur;

public class EnvoiMessageException extends Exception {
    public EnvoiMessageException(String message) {
        super(message);
    }

    public EnvoiMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
