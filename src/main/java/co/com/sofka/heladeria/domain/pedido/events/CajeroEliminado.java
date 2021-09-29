package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.entity.Recibo;

public class CajeroEliminado extends DomainEvent {
    private final Recibo recibo;

    public CajeroEliminado(Recibo recibo) {
        super("sofka.heladeria.domain.pedido.mensajecajerocreado");
        this.recibo = recibo;
    }

    public Recibo getCajero() {
        return recibo;
    }
}
