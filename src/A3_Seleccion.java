public class A3_Seleccion {

    /**
     * El metodo seleccion ordena un arreglo de enteros utilizando el algoritmo
     * de ordenamiento seleccion. El algoritmo consiste en repetir múltiples
     * veces un proceso de comparación entre elementos adyacentes del arreglo.
     * @param arreglo El arreglo a ordenar
     * @return El arreglo ordenado
     */
    public static int[] seleccion(int[] arreglo) {
        int aux, menor;
        for (int i = 0; i < arreglo.length; i++) {
            menor = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[menor]) {
                    menor = j;
                }
            }
            aux = arreglo[i];
            arreglo[i] = arreglo[menor];
            arreglo[menor] = aux;
        }
        return arreglo;
    }
}
