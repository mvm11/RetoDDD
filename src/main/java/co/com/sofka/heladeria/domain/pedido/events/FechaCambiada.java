package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;

public class FechaCambiada extends DomainEvent {

    private final PedidoId pedidoId;
    private final Fecha fecha;

    public FechaCambiada(PedidoId pedidoId, Fecha fecha) {
        super("sofka.heladeria.domain.pedido.fechacambiada");
        this.pedidoId = pedidoId;
        this.fecha = fecha;
    }

    public PedidoId getIdPedido() {
        return pedidoId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
