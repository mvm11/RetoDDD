package co.com.sofka.heladeria.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.BonoDescuento;
import co.com.sofka.heladeria.domain.pedido.values.ClienteId;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {

    private Nombre nombre;
    private Telefono telefono;
    private BonoDescuento bonoDescuento;

    public Cliente(ClienteId clienteId, Nombre nombre, Telefono telefono) {
        super(clienteId);
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
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void cambiarTelefono(Telefono telefono) {
        this.telefono = Objects.requireNonNull(telefono);
    }

    public void añadirBonoDescuento(BonoDescuento bonoDescuento) {
        this.bonoDescuento = Objects.requireNonNull(bonoDescuento);
    }

    public BonoDescuento bonoDescuento(BonoDescuento bonoDescuento) {
        return this.bonoDescuento;
    }

}
