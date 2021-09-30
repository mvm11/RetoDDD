package co.com.sofka.heladeria.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.BonoDescuento;
import co.com.sofka.heladeria.domain.pedido.values.IdCliente;

public class Cliente extends Entity<IdCliente> {

    private Nombre nombre;
    private Telefono telefono;
    private BonoDescuento bonoDescuento;

    public Cliente(IdCliente idCliente, Nombre nombre, Telefono telefono) {
        super(idCliente);
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

    public void añadirBonoDescuento(BonoDescuento bonoDescuento) {
        setBonoDescuento(bonoDescuento);
    }


    public BonoDescuento bonoDescuento(BonoDescuento bonoDescuento) {
        return this.bonoDescuento;
    }

    public void setBonoDescuento(BonoDescuento bonoDescuento) {
        this.bonoDescuento = bonoDescuento;
    }


}
