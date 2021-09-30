package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.ClienteId;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;

public class AsignarCliente implements Command {

    private final PedidoId pedidoId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Telefono telefono;

    public AsignarCliente(PedidoId pedidoId, ClienteId clienteId, Nombre nombre, Telefono telefono) {
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
