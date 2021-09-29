package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Helado;

public class EliminarHeladero implements Command {

    Helado helado;

    public EliminarHeladero(Helado helado) {
        this.helado = helado;
    }

    public Helado getHeladero() {
        return helado;
    }
}
