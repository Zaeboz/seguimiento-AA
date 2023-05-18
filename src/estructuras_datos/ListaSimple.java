package estructuras_datos;

import java.util.Iterator;


/**
 * Definici�n de la clase lista Simple de tipo Generics
 *
 * @param <T>
 **/

public class ListaSimple<T> implements Iterable<T> {

    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private int tamanio;


    public ListaSimple() {
        nodoPrimero = null;
        tamanio = 0;
    }


    //Metodos basicos


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
    public void agregarfinal(T valorNodo) {

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
                nodoUltimo = previo;
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
    public void eliminarPrimero() {

        if (!estaVacia()) {
            Nodo<T> n = nodoPrimero;
            T valor = n.getValorNodo();
            nodoPrimero = n.getSiguienteNodo();

            if (nodoPrimero == null) {
                nodoUltimo = null;
            }

            tamanio--;
            return;
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

        int i = 0;

        for (Nodo<T> aux = nodoPrimero; aux != null; aux = aux.getSiguienteNodo()) {
            if (aux.getValorNodo().equals(dato)) {
                return i;
            }
            i++;
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

    public void limpiarLista() {
        nodoPrimero = null;
        nodoUltimo = null;
        tamanio = 0;
    }

    public Nodo<T> insertarEnPosicion(int posicion, T dato) {
        Nodo<T> nuevo = new Nodo<T>(dato);
        Nodo<T> aux = nodoPrimero;
        Nodo<T> previo = null;
        int i = 0;

        if (posicion == 0) {
            nuevo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevo;
            tamanio++;
            return nuevo;
        }

        while (aux != null) {
            if (i == posicion) {
                previo.setSiguienteNodo(nuevo);
                nuevo.setSiguienteNodo(aux);
                tamanio++;
                return nuevo;
            }
            previo = aux;
            aux = aux.getSiguienteNodo();
            i++;
        }
        return null;
    }

    public boolean buscar(T dato) {
        Nodo<T> aux = nodoPrimero;
        while (aux != null) {
            if (aux.getValorNodo().equals(dato)) {
                return true;
            }
            aux = aux.getSiguienteNodo();
        }
        return false;
    }

    public Nodo<T> eliminarPosicion(int pos) {
        Nodo<T> aux = nodoPrimero;
        Nodo<T> previo = null;
        int i = 0;

        if (pos == 0) {
            nodoPrimero = aux.getSiguienteNodo();
            tamanio--;
            return aux;
        }

        while (aux != null) {
            if (i == pos) {
                previo.setSiguienteNodo(aux.getSiguienteNodo());
                tamanio--;
                return aux;
            }
            previo = aux;
            aux = aux.getSiguienteNodo();
            i++;
        }
        return null;
    }

    public boolean busquedaRecursiva(T dato) {
        return busquedaRecursiva(dato, nodoPrimero);
    }

    private boolean busquedaRecursiva(T dato, Nodo<T> nodo) {
        if (nodo == null) {
            return false;
        } else if (nodo.getValorNodo().equals(dato)) {
            return true;
        } else {
            return busquedaRecursiva(dato, nodo.getSiguienteNodo());
        }
    }

    //metodo para eliminar un nodo de una lista de forma recursiva
    public boolean eliminarNodoRecursivo(int pos) {
        return eliminarNodoRecursivo(pos, nodoPrimero);
    }

    private boolean eliminarNodoRecursivo(int pos, Nodo<T> nodo) {
        if (nodo == null) {
            return false;
        } else if (pos == 0) {
            nodoPrimero = nodo.getSiguienteNodo();
            tamanio--;
            return true;
        } else if (pos == 1) {
            nodo.setSiguienteNodo(nodo.getSiguienteNodo().getSiguienteNodo());
            tamanio--;
            return true;
        } else {
            return eliminarNodoRecursivo(pos - 1, nodo.getSiguienteNodo());
        }
    }

    //Metodo para insertar un nodo en una posicion en especifico de forma recursiva
    public boolean insertarNodoRecursivo(int pos, T dato) {
        return insertarNodoRecursivo(pos, dato, nodoPrimero);
    }

    private boolean insertarNodoRecursivo(int pos, T dato, Nodo<T> nodo) {
        if (nodo == null) {
            return false;
        } else if (pos == 0) {
            Nodo<T> nuevo = new Nodo<T>(dato);
            nuevo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevo;
            tamanio++;
            return true;
        } else if (pos == 1) {
            Nodo<T> nuevo = new Nodo<T>(dato);
            nuevo.setSiguienteNodo(nodo.getSiguienteNodo());
            nodo.setSiguienteNodo(nuevo);
            tamanio++;
            return true;
        } else {
            return insertarNodoRecursivo(pos - 1, dato, nodo.getSiguienteNodo());
        }
    }

    public Nodo<T> eliminarParcial(int pos){
        Nodo<T> aux = nodoPrimero;
        Nodo<T> previo = null;
        int i = 0;

        if (pos-1 == 0) {
            nodoPrimero = aux.getSiguienteNodo();
            tamanio--;
            return aux;
        }

        while (aux != null) {
            if (i == pos-1) {
                previo.setSiguienteNodo(aux.getSiguienteNodo());
                tamanio--;
                return aux;
            }
            previo = aux;
            aux = aux.getSiguienteNodo();
            i++;
        }
        return null;
    }

    public void insertarPenultimaParcial(T valor){
        Nodo<T> nuevo = new Nodo<T>(valor);
        Nodo<T> aux = nodoPrimero;
        Nodo<T> previo = null;
        int i = 0;

        while (aux != null) {
            if (i == tamanio-1) {
                assert previo != null;
                previo.setSiguienteNodo(nuevo);
                nuevo.setSiguienteNodo(aux);
                tamanio++;
            }
            previo = aux;
            aux = aux.getSiguienteNodo();
            i++;
        }
    }

}
