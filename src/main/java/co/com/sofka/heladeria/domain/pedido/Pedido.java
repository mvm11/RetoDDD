package co.com.sofka.heladeria.domain.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.pedido.entity.Recibo;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.entity.Helado;
import co.com.sofka.heladeria.domain.pedido.events.*;
import co.com.sofka.heladeria.domain.pedido.values.*;

import java.util.List;
import java.util.Objects;

public class Pedido extends AggregateEvent<PedidoId> {

    protected PedidoId pedidoId;
    protected Descripcion descripcion;
    protected Fecha fecha;
    protected Recibo recibo;
    protected Cliente cliente;
    protected List <Helado> helado;

    private Pedido(PedidoId pedidoId) {
        super(pedidoId);
        subscribe(new PedidoChange(this));
    }

    public Pedido(PedidoId pedidoId, Fecha fecha, Descripcion descripcion, Cliente cliente) {
        super(pedidoId);
        appendChange(new PedidoCreado(pedidoId, fecha, descripcion, cliente)).apply();
    }

    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events) {
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    public void añadirHelado(PedidoId pedidoId, HeladoId heladoId, Sabor sabor){
        Objects.requireNonNull(pedidoId);
        Objects.requireNonNull(heladoId);
        Objects.requireNonNull(sabor);
        appendChange(new HeladoAñadido(pedidoId, heladoId, sabor)).apply();
    }

    public void eliminarHelado(PedidoId pedidoId, HeladoId heladoId){
        appendChange(new HeladoEliminado(pedidoId, heladoId)).apply();
    }

    public void asignarCliente(PedidoId pedidoId, ClienteId clienteId, Nombre nombre, Telefono telefono){
        appendChange(new ClienteAsignado(pedidoId, clienteId,nombre,telefono)).apply();
    }

    public void cambiarDescripcion(PedidoId pedidoId, Descripcion descripcion){
        Objects.requireNonNull(pedidoId);
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionCambiada(pedidoId, descripcion)).apply();
    }

    public void cambiarFecha(PedidoId pedidoId, Fecha fecha){
        Objects.requireNonNull(pedidoId);
        Objects.requireNonNull(fecha);
        appendChange(new FechaCambiada(pedidoId, fecha)).apply();
    }


    public PedidoId getIdPedido() {
        return pedidoId;
    }

    public Descripcion getDescripcionPedido() {
        return descripcion;
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
