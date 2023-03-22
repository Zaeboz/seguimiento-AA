package algoritmos_ordenamiento;

public class A8_MergeSort extends Ordenamiento implements Runnable {

    private int[] array;

    //constructor
    public A8_MergeSort(){
    }


    public int[] mergeSort(int[] arreglo) {
        int n = arreglo.length;
        if (n < 2) {
            array = arreglo;
            return array;
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
        array = merge(left, right);
        return array;
    }

    private int[] merge(int[] left, int[] right) {
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

    @Override
    public void ordenar(int[] arreglo) {
        mergeSort(arreglo);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}