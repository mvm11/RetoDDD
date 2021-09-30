package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;

public class CambiarTelefonoHeladeria implements Command {

    private final IdHeladeria idheladeria;
    private final TelefonoHeladeria telefonoHeladeria;

    public CambiarTelefonoHeladeria(IdHeladeria idheladeria, TelefonoHeladeria telefonoHeladeria) {
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
