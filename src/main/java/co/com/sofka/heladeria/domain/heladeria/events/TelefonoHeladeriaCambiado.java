package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;

public class TelefonoHeladeriaCambiado extends DomainEvent {

    private final IdHeladeria idheladeria;
    private final TelefonoHeladeria telefonoHeladeria;

    public TelefonoHeladeriaCambiado(IdHeladeria idheladeria, TelefonoHeladeria telefonoHeladeria) {
        super("sofka.heladeria.heladeria.pedido.telefonoheladeriacambiado");
        this.idheladeria = idheladeria;
        this.telefonoHeladeria = telefonoHeladeria;
    }

    public IdHeladeria getIdheladeria() {
        return idheladeria;
    }

    public TelefonoHeladeria getTelefonoHeladeria() {
        return telefonoHeladeria;
    }
}
