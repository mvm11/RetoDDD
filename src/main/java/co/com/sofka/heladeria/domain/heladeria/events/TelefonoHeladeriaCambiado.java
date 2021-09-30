package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;

public class TelefonoHeladeriaCambiado extends DomainEvent {

    private final HeladeriaId idheladeria;
    private final TelefonoHeladeria telefonoHeladeria;

    public TelefonoHeladeriaCambiado(HeladeriaId idheladeria, TelefonoHeladeria telefonoHeladeria) {
        super("sofka.heladeria.heladeria.pedido.telefonoheladeriacambiado");
        this.idheladeria = idheladeria;
        this.telefonoHeladeria = telefonoHeladeria;
    }

    public HeladeriaId getIdheladeria() {
        return idheladeria;
    }

    public TelefonoHeladeria getTelefonoHeladeria() {
        return telefonoHeladeria;
    }
}
