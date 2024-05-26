package aed;

import java.sql.Array;
import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    public Nodo nodo;
    public ArrayList<T> elementos;
    private class Nodo {
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;

        Nodo (T valor){
            this.valor = valor;
            this.izq = null;
            this.der = null;
            this.padre = null;
        }
    }

    public ABB() {
        nodo = null;
        elementos = new ArrayList<>();
    }

    public int cardinal() {
        return elementos.size();
    }

    public T minimo(){
        Nodo actual = this.nodo;
        while(actual.padre != null){
            actual = actual.padre;
        }
        while (actual.izq != null){
            actual = actual.izq;
        } 
        return actual.valor;
    }

    public T maximo(){
        Nodo actual = this.nodo;
        while(actual.padre != null){
            actual = actual.padre;
        }
        while (actual.der != null){
            actual = actual.der;
        } 
        return actual.valor;
    }

    public void insertar(T elem) {
        if (this.nodo == null) {
            this.nodo = new Nodo(elem);
            elementos.add(elem);
        } else {
            insertarRec(this.nodo, elem);
        }
    }

    private void insertarRec(Nodo actual, T elem) {
        if (elem.compareTo(actual.valor) < 0) {
            if (actual.izq == null) {
                actual.izq = new Nodo(elem);
                actual.izq.padre = actual;
                elementos.add(elem);
            } else {
                insertarRec(actual.izq, elem);
            }
        } else if (elem.compareTo(actual.valor) > 0) {
            if (actual.der == null) {
                actual.der = new Nodo(elem);
                actual.der.padre = actual;
                elementos.add(elem);
            } else {
                insertarRec(actual.der, elem);
            }
        }
}

    public boolean pertenece(T elem){
        return elementos.contains(elem);
    }

    public void eliminar(T elem){
        elementos.remove(elem);
    }

    public String toString(){
        StringBuilder string = new StringBuilder("{");
        ArrayList<T> elementos_copy = new ArrayList<>(elementos);
        Collections.sort(elementos_copy);
        for(int i = 0; i < elementos_copy.size() - 1; i++){
            string.append(elementos_copy.get(i)+ ",");
        }
        string.append(elementos_copy.get(elementos_copy.size()-1)+"}");
        return string.toString(); 
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;
        public int puntero;

        public ABB_Iterador(){
            _actual = nodo;
            puntero = elementos.indexOf(_actual.valor);
        }

        public boolean haySiguiente() {            
            return _actual.izq != null || _actual.der != null;
        }
        
        public T siguiente() {
            Collections.sort(elementos);
            puntero = puntero + 1;
            return elementos.get(puntero - 1);
    }
}

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
