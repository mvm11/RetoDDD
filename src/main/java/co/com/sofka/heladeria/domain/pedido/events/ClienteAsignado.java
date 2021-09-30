package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdCliente;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class ClienteAsignado extends DomainEvent {

    private final IdPedido idPedido;
    private final IdCliente idCliente;
    private final Nombre nombre;
    private final Telefono telefono;


    public ClienteAsignado(IdPedido idPedido, IdCliente idCliente, Nombre nombre, Telefono telefono) {
        super("sofka.heladeria.domain.pedido.clienteasignado");
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public IdPedido getIdPedido() {
        return idPedido;
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
