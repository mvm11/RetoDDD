package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Sabor implements ValueObject<String> {
    private final String value;

    public Sabor(String value) {
        this.value = value;
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El sabor no puede estar vacío");
        }

    }

    public String value() {
        return value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sabor sabor = (Sabor) o;
        return Objects.equals(value, sabor.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
