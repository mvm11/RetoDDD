package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;

public class ClienteEliminado extends DomainEvent {
    private final Cliente cliente;

    public ClienteEliminado(Cliente cliente) {
        super("sofka.heladeria.domain.pedido.clientecreado");
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
