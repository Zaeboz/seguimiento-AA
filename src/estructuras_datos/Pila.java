package estructuras_datos;


public class Pila<T> {

    private Nodo<T> cima;

    public Pila() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void push(T e) {
        Nodo<T> n = new Nodo<>(e);
        if (cima != null) {
            n.setSiguienteNodo(cima);
        }
        cima = n;
    }

	public T top() {
		if (cima != null) {
			return cima.getValorNodo();
		}
		return null;
	}

	public T pop() {
		if (cima != null) {
			T e = cima.getValorNodo();
			cima = cima.getSiguienteNodo();
			return e;
		}
		return null;
	}

	public void limpiarPila() {
		cima = null;
	}

}
