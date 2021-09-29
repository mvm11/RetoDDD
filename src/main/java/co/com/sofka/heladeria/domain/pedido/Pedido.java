package co.com.sofka.heladeria.domain.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.entity.Recibo;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.entity.Helado;
import co.com.sofka.heladeria.domain.pedido.events.*;
import co.com.sofka.heladeria.domain.pedido.values.*;

import java.util.List;
import java.util.Objects;

public class Pedido extends AggregateEvent<IdPedido> {

    protected IdPedido idPedido;
    protected DescripcionPedido descripcionPedido;
    protected Fecha fecha;
    protected List <Recibo> recibo;
    protected List <Cliente> cliente;
    protected List <Helado> helado;

    private Pedido(IdPedido idPedido) {
        super(idPedido);
        subscribe(new PedidoChange(this));
    }

    public Pedido(IdPedido idPedido, Fecha fecha, DescripcionPedido descripcionPedido, Cliente cliente) {
        super(idPedido);
        appendChange(new PedidoCreado(idPedido, fecha, descripcionPedido, cliente)).apply();
    }

    public static Pedido from(IdPedido idPedido, List<DomainEvent> events) {
        var pedido = new Pedido(idPedido);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    public void añadirHelado(IdHelado idHelado, Sabor sabor){
        Objects.requireNonNull(idHelado);
        Objects.requireNonNull(sabor);
        appendChange(new HeladoAñadido(idHelado,sabor)).apply();
    }

    public void EliminarHelado(Helado helado){
        appendChange(new HeladeroEliminado(helado)).apply();
    }


    public void cambiarDescripcionPedido(IdPedido idPedido, DescripcionPedido descripcionPedido){
        Objects.requireNonNull(idPedido);
        Objects.requireNonNull(descripcionPedido);
        appendChange(new OrdenCambiada(idPedido, descripcionPedido)).apply();
    }

    public void asignarCliente(){

    }

    public void añadirBonoDescuento(IdCliente idCliente){
        appendChange(new BonoDescuentoAñadido(idCliente)).apply();
    }

    public DescripcionPedido getOrden() {
        return descripcionPedido;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public List<Recibo> getCajero() {
        return recibo;
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
