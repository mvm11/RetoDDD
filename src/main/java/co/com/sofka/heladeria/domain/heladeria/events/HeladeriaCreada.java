package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;

public class HeladeriaCreada extends DomainEvent {

    private final HeladeriaId heladeriaId;
    private final NombreHeladeria nombreHeladeria;
    private final TelefonoHeladeria telefonoHeladeria;

    public HeladeriaCreada(HeladeriaId heladeriaId, NombreHeladeria nombreHeladeria, TelefonoHeladeria telefonoHeladeria) {
        super("sofka.heladeria.domain.heladeria.heladeriacreada");
        this.heladeriaId = heladeriaId;
        this.nombreHeladeria = nombreHeladeria;
        this.telefonoHeladeria = telefonoHeladeria;
    }

    public HeladeriaId getIdHeladeria() {
        return heladeriaId;
    }

    public NombreHeladeria getNombreHeladeria() {
        return nombreHeladeria;
    }

    public TelefonoHeladeria getTelefonoHeladeria() {
        return telefonoHeladeria;
    }
}
