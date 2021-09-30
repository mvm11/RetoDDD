package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.Descripcion;

public class DescripcionCambiada extends DomainEvent {

    private final IdPedido idPedido;
    private final Descripcion descripcion;

    public DescripcionCambiada(IdPedido idPedido, Descripcion descripcion) {
        super("sofka.heladeria.domain.pedido.descripcionordencambiada");
        this.idPedido = idPedido;
        this.descripcion = descripcion;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Descripcion getDescripcionPedido() {
        return descripcion;
    }
}
