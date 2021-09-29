package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class CambiarNombre implements Command {

    private final IdPedido idPedido;
    private final Nombre nombre;

    public CambiarNombre(IdPedido idPedido, Nombre nombre) {
        this.idPedido = idPedido;
        this.nombre = nombre;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
