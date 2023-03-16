public class A2_BurbujaDoble {

    /**
     * El método burbujaDoble() ordena un arreglo de enteros utilizando el
     * algoritmo de ordenamiento burbuja doble. El algoritmo consiste en repetir
     * múltiples veces un proceso de comparación entre elementos adyacentes del
     * arreglo. En cada pasada, los elementos más grandes van "flotando" hacia
     * el final del arreglo, y los elementos más pequeños van "hundiéndose" hacia
     * el inicio.
     * @param arreglo El arreglo a ordenar
     * @return El arreglo ordenado
     */
    public static int[] burbujaDoble(int[] arreglo) {
        int aux, primero = 1, ultimo = arreglo.length - 1, dir = arreglo.length - 1;
        while(ultimo >= primero){
            for(int i = ultimo; i >= primero; i--){
                if(arreglo[i - 1] > arreglo[i]){
                    aux = arreglo[i - 1];
                    arreglo[i - 1] = arreglo[i];
                    arreglo[i] = aux;
                    dir = i;
                }
            }
            primero = dir + 1;
            for(int i = primero; i <= ultimo; i++){
                if(arreglo[i - 1] > arreglo[i]){
                    aux = arreglo[i - 1];
                    arreglo[i - 1] = arreglo[i];
                    arreglo[i] = aux;
                    dir = i;
                }
            }
            ultimo = dir - 1;
        }
        return arreglo;
    }
}
