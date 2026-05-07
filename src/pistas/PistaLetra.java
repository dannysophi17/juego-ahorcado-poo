package pistas;

import java.util.ArrayList;
import java.util.Random;
import modelo.JuegoAhorcado;

// Esta pista revela una letra de la palabra actual.
// Se usa polimorfismo porque sobrescribe el metodo mostrarPista().
public class PistaLetra extends Pista {

    @Override
    public String mostrarPista(JuegoAhorcado juego) {
        // Si la pista ya fue usada, no se permite usarla otra vez
        if (usada) {
            return "La pista de letra ya fue usada.";
        }

        // Se obtiene la palabra actual y el progreso visible del jugador
        String palabra = juego.getPalabraActual().getTexto();
        char[] progreso = juego.getProgresoArray();

        // Aqui se guardan las posiciones que todavia estan ocultas
        ArrayList<Integer> posicionesOcultas = new ArrayList<>();

        // Se recorre la palabra para buscar letras que aun no han sido reveladas
        for (int i = 0; i < palabra.length(); i++) {
            // Los espacios no se toman como letras para revelar
            if (palabra.charAt(i) != ' ' && progreso[i] == '_') {
                posicionesOcultas.add(i);
            }
        }

        // Si ya no quedan letras ocultas, no hay nada para revelar
        if (posicionesOcultas.isEmpty()) {
            usada = true;
            return "No hay letras ocultas para revelar.";
        }

        // Se escoge una posicion oculta de forma aleatoria
        Random random = new Random();
        int posicionElegida = posicionesOcultas.get(random.nextInt(posicionesOcultas.size()));

        // Se obtiene la letra que esta en esa posicion
        char letra = palabra.charAt(posicionElegida);

        /*
         * Se usa probarLetra(letra) para reutilizar la misma logica del juego.
         * Asi no se repite codigo y la letra se revela en todas sus posiciones.
         */
        juego.probarLetra(letra);

        // Se marca la pista como usada
        usada = true;

        return "Se revelo la letra: " + letra;
    }
}