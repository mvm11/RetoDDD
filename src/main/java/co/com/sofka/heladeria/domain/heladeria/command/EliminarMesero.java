package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.IdMesero;

public class EliminarMesero implements Command {

    private final IdHeladeria idheladeria;
    private final IdMesero idMesero;

    public EliminarMesero(IdHeladeria idheladeria, IdMesero idMesero) {
        this.idheladeria = idheladeria;
        this.idMesero = idMesero;
    }

    public IdHeladeria getIdheladeria() {
        return idheladeria;
    }

    public IdMesero getIdMesero() {
        return idMesero;
    }
}
