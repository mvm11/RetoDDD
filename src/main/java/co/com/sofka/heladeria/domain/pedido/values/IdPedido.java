package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdPedido extends Identity {
    public IdPedido() {
    }
    public IdPedido(String id) {
        super(id);
    }
    public static IdPedido of(String id) {
        return new IdPedido();
    }
}
