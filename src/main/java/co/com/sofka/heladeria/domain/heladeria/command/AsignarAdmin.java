package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.values.AdminId;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;


public class AsignarAdmin implements Command {

    private final HeladeriaId idheladeria;
    private final AdminId adminId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Funcion funcion;

    public AsignarAdmin(HeladeriaId idheladeria, AdminId adminId, Nombre nombre, Telefono telefono, Funcion funcion) {
        this.idheladeria = idheladeria;
        this.adminId = adminId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.funcion = funcion;
    }

    public HeladeriaId getIdheladeria() {
        return idheladeria;
    }

    public AdminId getIdAdmin() {
        return adminId;
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
