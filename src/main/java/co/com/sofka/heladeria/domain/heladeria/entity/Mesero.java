package co.com.sofka.heladeria.domain.heladeria.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.genericValues.Funcion;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.values.IdMesero;

import java.util.Objects;

public class Mesero extends Entity<IdMesero> {

    private Nombre nombre;
    private Telefono telefono;
    private Funcion funcion;

    public Mesero(IdMesero entityId, Nombre nombre, Telefono telefono, Funcion funcion) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.funcion = funcion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void cambiarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }
    public void cambiarTelefono(Telefono telefono) {
        this.telefono = Objects.requireNonNull(telefono);
    }
    public void cambiarFuncion(Funcion funcion) {
        this.funcion = Objects.requireNonNull(funcion);
    }
}
