package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;

public class CrearHeladeria implements Command {

    private final IdHeladeria idHeladeria;
    private final NombreHeladeria nombreHeladeria;
    private final TelefonoHeladeria telefonoHeladeria;

    public IdHeladeria getIdHeladeria() {
        return idHeladeria;
    }

    public NombreHeladeria getNombreHeladeria() {
        return nombreHeladeria;
    }

    public TelefonoHeladeria getTelefonoHeladeria() {
        return telefonoHeladeria;
    }

    public CrearHeladeria(IdHeladeria idHeladeria, NombreHeladeria nombreHeladeria, TelefonoHeladeria telefonoHeladeria) {
        this.idHeladeria = idHeladeria;
        this.nombreHeladeria = nombreHeladeria;
        this.telefonoHeladeria = telefonoHeladeria;

    }
}
