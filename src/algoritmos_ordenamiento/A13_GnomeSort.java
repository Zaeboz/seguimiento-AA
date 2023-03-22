package algoritmos_ordenamiento;

public class A13_GnomeSort extends Ordenamiento implements Runnable{

    private int[] array;

    public A13_GnomeSort() {
    }

    private void gnomeSort(int[] arreglo){
        int n = arreglo.length;
        int index = 0;
        while (index < n) {
            if (index == 0)
                index++;
            if (arreglo[index] >= arreglo[index - 1])
                index++;
            else {
                int temp = 0;
                temp = arreglo[index];
                arreglo[index] = arreglo[index - 1];
                arreglo[index - 1] = temp;
                index--;
            }
        }
        array = arreglo;
    }

    @Override
    public void ordenar(int[] arreglo) {
        gnomeSort(arreglo);
    }

    @Override
    public void run() {
        ordenar(array);
    }
}
