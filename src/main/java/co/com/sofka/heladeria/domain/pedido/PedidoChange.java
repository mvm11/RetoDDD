package co.com.sofka.heladeria.domain.pedido;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.entity.Helado;
import co.com.sofka.heladeria.domain.pedido.events.*;

public class PedidoChange extends EventChange {

    public PedidoChange(Pedido pedido) {

        apply((PedidoCreado event) -> {
            pedido.pedidoId = event.getIdPedido();
            pedido.fecha = event.getFecha();
            pedido.descripcion = event.getOrden();
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
            pedido.helado.removeIf(helado -> helado.identity().equals(event.getIdHelado()));
        });

        apply((ClienteAsignado event) -> {
            pedido.cliente = new Cliente(event.getIdCliente(), event.getNombre(), event.getTelefono());
        });

        apply((DescripcionCambiada event) -> {
            pedido.descripcion = event.getDescripcionPedido();
        });

        apply((FechaCambiada event) -> {
            pedido.fecha = event.getFecha();
        });
    }
}
