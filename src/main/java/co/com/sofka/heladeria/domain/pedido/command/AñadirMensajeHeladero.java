package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Heladero;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class AñadirMensajeHeladero implements Command {

    IdPedido idPedido;
    Heladero heladero;

    public AñadirMensajeHeladero(IdPedido idPedido, Heladero heladero) {
        this.idPedido = idPedido;
        this.heladero = heladero;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Heladero getHeladero() {
        return heladero;
    }
}
