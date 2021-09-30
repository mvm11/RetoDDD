package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.MeseroId;

public class EliminarMesero implements Command {

    private final HeladeriaId idheladeria;
    private final MeseroId meseroId;

    public EliminarMesero(HeladeriaId idheladeria, MeseroId meseroId) {
        this.idheladeria = idheladeria;
        this.meseroId = meseroId;
    }

    public HeladeriaId getIdheladeria() {
        return idheladeria;
    }

    public MeseroId getIdMesero() {
        return meseroId;
    }
}
