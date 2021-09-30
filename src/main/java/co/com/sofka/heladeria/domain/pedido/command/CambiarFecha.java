package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class CambiarFecha implements Command {

    private final IdPedido idPedido;
    private final Fecha fecha;

    public CambiarFecha(IdPedido idPedido, Fecha fecha) {
        this.idPedido = idPedido;
        this.fecha = fecha;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
