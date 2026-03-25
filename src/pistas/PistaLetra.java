package pistas;

import java.util.ArrayList;
import java.util.Random;
import modelo.JuegoAhorcado;

public class PistaLetra extends Pista {

    @Override
    public String mostrarPista(JuegoAhorcado juego) {
        if (usada) {
            return "La pista de letra ya fue usada.";
        }

        String palabra = juego.getPalabraActual().getTexto();
        char[] progreso = juego.getProgresoArray();

        // Lista de posiciones que siguen ocultas
        ArrayList<Integer> posicionesOcultas = new ArrayList<>();

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) != ' ' && progreso[i] == '_') {
                posicionesOcultas.add(i);
            }
        }

        if (posicionesOcultas.isEmpty()) {
            usada = true;
            return "No hay letras ocultas para revelar.";
        }

        Random random = new Random();
        int posicionElegida = posicionesOcultas.get(random.nextInt(posicionesOcultas.size()));
        char letra = palabra.charAt(posicionElegida);

        // Se reutiliza la misma logica del juego para no duplicar codigo
        juego.probarLetra(letra);

        usada = true;
        return "Se revelo la letra: " + letra;
    }
}