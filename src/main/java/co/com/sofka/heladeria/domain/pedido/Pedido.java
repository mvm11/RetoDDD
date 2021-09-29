package co.com.sofka.heladeria.domain.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.IdCliente;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

import java.util.List;
import java.util.Objects;

public class Pedido extends AggregateEvent<IdPedido> {

    protected Orden orden;
    protected Fecha fecha;
    protected Cajero cajero;
    protected Cliente cliente;
    protected Heladero heladero;

    public Pedido(IdPedido idPedido) {
        super(idPedido);
        subscribe(new PedidoChange(this));
    }

    public Pedido(IdPedido idPedido, Orden orden,  Fecha fecha) {
        super(idPedido);
        appendChange(new PedidoCreado(idPedido, idPedido, fecha)).apply();
    }

    public static Pedido from(IdPedido idPedido, List<DomainEvent> events) {
        var pedido = new Pedido(idPedido);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    public void añadirHeladero(IdHeladero idHeladero, Nombre nombre, Telefono telefono){
        Objects.requireNonNull(idHeladero);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new HeladeroAñadido(idHeladero,nombre,telefono)).apply();
    }

    public void añadirCajero(IdCajero idCajero, Nombre nombre, Telefono telefono){
        Objects.requireNonNull(idCajero);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new CajeroAñadido(idCajero,nombre,telefono)).apply();
    }

    public void añadirCliente(IdCliente idCliente, Nombre nombre, Telefono telefono){
        Objects.requireNonNull(idCliente);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new ClienteAñadido(idCliente,nombre,telefono)).apply();
    }

    public void añadirMensajeHeladero(Heladero heladero){
        appendChange(new MensajeHeladeroCreado(heladero)).apply();
    }

    public void añadirMensajeCajero(Cajero cajero){
        appendChange(new MensajeCajeroCreado(cajero)).apply();
    }

    public void añadirMensajeCliente(Cliente cliente){
        appendChange(new MensajeClienteCreado(cliente)).apply();
    }


    public void cambiarOrden(IdOrden idOrden, Orden orden){
        Objects.requireNonNull(idOrden);
        Objects.requireNonNull(orden);
        appendChange(new OrdenCambiada(idOrden, orden)).apply();
    }

    public Orden getOrden() {
        return orden;
    }

    public Fecha getFecha() {
        return fecha;
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
