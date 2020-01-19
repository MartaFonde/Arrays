public class Ventas {
    private int[] ventasMes = new int[12];
    private int ano;

    /**
     * Inicializa el vector ventasMes con números aleatorios entre 0 y 1000
     * 
     * @param ano año dado
     */
    public Ventas(int ano) {
        for (int i = 0; i < ventasMes.length; i++) {
            this.ventasMes[i] = (int) (Math.random() * 1001 + 0);
        }
        this.ano = ano;
    }

    /**
     * Halla la media de valores del vector ventasMes
     * 
     * @return media de ventasMes
     */
    public double media() {
        double suma = 0;
        double mediaVentas = 0;
        for (int i = 0; i < ventasMes.length; i++) {
            suma = (double) ventasMes[i] + suma;
            mediaVentas = suma / (double) (i + 1);
        }
        return mediaVentas;
    }

    /**
     * Muestra en pantalla un gráfico de barras tal que por cada 100 uds vendidas
     * aparezca un nuevo bloque # aumentado a la barra de ese mes.
     */
    public void grafica() {
        char asterisco = '#';
        System.out.printf("Año %d:\n\n", ano);
        for (int i = 0; i < ventasMes.length; i++) {
            // int espacio=ventasMes[i].length; ¡¡length non existe para variables
            // primitivas!!
            int espacios;
            String esp;
            if (ventasMes[i] < 10) {
                espacios = 1;
                esp = "  ";
            } else if (ventasMes[i] < 100) {
                espacios = 2;
                esp = " ";
            } else {
                espacios = 3;
                esp = "";
            }
            System.out.printf("Mes %2d %s(%" + espacios + "d):", i + 1, esp, ventasMes[i]);

            for (int num = 0; num <= ventasMes[i]; num++) {
                if (num >= 0 && num % 100 == 0) {
                    System.out.printf("%c", asterisco);
                }
            }
            System.out.println();
        }
    }

}