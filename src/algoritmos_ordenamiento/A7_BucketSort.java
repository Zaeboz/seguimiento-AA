package algoritmos_ordenamiento;

import java.util.ArrayList;
import java.util.Collections;

public class A7_BucketSort extends Ordenamiento implements Runnable {

    private int[] array;

    public void bucketSort(int[] arreglo) {
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
        array = arreglo;
    }

    @Override
    public void ordenar(int[] arreglo) {
        bucketSort(arreglo);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}
