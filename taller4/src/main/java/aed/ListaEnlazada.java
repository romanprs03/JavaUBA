package aed;

import java.util.List;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    private class Nodo {
        T valor;
        Nodo Siguiente;

        Nodo(T valor) {
            this.valor = valor;
            this.Siguiente = null;
        }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (primero == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            nuevoNodo.Siguiente = primero;
            primero = nuevoNodo;
        }
        longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (ultimo == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.Siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }
        longitud++;
    }

    public T obtener(int i) {
        Nodo actual = primero;
        for (int j = 0; j < i; j++) {
            actual = actual.Siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        if (i == 0) {
            primero = primero.Siguiente;
            if (primero == null) {
                ultimo = null;
            }
        } else {
            Nodo anterior = primero;
            for (int j = 0; j < i - 1; j++) {
                anterior = anterior.Siguiente;
            }
            anterior.Siguiente = anterior.Siguiente.Siguiente;
            if (anterior.Siguiente == null) {
                ultimo = anterior;
            }
        }
        longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        for (int j = 0; j < indice; j++) {
            actual = actual.Siguiente;
        }
        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<>();
        Nodo actual = primero;
        while (actual != null) {
            copia.agregarAtras(actual.valor);
            actual = actual.Siguiente;
        }
        return copia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual = lista.primero;
        while (actual != null) {
            this.agregarAtras(actual.valor);
            actual = actual.Siguiente;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = primero;
        sb.append("[");
        while (actual != null) {
            sb.append(actual.valor);
            if (actual.Siguiente != null){
                sb.append(", ");
            }
            actual = actual.Siguiente;
        }
        sb.append("]");
        return sb.toString();
    }

    private class ListaIterador implements Iterador<T> {
        private int puntero;

        ListaIterador(){
            puntero = 0;
        }

        public boolean haySiguiente() {
            return puntero != longitud;
        }

        public boolean hayAnterior() {
            return puntero != 0;
        }

        public T siguiente() {
            puntero ++;
            return obtener(puntero - 1);
        }

        public T anterior() {
            puntero --;
            return obtener(puntero);
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }
}
