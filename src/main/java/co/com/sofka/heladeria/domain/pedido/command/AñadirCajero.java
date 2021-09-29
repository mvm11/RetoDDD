package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdHeladero;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class AñadirCajero implements Command {

    private final IdPedido idPedido;
    private final IdHeladero idHeladero;
    private final Nombre nombre;
    private final Telefono telefono;

    public AñadirCajero(IdPedido idPedido, IdHeladero idHeladero, Nombre nombre, Telefono telefono) {
        this.idPedido = idPedido;
        this.idHeladero = idHeladero;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public IdPedido getIdPedido() {
        return idPedido;
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
