package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;

public class CrearHeladeria implements Command {

    private final HeladeriaId heladeriaId;
    private final NombreHeladeria nombreHeladeria;
    private final TelefonoHeladeria telefonoHeladeria;

    public HeladeriaId getIdHeladeria() {
        return heladeriaId;
    }

    public NombreHeladeria getNombreHeladeria() {
        return nombreHeladeria;
    }

    public TelefonoHeladeria getTelefonoHeladeria() {
        return telefonoHeladeria;
    }

    public CrearHeladeria(HeladeriaId heladeriaId, NombreHeladeria nombreHeladeria, TelefonoHeladeria telefonoHeladeria) {
        this.heladeriaId = heladeriaId;
        this.nombreHeladeria = nombreHeladeria;
        this.telefonoHeladeria = telefonoHeladeria;

    }
}
