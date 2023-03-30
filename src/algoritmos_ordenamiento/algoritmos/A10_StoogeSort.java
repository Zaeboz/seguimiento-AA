package algoritmos_ordenamiento.algoritmos;

import algoritmos_ordenamiento.Ordenamiento;

public class A10_StoogeSort extends Ordenamiento implements Runnable {

    private int[] array;

    public A10_StoogeSort(){
    }

    public void stoogeSort(int[] arreglo, int bajo, int alto) {
        if (arreglo[alto] < arreglo[bajo]) {
            int temp = arreglo[bajo];
            arreglo[bajo] = arreglo[alto];
            arreglo[alto] = temp;
        }
        if (alto - bajo + 1 > 2) {
            int t = (alto - bajo + 1) / 3;
            stoogeSort(arreglo, bajo, alto - t);
            stoogeSort(arreglo, bajo + t, alto);
            stoogeSort(arreglo, bajo, alto - t);
        }
        array = arreglo;
    }

    @Override
    public void ordenar(int[] arreglo) {
        stoogeSort(arreglo, 0, arreglo.length - 1);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}
