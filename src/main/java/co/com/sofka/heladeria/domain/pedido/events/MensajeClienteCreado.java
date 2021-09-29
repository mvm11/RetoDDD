package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;

public class MensajeClienteCreado extends DomainEvent {
    private final Cliente cliente;

    public MensajeClienteCreado(Cliente cliente) {
        super("sofka.heladeria.domain.pedido.clientecreado");
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
