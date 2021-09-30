package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.domain.pedido.values.Descripcion;

public class DescripcionCambiada extends DomainEvent {

    private final PedidoId pedidoId;
    private final Descripcion descripcion;

    public DescripcionCambiada(PedidoId pedidoId, Descripcion descripcion) {
        super("sofka.heladeria.domain.pedido.descripcionordencambiada");
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
