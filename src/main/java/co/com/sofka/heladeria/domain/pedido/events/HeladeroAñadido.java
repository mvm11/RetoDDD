package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdHeladero;

public class HeladeroAñadido extends DomainEvent {

    private final IdHeladero idHeladero;
    private final Nombre nombre;
    private final Telefono telefono;

    public HeladeroAñadido(IdHeladero idHeladero, Nombre nombre, Telefono telefono) {
        super("sofka.heladeria.domain.pedido.heladeroañadido");
        this.idHeladero = idHeladero;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public IdHeladero getIdHeladero() {
        return idHeladero;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

}
