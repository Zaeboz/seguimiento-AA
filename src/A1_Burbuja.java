
public class A1_Burbuja {

    /**
     * El método burbuja es un algoritmo de ordenamiento que consiste en repetir
     * múltiples veces un proceso de comparación entre elementos adyacentes del
     * arreglo. En cada pasada, los elementos más grandes van "flotando" hacia
     * el final del arreglo, y los elementos más pequeños van "hundiéndose" hacia
     * el inicio. El proceso termina cuando no se realizan más intercambios, lo
     * que significa que el arreglo está ordenado.
     * @param arreglo El arreglo a ordenar
     * @return El arreglo ordenado
     */
    public static int[] burbuja(int[] arreglo){
        int aux;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
        return arreglo;
    }
}
