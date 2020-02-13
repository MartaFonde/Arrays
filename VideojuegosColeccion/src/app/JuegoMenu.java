package app;

import java.util.ArrayList;
import java.util.Scanner;

public class JuegoMenu {
    private Scanner sc = new Scanner(System.in);
    private int opcion;
    private Juego juego;

    /**
     * Muestra el menú de opciones y vincula cada una con su respectiva función
     * @param colecJuegos colección dada
     */
    public void mostrarMenu(ArrayList<Juego> colecJuegos) {
        do {
            System.out.println("=== OPCIONES ===");
            System.out.println("1. Insertar nuevo juego");
            System.out.println("2. Eliminar videojuego");
            System.out.println("3. Confirmar si existe un videojuego");
            System.out.println("4. Visualizar toda la lista de videojuegos");
            System.out.println("5. Visualización de videojuegos de un año determinado");
            System.out.println("6. Borrar videojuegos de un año determinado");
            System.out.println("7. Salir del programa");
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1: insertarJuego(colecJuegos);
                    break;
                case 2: eliminarJuego(colecJuegos);
                    break;
                case 3: confirmarJuego(colecJuegos);
                    break;
                case 4: mostrarColeccion(colecJuegos);
                    break;
                case 5: mostrarJuegosAno(colecJuegos);
                    break;
                case 6: elimJuegoAno(colecJuegos);
                    break;
                case 7: System.out.println("Abur!");
                    break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 7);
    }

    /**
     * Inserta un nuevo juego en una colección dada. Permite decidir al usuario si
     * insertalo al principio o al final de la colección si hay algún elemento. 
     * @param colecJuegos colección dada
     */
    public void insertarJuego(ArrayList<Juego> colecJuegos) {
        juego = new Juego();
        //int opcion1;
        if (colecJuegos.size() > 0) {
            do{
                System.out.printf("1. Insertar al inicio\n2. Insertar al final\n");
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion == 1) {
                    colecJuegos.add(0, juego);
                } else if (opcion == 2) {
                    colecJuegos.add(juego);
                } else {
                    System.out.println("Opción no válida");
                }  
            }while(opcion!=1 && opcion!=2);   
        }
    }
    /**
     * Elimina un juego de una colección dada, indicando la posición.
     * @param colecJuegos colección dada
     */
    public void eliminarJuego(ArrayList<Juego> colecJuegos) {
        int posicion;
        //int confirmacion;
        System.out.println("Introduce posicion");
        posicion = Integer.parseInt(sc.nextLine());
        System.out.printf("Título: %s\nAño: %d\nFabricante: %s\n\n", colecJuegos.get(posicion).getTitulo(), 
                        colecJuegos.get(posicion).getAno(), colecJuegos.get(posicion).getFabricante());
        System.out.printf("¿Está seguro que desea eliminarlo?\n1. Sí\n2. No\n");
        opcion = Integer.parseInt(sc.nextLine());
        if (opcion == 1) {
            colecJuegos.remove(posicion);
        } else if (opcion == 2) {
            System.out.println("Juego no eliminado");
        } else {
            System.out.println("Opción no válida");
        }
    }

    /**
     * Confirma si existe un juego en la colección. Se puede meter el principio del título
     * y mostrar todos los títulos que empiecen por dicho fragmento.
     * @param colecJuegos
     */
    public void confirmarJuego(ArrayList<Juego> colecJuegos) {
        String titulo;
        boolean existencia=false;
        System.out.println("Introduzca título:");
        titulo = sc.nextLine().trim();
        String tituloMayus = titulo.toUpperCase();
        for (Juego juegos : colecJuegos) {
            if ((juegos.getTitulo()).startsWith(tituloMayus)) {
                System.out.printf("Titulo: %s\n", juegos.getTitulo());
                existencia=true;
            }
        }
        if(existencia==false){
            System.out.println("Título no existente");
        }
    }

    /**
     * Muestra toda la lista de juegos 
     * @param colecJuegos coleccion dada
     */
    public void mostrarColeccion(ArrayList<Juego> colecJuegos) {
        for (int i = 0; i < colecJuegos.size(); i++) {
            System.out.printf("%6d\nTítulo: %s\nAño: %d\nFabricante: %s\n\n", i, colecJuegos.get(i).getTitulo(),
                    colecJuegos.get(i).getAno(), colecJuegos.get(i).getFabricante());
        }
    }

    /**
     * Muestra los juegos de un año determinado
     * @param colecJuegos colección dada
     */
    public void mostrarJuegosAno(ArrayList<Juego> colecJuegos) {
        int ano;
        boolean existencia=false;
        System.out.println("Introduce un año");
        ano = Integer.parseInt(sc.nextLine().trim());
        for (Juego juegos : colecJuegos) {
            if (ano == juegos.getAno()) {
                System.out.printf("Título: %s\nAño: %d\nFabricante: %s\n\n", juegos.getTitulo(), juegos.getAno(),
                        juegos.getFabricante());
                existencia=true;
            }
        }
        if(existencia==false){
            System.out.println("No existen videojuegos de ese año");
        }
    }

    /**
     * Elimina uno o varios juegos de un año determinado de la colección
     * @param colecJuegos colección dada
     */
    public void elimJuegoAno(ArrayList<Juego> colecJuegos) {
        int anoElim;
        boolean existencia=false;
        System.out.println("Introduce un año");
        anoElim = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i <colecJuegos.size(); i++) {
            if (anoElim == colecJuegos.get(i).getAno()) {
                System.out.printf("Título: %s\nAño: %d\nFabricante: %s\n\n", 
                                colecJuegos.get(i).getTitulo(), colecJuegos.get(i).getAno(),
                                colecJuegos.get(i).getFabricante());
                existencia=true;
                System.out.printf("¿Está seguro que desea eliminarlo?\n1. Sí\n2. No\n");
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion == 1) {
                    colecJuegos.remove(i);
                    System.out.printf("Juego eliminado\n");
                } else if (opcion == 2) {
                    System.out.printf("Juego no eliminado\n");
                } else {
                    System.out.printf("Opción no válida\n");
                }
            }
        }
        if(existencia==false){
            System.out.println("No existen videojuegos de ese año");
        }
    }
}