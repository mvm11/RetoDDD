package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La orden no puede estar vacía");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion descripcion = (Descripcion) o;
        return Objects.equals(value, descripcion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
