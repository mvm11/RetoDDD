package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.IdCliente;

public class bonoDescuentoAñadido extends DomainEvent {
    private final IdCliente idCliente;

    public bonoDescuentoAñadido(IdCliente idCliente) {
        super("sofka.heladeria.domain.pedido.bonodescuentoañadido");
        this.idCliente = idCliente;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }
}
