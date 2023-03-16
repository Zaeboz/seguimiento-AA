import java.io.IOException;
import java.util.concurrent.TransferQueue;

import algoritmos_ordenamiento.*;

public class App {
    public static void main(String[] args) throws IOException {
        int cantidad = 100000;
        int[] numerosConv = Generador.leerArchivo("archivo_"+""+cantidad+"_valores.txt");
        A1_Burbuja burbuja = new A1_Burbuja();
        A2_BurbujaDoble burbujaDoble = new A2_BurbujaDoble();
        Ordenamiento[] algoritmos = {burbuja, burbujaDoble};
        long[] tiempos = ejecutarAlgoritmosEnHilos(numerosConv, algoritmos);

        System.out.println("Tiempo de ejecución:");
        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("Método " + (i+1) + ": " + tiempos[i] + " ms");
        }

    }

    public static long[] ejecutarAlgoritmosEnHilos(int[] arr, Ordenamiento[] algoritmos){
        long[] tiempos = new long[algoritmos.length];
        Thread[] hilos = new Thread[algoritmos.length];
        for (int i = 0; i < algoritmos.length; i++) {
            Ordenamiento algoritmo = algoritmos[i];
            int finalI = i;
            hilos[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    long inicio = System.currentTimeMillis();
                    algoritmo.ordenar(arr);
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
}