package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Integer> {

    private final int value;

    public Precio(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio precio = (Precio) o;
        return value == precio.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
