package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.values.IdCliente;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class AñadirBonoDescuento implements Command {

    private final IdPedido idPedido;
    private final IdCliente idCliente;

    public AñadirBonoDescuento(IdPedido idPedido, IdCliente idCliente) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }
}
