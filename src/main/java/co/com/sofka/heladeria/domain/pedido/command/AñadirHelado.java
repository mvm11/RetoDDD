package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.values.HeladoId;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;

public class AñadirHelado implements Command {


    private final PedidoId pedidoId;
    private final HeladoId heladoId;
    private final Sabor sabor;

    public AñadirHelado(PedidoId pedidoId, HeladoId heladoId, Sabor sabor) {
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
