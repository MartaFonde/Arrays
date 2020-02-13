public class Matriz {
    private int[][] matriz;
    private int[][] nuevaMatriz;

    /**
     * Inicializa una matriz cuadrada de tamaño NxN con valores aleatorios entre 0 y 10.
     * @param n número de filas y columnas de la matriz
     */
    public Matriz(int n){
        this.matriz = new int[n][n]; // inicialización CON THIS!!
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
     * Halla la suma los valores de la diagonal principal o 
     * la suma el todos los valores de la matriz, excepto los de la diagonal principal.
     * @param diagonal si es true, calcula la suma de los valores de la diagonal.
     * Si es false, calcula la suma del resto de valores.
     * @return suma de los valores.
     */
    public int suma(boolean diagonal) {
        int sumaDiag = 0;
        for (int i = 0; i < matriz.length; i++) {
            sumaDiag = matriz[i][i] + sumaDiag;

            /*for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    sumaDiag = matriz[i][j] + sumaDiag;
                }
            }*/
        }
        if (diagonal == true) {
            return sumaDiag;
        } else {
            return suma() - sumaDiag;
        }

    }

    /**
     * Halla la suma de los elementos de una fila
     * @param fila fila dada
     * @return suma de los valores de la fila. Si la fila no existe devuelve -1.
     */
    public int suma(int fila) {
        int sumaFila = 0;
        if (fila < matriz.length && fila >=0) {
            for (int j = 0; j < matriz[fila].length; j++) {
                sumaFila = matriz[fila][j] + sumaFila;
            }
            return sumaFila;
        } else {
            return -1;
        }
    }


    /**
     * Crea una nueva matriz, partiendo de la original, sin una fila indicada.
     * Luego la muestra.
     * @param elimFila fila a eliminar
     */
    public void eliminarFila(int elimFila){ 
        this.nuevaMatriz=new int[matriz.length-1][matriz[0].length];
        if(elimFila < 0 || elimFila >= matriz.length){
            System.out.println("Posición no válida");
        } else {
            for(int i=0; i < matriz.length; i++){  
                if(i<elimFila){ 
                    nuevaMatriz[i]=matriz[i];
                }else{
                    for(int j=elimFila; j<matriz.length-1; j++){
                        nuevaMatriz[j]=matriz[j+1];
                    }
                }
            }
            for (int[] fila : nuevaMatriz) {
                for (int valor : fila) {
                    System.out.printf("%3d", valor);
                }
                System.out.println();
            }
        }
    }  
}
