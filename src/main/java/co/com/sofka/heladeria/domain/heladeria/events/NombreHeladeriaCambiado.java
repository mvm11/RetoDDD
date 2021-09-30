package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;

public class NombreHeladeriaCambiado extends DomainEvent {

    private final HeladeriaId idheladeria;
    private final NombreHeladeria nombreHeladeria;

    public NombreHeladeriaCambiado(HeladeriaId idheladeria, NombreHeladeria nombreHeladeria) {
        super("sofka.heladeria.heladeria.pedido.nombreheladeriacambiado");
        this.idheladeria = idheladeria;
        this.nombreHeladeria = nombreHeladeria;
    }

    public HeladeriaId getIdheladeria() {
        return idheladeria;
    }

    public NombreHeladeria getNombreHeladeria() {
        return nombreHeladeria;
    }
}
