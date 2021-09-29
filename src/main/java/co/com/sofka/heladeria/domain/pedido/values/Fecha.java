package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Fecha implements ValueObject<String> {

    private final String fecha;

    public Fecha() {
        this.fecha =  Objects.requireNonNull(fechaHora());
    }

    public String fechaHora() {
        Fecha HoraYFecha = new Fecha();
        SimpleDateFormat Format = new SimpleDateFormat("YYYY/MM/DD '-' HH:mm:ss");
        return Format.format(HoraYFecha);
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha1 = (Fecha) o;
        return Objects.equals(fecha, fecha1.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }


    @Override
    public String value() {
        return fecha;
    }
}

