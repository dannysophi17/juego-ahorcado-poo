package pistas;

import modelo.JuegoAhorcado;

public class PistaEscrita extends Pista {

    @Override
    public String mostrarPista(JuegoAhorcado juego) {
        if (usada) {
            return "La pista escrita ya fue usada.";
        }

        usada = true;
        return "Pista: " + juego.getPalabraActual().getPistaEscrita();
    }
}