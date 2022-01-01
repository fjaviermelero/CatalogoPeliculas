package com.gm.peliculas.datos;

import com.gm.peliculas.domain.Pelicula;
import com.gm.peliculas.excepciones.*;

import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements IAccesoDatos {

    //TESTED
    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    //TESTED
    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        List<Pelicula> peliculas = new ArrayList<>();
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            try {
                var lectura = entrada.readLine();
                while (lectura != null) {
                    Pelicula pelicula = new Pelicula(lectura);
                    peliculas.add(pelicula);
                    lectura = entrada.readLine();
                }
                entrada.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
                throw new LecturaDatosEx("Excepcion al listar peliculas");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas");
        }
        return peliculas;
    }

    //TESTED
    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.getNombre());
            salida.close();
            System.out.println("Se ha escrito el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir datos");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir datos");
        }
    }

    //TESTED
    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String lecturaEncontrada = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            try {
                var lectura = entrada.readLine();
                while (lectura != null) {
                    if (lectura.equals(buscar)) {
                        lecturaEncontrada = buscar;
                    }
                    lectura = entrada.readLine();
                }
                entrada.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar la pelicula");
        }
        return lecturaEncontrada;
    }

    //TESTED
    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx{
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el catalogo: " + nombreArchivo + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al crear archivo");
        }
    }

    //TESTED
    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.delete()) {
            System.out.println("Se ha eliminado el archivo: " + nombreArchivo);
        } else {
            System.out.println("No se pudo eliminar el archivo: " + nombreArchivo);
        }
    }

}
