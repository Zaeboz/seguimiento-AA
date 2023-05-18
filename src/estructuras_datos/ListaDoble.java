package estructuras_datos;

import java.util.Iterator;

/**
 * Definici�n de la clase lista Simple de tipo Generics
 *
 * @param <T>
 **/
public class ListaDoble<T> implements Iterable<T> {

    private NodoDoble<T> nodoPrimero;
    private NodoDoble<T> nodoUltimo;
    private int tamanio;


    public ListaDoble() {
        nodoUltimo = null;
        nodoPrimero = null;
        tamanio = 0;
    }


    //Metodos basicos


    //Agregar al inicio de la lista
    public void agregarInicio(T valorNodo) {

        NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }
        tamanio++;
    }

    //Agregar al final de la lista
    public void agregarfinal(T valorNodo) {

        NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        } else {
            nodoUltimo.setSiguienteNodo(nuevoNodo);
            nuevoNodo.setAnteriorNodo(nodoUltimo);
            nodoUltimo = nuevoNodo;
        }
        tamanio++;
    }

    /**
     * Agrega un valor en la lista en una posici�n espec�fica
     *
     * @param indice �ndice donde se va a guardar el dato
     */
    public void insertarPoscion(T dato, int indice) {

        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);

        if (indiceValido(indice)) {

            if (indice == 0) {
                agregarInicio(dato);
            } else if (indice == tamanio) {
                agregarfinal(dato);
            } else {

                NodoDoble<T> aux = nodoPrimero;

                for (int i = 0; i < indice - 1; i++) {
                    aux = aux.getSiguienteNodo();
                }

                nuevoNodo.setSiguienteNodo(aux.getSiguienteNodo());
                aux.getSiguienteNodo().setAnteriorNodo(nuevoNodo);
                aux.setSiguienteNodo(nuevoNodo);
                nuevoNodo.setAnteriorNodo(aux);
                tamanio++;
            }
        }
    }


    /**
     * Borra completamente la Lista
     */
    public void borrarLista() {
        nodoPrimero = nodoUltimo = null;
        tamanio = 0;
    }


    //Metodo para obtener el valor de un Nodo en una posicion especifica
    public T obtenerValorNodo(int indice) {

        if (indiceValido(indice)) {

            NodoDoble<T> aux = nodoPrimero;

            for (int i = 0; i < indice; i++) {
                aux = aux.getSiguienteNodo();
            }

            return aux.getValorNodo();
        }

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
        return nodoPrimero == null && nodoUltimo == null;
    }


    /**
     * Imprime en consola la lista enlazada
     */
    public void imprimirLista() {

        NodoDoble<T> aux = nodoPrimero;

        while (aux != null) {
            System.out.print(aux.getValorNodo() + "\t");
            aux = aux.getSiguienteNodo();
        }

        System.out.println();
    }

    public void imprimirHaciaAtras() {

        for (NodoDoble<T> aux = nodoUltimo; aux != null; aux = aux.getAnteriorNodo()) {
            System.out.print(aux.getValorNodo() + "\t");
        }
        System.out.println();

    }


    //Eliminar dado el valor de un nodo

    /**
     * Elimina un elemento de la lista
     *
     * @param dato dato a eliminar
     */
    public void eliminar(T dato) {

        NodoDoble<T> actual = nodoPrimero;

        while (actual != null && !actual.getValorNodo().equals(dato)) {
            actual = actual.getSiguienteNodo();
        }

        if (actual != null) {

            if (actual == nodoPrimero) {
                eliminarPrimero();
                return;
            } else if (actual == nodoUltimo) {
                eliminarUltimo();
                return;
            } else {
                actual.getAnteriorNodo().setSiguienteNodo(actual.getSiguienteNodo());
                actual.getSiguienteNodo().setAnteriorNodo(actual.getAnteriorNodo());
                tamanio--;
                return;
            }
        }

        throw new RuntimeException("El dato no existe");
    }


    //Elimina el primer nodo de la lista
    public void eliminarPrimero() {

        if (!estaVacia()) {
            NodoDoble<T> nodoAux = nodoPrimero;
            T valor = nodoAux.getValorNodo();
            nodoPrimero = nodoAux.getSiguienteNodo();

            if (nodoPrimero == null) {
                nodoUltimo = null;
            } else {
                nodoPrimero.setAnteriorNodo(null);
            }

            tamanio--;
            return;
        }

        throw new RuntimeException("Lista vac�a");
    }


    public void eliminarUltimo() {

        if (!estaVacia()) {
            T valor = nodoUltimo.getValorNodo();
            NodoDoble<T> prev = obtenerNodo(tamanio - 2);
            nodoUltimo = prev;

            if (nodoUltimo == null) {
                nodoPrimero = null;
            } else {
                prev.setSiguienteNodo(null);
            }

            tamanio--;
            return;
        }

        throw new RuntimeException("Lista vac�a");
    }


    /**
     * Devuelve el Nodo de una lista dada su posici�n
     *
     * @param indice �ndice para obtener el Nodo
     * @return Nodo objeto
     */
    private NodoDoble<T> obtenerNodo(int indice) {

        if (indice >= 0 && indice < tamanio) {

            NodoDoble<T> nodo = nodoPrimero;

            for (int i = 0; i < indice; i++) {
                nodo = nodo.getSiguienteNodo();
            }

            return nodo;
        }

        return null;
    }

    /**
     * Devuelve un nodo que contenga un dato espec�fico
     *
     * @param dato Dato a buscar
     * @return Nodo
     */
    private NodoDoble<T> buscarNodo(T dato) {

        NodoDoble<T> nodo = nodoPrimero;

        while (nodo != null && !nodo.getValorNodo().equals(dato)) {
            nodo = nodo.getSiguienteNodo();
        }

        return nodo;
    }


    /**
     * Cambia el valor de un nodo dada su posici�n en la lista
     *
     * @param indice posici�n donde se va a cambiar el dato
     * @param nuevo  nuevo valor por el que se actualizar� el nodo
     */
    public void modificarNodo(int indice, T nuevo) {

        if (indiceValido(indice)) {
            NodoDoble<T> nodo = obtenerNodo(indice);
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

        NodoDoble<T> nodo = nodoPrimero;
        int posicion = 0;

        while (nodo != null && !nodo.getValorNodo().equals(dato)) {
            nodo = nodo.getSiguienteNodo();
            posicion++;
        }

        return posicion;
    }


    /**
     * Devuelve un elemento de la lista dado su �ndice
     *
     * @param indice �ndice de la lista
     * @return dato guardado en el �ndice especificado
     */
    public T obtener(int indice) {

        if (indiceValido(indice)) {
            NodoDoble<T> n = obtenerNodo(indice);

            if (n != null) {
                return n.getValorNodo();
            }
        }

        return null;
    }

    @Override
    public Iterator<T> iterator() {

        return new IteradorListaDoble(nodoPrimero);
    }

    protected class IteradorListaDoble implements Iterator<T> {

        private NodoDoble<T> nodo;
        private int posicion;

        /**
         * Constructor de la clase Iterador
         */
        public IteradorListaDoble(NodoDoble<T> nodo) {
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

        public boolean hasPrevious() {
            return nodo != null;
        }


        public T previous() {
            T aux = nodo.getValorNodo();
            nodo = nodo.getAnteriorNodo();
            posicion--;
            return aux;
        }

        public int nextIndex() {
            return posicion;
        }


        public int previousIndex() {
            return posicion - 1;
        }

        public void remove() {
            if (nodo != null) {
                eliminar(nodo.getValorNodo());
            }
        }

        public void set(T e) {
            if (nodo != null) {
                nodo.setValorNodo(e);
            }
        }

        public void add(T e) {
            agregarfinal(e);
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


    public NodoDoble<T> getNodoPrimero() {
        return nodoPrimero;
    }


    public void setNodoPrimero(NodoDoble<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public NodoDoble<T> getNodoUltimo() {
        return nodoUltimo;
    }


    public void setNodoUltimo(NodoDoble<T> nodoUltimo) {
        this.nodoUltimo = nodoUltimo;
    }


    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamano) {
        this.tamanio = tamano;
    }

    //Metodo para eliminar un nodo en una posicion en especifica
    public void eliminarNodo(int indice) {
        if (indiceValido(indice)) {
            NodoDoble<T> nodo = obtenerNodo(indice);
            if (nodo != null) {
                if (nodo.getAnteriorNodo() != null) {
                    nodo.getAnteriorNodo().setSiguienteNodo(nodo.getSiguienteNodo());
                }
                if (nodo.getSiguienteNodo() != null) {
                    nodo.getSiguienteNodo().setAnteriorNodo(nodo.getAnteriorNodo());
                }
                tamanio--;
            }
        }
    }

    //Metodo para insertar un nodo al final de forma recursiva
    public void insertarNodoFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<T>(dato);
        if (nodoPrimero == null) {
            nodoPrimero = nuevo;
            nodoUltimo = nuevo;
        } else {
            insertarNodoFinal(nodoPrimero, nuevo);
        }
    }

    private void insertarNodoFinal(NodoDoble<T> ultimo, NodoDoble<T> nuevo) {
        if (ultimo.getSiguienteNodo() == null) {
            ultimo.setSiguienteNodo(nuevo);
            nuevo.setAnteriorNodo(ultimo);
            nodoUltimo = nuevo;
        } else {
            insertarNodoFinal(ultimo.getSiguienteNodo(), nuevo);
        }
    }

    //Metodo para insertar un nodo al inicio de forma recursiva
    public void insertarNodoInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<T>(dato);
        if (nodoPrimero == null) {
            nodoPrimero = nuevo;
            nodoUltimo = nuevo;
        } else {
            insertarNodoInicio(nodoPrimero, nuevo);
        }
    }

    private void insertarNodoInicio(NodoDoble<T> primero, NodoDoble<T> nuevo) {
        if (primero.getAnteriorNodo() == null) {
            primero.setAnteriorNodo(nuevo);
            nuevo.setSiguienteNodo(primero);
            nodoPrimero = nuevo;
        } else {
            insertarNodoInicio(primero.getAnteriorNodo(), nuevo);
        }
    }

    //Metodo para insertar un nodo en una posicione en especifico de forma recursiva
    public void insertarNodoRecursivo(T dato, int indice) {
        NodoDoble<T> nuevo = new NodoDoble<T>(dato);
        if (indiceValido(indice)) {
            if (indice == 0) {
                insertarNodoInicio(dato);
            } else if (indice == tamanio) {
                insertarNodoFinal(dato);
            } else {
                insertarNodoRecursivo(nodoPrimero, nuevo, indice);
            }
        }
    }

    private void insertarNodoRecursivo(NodoDoble<T> primero, NodoDoble<T> nuevo, int indice) {
        if (indice == 1) {
            nuevo.setSiguienteNodo(primero.getSiguienteNodo());
            nuevo.setAnteriorNodo(primero);
            primero.getSiguienteNodo().setAnteriorNodo(nuevo);
            primero.setSiguienteNodo(nuevo);
        } else {
            insertarNodoRecursivo(primero.getSiguienteNodo(), nuevo, indice - 1);
        }
    }

    //Metodo para buscar un nodo de forma recursiva
    public NodoDoble<T> buscarNodoRecursivo(T dato) {
        if (nodoPrimero != null) {
            return buscarNodoRecursivo(nodoPrimero, dato);
        }
        return null;
    }

    private NodoDoble<T> buscarNodoRecursivo(NodoDoble<T> nodo, T dato) {
        if (nodo.getValorNodo().equals(dato)) {
            return nodo;
        } else {
            if (nodo.getSiguienteNodo() != null) {
                return buscarNodoRecursivo(nodo.getSiguienteNodo(), dato);
            }
        }
        return null;
    }
}
