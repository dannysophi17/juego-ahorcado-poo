package pistas;

import modelo.JuegoAhorcado;

public class PistaCategoria extends Pista {

    @Override
    public String mostrarPista(JuegoAhorcado juego) {
        if (usada) {
            return "La pista de categoria ya fue usada.";
        }

        usada = true;
        return "Categoria: " + juego.getPalabraActual().getCategoria();
    }
}
