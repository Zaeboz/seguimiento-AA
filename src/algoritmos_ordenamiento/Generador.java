package algoritmos_ordenamiento;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Generador {


    public static String generarArreglo(int numero)
    {

        String numerosEnCadena= "";

        int[] arr = new int[numero]; 
        Random random = new Random(); // crear un objeto Random para generar números aleatorios

        // Llenar el arreglo con valores aleatorios
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(900) + 100; // generar un número entero aleatorio de 3 dígitos
        }

        numerosEnCadena= Arrays.toString(arr);

        return numerosEnCadena;
    }

    public static void escribirArchivo(String cadenaAEscribir,String nombre)
    {
        try {
            FileOutputStream archivo = new FileOutputStream("C:\\Users\\jegs2\\OneDrive\\Escritorio\\Trabajo en clase\\seguimiento\\src\\arreglos\\archivo_"+nombre+"_valores.txt");
            byte[] contenidoEnBytes = cadenaAEscribir.getBytes();
            archivo.write(contenidoEnBytes);
            archivo.close();
            System.out.println("Se escribió en el archivo exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    public static int[] leerArchivo(String nombreArchivo) {
        int[] numerosConv = new int[0];
        try {
            // Abrir el archivo
            File archivo = new File("C:\\Users\\jegs2\\OneDrive\\Escritorio\\Trabajo en clase\\seguimiento\\src\\arreglos\\"+nombreArchivo);
            Scanner scanner = new Scanner(archivo);

            // Leer el archivo línea por línea
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();

                // Analizar la línea y obtener los números
                String[] numeros = linea.replaceAll("[^\\d\\s]+", "").trim().split("\\s+");

                //Arrays.stream(numeros).forEach(num -> System.out.print(num + " "));

                // Imprimir los números encontrados
                numerosConv = Arrays.stream(numeros).mapToInt(Integer::parseInt).toArray();

            }

            // Cerrar el scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

        return numerosConv;
    }
}
