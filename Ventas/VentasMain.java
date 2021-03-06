import java.util.Scanner;

public class VentasMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ano;
        int opcion;
        do {
            if(args.length == 0){
                System.out.println("Introduce año");
                ano = sc.nextInt();
                sc.nextLine();
                Ventas ventas1 = new Ventas(ano);
                ventas1.grafica();
                System.out.printf("Media: %.2f\n\n", ventas1.media());
            } else {
                int anoComando=Integer.parseInt(args[0]);
                Ventas ventas2 = new Ventas(anoComando);
                ventas2.grafica();
                System.out.printf("Media: %.2f\n\n", ventas2.media());
            }    
            System.out.println("¿Repetir?\n 1. Sí\n 2. No");
            opcion = sc.nextInt();
        } while (opcion == 1);
    }
}
