package algoritmos_ordenamiento.algoritmos;

import algoritmos_ordenamiento.Ordenamiento;

public class A9_QuickSort extends Ordenamiento implements Runnable {

    private int[] array;

    public A9_QuickSort() {
    }

    public int particion(int[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto];
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temp;
        return i + 1;
    }

    public void quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto) {
            int pi = particion(arreglo, bajo, alto);
            quickSort(arreglo, bajo, pi - 1);
            quickSort(arreglo, pi + 1, alto);
        }
        array = arreglo;
    }

    @Override
    public void ordenar(int[] arreglo) {
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}
