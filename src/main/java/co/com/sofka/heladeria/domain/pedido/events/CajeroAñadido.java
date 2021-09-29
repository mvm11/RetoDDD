package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdCajero;

public class CajeroAñadido extends DomainEvent {
    private final IdCajero idCajero;
    private final Nombre nombre;
    private final Telefono telefono;

    public CajeroAñadido(IdCajero idCajero, Nombre nombre, Telefono telefono) {
        super("sofka.heladeria.domain.pedido.cajeroañadido");
        this.idCajero = idCajero;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public IdCajero getIdCajero() {
        return idCajero;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
