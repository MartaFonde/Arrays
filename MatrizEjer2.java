public class Ejer2_Bol5 {

    public static char[][] matrizChar(int fila, int columna) {
        char[][] matriz = new char[fila][columna];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (char) (Math.random() * 26 + 'A');
            }
        }
        return matriz;
    }

    public static void mostrarMatrizChar(char[][] matriz) {
        for (char fila[] : matriz) {
            for (char col : fila){
                System.out.printf("%4c", col);
            }
            System.out.println(); 
        }
        
    }

    public static char maxLetra(char[][] matriz) {
        char max = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > max) {
                    max = matriz[i][j];
                }
            }
        }
        return max;

    }

    public static char minLetra(char[][] matriz) {
        char min = matriz[0][0];
        for (char[] fila : matriz) {
            for (char col : fila) {
                if (col < min) {
                    min = col;
                }
            }
        }
        return min;
    }

    public static boolean intercambio(char[][] matriz, int fila1, int col1, int fila2, int col2) {
        if (fila1 >= 0 && col1 >= 0 && fila2 >= 0 && col2 >= 0 && fila1 < matriz.length && fila2 < matriz.length
                && col1 < matriz[fila1].length && col2 < matriz[fila2].length) {
            char temporary = matriz[fila1][col1];
            matriz[fila1][col1] = matriz[fila2][col2];
            matriz[fila2][col2] = temporary;
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        char[][] matriz;
        matriz = matrizChar(3, 4);
        mostrarMatrizChar(matriz);
        System.out.printf("Letra máx: %4c\n", maxLetra(matriz));
        System.out.printf("Letra mín: %4c\n", minLetra(matriz));
        System.out.println(intercambio(matriz, 0, 0, 1, 3));
        mostrarMatrizChar(matriz);

    }
}
