package programacion_dinamica;

public class App {
    public static void main(String[] args) {
        Punto4 p4 = new Punto4();
        int[][] tabla3 = new int[6][6];
        p4.tabulacion(tabla3);

        Punto5 p5 = new Punto5();
        int[][] tabla4 = new int[6][6];
        p5.tabulacion(tabla4);
    }
}
