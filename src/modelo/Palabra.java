package modelo;

public class Palabra {
    // Texto que el jugador debe adivinar
    private String texto;

    // Categoria a la que pertenece la palabra
    private String categoria;

    // Pista escrita para ayudar al jugador
    private String pistaEscrita;

    // Constructor principal de la clase
    public Palabra(String texto, String categoria, String pistaEscrita) {
        this.texto = texto;
        this.categoria = categoria;
        this.pistaEscrita = pistaEscrita;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPistaEscrita() {
        return pistaEscrita;
    }

    public void setPistaEscrita(String pistaEscrita) {
        this.pistaEscrita = pistaEscrita;
    }

    @Override
    public String toString() {
        return texto + " - " + categoria;
    }
}