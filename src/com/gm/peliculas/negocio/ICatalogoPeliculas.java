package com.gm.peliculas.negocio;

import com.gm.peliculas.excepciones.AccesoDatosEx;

public interface ICatalogoPeliculas {

    void agregarPelicula(String nombrePelicula, String nombreArchivo);
    void listarPeliculas(String nombreArchivo);
    void buscarPelicula(String nombreArchivo, String buscar);
    void iniciarArchivo(String nombreArchivo);

}
