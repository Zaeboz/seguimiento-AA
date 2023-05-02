package actividades_clase;

public class Funciones {

    public static int factorialDinamico(int n, int[] arreglo){
        if(n == 0){
            return 1;
        }
        if(arreglo[n] != 0){
            return arreglo[n];
        }
        arreglo[n] = n * factorialDinamico(n-1, arreglo);
        return arreglo[n];
    }

    public static int factorialDinamicoV2(int n, int[] arreglo){
        if(n == 0){
            arreglo[0] = 1;
        } else {
            arreglo[n] = n * factorialDinamico(n-1, arreglo);
        }
        return arreglo[n];
    }

    public static int fibonacciRecursivo(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        } else {
            return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
        }
    }

    public static int fibonacciDinamico(int n, int[] arreglo){
        if(n == 0){
            arreglo[0] = 0;
        } else if(n == 1){
            arreglo[1] = 1;
        } else {
            arreglo[n] = fibonacciDinamico(n-1, arreglo) + fibonacciDinamico(n-2, arreglo);
        }
        return arreglo[n];
    }

    public static int [][] trianguloPascal(int n){
        int [][] triangulo = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    triangulo[i][j] = 1;
                } else {
                    triangulo[i][j] = triangulo[i-1][j-1] + triangulo[i-1][j];
                }
            }
        }
        return triangulo;
    }

    public static int trianguloPascalRecursivo(int n, int k){
        if(k == 0 || k == n){
            return 1;
        } else {
            return trianguloPascalRecursivo(n-1, k-1) + trianguloPascalRecursivo(n-1, k);
        }
    }

    public static int[][] trianguloPascalDinamico(int n, int k, int [][] triangulo){
        if(k == 0 || k == n) {
            triangulo[n][k] = 1;
            return triangulo;
        } else {
            if(triangulo[n-1][k-1] == 0){
                trianguloPascalDinamico(n-1, k-1, triangulo);
            }
            if(triangulo[n-1][k] == 0){
                trianguloPascalDinamico(n-1, k, triangulo);
            }
            triangulo[n][k] = triangulo[n-1][k-1] + triangulo[n-1][k];
            return triangulo;
        }

    }

    public static void imprimirTrianguloPascal(int [][] triangulo){
        for(int i = 0; i < triangulo.length; i++){
            for(int j = 0; j < triangulo.length - i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++){
                System.out.print(triangulo[i][j] + " ");
            }
            System.out.println();
        }
    }
}
