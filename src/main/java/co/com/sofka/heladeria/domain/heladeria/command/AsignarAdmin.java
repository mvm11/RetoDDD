package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.values.IdAdmin;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;

public class AsignarAdmin implements Command {

    private final IdHeladeria idheladeria;
    private final IdAdmin idAdmin;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Funcion funcion;

    public AsignarAdmin(IdHeladeria idheladeria, IdAdmin idAdmin, Nombre nombre, Telefono telefono, Funcion funcion) {
        this.idheladeria = idheladeria;
        this.idAdmin = idAdmin;
        this.nombre = nombre;
        this.telefono = telefono;
        this.funcion = funcion;
    }

    public IdHeladeria getIdheladeria() {
        return idheladeria;
    }

    public IdAdmin getIdAdmin() {
        return idAdmin;
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
