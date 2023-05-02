package actividades_clase;

public class App {

    public static void main (String[] args){
        CodigoBarras codigo = new CodigoBarras();
        String numeros = "90028819512";

        System.out.println(codigo.verificacionCodigo(numeros));
        System.out.println(codigo.verificacionCodigoRecursivo(numeros,1,0,0,(numeros.charAt(0) - '0')));
    }
}
