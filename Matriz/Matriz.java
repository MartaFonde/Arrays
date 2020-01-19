public class Matriz {
    private int[][] matriz;

    /**
     * Constructor que inicializa la matriz a tamaño NxN con valores aleatorios entre 0 y 1o.
     * @param n número de filas y columnas de la matriz
     */
    public Matriz(int n){
        matriz = new int[n][n]; // inicialización!!
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matriz[i][j]=(int)(Math.random()*11+0);
            }
        }
    }

    /**
     * Muestra la matriz
     */
    public void muestraMatriz() {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.printf("%3d", valor);
            }
            System.out.println();
        }
    }

    /**
     * Suma todos los elementos de la matriz
     * 
     * @return suma
     */
    public int suma() {
        int sumaNum = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumaNum = matriz[i][j] + sumaNum;
            }
        }
        return sumaNum;
    }

    /**
     * Suma los valores de la diagonal principal.
     * 
     * @param diagonal
     * @return
     */
    public int suma(boolean diagonal) {
        int sumaDiag = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    sumaDiag = matriz[i][j] + sumaDiag;
                }
            }
        }
        if (diagonal == true) {
            return sumaDiag;
        } else {
            return suma() - sumaDiag;
        }

    }

    public int suma(int fila) {
        int sumaFila = 0;
        if (fila < matriz.length) {
            for (int j = 0; j < matriz[fila].length; j++) {
                sumaFila = matriz[fila][j] + sumaFila;
            }
            return sumaFila;
        } else {
            return -1;
        }
    }

}