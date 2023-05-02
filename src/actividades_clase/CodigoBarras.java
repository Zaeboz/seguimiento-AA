package actividades_clase;

public class CodigoBarras {

    public boolean verificacionCodigo(String codigo){
        int suma = 0;
        int primerDigito = Integer.parseInt(codigo.substring(0, 1));
        String S1 = codigo.substring(1, 6);
        String S2 = codigo.substring(6, 11);
        int suma2 = 0;


        for(int i = 0, h = 0; i < S1.length() && h < S1.length(); ){
            int numero1 = (S1.charAt(i) - '0');
            int numero2 = (S2.charAt(h) - '0');

            if(numero1 % 2 == 0){
                suma += (S1.charAt(i) - '0') * 5;
            } else {
                suma += (codigo.charAt(h) - '0') * 3;
            }
            i++;

            if(numero2 % 2 == 0){
                suma2 += (S2.charAt(h) - '0') * 5;
            } else {
                suma2 += (S2.charAt(h) - '0') * 3;
            }
            h++;
        }
        boolean isPrimo = isPrimoRecursivo(suma2+primerDigito, 2);

        return suma > suma2 && isPrimo;
    }

    boolean isPrimoRecursivo(int n, int i){
        if(n <= 2){
            return (n == 2) ? true : false;
        }
        if(n % i == 0){
            return false;
        }
        if(i * i > n){
            return true;
        }
        return isPrimoRecursivo(n, i + 1);
    }

    public boolean verificacionCodigoRecursivo(String codigo, int i, int suma, int suma2, int primerDigito){
        if(i == codigo.length()){
            return suma > suma2 && isPrimoRecursivo(suma2+primerDigito, 2);
        }
        int numero = (codigo.charAt(i) - '0');
        if (i < (codigo.length() / 2)+1) {
            if(numero % 2 == 0){
                suma += numero * 5;
            } else {
                suma += numero * 3;
            }
        } else{
            if(numero % 2 == 0){
                suma2 += numero * 5;
            } else {
                suma2 += numero * 3;
            }
        }
        return verificacionCodigoRecursivo(codigo, i+1, suma, suma2, primerDigito);
    }
}


