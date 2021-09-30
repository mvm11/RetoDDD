package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ubicacion implements ValueObject<String> {

    private final String value;

    public Ubicacion(String value) {
        this.value = value;
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La ubicación no puede estar vacía");
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
        Ubicacion ubicacion = (Ubicacion) o;
        return Objects.equals(value, ubicacion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
