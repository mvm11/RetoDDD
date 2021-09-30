package co.com.sofka.heladeria.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.pedido.values.IdHelado;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;

public class AñadirHelado implements Command {


    private final IdPedido idPedido;
    private final IdHelado idHelado;
    private final Sabor sabor;

    public AñadirHelado(IdPedido idPedido, IdHelado idHelado, Sabor sabor) {
        this.idPedido = idPedido;
        this.idHelado = idHelado;
        this.sabor = sabor;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdHelado getIdHelado() {
        return idHelado;
    }

    public Sabor getSabor() {
        return sabor;
    }
}
