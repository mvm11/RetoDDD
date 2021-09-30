package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreHeladeria implements ValueObject<String> {
    private final String value;

    public NombreHeladeria(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreHeladeria that = (NombreHeladeria) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}