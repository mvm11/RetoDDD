package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdHelado;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class AñadirCajero implements Command {

    private final IdPedido idPedido;
    private final IdHelado idHelado;
    private final Nombre nombre;
    private final Telefono telefono;

    public AñadirCajero(IdPedido idPedido, IdHelado idHelado, Nombre nombre, Telefono telefono) {
        this.idPedido = idPedido;
        this.idHelado = idHelado;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public IdPedido getIdPedido() {
        return idPedido;
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
