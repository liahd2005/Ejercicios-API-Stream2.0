/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosApi2;

import java.util.List;


public class Pelicula {
    private int idPelicula;
    private String tituloPelicula;
    private int year;
    private String ranking;
    private List<Genero> generos;
    private List<Director> directores;

    public Pelicula(int idPelicula, String tituloPelicula, int year, String ranking, List<Genero> generos, List<Director> directores) {
        this.idPelicula = idPelicula;
        this.tituloPelicula = tituloPelicula;
        this.year = year;
        this.ranking = ranking;
        this.generos = generos;
        this.directores = directores;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }
}
