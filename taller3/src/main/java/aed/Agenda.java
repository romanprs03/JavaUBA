package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios listaDeRecordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = new Fecha(fechaActual);
        this.listaDeRecordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        listaDeRecordatorios.agregarAtras(recordatorio);
    }
    

    @Override
   
    public String toString() {
        String res = fechaActual() + "\n"
                     + "=====\n";
            for (int i = 0; i < listaDeRecordatorios.longitud(); i++) {
                Recordatorio recordatorio = listaDeRecordatorios.obtener(i);
                if(fechaActual.equals(recordatorio.fecha())){
                res += recordatorio.toString() + "\n";
                }
            }
    
        return res;
    }
    
    
    public void incrementarDia() {
        fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(fechaActual);
    }
}
