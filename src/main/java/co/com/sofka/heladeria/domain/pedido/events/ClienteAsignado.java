package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.ClienteId;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;

public class ClienteAsignado extends DomainEvent {

    private final PedidoId pedidoId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Telefono telefono;

    public ClienteAsignado(PedidoId pedidoId, ClienteId clienteId, Nombre nombre, Telefono telefono) {
        super("sofka.heladeria.domain.pedido.clienteasignado");
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.telefono = telefono;
    }



    public PedidoId getIdPedido() {
        return pedidoId;
    }

    public ClienteId getIdCliente() {
        return clienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
