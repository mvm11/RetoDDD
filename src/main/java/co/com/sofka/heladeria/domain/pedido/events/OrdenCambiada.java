package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.DescripcionPedido;

public class OrdenCambiada extends DomainEvent {

    private final IdPedido idPedido;
    private final DescripcionPedido descripcionPedido;

    public OrdenCambiada(IdPedido idPedido, DescripcionPedido descripcionPedido) {
        super("sofka.heladeria.domain.pedido.ordencambiada");
        this.idPedido = idPedido;
        this.descripcionPedido = descripcionPedido;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public DescripcionPedido getOrden() {
        return descripcionPedido;
    }
}
