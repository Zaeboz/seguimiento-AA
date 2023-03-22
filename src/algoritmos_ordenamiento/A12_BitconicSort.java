package algoritmos_ordenamiento;

public class A12_BitconicSort extends Ordenamiento implements Runnable {

    private int[] array;

    public A12_BitconicSort() {
    }

    private void compAndSwap(int[] a, int i, int j, int dir) {
        if ((a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) {
            int aux = a[i];
            a[i] = a[j];
            a[j] = aux;
        }
    }

    private void bitonicMerge(int[] a, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                compAndSwap(a, i, i + k, dir);
            }
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    private void bitonicSort(int[] a, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            bitonicSort(a, low, k, 1);
            bitonicSort(a, low + k, k, 0);
            bitonicMerge(a, low, cnt, dir);
        }
        array = a;
    }

    private void sort(int[] a, int N) {
        bitonicSort(a, 0, N, 1);
    }

    @Override
    public void ordenar(int[] arreglo) {
        sort(arreglo, arreglo.length);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}
