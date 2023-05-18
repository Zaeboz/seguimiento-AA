package estructuras_datos;

public class Arbol<T> {

    private NodoDoble<T> nodoRaiz;

    public Arbol() {
        nodoRaiz = null;
    }

    public boolean buscar(NodoDoble<T> nodo) {
        if (nodoRaiz != null) {
            NodoDoble<T> nodoActual = nodoRaiz;
            while (nodoActual != null) {
                if (nodoActual.getValorNodo().equals(nodo.getValorNodo())) {
                    return true;
                } else {
                    if (nodo.getValorNodo().hashCode() < nodoActual.getValorNodo().hashCode()) {
                        nodoActual = nodoActual.getAnteriorNodo();
                    } else {
                        nodoActual = nodoActual.getSiguienteNodo();
                    }
                }
            }
        }
        return false;
    }

    public void insertar(NodoDoble<T> nodo) {
        if (nodoRaiz == null) {
            nodoRaiz = nodo;
        } else {
            NodoDoble<T> nodoActual = nodoRaiz;
            NodoDoble<T> nodoPadre;
            while (true) {
                nodoPadre = nodoActual;
                if (nodo.getValorNodo().hashCode() < nodoActual.getValorNodo().hashCode()) {
                    nodoActual = nodoActual.getAnteriorNodo();
                    if (nodoActual == null) {
                        nodoPadre.setAnteriorNodo(nodo);
                        return;
                    }
                } else {
                    nodoActual = nodoActual.getSiguienteNodo();
                    if (nodoActual == null) {
                        nodoPadre.setSiguienteNodo(nodo);
                        return;
                    }
                }
            }
        }
    }

    public void eliminar(NodoDoble<T> nodo) {
        if (nodoRaiz != null) {
            NodoDoble<T> nodoActual = nodoRaiz;
            NodoDoble<T> nodoPadre = nodoRaiz;
            boolean esHijoIzquierdo = true;
            while (!nodoActual.getValorNodo().equals(nodo.getValorNodo())) {
                nodoPadre = nodoActual;
                if (nodo.getValorNodo().hashCode() < nodoActual.getValorNodo().hashCode()) {
                    esHijoIzquierdo = true;
                    nodoActual = nodoActual.getAnteriorNodo();
                } else {
                    esHijoIzquierdo = false;
                    nodoActual = nodoActual.getSiguienteNodo();
                }
                if (nodoActual == null) {
                    return;
                }
            }
            if (nodoActual.getAnteriorNodo() == null && nodoActual.getSiguienteNodo() == null) {
                if (nodoActual == nodoRaiz) {
                    nodoRaiz = null;
                } else if (esHijoIzquierdo) {
                    nodoPadre.setAnteriorNodo(null);
                } else {
                    nodoPadre.setSiguienteNodo(null);
                }
            } else if (nodoActual.getSiguienteNodo() == null) {
                if (nodoActual == nodoRaiz) {
                    nodoRaiz = nodoActual.getAnteriorNodo();
                } else if (esHijoIzquierdo) {
                    nodoPadre.setAnteriorNodo(nodoActual.getAnteriorNodo());
                } else {
                    nodoPadre.setSiguienteNodo(nodoActual.getAnteriorNodo());
                }
            } else if (nodoActual.getAnteriorNodo() == null) {
                if (nodoActual == nodoRaiz) {
                    nodoRaiz = nodoActual.getSiguienteNodo();
                } else if (esHijoIzquierdo) {
                    nodoPadre.setAnteriorNodo(nodoActual.getSiguienteNodo());
                } else {
                    nodoPadre.setSiguienteNodo(nodoActual.getSiguienteNodo());
                }
            } else {
                NodoDoble<T> reemplazo = obtenerNodoReemplazo(nodoActual);
                if (nodoActual == nodoRaiz) {
                    nodoRaiz = reemplazo;
                } else if (esHijoIzquierdo) {
                    nodoPadre.setAnteriorNodo(reemplazo);
                } else {
                    nodoPadre.setSiguienteNodo(reemplazo);
                }
                reemplazo.setAnteriorNodo(nodoActual.getAnteriorNodo());
            }
        }

    }

    private NodoDoble<T> obtenerNodoReemplazo(NodoDoble<T> nodoActual) {
        NodoDoble<T> reemplazarPadre = nodoActual;
        NodoDoble<T> reemplazo = nodoActual;
        NodoDoble<T> nodoActual2 = nodoActual.getSiguienteNodo();
        while (nodoActual2 != null) {
            reemplazarPadre = reemplazo;
            reemplazo = nodoActual2;
            nodoActual2 = nodoActual2.getAnteriorNodo();
        }
        if (reemplazo != nodoActual.getSiguienteNodo()) {
            reemplazarPadre.setAnteriorNodo(reemplazo.getSiguienteNodo());
            reemplazo.setSiguienteNodo(nodoActual.getSiguienteNodo());
        }
        return reemplazo;
    }

    public void eliminarSubArbol(NodoDoble<T> nodoActual) {
        if (nodoActual != null) {
            eliminarSubArbol(nodoActual.getAnteriorNodo());
            eliminarSubArbol(nodoActual.getSiguienteNodo());
            eliminar(nodoActual);
        }
    }

    //Busca el menor elemento de un arbol no binario
    public NodoDoble<T> buscarMenor() {
        NodoDoble<T> nodoActual = nodoRaiz;
        NodoDoble<T> nodoPadre = nodoRaiz;
        while (nodoActual != null) {
            nodoPadre = nodoActual;
            nodoActual = nodoActual.getAnteriorNodo();
        }
        return nodoPadre;
    }

    //Busca el mayor elemento de un arbol no ordenado
    public NodoDoble<T> buscarMayor() {
        NodoDoble<T> nodoActual = nodoRaiz;
        NodoDoble<T> nodoPadre = nodoRaiz;
        while (nodoActual != null) {
            nodoPadre = nodoActual;
            nodoActual = nodoActual.getSiguienteNodo();
        }
        return nodoPadre;
    }

    public NodoDoble<T> eliminarMenor() {
        NodoDoble<T> nodoActual = nodoRaiz;
        NodoDoble<T> nodoPadre = nodoRaiz;
        while (nodoActual != null) {
            nodoPadre = nodoActual;
            nodoActual = nodoActual.getAnteriorNodo();
        }
        if (nodoPadre != null) {
            eliminar(nodoPadre);
        }
        return nodoPadre;
    }

    public NodoDoble<T> eliminarMayor() {
        NodoDoble<T> nodoActual = nodoRaiz;
        NodoDoble<T> nodoPadre = nodoRaiz;
        while (nodoActual != null) {
            nodoPadre = nodoActual;
            nodoActual = nodoActual.getSiguienteNodo();
        }
        if (nodoPadre != null) {
            eliminar(nodoPadre);
        }
        return nodoPadre;
    }

    public int altura(){
        return altura(nodoRaiz);
    }

    private int altura(NodoDoble<T> nodoActual){
        if(nodoActual == null){
            return 0;
        }else{
            return 1 + Math.max(altura(nodoActual.getAnteriorNodo()), altura(nodoActual.getSiguienteNodo()));
        }
    }

    private int peso(){
        return peso(nodoRaiz);
    }

    private int peso(NodoDoble<T> nodoActual){
        if(nodoActual == null){
            return 0;
        }else{
            return 1 + peso(nodoActual.getAnteriorNodo()) + peso(nodoActual.getSiguienteNodo());
        }
    }

    public void imprimirInOrden(){
        imprimirInOrden(nodoRaiz);
    }

    private void imprimirInOrden(NodoDoble<T> nodoActual){
        if(nodoActual != null){
            imprimirInOrden(nodoActual.getAnteriorNodo());
            System.out.print(nodoActual.getValorNodo() + " ");
            imprimirInOrden(nodoActual.getSiguienteNodo());
        }
    }

    public void eliminarSubarbolIzquierdo(NodoDoble<T> nodoActual){
        if(nodoActual != null){
            eliminarSubarbolIzquierdo(nodoActual.getAnteriorNodo());
            eliminar(nodoActual);
        }
    }
}
