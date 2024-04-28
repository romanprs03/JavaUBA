package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;
    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        return new Fecha(fecha);
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return mensaje + " @ " + fecha + " " + horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;
        if (otro == null || getClass() != otro.getClass()) return false;
        Recordatorio recordatorio = (Recordatorio) otro;
        return mensaje.equals(recordatorio.mensaje) && fecha.equals(recordatorio.fecha) && horario.equals(recordatorio.horario);
    }

}
