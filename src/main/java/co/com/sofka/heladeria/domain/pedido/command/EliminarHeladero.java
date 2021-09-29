package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Heladero;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class EliminarHeladero implements Command {

    Heladero heladero;

    public EliminarHeladero(Heladero heladero) {
        this.heladero = heladero;
    }

    public Heladero getHeladero() {
        return heladero;
    }
}
