/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioApi;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Inicializar la lista de países con sus ciudades
        List<Ciudad> ciudadesUSA = Arrays.asList(
            new Ciudad(1, "Nueva York", 8419600, "NYC"),
            new Ciudad(2, "Los Ángeles", 3980400, "LA")
        );

        List<Ciudad> ciudadesCanada = Arrays.asList(
            new Ciudad(3, "Toronto", 2731571, "TOR"),
            new Ciudad(4, "Vancouver", 631486, "VAN")
        );
        List<Ciudad> ciudadesAustralia = Arrays.asList(
            new Ciudad(5, "Sídney", 5312163, "SYD"),
            new Ciudad(6, "Melbourne", 5081000, "MEL")
        );

        List<Ciudad> ciudadesChina = Arrays.asList(
            new Ciudad(7, "Shanghai", 24183300, "SHA"),
            new Ciudad(8, "Beijing", 21542000, "BEI")
        );

        List<Ciudad> ciudadesSudafrica = Arrays.asList(
            new Ciudad(9, "Johannesburgo", 9574417, "JHB"),
            new Ciudad(10, "Ciudad del Cabo", 433688, "CPT")
        );

        List<Ciudad> ciudadesAlemania = Arrays.asList(
            new Ciudad(11, "Berlín", 3644826, "BER"),
            new Ciudad(12, "Múnich", 1471508, "MUC")
        );
        
        List<Pais> paises = Arrays.asList(
            new Pais("US", "Estados Unidos", "América del Norte", 9833517, 1, 331000000, ciudadesUSA),
            new Pais("CA", "Canadá", "América del Norte", 9984670, 3, 37700000, ciudadesCanada),
            new Pais("AU", "Australia", "Oceanía", 7692024, 5, 25600000, ciudadesAustralia),
            new Pais("CN", "China", "Asia", 9596961, 7, 1393000000, ciudadesChina),
            new Pais("ZA", "Sudáfrica", "África", 1219090, 9, 60000000, ciudadesSudafrica),
            new Pais("DE", "Alemania", "Europa", 357022, 11, 83783942, ciudadesAlemania)
        );
        List<Pais> paisesOrdenadosPorCiudades = paises.stream()
            .sorted(Comparator.comparingInt(Pais::getNumeroCiudades).reversed())
            .collect(Collectors.toList());

        System.out.println("Países ordenados por número de ciudades (descendente):");
        paisesOrdenadosPorCiudades.forEach(pais -> 
            System.out.println("País: " + pais.getNombrePais() + ", Número de ciudades: " + pais.getNumeroCiudades())
        );
        List<Pais> paisesOrdenadosPorPoblacion = paises.stream()
            .sorted(Comparator.comparingInt(Pais::getNroPoblacion))
            .collect(Collectors.toList());

        System.out.println("\nPaíses ordenados por número de población (ascendente):");
        paisesOrdenadosPorPoblacion.forEach(pais -> 
            System.out.println("País: " + pais.getNombrePais() + ", Población: " + pais.getNroPoblacion())
        );

        // Encontrar las ciudades más pobladas por continente
        Map<String, Ciudad> ciudadesMasPobladas = paises.stream()
                .flatMap(pais -> pais.getCiudades().stream()
                        .map(ciudad -> new AbstractMap.SimpleEntry<>(pais.getNombreContinente(), ciudad)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.maxBy(Comparator.comparingInt(Ciudad::getNroPoblacion)))
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get()));

        // Mostrar resultados
        System.out.println("Ciudades más pobladas por continente:");
        ciudadesMasPobladas.forEach((continente, ciudad) -> {
            System.out.println("Continente: " + continente + ", Ciudad más poblada: " + ciudad.getNombreCiudad());
        });
        
        // Encontrar la ciudad más poblada de todos los continentes
        Ciudad ciudadMasPoblada = ciudadesMasPobladas.values().stream()
                .max(Comparator.comparingInt(Ciudad::getNroPoblacion))
                .orElse(null);

        // Mostrar ciudad más poblada
        if (ciudadMasPoblada != null) {
            System.out.println("\nLa ciudad más poblada de todos los continentes es: " + ciudadMasPoblada.getNombreCiudad() + " (" + ciudadMasPoblada.getNroPoblacion() + " habitantes)");
        }

        // Guardar resultados en un archivo
        guardarResultados(ciudadesMasPobladas);
    }

    public static void guardarResultados(Map<String, Ciudad> resultados) {
        List<String> lineas = resultados.entrySet()
                .stream()
                .map(entry -> "Continente: " + entry.getKey() + ", Ciudad más poblada: " + entry.getValue().getNombreCiudad())
                .collect(Collectors.toList());

        try {
            Files.write(Paths.get("ciudades_mas_pobladas.txt"), lineas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

