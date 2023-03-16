public class A5_RecursiveInsertionSort {

    /**
     * Este método ordena un arreglo de enteros usando el algoritmo de
     * ordenamiento por inserción recursivo. El método consiste en recorrer el
     * arreglo desde el ultimo elemento hasta el segundo, y a cada elemento se le
     * compara con los anteriores, si es menor se intercambia de lugar con el
     * anterior,
     * @param arreglo
     * @param n
     * @return
     */
    public static int[] recursiveInsertionSort(int[] arreglo, int n) {
        if (n <= 1) {
            return arreglo;
        }
        recursiveInsertionSort(arreglo, n - 1);
        int llave = arreglo[n - 1];
        int j = n - 2;
        while (j >= 0 && arreglo[j] > llave) {
            arreglo[j + 1] = arreglo[j];
            j--;
        }
        arreglo[j + 1] = llave;
        return arreglo;
    }
}
