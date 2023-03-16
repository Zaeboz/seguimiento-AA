public class A6_ShellSort {

    public static int[] shellSort(int[] arreglo) {
        for(int incr = arreglo.length / 2; incr > 0; incr /= 2) {
            for(int i = incr; i < arreglo.length; i++) {
                int j = i - incr;
                while(j >= 0)
                {
                    if(arreglo[j] > arreglo[j + incr]) {
                        int temp = arreglo[j];
                        arreglo[j] = arreglo[j + incr];
                        arreglo[j + incr] = temp;
                        j -= incr;
                    } else {
                        j = -1;
                    }
                }
            }
        }
        return arreglo;
    }
}
