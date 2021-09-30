package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.domain.pedido.values.Descripcion;

public class CrearPedido implements Command {

    private final PedidoId pedidoId;
    private final Fecha fecha;
    private final Descripcion descripcion;
    private final Cliente cliente;

    public CrearPedido(PedidoId pedidoId, Fecha fecha, Descripcion descripcion, Cliente cliente) {
        this.pedidoId = pedidoId;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cliente = cliente;
    }

    public PedidoId getIdPedido() {
        return pedidoId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Descripcion getOrden() {
        return descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
