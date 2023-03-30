package algoritmos_ordenamiento.algoritmos;

import algoritmos_ordenamiento.Ordenamiento;

public class A5_RecursiveInsertionSort extends Ordenamiento implements Runnable {

    private int[] array;

    public A5_RecursiveInsertionSort() {
    }

    //El método no funciona porque se desborda por la cantidad de llamadas recursivas
    public void recursiveInsertionSort(int[] arreglo, int n) {
        if (n <= 1) {
            array = arreglo;
            return;
        }
        recursiveInsertionSort(arreglo, n - 1);
        int llave = arreglo[n - 1];
        int j = n - 2;
        while (j >= 0 && arreglo[j] > llave) {
            arreglo[j + 1] = arreglo[j];
            j--;
        }
        arreglo[j + 1] = llave;
        array = arreglo;
    }

    @Override
    public void ordenar(int[] arreglo) {
        recursiveInsertionSort(arreglo, arreglo.length);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}
