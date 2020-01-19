public class Ejer1_Bol5 {

    public static int[] numEnteros(int ind) {
        int[] vector = new int[ind];
        for (int i = 0; i < ind; i++) {
            vector[i] = (int) (Math.random() * 4001 + 1000);
        }
        return vector;
    }

    public static void mostrarNumEnteros(int[] vector) {
        for (int num : vector) {
            System.out.printf("%8d", num);
        }
        System.out.println();
    }

    public static int maxEnteros(int[] vector) {
        int max = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max) {
                max = vector[i];
            }
        }
        return max;
    }

    public static int minEnteros(int[] vector) {
        int min = vector[0];
        for (int num : vector) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static boolean intercambio(int[] vector, int ind1, int ind2) {
        if (ind1 < vector.length && ind2 < vector.length && ind1 >= 0 && ind2 >= 0) {
            int temporary = vector[ind1];
            vector[ind1] = vector[ind2];
            vector[ind2] = temporary;
            return true;            
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        int[] vector;
        vector = numEnteros(30);
        mostrarNumEnteros(vector);
        System.out.printf("Máximo: %d\n", maxEnteros(vector));
        System.out.printf("Mínimo: %d\n", minEnteros(vector));
        System.out.println(intercambio(vector, 30, 1));
        mostrarNumEnteros(vector);
        System.out.println();

    }
}
