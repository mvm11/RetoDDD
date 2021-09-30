package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.Color;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.MesaId;
import co.com.sofka.heladeria.domain.heladeria.values.Ubicacion;

public class AñadirMesa implements Command {

    private final HeladeriaId idheladeria;
    private final MesaId mesaId;
    private final Color color;
    private final Ubicacion ubicacion;

    public AñadirMesa(HeladeriaId idheladeria, MesaId mesaId, Color color, Ubicacion ubicacion) {
        this.idheladeria = idheladeria;
        this.mesaId = mesaId;
        this.color = color;
        this.ubicacion = ubicacion;
    }

    public HeladeriaId getIdheladeria() {
        return idheladeria;
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
