package com.daw.cinemadaw.service;

public class SeatsAlreadyBookedException extends RuntimeException {

    public SeatsAlreadyBookedException() {
        super("Uno o más asientos ya han sido comprados por otro usuario.");
    }
}
