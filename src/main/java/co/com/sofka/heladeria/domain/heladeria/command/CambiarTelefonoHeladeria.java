package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;

public class CambiarTelefonoHeladeria implements Command {

    private final HeladeriaId idheladeria;
    private final TelefonoHeladeria telefonoHeladeria;

    public CambiarTelefonoHeladeria(HeladeriaId idheladeria, TelefonoHeladeria telefonoHeladeria) {
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
