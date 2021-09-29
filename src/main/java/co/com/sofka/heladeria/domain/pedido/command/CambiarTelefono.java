package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class CambiarTelefono implements Command {

    private final IdPedido idPedido;
    private final Telefono telefono;

    public CambiarTelefono(IdPedido idPedido, Telefono telefono) {
        this.idPedido = idPedido;
        this.telefono = telefono;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
