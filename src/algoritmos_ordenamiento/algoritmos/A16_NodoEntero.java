package algoritmos_ordenamiento.algoritmos;

public class A16_NodoEntero {

    public A16_NodoEntero(int a){
        valor = a;
        siguiente = null;
    }

    public A16_NodoEntero(){
        valor = 0;
        siguiente = null;
    }

    public int valor;
    public A16_NodoEntero siguiente;
    public A16_NodoEntero siguiente() {
        return siguiente;
    }

    public int valor() {
        return valor;
    }
    
}
