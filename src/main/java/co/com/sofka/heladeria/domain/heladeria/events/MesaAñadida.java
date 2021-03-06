package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.values.Color;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.MesaId;
import co.com.sofka.heladeria.domain.heladeria.values.Ubicacion;

public class MesaAñadida extends DomainEvent {

    private final MesaId mesaId;
    private final Color color;
    private final Ubicacion ubicacion;


    public MesaAñadida(MesaId mesaId, Color color, Ubicacion ubicacion) {
        super("sofka.heladeria.heladeria.pedido.mensajeañadido");
        this.mesaId = mesaId;
        this.color = color;
        this.ubicacion = ubicacion;
    }

    public MesaId getIdMesa() {
        return mesaId;
    }

    public Color getColor() {
        return color;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
