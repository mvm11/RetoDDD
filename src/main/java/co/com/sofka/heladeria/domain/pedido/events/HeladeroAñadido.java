package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdHelado;

public class HeladeroAñadido extends DomainEvent {

    private final IdHelado idHelado;
    private final Nombre nombre;
    private final Telefono telefono;

    public HeladeroAñadido(IdHelado idHelado, Nombre nombre, Telefono telefono) {
        super("sofka.heladeria.domain.pedido.heladeroañadido");
        this.idHelado = idHelado;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public IdHelado getIdHeladero() {
        return idHelado;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

}
