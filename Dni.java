import java.util.Scanner;

public class Dni {

    /**
     * Calcula la letra correspondiente a un número de DNI o verifica si la letra 
     * es correcta. Si el DNI es dado con puntos crea una nueva cadena sin ellos.
     * @param dni dni dado
     * @return devuelve la letra del DNI o '*' si el DNI está mal dado.
     */
    public static char letraDni(String dni){ 
        char letra;
        String cadenaLetra="TRWAGMYFPDXBNJZSQVHLCKE"; 
        int num;
        String dniPuntos="";

        if(!comprobacionDni(dni)){  //false = sen erros
            if(dni.contains(".")){
                dniPuntos+=dni.substring(0, 2);
                dniPuntos+=dni.substring(3, 6);
                dniPuntos+=dni.substring(7, 10);
                num=Integer.parseInt(dniPuntos);
            }else{
                num=Integer.parseInt(dni.substring(0, 8));
            }
            letra=cadenaLetra.charAt(num%23);
            return letra;
        } else {
            return '*';
        }
    }

    /**
     * Comprueba si el DNI cumple con la longitud correcta, si está compuesto
     * por 8 números y una letra. Tiene en cuenta tanto si el DNI son sólo números 
     * como si contiene separación de millares.
     * @param dni dni dado
     * @return true si el dni tiene formato incorrecto, false si es correcto.
     */
    public static boolean comprobacionDni(String dni){ 
        boolean erro=false;
        boolean letra=false;
        String dniPuntos="";

        if(dni.charAt(dni.length()-1) >= 'A' && dni.charAt(dni.length()-1) <= 'Z' ||
                dni.charAt(dni.length()-1) >= 'a' && dni.charAt(dni.length()-1) <= 'z'){
            letra=true;
        }
    
        if(dni.length() < 8 || dni.length() > 11){   
            return true;
        } 
        
        if(!dni.contains(".")){   
            for(int i=0; i < 8; i++){     
                if(!(dni.charAt(i) >= '0' && dni.charAt(i) <= '9')){
                    erro = true;
                }
            }
            if(!letra && dni.length() != 8){
                erro = true; 
            }
            if(letra && dni.length() != 9){
                erro = true;     
            }
        }
            
        if(dni.contains(".")){
            dniPuntos+=dni.substring(0, 2);
            dniPuntos+=dni.substring(3, 6);
            dniPuntos+=dni.substring(7, 10);
            for(int i=0; i < 8; i++){     
                if(!(dniPuntos.charAt(i) >= '0' && dniPuntos.charAt(i) <= '9')){
                    erro=true;
                }
            }
            if(!letra && dni.length() != 10){
                erro=true;   
            }
            if(letra && dni.length() != 11){
                erro=true;
            }
        }
        return erro;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String dni;
        int opcion;
        if(args.length == 0){
            do{
                System.out.println("=== Opciones ===");
                System.out.println("1. Obtener letra del DNI");
                System.out.println("2. Comprobar DNI");
                System.out.println("3. Salir");
                opcion=Integer.parseInt(sc.nextLine());
                switch(opcion){
                    case 1: System.out.println("Introduzca DNI");
                            dni=sc.nextLine().trim();
                            System.out.println(letraDni(dni));
                            break;
                    case 2: System.out.println("Introduzca DNI");
                            dni=sc.nextLine().trim().toUpperCase();
                            if(dni.charAt(dni.length()-1)==letraDni(dni)){
                                System.out.println("Letra correcta");
                            }else{
                                System.out.println(letraDni(dni));
                            }
                            break;
                    case 3: System.out.println("Abur");
                            break;
                    default: System.out.println("opción no válida");
                }
            }while(opcion!=3);
        } else {
                System.out.println(letraDni(args[0]));
        }
    }
}
