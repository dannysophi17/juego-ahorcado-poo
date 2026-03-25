package modelo;

import java.util.ArrayList;
import java.util.Random;

public class BancoPalabras {
    // ArrayList para manejar las palabras de forma dinamica
    private ArrayList<Palabra> palabras;

    public BancoPalabras() {
        palabras = new ArrayList<>();
        cargarPalabras();
    }

    // Aqui se cargan algunas palabras de prueba para poder avanzar
    // Luego Mariana puede ampliar esto hasta completar las 200
    public void cargarPalabras() {
        palabras.add(new Palabra("tigre", "animales", "Felino salvaje con rayas"));
        palabras.add(new Palabra("jirafa", "animales", "Animal de cuello muy largo"));
        palabras.add(new Palabra("ballena", "animales", "Animal marino de gran tamaño"));

        palabras.add(new Palabra("avatar", "peliculas", "Pelicula ambientada en Pandora"));
        palabras.add(new Palabra("frozen", "peliculas", "Pelicula animada con dos hermanas"));
        palabras.add(new Palabra("gladiador", "peliculas", "Pelicula sobre un guerrero romano"));

        palabras.add(new Palabra("bandeja paisa", "platos tipicos", "Plato tradicional muy conocido en colombia"));
        palabras.add(new Palabra("ajiaco", "platos tipicos", "Sopa tipica colombiana"));
        palabras.add(new Palabra("empanada", "platos tipicos", "Masa rellena y frita"));

        palabras.add(new Palabra("paris", "ciudades", "Ciudad famosa por la torre Eiffel"));
        palabras.add(new Palabra("new york", "ciudades", "Ciudad conocida como la gran manzana"));
        palabras.add(new Palabra("bogota", "ciudades", "Capital de colombia"));

        palabras.add(new Palabra("colombia", "paises", "Pais sudamericano"));
        palabras.add(new Palabra("canada", "paises", "Pais conocido por sus inviernos"));
        palabras.add(new Palabra("japon", "paises", "Pais asiatico muy avanzado tecnologicamente"));
    }

    // Permite agregar palabras desde otra parte del programa
    public void agregarPalabra(Palabra palabra) {
        palabras.add(palabra);
    }

    // Devuelve una palabra aleatoria del banco
    public Palabra obtenerPalabraAleatoria() {
        if (palabras.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int indice = random.nextInt(palabras.size());
        return palabras.get(indice);
    }

    public ArrayList<Palabra> getPalabras() {
        return palabras;
    }
}
