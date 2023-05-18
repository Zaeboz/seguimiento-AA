package programacion_dinamica;

public class Punto5 {

    public void tabulacion(int[][] tabla){
        for (int n = 0; n < tabla.length; n++) {
            for (int k = 0; k < tabla.length; k++) {
                if (n == k) {
                    tabla[n][k] = 2;
                } else if (n > k && k > 0) {
                    tabla[n][k] = tabla[n][k - 1] + tabla[n - 1][k - 1] + tabla[n - 1][k];
                } else if (k == 0) {
                    tabla[n][k] = 2;
                }
            }
        }
        imprimirTabla(tabla);
    }

    public void iterativo(int[][] tabla) {
        int resultado1 = 0;
        int resultado2 = 0;
        int resultado3 = 0;
        for (int n = 0; n < tabla.length; n++) {
            for (int k = 0; k < tabla.length; k++) {
                if (n == k) {
                    System.out.println(2);
                } else if (n > k && k > 0) {
                    resultado1 =
                    tabla[n][k] = tabla[n][k - 1] + tabla[n - 1][k - 1] + tabla[n - 1][k];
                } else if (k == 0) {
                    System.out.print(2);
                }
                System.out.println();
            }
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
