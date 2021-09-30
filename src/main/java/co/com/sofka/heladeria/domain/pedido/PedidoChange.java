package co.com.sofka.heladeria.domain.pedido;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.entity.Helado;
import co.com.sofka.heladeria.domain.pedido.events.*;
import co.com.sofka.heladeria.domain.pedido.values.BonoDescuento;

public class PedidoChange extends EventChange {

    public PedidoChange(Pedido pedido) {

        apply((PedidoCreado event) -> {
            pedido.idPedido = event.getIdPedido();
            pedido.fecha = event.getFecha();
            pedido.descripcionPedido = event.getOrden();
            pedido.cliente = event.getCliente();
        });

        apply((HeladoAñadido event) -> {
            int numHelados = pedido.helado.size();
            if (numHelados == 5) {
                throw new IllegalArgumentException("No puedes agregar más de 5 helados");
            }
            pedido.helado.add(new Helado(event.getIdHelado(), event.getSabor()));
        });

        apply((HeladoEliminado event) -> {
            pedido.helado.removeIf(helado -> helado.equals(event.getIdHelado()));
        });

        apply((DescripcionOrdenCambiada event) -> {
            pedido.descripcionPedido = event.getDescripcionPedido();
        });

        apply((ClienteAsignado event) -> {
            pedido.cliente = new Cliente(event.getIdCliente(), event.getNombre(), event.getTelefono());
        });

        apply((BonoDescuentoAñadido event) -> {
                if (pedido.cliente.identity().equals(event.getIdCliente())) {
                    pedido.cliente.bonoDescuento(new BonoDescuento(20000));
                }
        });
    }
}
