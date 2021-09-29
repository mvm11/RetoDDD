package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.Orden;

public class OrdenCambiada extends DomainEvent {

    private final IdPedido idPedido;
    private final Orden orden;

    public OrdenCambiada(IdPedido idPedido, Orden orden) {
        super("sofka.heladeria.domain.pedido.ordencambiada");
        this.idPedido = idPedido;
        this.orden = orden;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Orden getOrden() {
        return orden;
    }
}
