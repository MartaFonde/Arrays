public class EjerString{
    public static void main(String[] args) {
        String frase="Jar Jar is the Big Boss";
        int longitud=frase.length();
        System.out.printf("Longitud: %d\n", longitud);
        System.out.printf("Carácter posición inicial: %s\n", frase.charAt(0));
        System.out.printf("Carácter posición final: %s\n", frase.charAt(longitud-1));
        // System.out.printf("Carácter posición 100: %s\n", frase.charAt(100));
        // String index out of range: 100
        String mayus=frase.toUpperCase();
        System.out.printf("%s\n", frase.equals(mayus));  //false. Compara, tiene en cuenta el case
        System.out.printf("%s\n", frase.equalsIgnoreCase(mayus)); //true. Ignora case
        System.out.printf("%s\n", frase.toLowerCase());
        System.out.printf("%s\n", frase.endsWith("Jar")); //false
        System.out.printf("%s\n", frase.endsWith("Boss")); //true
        System.out.printf("%d\n", frase.indexOf("Jar")); //0
        System.out.printf("%d\n", frase.lastIndexOf("Jar")); //4
        String frag=frase.substring(3, 7);
        System.out.println(frag);
        System.out.println(frag.trim());
        System.out.println();
        
        String[] vectorFrase = new String[longitud];
        vectorFrase=frase.split(" ");
        for(String a : vectorFrase){
            System.out.println(a);
        }
        //System.out.printf("%s\n", frase.split("  ")); NO!!




        



    }
}