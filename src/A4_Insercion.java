public class A4_Insercion {

    /**
     * Este método ordena un arreglo de enteros mediante el método de inserción.
     * El método consiste en recorrer el arreglo desde el segundo elemento hasta
     * el último, y a cada elemento se le compara con los anteriores, si es menor
     * se intercambia de lugar con el anterior, y se compara con el anterior a
     * este, hasta que se encuentre un elemento menor o se llegue al inicio del
     * arreglo.
     * @param arreglo El arreglo a ordenar
     * @return El arreglo ordenado
     */
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
}
