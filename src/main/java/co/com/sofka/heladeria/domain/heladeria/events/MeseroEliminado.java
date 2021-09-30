package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.MeseroId;

public class MeseroEliminado extends DomainEvent {

    private final HeladeriaId idheladeria;
    private final MeseroId meseroId;

    public MeseroEliminado(HeladeriaId idheladeria, MeseroId meseroId) {
        super("sofka.heladeria.heladeria.pedido.meseroeliminado");
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
