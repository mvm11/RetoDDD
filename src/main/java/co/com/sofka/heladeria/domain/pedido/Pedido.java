package co.com.sofka.heladeria.domain.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
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
    protected Recibo recibo;
    protected Cliente cliente;
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

    public void añadirHelado(IdPedido idPedido, IdHelado idHelado, Sabor sabor){
        Objects.requireNonNull(idPedido);
        Objects.requireNonNull(idHelado);
        Objects.requireNonNull(sabor);
        appendChange(new HeladoAñadido(idPedido, idHelado, sabor)).apply();
    }

    public void EliminarHelado(IdPedido idPedido, IdHelado idHelado, Sabor sabor){
        appendChange(new HeladoEliminado(idPedido, idHelado, sabor)).apply();
    }

    public void asignarCliente(IdPedido idPedido, IdCliente idCliente, Nombre nombre, Telefono telefono){
        appendChange(new ClienteAsignado(idPedido, idCliente, nombre, telefono)).apply();
    }

    public void cambiarDescripcionPedido(IdPedido idPedido, DescripcionPedido descripcionPedido){
        Objects.requireNonNull(idPedido);
        Objects.requireNonNull(descripcionPedido);
        appendChange(new DescripcionOrdenCambiada(idPedido, descripcionPedido)).apply();
    }

    public void añadirBonoDescuento(IdCliente idCliente){
        appendChange(new BonoDescuentoAñadido(idCliente)).apply();
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public DescripcionPedido getDescripcionPedido() {
        return descripcionPedido;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Helado> getHelado() {
        return helado;
    }
}
