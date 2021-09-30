package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.pedido.values.IdHelado;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;

public class HeladoEliminado extends DomainEvent {

    private final IdPedido idPedido;
    private final IdHelado idHelado;
    private final Sabor sabor;

    public HeladoEliminado(IdPedido idPedido, IdHelado idHelado, Sabor sabor) {
        super("sofka.heladeria.domain.pedido.heladoeliminado");
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

