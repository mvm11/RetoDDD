package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.MesaId;

public class MesaEliminada extends DomainEvent {

    private final HeladeriaId idheladeria;
    private final MesaId mesaId;

    public MesaEliminada(HeladeriaId idheladeria, MesaId mesaId) {
        super("sofka.heladeria.heladeria.pedido.mesaeliminada");
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
