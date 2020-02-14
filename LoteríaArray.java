import java.util.ArrayList;
import java.util.Scanner;

public class Ejer9_Bol5 {

    /**
     * Pide seis enteros al usuario, separados por comas, y los guarda (sin comas)
     * en una colección. Si el usuario introduce menos de 6 números o no introduce
     * comas, da error y tiene que volver a introducir datos.
     * 
     * @param colecUsuario colección dada
     */
    public static void datosUsuario(ArrayList<Integer> colecUsuario) {
        Scanner sc = new Scanner(System.in);
        String[] vectorNumeros;
        String num;
        int numColec;
        do {
            System.out.println("Introduce 6 números entre 1 y 49, separados por comas");
            num = sc.nextLine().trim();
            vectorNumeros = num.split(",");
            if (vectorNumeros.length != 6) {
                System.out.println("Error. Cadena inválida");
            }
        } while (vectorNumeros.length != 6);
        for (int i = 0; i < 6; i++) {
            numColec = Integer.parseInt(vectorNumeros[i].trim());
            colecUsuario.add(numColec);
        }
        comprobacionNum(colecUsuario);
    }

    /**
     * Comprueba si los números de la colección están en el rango (1, 49). Si da
     * error, el usuario tendrá que volver a introducir los números indicados.
     * 
     * @param colecUsuario colección dada
     */
    public static void comprobacionNum(ArrayList<Integer> colecUsuario) {
        Scanner sc = new Scanner(System.in);
        int num;
        for (int i = 0; i < colecUsuario.size(); i++) {
            while (colecUsuario.get(i) < 1 || colecUsuario.get(i) > 49 || valoresRepetidos(i, colecUsuario)) {
                System.out.printf("Error. Número incorrecto %d.\nIntroduce un número entre 1 y 49: ",
                        colecUsuario.get(i));
                num = Integer.parseInt(sc.nextLine());
                colecUsuario.set(i, num);
            }
        }
    }

    /**
     * Comprueba si el valor de la colección en una posición está contenido en la
     * colección.
     * 
     * @param posicion     posición dada
     * @param colecUsuario colección
     * @return true si el valor está repetido, false si no lo está.
     */
    public static boolean valoresRepetidos(int posicion, ArrayList<Integer> colecUsuario) {
        for (int j = posicion - 1; j >= 0; j--) {
            if (colecUsuario.get(posicion) == colecUsuario.get(j)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Asigna a una colección enteros entre 1 y 49 aleatorios
     * 
     * @param colecCpu colección dada
     */
    public static void datosCpu(ArrayList<Integer> colecCpu) {
        for (int i = 0; i < 6; i++) {
            colecCpu.add((int) (Math.random() * 10 + 1));
            while (valoresRepetidos(i, colecCpu)) {
                // System.out.println(colecCpu.size());
                colecCpu.set(i, (int) (Math.random() * 10 + 1));
            }
        }
    }

    /**
     * Muestra los datos de una colección.
     * 
     * @param colec colección dada
     */
    public static void mostrarDatos(ArrayList<Integer> colec) {
        for (int i = 0; i < colec.size(); i++) {
            System.out.printf("%d%s", colec.get(i), i < colec.size() - 1 ? ", " : ".\n");
        }
    }

    /**
     * Contabiliza el número de coincidencias entre valores de dos colecciones.
     * 
     * @param colecUsuario colección dada
     * @param colecCpu     colección dada
     */
    public static void aciertos(ArrayList<Integer> colecUsuario, ArrayList<Integer> colecCpu) {
        int aciertos = 0;
        for (int i = 0; i < colecUsuario.size(); i++) {
            for (int j = 0; j < colecCpu.size(); j++) {
                if (colecUsuario.get(i) == colecCpu.get(j)) {
                    System.out.println("Acierto: " + colecUsuario.get(i));
                    aciertos++;
                }
            }
        }
        System.out.println("Total de aciertos: " + aciertos);
    }

    public static void main(String[] args) {
        ArrayList<Integer> colecUsuario = new ArrayList<Integer>();
        ArrayList<Integer> colecCpu = new ArrayList<Integer>();
        datosUsuario(colecUsuario);
        datosCpu(colecCpu);
        System.out.println("=== Datos cpu ===");
        mostrarDatos(colecCpu);
        System.out.println("=== Datos usuario ===");
        mostrarDatos(colecUsuario);
        aciertos(colecUsuario, colecCpu);

    }
}
