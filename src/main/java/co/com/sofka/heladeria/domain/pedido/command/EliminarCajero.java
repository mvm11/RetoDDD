package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Recibo;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class EliminarCajero implements Command {

    IdPedido idPedido;
    Recibo recibo;

    public EliminarCajero(IdPedido idPedido, Recibo recibo) {
        this.idPedido = idPedido;
        this.recibo = recibo;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Recibo getCajero() {
        return recibo;
    }
}
