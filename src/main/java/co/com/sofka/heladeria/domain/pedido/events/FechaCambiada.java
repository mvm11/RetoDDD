package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class FechaCambiada extends DomainEvent {

    private final IdPedido idPedido;
    private final Fecha fecha;

    public FechaCambiada(IdPedido idPedido, Fecha fecha) {
        super("sofka.heladeria.domain.pedido.fechacambiada");
        this.idPedido = idPedido;
        this.fecha = fecha;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
