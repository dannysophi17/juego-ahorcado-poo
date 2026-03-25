package modelo;

import java.util.ArrayList;
import pistas.PistaCategoria;
import pistas.PistaEscrita;
import pistas.PistaLetra;

public class JuegoAhorcado {
    // Instancia del banco para obtener palabras aleatorias
    private BancoPalabras bancoPalabras;

    // Palabra que esta activa en la partida actual
    private Palabra palabraActual;

    // Guarda el progreso visible del jugador
    private char[] progreso;

    // Listas para guardar letras correctas e incorrectas
    private ArrayList<Character> letrasCorrectas;
    private ArrayList<Character> letrasIncorrectas;

    // Control del numero de errores
    private int intentosFallidos;
    private int maxIntentos;

    // Objetos de pistas segun el diagrama UML
    private PistaCategoria pistaCategoria;
    private PistaLetra pistaLetra;
    private PistaEscrita pistaEscrita;

    public JuegoAhorcado() {
        bancoPalabras = new BancoPalabras();
        letrasCorrectas = new ArrayList<>();
        letrasIncorrectas = new ArrayList<>();
        maxIntentos = 7;

        pistaCategoria = new PistaCategoria();
        pistaLetra = new PistaLetra();
        pistaEscrita = new PistaEscrita();

        iniciarJuego();
    }

    // Metodo que arranca o reinicia una partida
    public void iniciarJuego() {
        palabraActual = bancoPalabras.obtenerPalabraAleatoria();
        intentosFallidos = 0;
        letrasCorrectas.clear();
        letrasIncorrectas.clear();

        // Reiniciar tambien el estado de las pistas
        pistaCategoria = new PistaCategoria();
        pistaLetra = new PistaLetra();
        pistaEscrita = new PistaEscrita();

        if (palabraActual != null) {
            progreso = new char[palabraActual.getTexto().length()];

            // Los espacios se muestran desde el principio
            for (int i = 0; i < palabraActual.getTexto().length(); i++) {
                if (palabraActual.getTexto().charAt(i) == ' ') {
                    progreso[i] = ' ';
                } else {
                    progreso[i] = '_';
                }
            }
        }
    }

    // Recibe una letra y valida si esta o no en la palabra
    public boolean probarLetra(char letra) {
        letra = Character.toLowerCase(letra);

        // Si ya se uso, no se procesa otra vez
        if (letraYaFueUsada(letra)) {
            return false;
        }

        boolean acierto = false;
        String texto = palabraActual.getTexto();

        // Primero revisa si la letra existe en la palabra
        for (int i = 0; i < texto.length(); i++) {
            if (Character.toLowerCase(texto.charAt(i)) == letra) {
                acierto = true;
                break;
            }
        }

        // Si acierta, se actualiza el progreso
        if (acierto) {
            actualizarProgreso(letra);
            letrasCorrectas.add(letra);
        } else {
            letrasIncorrectas.add(letra);
            intentosFallidos++;
        }

        return acierto;
    }

    // Este metodo se dejo separado para que coincida mejor con el UML
    public void actualizarProgreso(char letra) {
        String texto = palabraActual.getTexto();

        for (int i = 0; i < texto.length(); i++) {
            if (Character.toLowerCase(texto.charAt(i)) == Character.toLowerCase(letra)) {
                progreso[i] = texto.charAt(i);
            }
        }
    }

    // Devuelve true si ya no quedan guiones bajos
    public boolean yaGano() {
        for (char c : progreso) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    // Devuelve true si ya llego al limite de errores
    public boolean yaPerdio() {
        return intentosFallidos >= maxIntentos;
    }

    public String usarPistaCategoria() {
        return pistaCategoria.mostrarPista(this);
    }

    public String usarPistaLetra() {
        return pistaLetra.mostrarPista(this);
    }

    public String usarPistaEscrita() {
        return pistaEscrita.mostrarPista(this);
    }

    // Devuelve el progreso listo para mostrar en pantalla
    public String getProgreso() {
        StringBuilder sb = new StringBuilder();

        for (char c : progreso) {
            sb.append(c).append(' ');
        }

        return sb.toString().trim();
    }

    // Este getter sirve especialmente para la pista de letra
    public char[] getProgresoArray() {
        return progreso;
    }

    // Metodo auxiliar para no contar letras repetidas
    public boolean letraYaFueUsada(char letra) {
        letra = Character.toLowerCase(letra);
        return letrasCorrectas.contains(letra) || letrasIncorrectas.contains(letra);
    }

    public Palabra getPalabraActual() {
        return palabraActual;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public ArrayList<Character> getLetrasIncorrectas() {
        return letrasIncorrectas;
    }

    public ArrayList<Character> getLetrasCorrectas() {
        return letrasCorrectas;
    }

    public int getMaxIntentos() {
        return maxIntentos;
    }

    public void reiniciarJuego() {
        iniciarJuego();
    }
}
