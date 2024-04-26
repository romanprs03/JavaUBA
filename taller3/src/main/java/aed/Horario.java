package aed;

public class Horario {
    private int hora;
    private int minutos;
    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return hora;
    }

    public int minutos() {
        return minutos;
    }

    @Override
    public String toString() {
        return hora + ":" + minutos;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;
        if (otro == null || getClass() != otro.getClass()) return false;
        Horario horario = (Horario) otro;
        return hora == horario.hora && minutos == horario.minutos;
    }

}
