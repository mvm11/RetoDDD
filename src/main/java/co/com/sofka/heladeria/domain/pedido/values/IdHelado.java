package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdHelado extends Identity {

    public IdHelado() {
    }

    public IdHelado(String id) {
        super(id);
    }

    public static IdHelado of(String id) {
        return new IdHelado();
    }
}
