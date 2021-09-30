package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.MeseroId;

public class AñadirMesero implements Command {

    private final HeladeriaId idheladeria;
    private final MeseroId meseroId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Funcion funcion;

    public AñadirMesero(HeladeriaId idheladeria, MeseroId meseroId, Nombre nombre, Telefono telefono, Funcion funcion) {
        this.idheladeria = idheladeria;
        this.meseroId = meseroId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.funcion = funcion;
    }

    public HeladeriaId getIdheladeria() {
        return idheladeria;
    }

    public MeseroId getIdMesero() {
        return meseroId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Funcion getFuncion() {
        return funcion;
    }
}
