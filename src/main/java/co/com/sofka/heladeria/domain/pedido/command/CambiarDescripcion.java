package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.values.Descripcion;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class CambiarDescripcion implements Command {

    private final IdPedido idPedido;
    private final Descripcion descripcion;

    public CambiarDescripcion(IdPedido idPedido, Descripcion descripcion) {
        this.idPedido = idPedido;
        this.descripcion = descripcion;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Descripcion getDescripcionPedido() {
        return descripcion;
    }
}
