package pistas;

import modelo.JuegoAhorcado;

// Esta pista muestra la pista escrita asociada a la palabra
public class PistaEscrita extends Pista {

    @Override
    public String mostrarPista(JuegoAhorcado juego) {
        // Si la pista ya fue usada, no se permite usarla otra vez
        if (usada) {
            return "La pista escrita ya fue usada.";
        }

        usada = true;
        return "Pista: " + juego.getPalabraActual().getPistaEscrita();
    }
}