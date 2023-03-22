package algoritmos_ordenamiento;

public class A16_RadixSort extends Ordenamiento implements Runnable {

    private int[] array;

    public A16_RadixSort(){
    }

    private void sort (int[] a, int numeroDigitos){
        A16_ColaEnlazada[] cola = new A16_ColaEnlazada[10];
        for (int i = 0; i < 10; i++) {
            cola[i] = new A16_ColaEnlazada();
        }
        for (int i = 0; i < numeroDigitos; i++) {
            for (int j = 0; j < a.length; j++) {
                cola[obtenerRadix(a[j], i)].encolar(a[j]);
            }
            int k = 0;
            for (int j = 0; j < 10; j++) {
                while (!cola[j].estaVacia()) {
                    a[k++] = cola[j].desencolar();
                }
            }
        }
    }

    private int obtenerRadix(int numero, int radical) {
        return (int) (numero / Math.pow(10, radical)) % 10;
    }

    private void sort(int[] a){
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        Integer maximo = max;
        String cadena = String.valueOf(maximo);
        int numeroDigitos = cadena.length();
        sort(a, numeroDigitos);
    }


    @Override
    public void run() {
        ordenar(array);
    }

    @Override
    public void ordenar(int[] arreglo) {
        sort(arreglo);
    }

}
