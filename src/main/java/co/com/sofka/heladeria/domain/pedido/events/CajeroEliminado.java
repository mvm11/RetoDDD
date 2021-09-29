package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.entity.Cajero;

public class CajeroEliminado extends DomainEvent {
    private final Cajero cajero;

    public CajeroEliminado(Cajero cajero) {
        super("sofka.heladeria.domain.pedido.mensajecajerocreado");
        this.cajero = cajero;
    }

    public Cajero getCajero() {
        return cajero;
    }
}
