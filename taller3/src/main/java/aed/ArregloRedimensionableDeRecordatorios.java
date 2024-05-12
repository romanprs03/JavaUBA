package aed;
import java.util.ArrayList;
class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private ArrayList<Recordatorio> arreglo;
    public ArregloRedimensionableDeRecordatorios() {
        this.arreglo = new ArrayList<>();
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.arreglo = new ArrayList<>(vector.arreglo);
    }

    public int longitud() {
        return arreglo.size();
    }

    public void agregarAtras(Recordatorio i) {
        arreglo.add(i);
    }

    public Recordatorio obtener(int i) {
        return arreglo.get(i);
    }

    public void quitarAtras() {
        arreglo.remove(arreglo.size() - 1);
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        arreglo.set(indice, valor);

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios();
        copia.arreglo.addAll(this.arreglo);
        return copia;
    }

}
