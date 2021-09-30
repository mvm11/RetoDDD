package co.com.sofka.heladeria.domain.heladeria.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.heladeria.values.Color;
import co.com.sofka.heladeria.domain.heladeria.values.MesaId;
import co.com.sofka.heladeria.domain.heladeria.values.Ubicacion;


import java.util.Objects;

public class Mesa extends Entity<MesaId> {

    private Color color;
    private Ubicacion ubicacion;

    public Mesa(MesaId entityId, Color color, Ubicacion ubicacion) {
        super(entityId);
        this.color = color;
        this.ubicacion = ubicacion;
    }

    public Color getColor() {
        return color;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void cambiarColor(Color color) {
        this.color = Objects.requireNonNull(color);
    }
    public void cambiarSabor(Ubicacion ubicacion) {
        this.ubicacion = Objects.requireNonNull(ubicacion);
    }

}
