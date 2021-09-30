package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;

public class NombreHeladeriaCambiado extends DomainEvent {

    private final IdHeladeria idheladeria;
    private final NombreHeladeria nombreHeladeria;

    public NombreHeladeriaCambiado(IdHeladeria idheladeria, NombreHeladeria nombreHeladeria) {
        super("sofka.heladeria.heladeria.pedido.nombreheladeriacambiado");
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
