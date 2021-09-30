package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.Color;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.IdMesa;
import co.com.sofka.heladeria.domain.heladeria.values.Ubicacion;

public class AñadirMesa implements Command {

    private final IdHeladeria idheladeria;
    private final IdMesa idMesa;
    private final Color color;
    private final Ubicacion ubicacion;

    public AñadirMesa(IdHeladeria idheladeria, IdMesa idMesa, Color color, Ubicacion ubicacion) {
        this.idheladeria = idheladeria;
        this.idMesa = idMesa;
        this.color = color;
        this.ubicacion = ubicacion;
    }

    public IdHeladeria getIdheladeria() {
        return idheladeria;
    }

    public IdMesa getIdMesa() {
        return idMesa;
    }

    public Color getColor() {
        return color;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
