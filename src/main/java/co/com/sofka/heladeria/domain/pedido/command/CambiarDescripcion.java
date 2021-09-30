package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.values.Descripcion;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;

public class CambiarDescripcion implements Command {

    private final PedidoId pedidoId;
    private final Descripcion descripcion;

    public CambiarDescripcion(PedidoId pedidoId, Descripcion descripcion) {
        this.pedidoId = pedidoId;
        this.descripcion = descripcion;
    }

    public PedidoId getIdPedido() {
        return pedidoId;
    }

    public Descripcion getDescripcionPedido() {
        return descripcion;
    }
}
