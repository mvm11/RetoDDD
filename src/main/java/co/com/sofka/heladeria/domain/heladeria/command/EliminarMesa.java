package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.IdMesa;

public class EliminarMesa implements Command {

    private final IdHeladeria idheladeria;
    private final IdMesa idMesa;

    public EliminarMesa(IdHeladeria idheladeria, IdMesa idMesa) {
        this.idheladeria = idheladeria;
        this.idMesa = idMesa;
    }

    public IdHeladeria getIdheladeria() {
        return idheladeria;
    }

    public IdMesa getIdMesa() {
        return idMesa;
    }
}
