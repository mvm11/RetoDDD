package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Color implements ValueObject<String> {

    private final String value;

    public Color(String value) {
        this.value = value;
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El color no puede estar vacío");
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
        Color color = (Color) o;
        return Objects.equals(value, color.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
