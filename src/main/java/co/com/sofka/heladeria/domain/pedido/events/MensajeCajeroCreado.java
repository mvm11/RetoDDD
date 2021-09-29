package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.entity.Cajero;

public class MensajeCajeroCreado extends DomainEvent {
    private final Cajero cajero;

    public MensajeCajeroCreado(Cajero cajero) {
        super("sofka.heladeria.domain.pedido.mensajecajerocreado");
        this.cajero = cajero;
    }

    public Cajero getCajero() {
        return cajero;
    }
}
