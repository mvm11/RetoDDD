package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.IdMesero;

public class MeseroEliminado extends DomainEvent {

    private final IdHeladeria idheladeria;
    private final IdMesero idMesero;

    public MeseroEliminado(IdHeladeria idheladeria, IdMesero idMesero) {
        super("sofka.heladeria.heladeria.pedido.meseroeliminado");
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
