package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.HeladoId;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;

public class HeladoEliminado extends DomainEvent {

    private final PedidoId pedidoId;
    private final HeladoId heladoId;
    private final Sabor sabor;

    public HeladoEliminado(PedidoId pedidoId, HeladoId heladoId, Sabor sabor) {
        super("sofka.heladeria.domain.pedido.heladoeliminado");
        this.pedidoId = pedidoId;
        this.heladoId = heladoId;
        this.sabor = sabor;
    }

    public PedidoId getIdPedido() {
        return pedidoId;
    }

    public HeladoId getIdHelado() {
        return heladoId;
    }

    public Sabor getSabor() {
        return sabor;
    }
}

