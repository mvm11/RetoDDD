package co.com.sofka.heladeria.domain.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.entity.Cajero;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.entity.Helado;
import co.com.sofka.heladeria.domain.pedido.events.*;
import co.com.sofka.heladeria.domain.pedido.values.*;

import java.util.List;
import java.util.Objects;

public class Pedido extends AggregateEvent<IdPedido> {

    protected IdPedido idPedido;
    protected Orden orden;
    protected Fecha fecha;
    protected List <Cajero> cajero;
    protected List <Cliente> cliente;
    protected List <Helado> helado;

    private Pedido(IdPedido idPedido) {
        super(idPedido);
        subscribe(new PedidoChange(this));
    }

    public Pedido(IdPedido idPedido, Fecha fecha, Orden orden, Cliente cliente) {
        super(idPedido);
        appendChange(new PedidoCreado(idPedido, fecha, orden, cliente)).apply();
    }

    public static Pedido from(IdPedido idPedido, List<DomainEvent> events) {
        var pedido = new Pedido(idPedido);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    public void añadirHeladero(IdHelado idHelado, Nombre nombre, Telefono telefono){
        Objects.requireNonNull(idHelado);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new HeladeroAñadido(idHelado,nombre,telefono)).apply();
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


    public void EliminarHeladero(Helado helado){
        appendChange(new HeladeroEliminado(helado)).apply();
    }


    public void cambiarOrden(IdPedido idPedido, Orden orden){
        Objects.requireNonNull(idPedido);
        Objects.requireNonNull(orden);
        appendChange(new OrdenCambiada(idPedido, orden)).apply();
    }

    public void añadirBonoDescuento(IdCliente idCliente){
        appendChange(new BonoDescuentoAñadido(idCliente)).apply();
    }

    public Orden getOrden() {
        return orden;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public List<Cajero> getCajero() {
        return cajero;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public List<Helado> getHeladero() {
        return helado;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }
}
