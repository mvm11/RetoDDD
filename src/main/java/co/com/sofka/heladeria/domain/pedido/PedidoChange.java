package co.com.sofka.heladeria.domain.pedido;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.heladeria.domain.pedido.entity.Cajero;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.entity.Heladero;
import co.com.sofka.heladeria.domain.pedido.events.*;
import co.com.sofka.heladeria.domain.pedido.values.BonoDescuento;

import java.util.ArrayList;

public class PedidoChange extends EventChange {

    public PedidoChange(Pedido pedido) {

        apply((PedidoCreado event) -> {
            pedido.idPedido = event.getIdPedido();
            pedido.fecha = event.getFecha();
            pedido.orden = event.getOrden();
            pedido.cliente = new ArrayList<Cliente>();
        });

        apply((HeladeroAñadido event) -> {
            int numHeladeros = pedido.heladero.size();
            if (numHeladeros == 6) {
                throw new IllegalArgumentException("No puedes tener más de 6 heladeros");
            }
            pedido.heladero.add(new Heladero(event.getIdHeladero(), event.getNombre(), event.getTelefono()));
        });

        apply((CajeroAñadido event) -> {
            int numCajeros = pedido.cajero.size();
            if (numCajeros == 6) {
                throw new IllegalArgumentException("No puedes tener más de 6 cajeros");
            }
            pedido.cajero.add(new Cajero(event.getIdCajero(), event.getNombre(), event.getTelefono()));
        });

        apply((ClienteAñadido event) -> {
            pedido.cliente.add(new Cliente(event.getIdCliente(), event.getNombre(), event.getTelefono()));
        });

        apply((BonoDescuentoAñadido event) -> {
            for (Cliente cliente : pedido.cliente) {
                if (cliente.identity().equals(event.getIdCliente())) {
                    cliente.bonoDescuento(new BonoDescuento(20000));
                }
            }
        });


    }
}
