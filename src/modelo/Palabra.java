package modelo;

public class Palabra {
    // Guarda el texto de la palabra que se debe adivinar
    private String texto;

    // Guarda la categoria a la que pertenece la palabra
    private String categoria;

    // Guarda la pista escrita relacionada con la palabra
    private String pistaEscrita;

    // Constructor principal
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