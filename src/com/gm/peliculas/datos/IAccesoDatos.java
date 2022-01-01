package com.gm.peliculas.datos;
import com.gm.peliculas.domain.Pelicula;
import com.gm.peliculas.excepciones.AccesoDatosEx;
import com.gm.peliculas.excepciones.EscrituraDatosEx;
import com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.*;

public interface IAccesoDatos {

    boolean existe(String nombreArchivo);
    List<Pelicula> listar(String nombre) throws LecturaDatosEx;
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    void crear(String nombreArchivo) throws AccesoDatosEx;
    void borrar(String nombreArchivo) throws AccesoDatosEx;

}
