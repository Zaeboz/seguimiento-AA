import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        int[] numerosConv= new int[0];
        int cantidad = 200000;
        numerosConv = Generador.leerArchivo("archivo_"+""+cantidad+"_valores.txt");
        
        /*long startTime = System.currentTimeMillis();
        Algoritmos.burbuja(numerosConv);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        double minutes = (double) duration / 60000;
        System.out.println("La duracion fue de " + duration + " milisegungos /" + minutes + " minutos");
         */
    }   
}