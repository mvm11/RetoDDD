package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BonoDescuento implements ValueObject<Integer> {

    private final int bonoDescuento;

    public BonoDescuento(int bonoDescuento){
        this.bonoDescuento = bonoDescuento;
    }

    @Override
    public Integer value() {
        return bonoDescuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonoDescuento that = (BonoDescuento) o;
        return bonoDescuento == that.bonoDescuento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonoDescuento);
    }
}
