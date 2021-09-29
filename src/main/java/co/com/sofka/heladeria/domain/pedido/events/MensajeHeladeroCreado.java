package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.entity.Heladero;

public class MensajeHeladeroCreado extends DomainEvent {
   private final Heladero heladero;

    public MensajeHeladeroCreado(Heladero heladero) {
        super("sofka.heladeria.domain.pedido.mensajeheladerocreado");
        this.heladero = heladero;
    }

    public Heladero getHeladero() {
        return heladero;
    }
}
