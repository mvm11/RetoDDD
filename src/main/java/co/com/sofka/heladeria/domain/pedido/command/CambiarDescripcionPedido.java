package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.values.DescripcionPedido;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class CambiarDescripcionPedido implements Command {

    private final IdPedido idPedido;
    private final DescripcionPedido descripcionPedido;

    public CambiarDescripcionPedido(IdPedido idPedido, DescripcionPedido descripcionPedido) {
        this.idPedido = idPedido;
        this.descripcionPedido = descripcionPedido;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public DescripcionPedido getDescripcionPedido() {
        return descripcionPedido;
    }
}
