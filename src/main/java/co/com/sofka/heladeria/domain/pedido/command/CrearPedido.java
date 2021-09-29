package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.entity.Cajero;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.entity.Heladero;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.Orden;

public class CrearPedido implements Command {

    private final IdPedido idPedido;
    private final Fecha fecha;
    private final Orden orden;
    private final Cajero cajero;
    private final Cliente cliente;
    private final Heladero heladero;

    public CrearPedido(IdPedido idPedido, Fecha fecha, Orden orden, Cajero cajero, Cliente cliente, Heladero heladero) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.orden = orden;
        this.cajero = cajero;
        this.cliente = cliente;
        this.heladero = heladero;
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

    public Cajero getCajero() {
        return cajero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Heladero getHeladero() {
        return heladero;
    }
}
