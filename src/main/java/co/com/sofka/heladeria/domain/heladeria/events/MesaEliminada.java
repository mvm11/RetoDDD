package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.IdMesa;

public class MesaEliminada extends DomainEvent {

    private final IdHeladeria idheladeria;
    private final IdMesa idMesa;

    public MesaEliminada(IdHeladeria idheladeria, IdMesa idMesa) {
        super("sofka.heladeria.heladeria.pedido.mesaeliminada");
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
