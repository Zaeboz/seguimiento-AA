package algoritmos_ordenamiento;

public class A15_StrandSort extends Ordenamiento implements Runnable{

    private int[] array;

    public A15_StrandSort() {
    }

    private void strandSort(int[] arreglo, int n) {
        if (n == 1) {
            return;
        }
        int mid = n / 2;
        strandSort(arreglo, mid);
        strandSort(arreglo, n - mid);
        merge(arreglo, mid, n);
    }

    private void merge(int[] arreglo, int mid, int n) {
        int i = 0, j = mid, k = 0;
        int[] temp = new int[n];
        while (i < mid && j < n) {
            if (arreglo[i] < arreglo[j]) {
                temp[k++] = arreglo[i++];
            } else {
                temp[k++] = arreglo[j++];
            }
        }
        while (i < mid) {
            temp[k++] = arreglo[i++];
        }
        while (j < n) {
            temp[k++] = arreglo[j++];
        }
        for (i = 0; i < n; i++) {
            arreglo[i] = temp[i];
        }
    }

    @Override
    public void ordenar(int[] arreglo) {
        strandSort(arreglo, arreglo.length);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}
