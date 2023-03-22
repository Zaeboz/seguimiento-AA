package algoritmos_ordenamiento;

public class A11_HeapSort extends Ordenamiento implements Runnable {

    private static int[] array;

    public A11_HeapSort() {
    }

    public static void heapSort(int[] arreglo) {
        int n = arreglo.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arreglo, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arreglo[0];
            arreglo[0] = arreglo[i];
            arreglo[i] = temp;
            heapify(arreglo, i, 0);
        }
        array = arreglo;
    }

    private static void heapify(int[] arreglo, int n, int i) {
        int mayor = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;
        if (izq < n && arreglo[izq] > arreglo[mayor]) {
            mayor = izq;
        }
        if (der < n && arreglo[der] > arreglo[mayor]) {
            mayor = der;
        }
        if (mayor != i) {
            int swap = arreglo[i];
            arreglo[i] = arreglo[mayor];
            arreglo[mayor] = swap;
            heapify(arreglo, n, mayor);
        }
    }

    @Override
    public void ordenar(int[] arreglo) {
        heapSort(arreglo);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}
