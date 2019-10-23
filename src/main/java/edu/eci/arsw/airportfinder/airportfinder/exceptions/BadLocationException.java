package edu.eci.arsw.airportfinder.airportfinder.exceptions;

public class BadLocationException extends Exception {
    public BadLocationException(String message) {
        super(message);
    }

    public BadLocationException(String message, Throwable cause){
        super(message,cause);
    }
}
