package estructuras_datos;

public class Cola<T> {
    private final ListaSimple<T> cola;
    private int capacidad;
    private int cantidadIngresos;

    public Cola() {
        cola = new ListaSimple<>();
        cantidadIngresos = 0;
    }

    public T dequeue() {
        T dato = null;
        if (!colaVacia()) {
            dato = peek();
            cola.eliminarPrimero();
            cantidadIngresos--;
        } else {
            System.out.println("La cola esta vacia");
        }
        return dato;
    }

    public void queue(T elemento) {
        if (cantidadIngresos < capacidad) {
            cola.agregarfinal(elemento);
            cantidadIngresos++;
        } else {
            System.out.println("La cola esta llena");
        }
    }

    public Nodo<T> top() {
        return cola.getNodoPrimero();
    }

    public T peek() {
        cola.getNodoPrimero();
        return cola.obtenerValorNodo(cola.getTamanio());
    }

    public void agregar(T elemento, String nombre) {
        if (cantidadIngresos < capacidad) {

            cola.agregarfinal(elemento);
            cantidadIngresos++;
        } else {
            System.out.println("La cola esta llena");
        }
    }

    public void poll() {
        T dato = peek();
        cola.eliminarPrimero();
    }

    public boolean colaVacia() {
        return cola.getTamanio() == 0;
    }

    public boolean compararColas(Cola<T> cola1, Cola<T> cola2) {
        boolean centi = false;

        if (cola1.getCapacidad() == cola2.getCapacidad()) {
            for (int i = 0; i <= cola1.getCapacidad() - 1; i++) {
                centi = cola1.peek() == cola2.peek();

                cola1.poll();
                cola2.poll();
            }
        }
        return centi;
    }

    public int obtenerLongitud() {
        return cola.getTamanio();
    }

    public void eliminar() {
        cola.eliminarPrimero();
    }

    public String toString() {
        return cola.toString();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}