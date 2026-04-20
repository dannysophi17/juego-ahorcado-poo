package modelo;

import java.util.ArrayList;
import java.util.Random;

public class BancoPalabras {
    // Lista donde se guardan todas las palabras del juego
    private ArrayList<Palabra> palabras;

    public BancoPalabras() {
        palabras = new ArrayList<>();
        cargarPalabras();
    }

    // Aqui se cargan las palabras del banco.
    // La idea es que este archivo quede como base de datos simple del proyecto.
    public void cargarPalabras() {
        // Animales
        palabras.add(new Palabra("gato", "animales", "Es una mascota"));
        palabras.add(new Palabra("perro", "animales", "Ladra"));
        palabras.add(new Palabra("leon", "animales", "Rey de la selva"));
        palabras.add(new Palabra("tigre", "animales", "Tiene rayas"));
        palabras.add(new Palabra("elefante", "animales", "Tiene trompa"));
        palabras.add(new Palabra("jirafa", "animales", "Cuello largo"));
        palabras.add(new Palabra("conejo", "animales", "Come zanahoria"));
        palabras.add(new Palabra("oso", "animales", "Le gusta la miel"));
        palabras.add(new Palabra("zorro", "animales", "Muy astuto"));
        palabras.add(new Palabra("lobo", "animales", "Aulla"));
        palabras.add(new Palabra("cebra", "animales", "Blanco y negro"));
        palabras.add(new Palabra("caballo", "animales", "Corre rapido"));
        palabras.add(new Palabra("vaca", "animales", "Da leche"));
        palabras.add(new Palabra("oveja", "animales", "Tiene lana"));
        palabras.add(new Palabra("pollo", "animales", "Ave de granja"));
        palabras.add(new Palabra("gallina", "animales", "Pone huevos"));
        palabras.add(new Palabra("pato", "animales", "Nada en agua"));
        palabras.add(new Palabra("aguila", "animales", "Ave poderosa"));
        palabras.add(new Palabra("delfin", "animales", "Vive en el mar"));
        palabras.add(new Palabra("ballena", "animales", "Muy grande"));
        palabras.add(new Palabra("tiburon", "animales", "Tiene aletas"));
        palabras.add(new Palabra("mono", "animales", "Trepa arboles"));
        palabras.add(new Palabra("gorila", "animales", "Muy fuerte"));
        palabras.add(new Palabra("panda", "animales", "Blanco y negro"));
        palabras.add(new Palabra("koala", "animales", "Come eucalipto"));
        palabras.add(new Palabra("camello", "animales", "Tiene jorobas"));
        palabras.add(new Palabra("rinoceronte", "animales", "Tiene cuerno"));
        palabras.add(new Palabra("hipopotamo", "animales", "Muy pesado"));
        palabras.add(new Palabra("ardilla", "animales", "Le gustan las nueces"));
        palabras.add(new Palabra("raton", "animales", "Pequeno roedor"));
        palabras.add(new Palabra("hamster", "animales", "Mascota pequena"));
        palabras.add(new Palabra("serpiente", "animales", "Se arrastra"));
        palabras.add(new Palabra("iguana", "animales", "Reptil"));
        palabras.add(new Palabra("cocodrilo", "animales", "Vive en pantanos"));
        palabras.add(new Palabra("lagarto", "animales", "Reptil pequeno"));
        palabras.add(new Palabra("pinguino", "animales", "Vive en hielo"));
        palabras.add(new Palabra("flamenco", "animales", "Ave rosada"));
        palabras.add(new Palabra("abeja", "animales", "Produce miel"));
        palabras.add(new Palabra("mariposa", "animales", "Tiene alas coloridas"));
        palabras.add(new Palabra("rana", "animales", "Salta mucho"));
        palabras.add(new Palabra("tortuga", "animales", "Tiene caparazon"));
        palabras.add(new Palabra("canguro", "animales", "Salta y tiene bolsa"));

        // Peliculas
        palabras.add(new Palabra("titanic", "peliculas", "Barco famoso"));
        palabras.add(new Palabra("avatar", "peliculas", "Mundo azul"));
        palabras.add(new Palabra("encanto", "peliculas", "Familia colombiana"));
        palabras.add(new Palabra("coco", "peliculas", "Dia de muertos"));
        palabras.add(new Palabra("frozen", "peliculas", "Princesa del hielo"));
        palabras.add(new Palabra("shrek", "peliculas", "Ogro verde"));
        palabras.add(new Palabra("cars", "peliculas", "Autos que hablan"));
        palabras.add(new Palabra("moana", "peliculas", "Aventura en el mar"));
        palabras.add(new Palabra("barbie", "peliculas", "Muneca famosa"));
        palabras.add(new Palabra("up", "peliculas", "Casa con globos"));
        palabras.add(new Palabra("matrix", "peliculas", "Mundo virtual"));
        palabras.add(new Palabra("joker", "peliculas", "Villano famoso"));
        palabras.add(new Palabra("batman", "peliculas", "Heroe de ciudad"));
        palabras.add(new Palabra("superman", "peliculas", "Hombre de acero"));
        palabras.add(new Palabra("spiderman", "peliculas", "Lanza telaranas"));
        palabras.add(new Palabra("ironman", "peliculas", "Traje tecnologico"));
        palabras.add(new Palabra("thor", "peliculas", "Dios del trueno"));
        palabras.add(new Palabra("hulk", "peliculas", "Gigante verde"));
        palabras.add(new Palabra("avengers", "peliculas", "Equipo de heroes"));
        palabras.add(new Palabra("inception", "peliculas", "Sueno dentro de otro"));
        palabras.add(new Palabra("rapidos", "peliculas", "Carreras de carros"));
        palabras.add(new Palabra("transformers", "peliculas", "Robots que cambian"));
        palabras.add(new Palabra("intensamente", "peliculas", "Emociones"));
        palabras.add(new Palabra("toy story", "peliculas", "Juguetes que viven"));
        palabras.add(new Palabra("nemo", "peliculas", "Pez perdido"));
        palabras.add(new Palabra("dory", "peliculas", "Pez olvidadizo"));
        palabras.add(new Palabra("madagascar", "peliculas", "Animales en isla"));
        palabras.add(new Palabra("kung fu panda", "peliculas", "Panda guerrero"));
        palabras.add(new Palabra("minions", "peliculas", "Personajes amarillos"));
        palabras.add(new Palabra("gru", "peliculas", "Villano divertido"));
        palabras.add(new Palabra("zootopia", "peliculas", "Ciudad de animales"));
        palabras.add(new Palabra("aladdin", "peliculas", "Lampara magica"));
        palabras.add(new Palabra("mulan", "peliculas", "Guerrera china"));
        palabras.add(new Palabra("tarzan", "peliculas", "Hombre de la selva"));
        palabras.add(new Palabra("bambi", "peliculas", "Venado"));
        palabras.add(new Palabra("dumbo", "peliculas", "Elefante con grandes orejas"));
        palabras.add(new Palabra("bolt", "peliculas", "Perro heroe"));
        palabras.add(new Palabra("rio", "peliculas", "Guacamayas"));
        palabras.add(new Palabra("sing", "peliculas", "Animales cantantes"));
        palabras.add(new Palabra("elementos", "peliculas", "Agua fuego tierra aire"));

        // Platos tipicos
        palabras.add(new Palabra("bandeja paisa", "platos tipicos", "Plato colombiano"));
        palabras.add(new Palabra("ajiaco", "platos tipicos", "Sopa bogotana"));
        palabras.add(new Palabra("sancocho", "platos tipicos", "Sopa tradicional"));
        palabras.add(new Palabra("arepa", "platos tipicos", "Muy comun en Colombia"));
        palabras.add(new Palabra("empanada", "platos tipicos", "Frita y rellena"));
        palabras.add(new Palabra("tamal", "platos tipicos", "Envuelto en hoja"));
        palabras.add(new Palabra("lechona", "platos tipicos", "Cerdo relleno"));
        palabras.add(new Palabra("patacon", "platos tipicos", "Platano aplastado"));
        palabras.add(new Palabra("mondongo", "platos tipicos", "Sopa espesa"));
        palabras.add(new Palabra("arroz con pollo", "platos tipicos", "Plato popular"));
        palabras.add(new Palabra("frijoles", "platos tipicos", "Legumbre muy comida"));
        palabras.add(new Palabra("chicharron", "platos tipicos", "Carne crujiente"));
        palabras.add(new Palabra("picada", "platos tipicos", "Varios alimentos juntos"));
        palabras.add(new Palabra("tamal tolimense", "platos tipicos", "Muy famoso"));
        palabras.add(new Palabra("cazuela", "platos tipicos", "Se sirve en recipiente"));
        palabras.add(new Palabra("changua", "platos tipicos", "Sopa con huevo"));
        palabras.add(new Palabra("caldo", "platos tipicos", "Sopa ligera"));
        palabras.add(new Palabra("mute", "platos tipicos", "Sopa santandereana"));
        palabras.add(new Palabra("pescado frito", "platos tipicos", "Muy comun en costa"));
        palabras.add(new Palabra("ceviche", "platos tipicos", "Mariscos"));
        palabras.add(new Palabra("paella", "platos tipicos", "Plato espanol"));
        palabras.add(new Palabra("lasagna", "platos tipicos", "Pasta en capas"));
        palabras.add(new Palabra("pizza", "platos tipicos", "Comida italiana"));
        palabras.add(new Palabra("hamburguesa", "platos tipicos", "Pan con carne"));
        palabras.add(new Palabra("hot dog", "platos tipicos", "Pan con salchicha"));
        palabras.add(new Palabra("spaghetti", "platos tipicos", "Pasta larga"));
        palabras.add(new Palabra("ravioli", "platos tipicos", "Pasta rellena"));
        palabras.add(new Palabra("sushi", "platos tipicos", "Comida japonesa"));
        palabras.add(new Palabra("ramen", "platos tipicos", "Sopa asiatica"));
        palabras.add(new Palabra("burrito", "platos tipicos", "Comida mexicana"));
        palabras.add(new Palabra("taco", "platos tipicos", "Tortilla rellena"));
        palabras.add(new Palabra("nachos", "platos tipicos", "Con queso"));
        palabras.add(new Palabra("quesadilla", "platos tipicos", "Tortilla con queso"));
        palabras.add(new Palabra("enchilada", "platos tipicos", "Comida picante"));
        palabras.add(new Palabra("arroz chino", "platos tipicos", "Comida asiatica"));
        palabras.add(new Palabra("pollo apanado", "platos tipicos", "Crujiente"));
        palabras.add(new Palabra("salchipapa", "platos tipicos", "Muy popular"));
        palabras.add(new Palabra("mazamorra", "platos tipicos", "Postre tradicional"));
        palabras.add(new Palabra("natilla", "platos tipicos", "Postre navideno"));
        palabras.add(new Palabra("bunuelo", "platos tipicos", "Redondo y frito"));

        // Ciudades
        palabras.add(new Palabra("armenia", "ciudades", "Ciudad del Quindio"));
        palabras.add(new Palabra("pereira", "ciudades", "Ciudad cercana"));
        palabras.add(new Palabra("bogota", "ciudades", "Capital de Colombia"));
        palabras.add(new Palabra("medellin", "ciudades", "Eterna primavera"));
        palabras.add(new Palabra("cali", "ciudades", "Capital de la salsa"));
        palabras.add(new Palabra("cartagena", "ciudades", "Ciudad amurallada"));
        palabras.add(new Palabra("barranquilla", "ciudades", "Carnaval famoso"));
        palabras.add(new Palabra("manizales", "ciudades", "Ciudad cafetera"));
        palabras.add(new Palabra("ibague", "ciudades", "Capital musical"));
        palabras.add(new Palabra("pasto", "ciudades", "Carnaval de negros"));
        palabras.add(new Palabra("bucaramanga", "ciudades", "Ciudad bonita"));
        palabras.add(new Palabra("cucuta", "ciudades", "Frontera"));
        palabras.add(new Palabra("neiva", "ciudades", "San Pedro"));
        palabras.add(new Palabra("villavicencio", "ciudades", "Puerta al llano"));
        palabras.add(new Palabra("santa marta", "ciudades", "Ciudad costera"));
        palabras.add(new Palabra("sincelejo", "ciudades", "Sabana"));
        palabras.add(new Palabra("monteria", "ciudades", "Ganadera"));
        palabras.add(new Palabra("tunja", "ciudades", "Boyaca"));
        palabras.add(new Palabra("popayan", "ciudades", "Ciudad blanca"));
        palabras.add(new Palabra("valledupar", "ciudades", "Vallenato"));
        palabras.add(new Palabra("paris", "ciudades", "Torre Eiffel"));
        palabras.add(new Palabra("londres", "ciudades", "Big Ben"));
        palabras.add(new Palabra("roma", "ciudades", "Coliseo"));
        palabras.add(new Palabra("madrid", "ciudades", "Capital espanola"));
        palabras.add(new Palabra("barcelona", "ciudades", "Sagrada Familia"));
        palabras.add(new Palabra("miami", "ciudades", "Ciudad de playa"));
        palabras.add(new Palabra("new york", "ciudades", "Estatua de la libertad"));
        palabras.add(new Palabra("tokio", "ciudades", "Capital japonesa"));
        palabras.add(new Palabra("seul", "ciudades", "Corea"));
        palabras.add(new Palabra("moscu", "ciudades", "Rusia"));
        palabras.add(new Palabra("berlin", "ciudades", "Alemania"));
        palabras.add(new Palabra("lisboa", "ciudades", "Portugal"));
        palabras.add(new Palabra("viena", "ciudades", "Austria"));
        palabras.add(new Palabra("amsterdam", "ciudades", "Canales"));
        palabras.add(new Palabra("dubai", "ciudades", "Lujo"));
        palabras.add(new Palabra("sydney", "ciudades", "Opera"));
        palabras.add(new Palabra("toronto", "ciudades", "Canada"));
        palabras.add(new Palabra("mexico", "ciudades", "Capital mexicana"));
        palabras.add(new Palabra("quito", "ciudades", "Ecuador"));
        palabras.add(new Palabra("lima", "ciudades", "Capital peruana"));

        // Paises
        palabras.add(new Palabra("colombia", "paises", "Pais cafetero"));
        palabras.add(new Palabra("mexico", "paises", "Pais azteca"));
        palabras.add(new Palabra("argentina", "paises", "Pais del tango"));
        palabras.add(new Palabra("brasil", "paises", "Futbol y samba"));
        palabras.add(new Palabra("chile", "paises", "Pais largo"));
        palabras.add(new Palabra("peru", "paises", "Machu Picchu"));
        palabras.add(new Palabra("ecuador", "paises", "Mitad del mundo"));
        palabras.add(new Palabra("venezuela", "paises", "Pais vecino"));
        palabras.add(new Palabra("espana", "paises", "Europa"));
        palabras.add(new Palabra("francia", "paises", "Torre Eiffel"));
        palabras.add(new Palabra("italia", "paises", "Pizza y pasta"));
        palabras.add(new Palabra("alemania", "paises", "Europa central"));
        palabras.add(new Palabra("portugal", "paises", "Lisboa"));
        palabras.add(new Palabra("inglaterra", "paises", "Reino Unido"));
        palabras.add(new Palabra("canada", "paises", "Hoja de maple"));
        palabras.add(new Palabra("estados unidos", "paises", "Potencia mundial"));
        palabras.add(new Palabra("japon", "paises", "Tecnologia"));
        palabras.add(new Palabra("china", "paises", "Gran muralla"));
        palabras.add(new Palabra("corea", "paises", "Asia"));
        palabras.add(new Palabra("india", "paises", "Taj Mahal"));
        palabras.add(new Palabra("australia", "paises", "Canguros"));
        palabras.add(new Palabra("egipto", "paises", "Piramides"));
        palabras.add(new Palabra("sudafrica", "paises", "Africa"));
        palabras.add(new Palabra("marruecos", "paises", "Norte de Africa"));
        palabras.add(new Palabra("turquia", "paises", "Entre continentes"));
        palabras.add(new Palabra("grecia", "paises", "Mitologia"));
        palabras.add(new Palabra("suiza", "paises", "Relojes"));
        palabras.add(new Palabra("suecia", "paises", "Europa norte"));
        palabras.add(new Palabra("noruega", "paises", "Fiordos"));
        palabras.add(new Palabra("finlandia", "paises", "Auroras"));
        palabras.add(new Palabra("rusia", "paises", "Pais enorme"));
        palabras.add(new Palabra("ucrania", "paises", "Europa oriental"));
        palabras.add(new Palabra("panama", "paises", "Canal famoso"));
        palabras.add(new Palabra("costa rica", "paises", "Centroamerica"));
        palabras.add(new Palabra("guatemala", "paises", "Centroamerica"));
        palabras.add(new Palabra("bolivia", "paises", "Altiplano"));
        palabras.add(new Palabra("paraguay", "paises", "Sudamerica"));
        palabras.add(new Palabra("uruguay", "paises", "Montevideo"));
    }

    // Devuelve una palabra aleatoria para cada partida
    public Palabra obtenerPalabraAleatoria() {
        Random random = new Random();
        return palabras.get(random.nextInt(palabras.size()));
    }

    public ArrayList<Palabra> getPalabras() {
        return palabras;
    }
}