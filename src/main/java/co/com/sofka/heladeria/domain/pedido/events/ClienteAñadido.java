package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdCliente;

public class ClienteAñadido extends DomainEvent {

    private final IdCliente idCliente;
    private final Nombre nombre;
    private final Telefono telefono;

    public ClienteAñadido(IdCliente idCliente, Nombre nombre, Telefono telefono) {
        super("domain.pedido.clienteañadido");
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

