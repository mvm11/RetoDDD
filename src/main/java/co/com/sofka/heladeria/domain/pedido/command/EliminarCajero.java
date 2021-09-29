package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Cajero;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class EliminarCajero implements Command {

    IdPedido idPedido;
    Cajero cajero;

    public EliminarCajero(IdPedido idPedido, Cajero cajero) {
        this.idPedido = idPedido;
        this.cajero = cajero;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Cajero getCajero() {
        return cajero;
    }
}
