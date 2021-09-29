package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.Orden;

public class CrearPedido implements Command {

    private final IdPedido idPedido;
    private final Fecha fecha;
    private final Orden orden;
    private final Cliente cliente;

    public CrearPedido(IdPedido idPedido, Fecha fecha, Orden orden, Cliente cliente) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.orden = orden;
        this.cliente = cliente;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Orden getOrden() {
        return orden;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
