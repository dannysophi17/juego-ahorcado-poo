package pistas;

import modelo.JuegoAhorcado;

// Clase abstracta base para aplicar herencia y polimorfismo
public abstract class Pista {
    // Sirve para controlar el estado de la pista
    protected boolean usada;

    public Pista() {
        this.usada = false;
    }

    public boolean isUsada() {
        return usada;
    }

    public void setUsada(boolean usada) {
        this.usada = usada;
    }

    // Cada subclase implementa esta logica de forma distinta
    public abstract String mostrarPista(JuegoAhorcado juego);
}
