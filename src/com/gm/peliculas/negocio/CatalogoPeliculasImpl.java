package com.gm.peliculas.negocio;

import com.gm.peliculas.domain.Pelicula;
import com.gm.peliculas.datos.*;
import com.gm.peliculas.excepciones.AccesoDatosEx;
import com.gm.peliculas.excepciones.LecturaDatosEx;


public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        try {
            if (!datos.existe(nombreArchivo)) {
                System.out.println("El archivo no existe");
            } else{
                Pelicula pelicula = new Pelicula(nombrePelicula);
                datos.escribir(pelicula, nombreArchivo, true);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error de accesp a datos");
            e.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            if (!datos.existe(nombreArchivo)) {
                System.out.println("El archivo no existe");
            } else {
                for (Pelicula pelicula : datos.listar(nombreArchivo)) {
                    System.out.println(pelicula);
                }
            }
        } catch (LecturaDatosEx e) {
            System.out.println("Error al listar peliculas");
            e.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {

            try {
                if (datos.buscar(nombreArchivo, buscar) == null) {
                    System.out.println("La pelicula " + buscar + " no se encuentra en el archivo");
                } else {
                    System.out.println("La pelicula " + buscar + " se encuentra en el archivo");
                }
            } catch (LecturaDatosEx e) {
                System.out.println("Error al buscar la pelicula");
                e.printStackTrace();
            }
    }


    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if (datos.existe(nombreArchivo)) {
                System.out.println("Se ha elegido " + nombreArchivo + " como catalogo actual\n");
            } else {
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error al inicializar el archivo");
            e.printStackTrace();
        }
    }
}
