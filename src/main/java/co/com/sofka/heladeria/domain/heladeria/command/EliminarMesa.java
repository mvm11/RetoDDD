package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.MesaId;

public class EliminarMesa implements Command {

    private final HeladeriaId idheladeria;
    private final MesaId mesaId;

    public EliminarMesa(HeladeriaId idheladeria, MesaId mesaId) {
        this.idheladeria = idheladeria;
        this.mesaId = mesaId;
    }

    public HeladeriaId getIdheladeria() {
        return idheladeria;
    }

    public MesaId getIdMesa() {
        return mesaId;
    }
}
