package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.IdMesero;

public class AñadirMesero implements Command {

    private final IdHeladeria idheladeria;
    private final IdMesero idMesero;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Funcion funcion;

    public AñadirMesero(IdHeladeria idheladeria, IdMesero idMesero, Nombre nombre, Telefono telefono, Funcion funcion) {
        this.idheladeria = idheladeria;
        this.idMesero = idMesero;
        this.nombre = nombre;
        this.telefono = telefono;
        this.funcion = funcion;
    }

    public IdHeladeria getIdheladeria() {
        return idheladeria;
    }

    public IdMesero getIdMesero() {
        return idMesero;
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
