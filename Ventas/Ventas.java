public class Ventas {
    private int[] ventasMes = new int[12];
    private int ano;

    /**
     * Inicializa el vector ventasMes con números aleatorios entre 0 y 1000.
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
     * @return media de ventasMes
     */
    public double media() {
        double suma = 0;
        double mediaVentas;
        for (int i = 0; i < ventasMes.length; i++) {
            suma = (double) ventasMes[i] + suma;           
        }
        mediaVentas = suma / ventasMes.length;
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
            System.out.printf("Mes %2d %5s:", i + 1, "(" + ventasMes[i] + ")");

            for (int num = 0; num <= ventasMes[i]; num++) {
                if (num >= 0 && num % 100 == 0) {
                    System.out.printf("%c", asterisco);
                }
            }
            System.out.println();
        }
    }

}
