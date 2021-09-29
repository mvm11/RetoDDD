package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.entity.Helado;

public class HeladeroEliminado extends DomainEvent {
   private final Helado helado;

    public HeladeroEliminado(Helado helado) {
        super("sofka.heladeria.domain.pedido.heladeroeliminado");
        this.helado = helado;
    }

    public Helado getHeladero() {
        return helado;
    }
}
