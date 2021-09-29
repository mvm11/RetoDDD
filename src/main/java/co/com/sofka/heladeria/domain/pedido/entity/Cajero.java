package co.com.sofka.heladeria.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdCajero;


public class Cajero extends Entity<IdCajero> {

    private Nombre nombre;
    private Telefono telefono;

    public Cajero(IdCajero idCajero, Nombre nombre, Telefono telefono) {
        super(idCajero);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public void cambiarNombre(Nombre nombre) {
        setNombre(nombre);
    }

    public void cambiarTelefono(Telefono telefono) {
        setTelefono(telefono);
    }
}
