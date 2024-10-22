/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosApi2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author liahu
 */
public class Main {

    public static void main(String[] args) {
        
        Genero drama = new Genero(1, "Drama");
        Genero comedia = new Genero(2, "Comedia");
        Genero accion = new Genero(3, "Acción");
        Genero suspenso = new Genero(4, "suspenso");

        
        // Creación de directores
        Director director1 = new Director(1, "Director A", Arrays.asList("Premio 1", "Premio 2"));
        Director director2 = new Director(2, "Director B", Arrays.asList("Premio 3"));

        // Creación de películas
        List<Pelicula> peliculas = Arrays.asList(
            new Pelicula(1, "Parasite", 2020, "9.0", Arrays.asList(drama, suspenso), Arrays.asList(director1)),
            new Pelicula(2, "joker", 2019, "7.0", Arrays.asList(drama), Arrays.asList(director1)),
            new Pelicula(3, "rapidos y furiosos", 2001, "7.0", Arrays.asList(comedia, accion), Arrays.asList(director2)),
            new Pelicula(4, "Mamma Mia", 2008, "8.5", Arrays.asList(drama, comedia), Arrays.asList(director2))
        );

        // Encontrar películas que tienen solamente los géneros "Drama" y "Comedia"
        List<Pelicula> peliculasFiltradas = peliculas.stream()
            .filter(pelicula -> tieneSoloGenerosEspecificos(pelicula, Arrays.asList("Drama", "Comedia")))
            .collect(Collectors.toList());

        // Mostrar resultados
        System.out.println("Películas que tienen solamente los géneros 'Drama' y 'Comedia':");
        peliculasFiltradas.forEach(pelicula -> System.out.println(pelicula.getTituloPelicula()));
    }

    private static boolean tieneSoloGenerosEspecificos(Pelicula pelicula, List<String> generosEspecificos) {
        List<String> nombresGeneros = pelicula.getGeneros().stream()
            .map(Genero::getNombreGenero)
            .collect(Collectors.toList());

        // Verifica si todos los géneros de la película están en la lista de géneros específicos
        boolean todosSonEspecificos = nombresGeneros.stream().allMatch(generosEspecificos::contains);

        // Verifica si la cantidad de géneros coincide exactamente
        return todosSonEspecificos && nombresGeneros.size() == generosEspecificos.size();
    }
    }
    

