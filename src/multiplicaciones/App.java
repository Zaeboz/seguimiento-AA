package multiplicaciones;

import multiplicaciones.algoritmos.Multiplicacion_Americana;

public class App {

    public static void main (String[] args){
        Multiplicacion_Americana m = new Multiplicacion_Americana();
        int arreglo1[] = {9, 9};
        int arreglo2[] = {9, 5};
        int result[] = m.americano(arreglo1, arreglo2);

        imprimirArreglo(result);
    }

    public static void imprimirArreglo(int arreglo[]){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
        }
    }
}
