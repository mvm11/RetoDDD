package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;

public class HeladeriaCreada extends DomainEvent {

    private final IdHeladeria idHeladeria;
    private final NombreHeladeria nombreHeladeria;
    private final TelefonoHeladeria telefonoHeladeria;

    public HeladeriaCreada(IdHeladeria idHeladeria, NombreHeladeria nombreHeladeria, TelefonoHeladeria telefonoHeladeria) {
        super("sofka.heladeria.domain.heladeria.heladeriacreada");
        this.idHeladeria = idHeladeria;
        this.nombreHeladeria = nombreHeladeria;
        this.telefonoHeladeria = telefonoHeladeria;
    }

    public IdHeladeria getIdHeladeria() {
        return idHeladeria;
    }

    public NombreHeladeria getNombreHeladeria() {
        return nombreHeladeria;
    }

    public TelefonoHeladeria getTelefonoHeladeria() {
        return telefonoHeladeria;
    }
}
