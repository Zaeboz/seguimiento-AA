package parcial_1;

public class App {

    public static void main (String[] args){
        int x = 8, y = 5;
        System.out.println("La multiplicacion de" + x + "*" + y + "es: " + multiplicar(x, y));
    }

    public static int multiplicar(int x, int y){
        if(x == 0 || y == 0){
            return 0;
        }
        int z = multiplicar(x, y/2);
        if(y % 2 == 0){
            return 2 * z;
        }else{
            return x + 2 * z;
        }
    }
}
