import java.util.Scanner;
public class MatrizMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matriz matriz1 = new Matriz(4);
        int opcion;
        int fila;
        do{
            System.out.println("=== Opciones ===");
            System.out.println("1. Mostrar");
            System.out.println("2. Suma de todos los elementos");
            System.out.println("3. Suma de la diagonal");
            System.out.println("4. Suma de los elementos salvo la diagonal");
            System.out.println("5. Suma de elementos de una fila");
            System.out.println("6. Salir");
            opcion=sc.nextInt();
            switch(opcion){
                case 1: matriz1.muestraMatriz();
                    break;
                case 2: System.out.printf("Suma: %d\n", matriz1.suma());
                    break;
                case 3: System.out.printf("Suma diagonal: %d\n", matriz1.suma(true));
                    break;
                case 4: System.out.printf("Suma elementos fuera de la diagonal: %d\n", matriz1.suma(false));
                    break;
                case 5: System.out.println("Introduce una fila");
                        fila=sc.nextInt();
                        System.out.printf("Suma elementos de la fila: %d\n", matriz1.suma(fila));
            }   
        }while(opcion!=6);
    }
}