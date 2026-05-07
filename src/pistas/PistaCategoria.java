package pistas;

import modelo.JuegoAhorcado;

// Esta pista muestra la categoria de la palabra actual
public class PistaCategoria extends Pista {

    @Override
    public String mostrarPista(JuegoAhorcado juego) {
        // Si la pista ya fue usada, no se permite usarla otra vez
        if (usada) {
            return "La pista de categoria ya fue usada.";
        }

        usada = true;
        return "Categoria: " + juego.getPalabraActual().getCategoria();
    }
}
