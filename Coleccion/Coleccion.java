import java.util.ArrayList;

public class Coleccion {

    public static ArrayList<Integer> introduccionDatos(int n) {
        ArrayList<Integer> coleccion = new ArrayList<Integer>();
        Datos numero;
        for (int i = 0; i < n; i++) {
            numero = new Datos();
            coleccion.add(numero.numAleatorio());
        }
        return coleccion;
    }

    public static void mostrarDatos(ArrayList<Integer> coleccion) {
        for (Integer numero : coleccion) {
            System.out.println(numero);
        }
    }

    public static int maximo(ArrayList<Integer> coleccion) {
        int max = coleccion.get(0);
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i) > max) {
                max = coleccion.get(i);
            }
        }
        return max;
    }

    public static int minimo(ArrayList<Integer> coleccion) {
        int min = coleccion.get(0);
        for (int valor : coleccion) {
            if (valor < min) {
                min = valor;
            }
        }
        return min;
    }

    public static boolean intercambio(ArrayList<Integer> coleccion, int i, int j) {
        if (i >= 0 && j >= 0 && i < coleccion.size() && j < coleccion.size()) {
            int temporary = coleccion.get(i);
            coleccion.set(i, coleccion.get(j));
            coleccion.set(j, temporary);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> coleccion;
        coleccion = introduccionDatos(10);
        mostrarDatos(coleccion);
        System.out.printf("Máximo: %d\n", maximo(coleccion));
        System.out.printf("Mínimo: %d\n", minimo(coleccion));
        System.out.println(intercambio(coleccion, 0, 9));
        mostrarDatos(coleccion);

    }
}
