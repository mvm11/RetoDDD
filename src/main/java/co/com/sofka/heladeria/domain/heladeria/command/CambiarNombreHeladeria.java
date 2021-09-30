package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;

public class CambiarNombreHeladeria implements Command {

    private final IdHeladeria idheladeria;
    private final NombreHeladeria nombreHeladeria;

    public CambiarNombreHeladeria(IdHeladeria idheladeria, NombreHeladeria nombreHeladeria) {
        this.idheladeria = idheladeria;
        this.nombreHeladeria = nombreHeladeria;
    }

    public IdHeladeria getIdheladeria() {
        return idheladeria;
    }

    public NombreHeladeria getNombreHeladeria() {
        return nombreHeladeria;
    }
}
