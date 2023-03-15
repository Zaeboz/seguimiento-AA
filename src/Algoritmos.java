import java.util.ArrayList;
import java.util.Collections;

public class Algoritmos{

    //constructor
    public Algoritmos(){
    }

    //Metodo de burbuja
    public static int[] burbuja(int[] arreglo){
        int aux;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
        return arreglo;
    }

    public static int[] burbujaDoble(int[] arreglo) {
        int aux, primero = 1, ultimo = arreglo.length - 1, dir = arreglo.length - 1;
        while(ultimo >= primero){
            for(int i = ultimo; i >= primero; i--){
                if(arreglo[i - 1] > arreglo[i]){
                    aux = arreglo[i - 1];
                    arreglo[i - 1] = arreglo[i];
                    arreglo[i] = aux;
                    dir = i;
                }
            }
            primero = dir + 1;
            for(int i = primero; i <= ultimo; i++){
                if(arreglo[i - 1] > arreglo[i]){
                    aux = arreglo[i - 1];
                    arreglo[i - 1] = arreglo[i];
                    arreglo[i] = aux;
                    dir = i;
                }
            }
            ultimo = dir - 1;
        }
        return arreglo;
    }

     //Metodo de seleccion
     public static int[] seleccion(int[] arreglo) {
        int aux, menor;
        for (int i = 0; i < arreglo.length; i++) {
            menor = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[menor]) {
                    menor = j;
                }
            }
            aux = arreglo[i];
            arreglo[i] = arreglo[menor];
            arreglo[menor] = aux;
        }
        return arreglo;
    }

    //Metodo de insercion
    public static int[] insercion(int[] arreglo) {
        int llave, i;
        for (int j = 1; j < arreglo.length; j++) {
            llave = arreglo[j];
            i = j - 1;
            while (i >= 0 && arreglo[i] > llave) {
                arreglo[i + 1] = arreglo[i];
                i--;
            }
            arreglo[i + 1] = llave;
        }
        return arreglo;
    }

    /**
     * Metodo de insercion recursivo 
     * @param arreglo 
     * @param n tamaño del arreglo
     * @return arreglo ordenado
     */
    public static int[] insertionSortRecursivo(int[] arreglo, int n) {
        if (n <= 1) {
            return arreglo;
        }
        insertionSortRecursivo(arreglo, n - 1);
        int llave = arreglo[n - 1];
        int j = n - 2;
        while (j >= 0 && arreglo[j] > llave) {
            arreglo[j + 1] = arreglo[j];
            j--;
        }
        arreglo[j + 1] = llave;
        return arreglo;
    }

    /**
     * Metodo de mezcla
     * @param arreglo arreglo a ordenar
     * @return arreglo ordenado
     */
    public static int[] shellSort(int[] arreglo) {
        for(int incr = arreglo.length / 2; incr > 0; incr /= 2) {
            for(int i = incr; i < arreglo.length; i++) {
                int j = i - incr;
                while(j >= 0)
                {
                    if(arreglo[j] > arreglo[j + incr]) {
                        int temp = arreglo[j];
                        arreglo[j] = arreglo[j + incr];
                        arreglo[j + incr] = temp;
                        j -= incr;
                    } else {
                        j = -1;
                    }
                }
            }
        }
        return arreglo;
    }

    public static int[] bucketSort(int[] arreglo) {
        // Encontrar el valor máximo y mínimo en el arreglo
        int maxValue = arreglo[0];
        int minValue = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > maxValue) {
                maxValue = arreglo[i];
            }
            if (arreglo[i] < minValue) {
                minValue = arreglo[i];
            }
        }
    
        // Crear los buckets y distribuir los elementos en ellos
        int bucketSize = (maxValue - minValue) / arreglo.length + 1;
        ArrayList<Integer>[] buckets = new ArrayList[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        for (int k : arreglo) {
            int bucketIndex = (k - minValue) / bucketSize;
            buckets[bucketIndex].add(k);
        }
    
        // Ordenar cada bucket y concatenar los resultados
        int index = 0;
        for (int i = 0; i < arreglo.length; i++) {
            Collections.sort(buckets[i]);
            for (int j = 0; j < buckets[i].size(); j++) {
                arreglo[index++] = buckets[i].get(j);
            }
        }
        return arreglo;
    }

    public static int[] mergesort(int[] arreglo){
        return arreglo;
    }

    public static int[] mergeSort(int[] arreglo) {
        int n = arreglo.length;
        if (n < 2) {
            return arreglo;
        }
        int mitad = n / 2;
        int[] left = new int[mitad];
        int[] right = new int[n - mitad];
        for (int i = 0; i < mitad; i++) {
            left[i] = arreglo[i];
        }
        for (int i = mitad; i < n; i++) {
            right[i - mitad] = arreglo[i];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

}