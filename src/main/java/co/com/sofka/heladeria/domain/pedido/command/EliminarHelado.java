package co.com.sofka.heladeria.domain.pedido.command;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.pedido.values.HeladoId;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;

public class EliminarHelado implements Command {

    private final PedidoId pedidoId;
    private final HeladoId heladoId;

    public EliminarHelado(PedidoId pedidoId, HeladoId heladoId) {
        this.pedidoId = pedidoId;
        this.heladoId = heladoId;
    }


    public PedidoId getIdPedido() {
        return pedidoId;
    }

    public HeladoId getIdHelado() {
        return heladoId;
    }

}
