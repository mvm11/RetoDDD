package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdCliente extends Identity {
    public IdCliente() {
    }
    public IdCliente(String id) {
        super(id);
    }
    public static IdCliente of(String id) {
        return new IdCliente();
    }
}
