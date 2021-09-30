package co.com.sofka.heladeria.domain.genericvalues;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Funcion implements ValueObject<String> {

    private final String value;

    public Funcion(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La función no puede estar vacía");
        }
    }

    public String value() {
            return value;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcion funcion = (Funcion) o;
        return Objects.equals(value, funcion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

