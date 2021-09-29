package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class EliminarCliente implements Command {

    IdPedido idPedido;
    Cliente cliente;

    public EliminarCliente(IdPedido idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }
}