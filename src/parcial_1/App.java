package parcial_1;

public class App {

    public static void main (String[] args){
        String[][] palabras = {{"sien", "encima", "mapa"}, {"pata", "tapa", "papa"}, {"pato", "toma", "mama"}};
        System.out.println(isEncadenado(palabras, 0, 0));


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

    public static boolean isEncadenado(String[][] palabras, int i, int j){
        if( (i == palabras.length - 1) && (j == palabras[0].length - 1) ){
          return true;
        }
        if(j == palabras[0].length - 1){
          if(compararSilabas(palabras[i][j], palabras[i+1][0])){
            return isEncadenado(palabras, i+1, 0);
          } else {
            return false;
          }
        }
        if(compararSilabas(palabras[i][j], palabras[i][j+1])){
          return isEncadenado(palabras, i, j+1);
        } else {
          return false;
        }
      }
      
      public static boolean compararSilabas(String p1, String p2){
        String ultimasLetras;
        ultimasLetras = p1.substring(p1.length() - 2);
        String primerasLetras = p2.substring(0, 2);
        return ultimasLetras.equals(primerasLetras);
      }
      
}
