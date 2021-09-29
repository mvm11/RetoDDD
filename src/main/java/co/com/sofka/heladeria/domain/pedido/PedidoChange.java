package co.com.sofka.heladeria.domain.pedido;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.heladeria.domain.pedido.entity.Recibo;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.entity.Helado;
import co.com.sofka.heladeria.domain.pedido.events.*;
import co.com.sofka.heladeria.domain.pedido.values.BonoDescuento;

import java.util.ArrayList;

public class PedidoChange extends EventChange {

    public PedidoChange(Pedido pedido) {

        apply((PedidoCreado event) -> {
            pedido.idPedido = event.getIdPedido();
            pedido.fecha = event.getFecha();
            pedido.descripcionPedido = event.getOrden();
            pedido.cliente = new ArrayList<Cliente>();
        });

        apply((HeladoAñadido event) -> {
            int numHeladeros = pedido.helado.size();
            if (numHeladeros == 6) {
                throw new IllegalArgumentException("No puedes tener más de 6 heladeros");
            }
            pedido.helado.add(new Helado(event.getIdHelado(), event.getSabor()));
        });

        apply((CajeroAñadido event) -> {
            int numCajeros = pedido.recibo.size();
            if (numCajeros == 6) {
                throw new IllegalArgumentException("No puedes tener más de 6 cajeros");
            }
            pedido.recibo.add(new Recibo(event.getIdCajero(), event.getNombre(), event.getTelefono()));
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
