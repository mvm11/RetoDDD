package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;

public class CambiarFecha implements Command {

    private final PedidoId pedidoId;
    private final Fecha fecha;

    public CambiarFecha(PedidoId pedidoId, Fecha fecha) {
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
