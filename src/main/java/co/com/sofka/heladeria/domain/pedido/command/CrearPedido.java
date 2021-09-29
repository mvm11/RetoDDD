package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.DescripcionPedido;

public class CrearPedido implements Command {

    private final IdPedido idPedido;
    private final Fecha fecha;
    private final DescripcionPedido descripcionPedido;
    private final Cliente cliente;

    public CrearPedido(IdPedido idPedido, Fecha fecha, DescripcionPedido descripcionPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.descripcionPedido = descripcionPedido;
        this.cliente = cliente;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public DescripcionPedido getOrden() {
        return descripcionPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
