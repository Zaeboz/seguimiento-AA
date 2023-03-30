package algoritmos_ordenamiento.algoritmos;

import algoritmos_ordenamiento.Ordenamiento;

public class A14_BinaryInsertionSort extends Ordenamiento implements Runnable {

    private int[] array;

    private void binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int clave = arr[i];
            int pos = binarySearch(arr, 0, i - 1, clave);

            for (int j = i - 1; j >= pos; j--) {
                arr[j + 1] = arr[j];
            }
            arr[pos] = clave;
        }
    }

    int binarySearch(int[] arr, int inicio, int fin, int valor) {

        if (inicio > fin || valor > arr[fin]) {
            return fin + 1;
        }

        if (valor <= arr[inicio]) {
            return inicio;
        }

        int medio = (inicio + fin) / 2;

        if (valor == arr[medio]) {
            return medio + 1;
        }

        if (valor < arr[medio]) {
            return binarySearch(arr, inicio, medio - 1, valor);
        }

        return binarySearch(arr, medio + 1, fin, valor);
    }

    @Override
    public void ordenar(int[] arreglo) {
        binaryInsertionSort(arreglo);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}
