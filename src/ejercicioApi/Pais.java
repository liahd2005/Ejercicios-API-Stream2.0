/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioApi;

import java.util.List;

public class Pais {
    private String codigo;
    private String nombrePais;
    private String nombreContinente;
    private double areaPoblacion;
    private int capital;
    private int nroPoblacion;
    private List<Ciudad> ciudades;

    // Constructor, Getters y Setters
    public Pais(String codigo, String nombrePais, String nombreContinente, double areaPoblacion, int capital, int nroPoblacion, List<Ciudad> ciudades) {
        this.codigo = codigo;
        this.nombrePais = nombrePais;
        this.nombreContinente = nombreContinente;
        this.areaPoblacion = areaPoblacion;
        this.capital = capital;
        this.nroPoblacion = nroPoblacion;
        this.ciudades = ciudades;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }
    
    public int getNumeroCiudades() {
        return ciudades.size();
    }

    public int getNroPoblacion() {
        return nroPoblacion;
    }

    public String getNombrePais() {
        return nombrePais;
    }
}
