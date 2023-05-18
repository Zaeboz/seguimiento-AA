package programacion_dinamica;

public class Punto3 {

    public void tabulacion(int[][] tabla) {
        for (int n = 0; n < tabla.length; n++) {
            for (int k = 0; k < tabla.length; k++) {
                if (n == k || k == 0) {
                    tabla[n][k] = 3;
                } else if (n > k) {
                    tabla[n][k] = tabla[n][k - 1] + tabla[n - 1][k] + 2;
                }
            }
        }
        imprimirTabla(tabla);
    }

    public void recursivo(int[][] tabla, int n, int k) {
        if (n < tabla.length && k < tabla.length) {
            if (n == k || k == 0) {
                tabla[n][k] = 3;
                recursivo(tabla, n, k + 1);
            } else if (n > k) {
                tabla[n][k] = tabla[n][k - 1] + tabla[n - 1][k] + 2;
                recursivo(tabla, n, k + 1);
            } else {
                recursivo(tabla, n + 1, 0);
            }
        } else {
            imprimirTabla(tabla);
        }
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
