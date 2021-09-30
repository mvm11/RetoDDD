package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.DescripcionPedido;

public class DescripcionOrdenCambiada extends DomainEvent {

    private final IdPedido idPedido;
    private final DescripcionPedido descripcionPedido;

    public DescripcionOrdenCambiada(IdPedido idPedido, DescripcionPedido descripcionPedido) {
        super("sofka.heladeria.domain.pedido.descripcionordencambiada");
        this.idPedido = idPedido;
        this.descripcionPedido = descripcionPedido;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public DescripcionPedido getDescripcionPedido() {
        return descripcionPedido;
    }
}
