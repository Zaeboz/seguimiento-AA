package programacion_dinamica;

public class Punto4 {

    public void tabulacion(int[][] tabla) {
        for (int n = 0; n < tabla.length; n++) {
            for (int k = 0; k < tabla.length; k++) {
                if (n == k) {
                    tabla[n][k] = (int) Math.pow(n, k);
                } else if (n > k && k > 0) {
                    tabla[n][k] = tabla[n - 1][k] * 3 + tabla[n - 1][k - 1] * 2;
                } else if (k == 0) {
                    tabla[n][k] = 1;
                }
            }
        }
        imprimirTabla(tabla);
    }

    private void imprimirTabla(int[][] tabla) {
        for (int[] ints : tabla) {
            for (int k = 0; k < tabla.length; k++) {
                System.out.print(ints[k] + " ");
            }
            System.out.println();
        }
    }
}
