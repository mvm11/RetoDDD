package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.Orden;

public class PedidoCreado extends DomainEvent {


    private final IdPedido idPedido;
    private final Fecha fecha;
    private final Orden orden;
    private final Cliente cliente;

    public PedidoCreado(IdPedido idPedido, Fecha fecha, Orden orden, Cliente cliente) {
        super("domain.pedido.pedidocreado");
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
