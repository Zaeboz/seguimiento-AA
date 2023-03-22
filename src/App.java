import java.io.IOException;

import algoritmos_ordenamiento.*;

public class App {
    public static void main(String[] args) throws IOException {
        int cantidad = 90000;
        App app = new App();
        int[] numerosConv = Generador.leerArchivo("archivo_"+""+cantidad+"_valores.txt");
        A1_Burbuja burbuja = new A1_Burbuja();
        A2_BurbujaDoble burbujaDoble = new A2_BurbujaDoble();
        A3_Seleccion seleccion = new A3_Seleccion();
        A4_Insercion insercion = new A4_Insercion();
        /*Devido a que se esta haciendo uso de hilos, el algoritmo de inserción recursiva no funciona correctamente
        por eso se debe de ejecutar de forma normal*/
        A5_RecursiveInsertionSort recursiveInsertionSort = new A5_RecursiveInsertionSort();
        A6_ShellSort shellSort = new A6_ShellSort();
        A7_BucketSort bucketSort = new A7_BucketSort();
        A8_MergeSort mergeSort = new A8_MergeSort();
        A9_QuickSort quickSort = new A9_QuickSort();
        /*Para verificar que el algoritmo de stooge sort funciona correctamente,
        se debe de utilizar un arrelgo de tamaño 10000 o menor*/
        A10_StoogeSort stoogeSort = new A10_StoogeSort();
        A11_HeapSort heapSort = new A11_HeapSort();
        A12_BitconicSort bitconicSort = new A12_BitconicSort();
        A13_GnomeSort gnomeSort = new A13_GnomeSort();
        A14_BinaryInsertionSort binaryInsertionSort = new A14_BinaryInsertionSort();
        A15_StrandSort strandSort = new A15_StrandSort();
        A16_RadixSort radixSort = new A16_RadixSort();

        Ordenamiento[] algoritmos = {burbuja, burbujaDoble, seleccion, insercion, gnomeSort, binaryInsertionSort, shellSort, bucketSort, mergeSort, quickSort, heapSort, bitconicSort, strandSort, radixSort};

        long[] tiempos = app.ejecutarAlgoritmosEnHilos(numerosConv, algoritmos);

        imprimirArreglo(algoritmos.length, tiempos);
    }

    public long[] ejecutarAlgoritmosEnHilos(int[] arr, Ordenamiento[] algoritmos){
        long[] tiempos = new long[algoritmos.length];
        Thread[] hilos = new Thread[algoritmos.length];
        for (int i = 0; i < algoritmos.length; i++) {
            int[] array = arr.clone();
            Ordenamiento algoritmo = algoritmos[i];
            int finalI = i;
            hilos[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    long inicio = System.currentTimeMillis();
                    algoritmo.ordenar(array);
                    long fin = System.currentTimeMillis();
                    tiempos[finalI] = fin - inicio;
                }
            });
            hilos[i].start();
        }
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tiempos;
    }

    public static void imprimirArreglo(int size, long[] tiempos){
        for (int i = 0; i < size; i++) {
            System.out.println("Método " + (i+1) + ": " + tiempos[i] + " ms");
        }
        System.out.println();
    }
}