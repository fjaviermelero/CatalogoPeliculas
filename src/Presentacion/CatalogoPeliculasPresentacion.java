package Presentacion;

import com.gm.peliculas.negocio.*;
import java.util.Scanner;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
        int opcion = 99999;
        String nombreArchivo = "Catalogo sin inicializar";
        String nombrePelicula;

        while (opcion != 0) {

            if (nombreArchivo.equals("Catalogo sin inicializar")) {
                System.out.println("Introduce nombre del catalogo");
                nombreArchivo = leerStringConsola() + ".txt";
                catalogoPeliculas.iniciarArchivo(nombreArchivo);
                introContinuar();
            }
            else{
                imprimirMenu(nombreArchivo);
                opcion = leerEnteroConsola();
                switch (opcion) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Introduce nombre del catalogo");
                        nombreArchivo = leerStringConsola() + ".txt";
                        catalogoPeliculas.iniciarArchivo(nombreArchivo);
                        introContinuar();
                        break;
                    case 2:
                        System.out.println("Introduce nombre de la pelicula a agregar");
                        nombrePelicula = leerStringConsola();
                        catalogoPeliculas.agregarPelicula(nombrePelicula, nombreArchivo);
                        introContinuar();
                        break;
                    case 3:
                        catalogoPeliculas.listarPeliculas(nombreArchivo);
                        introContinuar();
                        break;
                    case 4:
                        System.out.println("Introduce nombre de la pelicula a buscar");
                        nombrePelicula = leerStringConsola();
                        catalogoPeliculas.buscarPelicula(nombreArchivo, nombrePelicula);
                        introContinuar();
                }
            }
        }
        System.out.println("Saliendo del programa");
        introContinuar();
    }

    public static int leerEnteroConsola() {
        int lectura;
        String input;
        Scanner sc = new Scanner(System.in);

        input = sc.nextLine();
        try {
            lectura = Integer.valueOf(input);
        } catch (Exception e) {
            System.out.println("El valor ha de ser un entero");
            introContinuar();
            lectura = 99999;
        }
        return lectura;
    }

    public static String leerStringConsola() {
        String lectura;
        Scanner sc = new Scanner(System.in);
        lectura = sc.nextLine();
        return lectura;
    }

    public static void introContinuar(){
        System.out.println("Pulsa intro para continuar");
        leerStringConsola();
    }

    public static void imprimirMenu(String nombreArchivo){
        System.out.println("\n");
        System.out.println("Catalogo actual: " + nombreArchivo);
        System.out.println("Elige Opcion:");
        System.out.println("1.- Iniciar catalogo de peliculas");
        System.out.println("2.- Agregar pelicula");
        System.out.println("3.- Listar peliculas");
        System.out.println("4.- Buscar pelicula");
        System.out.println("0.- Salir \n");
    }

}

