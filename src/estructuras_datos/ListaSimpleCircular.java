package estructuras_datos;

import java.util.Iterator;


/**
 * Definici�n de la clase lista Simple de tipo Generics
 *
 * @param <T>
 **/

public class ListaSimpleCircular<T> implements Iterable<T> {

    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private int tamanio;


    public ListaSimpleCircular() {
        nodoPrimero = null;
        nodoPrimero = null;
        tamanio = 0;
    }

    //Agregar al inicio de la lista
    public void agregarInicio(T valorNodo) {

        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nuevoNodo;
        } else {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }
        tamanio++;
    }


    //Agregar al final de la lista
    public void agregarFinal(T valorNodo) {

        Nodo<T> nodo = new Nodo<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nodo;
        } else {
            nodoUltimo.setSiguienteNodo(nodo);
            nodoUltimo = nodo;
        }

        tamanio++;
    }

    //Obtener Nodo el valor de un Nodo
    public T obtenerValorNodo(int indice) {

        Nodo<T> nodoTemporal = null;
        int contador = 0;

        if (indiceValido(indice)) {
            nodoTemporal = nodoPrimero;

            while (contador < indice) {

                nodoTemporal = nodoTemporal.getSiguienteNodo();
                contador++;
            }
        }

        if (nodoTemporal != null)
            return nodoTemporal.getValorNodo();
        else
            return null;
    }


    //Verificar si indice es valido
    private boolean indiceValido(int indice) {
        if (indice >= 0 && indice < tamanio) {
            return true;
        }
        throw new RuntimeException("�ndice no v�lido");
    }


    //Verificar si la lista esta vacia
    public boolean estaVacia() {
        return nodoPrimero == null;
    }


    /**
     * Imprime en consola la lista enlazada
     */
    public void imprimirLista() {

        Nodo<T> aux = nodoPrimero;

        while (aux != null) {
            System.out.print(aux.getValorNodo() + "\t");
            aux = aux.getSiguienteNodo();
        }

        System.out.println();
    }

    //Metodo para eliminar todos los nodos de una lista circular
    public void eliminarLista() {
        nodoPrimero = null;
        nodoUltimo = null;
        tamanio = 0;
    }

    //Eliminar dado el valor de un nodo
    public T eliminar(T dato) {
        Nodo<T> nodo = nodoPrimero;
        Nodo<T> previo = null;
        Nodo<T> siguiente = null;
        boolean encontrado = false;

        //buscar el nodo previo
        while (nodo != null) {
            if (nodo.getValorNodo() == dato) {
                encontrado = true;
                break;
            }
            previo = nodo;
            nodo = nodo.getSiguienteNodo();
        }

        if (encontrado) {
            siguiente = nodo.getSiguienteNodo();
            if (previo == null) {
                nodoPrimero = siguiente;
            } else {
                previo.setSiguienteNodo(siguiente);
            }

            if (siguiente == null) {
//				nodoUltimo = previo;
            } else {
                nodo.setSiguienteNodo(null);
            }

            nodo = null;
            tamanio--;
            return dato;
        }
        throw new RuntimeException("El elemento no existe");
    }


    //Elimina el primer nodo de la lista
    public T eliminarPrimero() {

        if (!estaVacia()) {
            Nodo<T> n = nodoPrimero;
            T valor = n.getValorNodo();
            nodoPrimero = n.getSiguienteNodo();

            tamanio--;
            return valor;
        }

        throw new RuntimeException("Lista vac�a");
    }


    public T eliminarUltimo() {

        if (!estaVacia()) {
            T valor = nodoUltimo.getValorNodo();
            Nodo<T> prev = obtenerNodo(tamanio - 2);
            nodoUltimo = prev;

            if (nodoUltimo == null) {
                nodoPrimero = null;
            } else {
                prev.setSiguienteNodo(null);
            }

            tamanio--;
            return valor;
        }

        throw new RuntimeException("Lista vac�a");
    }

    private Nodo<T> obtenerNodo(int indice) {

        if (indice >= 0 && indice < tamanio) {

            Nodo<T> nodo = nodoPrimero;

            for (int i = 0; i < indice; i++) {
                nodo = nodo.getSiguienteNodo();
            }

            return nodo;
        }

        return null;
    }


    /**
     * Cambia el valor de un nodo dada su posici�n en la lista
     *
     * @param indice posici�n donde se va a cambiar el dato
     * @param nuevo  nuevo valor por el que se actualizar� el nodo
     */
    public void modificarNodo(int indice, T nuevo) {

        if (indiceValido(indice)) {
            Nodo<T> nodo = obtenerNodo(indice);
            assert nodo != null;
            nodo.setValorNodo(nuevo);
        }

    }


    /**
     * Retorna la primera posici�n donde est� guardado el dato
     *
     * @param dato valor a buscar dentro de la lista
     * @return primera posici�n del dato
     */
    public int obtenerPosicionNodo(T dato) {

        Nodo<T> nodo = nodoPrimero;
        int posicion = 0;

        while (nodo != null) {

            if (nodo.getValorNodo() == dato) {
                return posicion;
            }

            nodo = nodo.getSiguienteNodo();
            posicion++;
        }

        return -1;
    }


    @Override
    public Iterator<T> iterator() {

        return new IteradorListaSimple(nodoPrimero);
    }

    protected class IteradorListaSimple implements Iterator<T> {

        private Nodo<T> nodo;
        private int posicion;

        /**
         * Constructor de la clase Iterador
         */
        public IteradorListaSimple(Nodo<T> nodo) {
            this.nodo = nodo;
            this.posicion = 0;
        }

        @Override
        public boolean hasNext() {
            return nodo != null;
        }

        @Override
        public T next() {
            T valor = nodo.getValorNodo();
            nodo = nodo.getSiguienteNodo();
            posicion++;
            return valor;
        }

        /**
         * Posici�n actual de la lista
         *
         * @return posici�n
         */
        public int getPosicion() {
            return posicion;
        }

    }


    //Metodos get y set de la clase ListaSimple


    public Nodo<T> getNodoPrimero() {
        return nodoPrimero;
    }


    public void setNodoPrimero(Nodo<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }


    public int getTamanio() {
        return tamanio;
    }


    public void setTamanio(int tamano) {
        this.tamanio = tamano;
    }

    //Metodo para insertar un nodo en una posicion especifica
    public void insertarNodo(T dato, int posicion) {
        Nodo<T> nuevo = new Nodo<T>(dato);
        if (posicion == 0) {
            nuevo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevo;
        } else {
            Nodo<T> aux = nodoPrimero;
            for (int i = 0; i < posicion - 1; i++) {
                aux = aux.getSiguienteNodo();
            }
            nuevo.setSiguienteNodo(aux.getSiguienteNodo());
            aux.setSiguienteNodo(nuevo);
        }
        tamanio++;
    }

    //Metodo para buscar un nodo
    public Nodo<T> buscarNodo(T dato) {
        Nodo<T> aux = nodoPrimero;
        while (aux != null && aux.getValorNodo() != dato) {
            aux = aux.getSiguienteNodo();
        }
        return aux;
    }

    //Metodo para eliminar un nodo en una posicion especifica
    public void eliminarNodo(int posicion) {
        if (posicion == 0) {
            nodoPrimero = nodoPrimero.getSiguienteNodo();
        } else {
            Nodo<T> aux = nodoPrimero;
            for (int i = 0; i < posicion - 1; i++) {
                aux = aux.getSiguienteNodo();
            }
            aux.setSiguienteNodo(aux.getSiguienteNodo().getSiguienteNodo());
        }
        tamanio--;
    }

    //Metodo para insertar un nodo al final de la lista de forma recursiva
    public void insertarNodoFinalRecrusivo(T dato) {
        Nodo<T> nuevo = new Nodo<T>(dato);
        if (nodoPrimero == null) {
            nodoPrimero = nuevo;
        } else {
            insertarNodoFinal(nodoPrimero, nuevo);
        }
        tamanio++;
    }

    private void insertarNodoFinal(Nodo<T> nodo, Nodo<T> nuevo) {
        if (nodo.getSiguienteNodo() == null) {
            nodo.setSiguienteNodo(nuevo);
        } else {
            insertarNodoFinal(nodo.getSiguienteNodo(), nuevo);
        }
    }

    //Metodo para insertar un nodo en una posicion especifica de forma recursiva
    public void insertarNodoRecursivo(T dato, int posicion) {
        Nodo<T> nuevo = new Nodo<T>(dato);
        if (posicion == 0) {
            nuevo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevo;
        } else {
            insertarNodo(nodoPrimero, nuevo, posicion);
        }
        tamanio++;
    }

    private void insertarNodo(Nodo<T> nodo, Nodo<T> nuevo, int posicion) {
        if (posicion == 1) {
            nuevo.setSiguienteNodo(nodo.getSiguienteNodo());
            nodo.setSiguienteNodo(nuevo);
        } else {
            insertarNodo(nodo.getSiguienteNodo(), nuevo, posicion - 1);
        }
    }

    //Metodo para buscar un nodo dentro de la lista de forma recursiva
    public Nodo<T> buscarNodoRecursivo(T dato) {
        return buscarNodo(nodoPrimero, dato);
    }

    private Nodo<T> buscarNodo(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        } else if (nodo.getValorNodo() == dato) {
            return nodo;
        } else {
            return buscarNodo(nodo.getSiguienteNodo(), dato);
        }
    }
}
