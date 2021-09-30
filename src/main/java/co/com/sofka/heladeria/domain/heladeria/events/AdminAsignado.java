package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.values.IdAdmin;
import co.com.sofka.heladeria.domain.heladeria.values.IdHeladeria;

public class AdminAsignado extends DomainEvent {

    private final IdHeladeria idheladeria;
    private final IdAdmin idAdmin;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Funcion funcion;

    public AdminAsignado(IdHeladeria idheladeria, IdAdmin idAdmin, Nombre nombre, Telefono telefono, Funcion funcion) {
        super("sofka.heladeria.domain.heladeria.adminasignado");
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
