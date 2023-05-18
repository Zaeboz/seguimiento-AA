package programacion_dinamica;

public class Punto2 {

    public int iterativo(int n) {
        if (n == 0) {
            return 3;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 1;

        }
        int resultado = 0;
        for (int i = 2; i <= n; i++) {
            resultado = (i - 1) + (i - 2)+ (i - 3);
        }
        return resultado;
    }

    public int recursivo(int n) {

        if (n == 0) {
            return 3;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 1;
        }
        int resultado = (n - 1) + (n - 2) + (n - 3);
        recursivo(n - 1);
        return resultado;
    }

    public int tabulacion(int n) {
        int[] tabla = new int[n + 1];
        tabla[0] = 3;
        tabla[1] = 2;
        tabla[2] = 1;
        for (int i = 2; i <= n; i++) {
            tabla[i] = (i - 1) + (i - 2) + (i - 3);
        }
        return tabla[n];
    }

    public int memorizacion(int n) {
        int[] tabla = new int[n + 1];
        tabla[0] = 3;
        tabla[1] = 2;
        tabla[2] = 1;
        return memorizacionAux(n, tabla);
    }

    private int memorizacionAux(int n, int[] tabla) {
        if (n == 0) {
            return 3;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 1;

        }
        if (tabla[n] == 0) {
            tabla[n] = n - 1 + (n - 2) + (n - 3);
            memorizacionAux(n - 1, tabla);
        }
        return tabla[n];
    }
}
