package estructuras_datos;

public class ListaDobleCircular<T> {

    private NodoDoble<T> nodoPrimero;
    private NodoDoble<T> nodoUltimo;
    private int tamanio;

    public ListaDobleCircular() {
        nodoPrimero = null;
        nodoUltimo = null;
        tamanio = 0;
    }

    /**
     * Agrega un nuevo nodo en la posici�n dada
     */
    public void insertarPosicion(T valor, int posicion) {
        if (posicion >= 0 && posicion <= tamanio) {
			NodoDoble<T> nuevo = new NodoDoble<>(valor);

			if (posicion == 0) {
				insertarInicio((NodoDoble<T>) nuevo);
			} else if (posicion == tamanio) {
				nodoUltimo.setSiguienteNodo(nuevo);
				nuevo.setAnteriorNodo(nodoUltimo);
				nodoUltimo = nuevo;
				nodoUltimo.setSiguienteNodo(nodoPrimero);
				nodoPrimero.setAnteriorNodo(nodoUltimo);
			} else {
				NodoDoble<T> aux = nodoPrimero;
				for (int i = 0; i < posicion - 1; i++) {
					aux = aux.getSiguienteNodo();
				}
				NodoDoble<T> siguiente = aux.getSiguienteNodo();
				aux.setSiguienteNodo(nuevo);
				nuevo.setAnteriorNodo(aux);
				nuevo.setSiguienteNodo(siguiente);
				siguiente.setAnteriorNodo(nuevo);
			}
			tamanio++;
		}
    }

	private void insertarInicio(NodoDoble<T> nuevo) {
		if (estaVacia()) {
			nodoPrimero = nuevo;
			nodoUltimo = nuevo;
			nodoPrimero.setSiguienteNodo(nuevo);
			nodoPrimero.setAnteriorNodo(nuevo);
		} else {
			nuevo.setSiguienteNodo(nodoPrimero);
			nodoPrimero.setAnteriorNodo(nuevo);
			nodoPrimero = nuevo;
			nodoPrimero.setAnteriorNodo(nodoUltimo);
			nodoUltimo.setSiguienteNodo(nodoPrimero);
		}
	}

	public boolean busar(T valor) {
		NodoDoble<T> aux = nodoPrimero;
		int cont = 0;

		while (aux != null && cont != tamanio) {
			if (aux.getValorNodo().equals(valor)) {
				return true;
			}
			aux = aux.getSiguienteNodo();
			cont++;
		}
		return false;
	}

    public void insertarFinal(T valorNodo) {
		NodoDoble<T> nuevo = new NodoDoble<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nuevo;
			nodoUltimo = nuevo;
			nodoPrimero.setSiguienteNodo(nuevo);
			nodoPrimero.setAnteriorNodo(nuevo);
		} else {
			nodoUltimo.setSiguienteNodo(nuevo);
			nuevo.setAnteriorNodo(nodoUltimo);
			nodoUltimo = nuevo;
			nodoUltimo.setSiguienteNodo(nodoPrimero);
			nodoPrimero.setAnteriorNodo(nodoUltimo);
		}

		tamanio++;
    }

    //Verificar si la lista esta vacia
    public boolean estaVacia() {
        return nodoPrimero == null && nodoUltimo == null;
    }

    /**
     * Imprime en consola la lista enlazada
     */
    public void imprimirLista() {
		if (!estaVacia()) {
			NodoDoble<T> aux = nodoPrimero;
			int cont = 0;
			while (aux != null && cont != tamanio) {
				System.out.print("[" + aux.getValorNodo() + "]--->");
				aux = aux.getSiguienteNodo();
				cont++;
			}
			System.out.println();
		}
    }

	//Metodo para vaciar la lista
	public void vaciarLista() {
		nodoPrimero = null;
		nodoUltimo = null;
		tamanio = 0;
	}

	public int getTamanio() {
		return tamanio;
	}

	//Metodo para insertar al incio de la lista
	public void insertarInicio(T valorNodo) {
		NodoDoble<T> nuevo = new NodoDoble<>(valorNodo);

		insertarInicio((NodoDoble<T>) nuevo);

		tamanio++;
	}

	//Metodo para obtener un nodo en una posicion especifica
	public NodoDoble<T> getNodo(int posicion) {
		NodoDoble<T> aux = nodoPrimero;

		for (int i = 0; i < posicion; i++) {
			aux = aux.getSiguienteNodo();
		}

		return aux;
	}

	//Metodo para obtener la posicion del nodo
	public int getPosicion(T valor) {
		NodoDoble<T> aux = nodoPrimero;
		int cont = 0;

		while (aux != null && cont != tamanio) {
			if (aux.getValorNodo().equals(valor)) {
				return cont;
			}
			aux = aux.getSiguienteNodo();
			cont++;
		}
		return -1;
	}

	//Metodo para eliminar un nodo en una posicion especifica
	public void eliminarPosicion(int posicion) {
		if (posicion >= 0 && posicion < tamanio) {
			if (posicion == 0) {
				nodoPrimero = nodoPrimero.getSiguienteNodo();
				nodoPrimero.setAnteriorNodo(nodoUltimo);
				nodoUltimo.setSiguienteNodo(nodoPrimero);
			} else if (posicion == tamanio - 1) {
				nodoUltimo = nodoUltimo.getAnteriorNodo();
				nodoUltimo.setSiguienteNodo(nodoPrimero);
				nodoPrimero.setAnteriorNodo(nodoUltimo);
			} else {
				NodoDoble<T> aux = nodoPrimero;
				for (int i = 0; i < posicion - 1; i++) {
					aux = aux.getSiguienteNodo();
				}
				NodoDoble<T> siguiente = aux.getSiguienteNodo();
				aux.setSiguienteNodo(siguiente.getSiguienteNodo());
				siguiente.getSiguienteNodo().setAnteriorNodo(aux);
			}
			tamanio--;
		}
	}

	//Metodo para insertar un nodo al final de forma recursiva
	public void insertarFinalRecursivo(T valorNodo) {
		NodoDoble<T> nuevo = new NodoDoble<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nuevo;
			nodoUltimo = nuevo;
			nodoPrimero.setSiguienteNodo(nuevo);
			nodoPrimero.setAnteriorNodo(nuevo);
		} else {
			insertarFinalRecursivo(nodoPrimero, nuevo);
		}

		tamanio++;
	}

	private void insertarFinalRecursivo(NodoDoble<T> nodo, NodoDoble<T> nuevo) {
		if (nodo.getSiguienteNodo() == nodoPrimero) {
			nodo.setSiguienteNodo(nuevo);
			nuevo.setAnteriorNodo(nodo);
			nuevo.setSiguienteNodo(nodoPrimero);
			nodoPrimero.setAnteriorNodo(nuevo);
			nodoUltimo = nuevo;
		} else {
			insertarFinalRecursivo(nodo.getSiguienteNodo(), nuevo);
		}
	}

	//Metodo para insertar un nodo al inicio de forma recursiva
	public void insertarInicioRecursivo(T valorNodo) {
		NodoDoble<T> nuevo = new NodoDoble<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nuevo;
			nodoUltimo = nuevo;
			nodoPrimero.setSiguienteNodo(nuevo);
			nodoPrimero.setAnteriorNodo(nuevo);
		} else {
			insertarInicioRecursivo(nodoPrimero, nuevo);
		}

		tamanio++;
	}

	private void insertarInicioRecursivo(NodoDoble<T> nodo, NodoDoble<T> nuevo) {
		if (nodo.getAnteriorNodo() == nodoUltimo) {
			nodo.setAnteriorNodo(nuevo);
			nuevo.setSiguienteNodo(nodo);
			nuevo.setAnteriorNodo(nodoUltimo);
			nodoUltimo.setSiguienteNodo(nuevo);
			nodoPrimero = nuevo;
		} else {
			insertarInicioRecursivo(nodo.getAnteriorNodo(), nuevo);
		}
	}

	//Metodo para insertar un nodo en una posicion en especifico de forma recursiva
	public void insertarPosicionRecursivo(T valorNodo, int posicion) {
		NodoDoble<T> nuevo = new NodoDoble<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nuevo;
			nodoUltimo = nuevo;
			nodoPrimero.setSiguienteNodo(nuevo);
			nodoPrimero.setAnteriorNodo(nuevo);
		} else {
			insertarPosicionRecursivo(nodoPrimero, nuevo, posicion);
		}

		tamanio++;
	}

	private void insertarPosicionRecursivo(NodoDoble<T> nodo, NodoDoble<T> nuevo, int posicion) {
		if (posicion == 0) {
			nodo.setAnteriorNodo(nuevo);
			nuevo.setSiguienteNodo(nodo);
			nuevo.setAnteriorNodo(nodoUltimo);
			nodoUltimo.setSiguienteNodo(nuevo);
			nodoPrimero = nuevo;
		} else if (posicion == tamanio - 1) {
			nodo.setSiguienteNodo(nuevo);
			nuevo.setAnteriorNodo(nodo);
			nuevo.setSiguienteNodo(nodoPrimero);
			nodoPrimero.setAnteriorNodo(nuevo);
			nodoUltimo = nuevo;
		} else {
			insertarPosicionRecursivo(nodo.getSiguienteNodo(), nuevo, posicion - 1);
		}
	}

	//Metodo para buscar un nodo de forma recursiva
	public boolean buscarRecursivo(T valor) {
		if (estaVacia()) {
			return false;
		} else {
			return buscarRecursivo(nodoPrimero, valor);
		}
	}

	private boolean buscarRecursivo(NodoDoble<T> nodo, T valor) {
		if (nodo.getValorNodo().equals(valor)) {
			return true;
		} else if (nodo.getSiguienteNodo() == nodoPrimero) {
			return false;
		} else {
			return buscarRecursivo(nodo.getSiguienteNodo(), valor);
		}
	}

}
