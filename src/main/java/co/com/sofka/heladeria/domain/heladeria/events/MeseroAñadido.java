package co.com.sofka.heladeria.domain.heladeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.MeseroId;

public class MeseroAñadido extends DomainEvent {

    private final MeseroId meseroId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Funcion funcion;

    public MeseroAñadido(MeseroId meseroId, Nombre nombre, Telefono telefono, Funcion funcion) {
        super("sofka.heladeria.heladeria.pedido.meseroañadido");
        this.meseroId = meseroId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.funcion = funcion;
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
