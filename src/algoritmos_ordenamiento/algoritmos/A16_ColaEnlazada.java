package algoritmos_ordenamiento.algoritmos;

public class A16_ColaEnlazada {
    private A16_NodoEntero inicio;
    private A16_NodoEntero fin;
    private int tamano;

    public A16_ColaEnlazada() {
        inicio = null;
        fin = null;
        tamano = 0;
    }

    public void encolar(int num) {
        A16_NodoEntero temp = new A16_NodoEntero(num);
        if (inicio == null) {
            inicio = temp;
            fin = temp;
        } else {
            fin.siguiente = temp;
            fin = temp;
        }
        tamano++;
    }

    public int desencolar() {
        A16_NodoEntero temp = inicio;
        inicio = inicio.siguiente;
        tamano--;
        return temp.valor;
    }

    public boolean estaVacia() {
        return (tamano == 0);
    }
    
}
