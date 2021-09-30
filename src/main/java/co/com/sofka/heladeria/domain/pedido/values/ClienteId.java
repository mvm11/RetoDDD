package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {
    public ClienteId() {
    }
    public ClienteId(String id) {
        super(id);
    }
    public static ClienteId of(String id) {
        return new ClienteId();
    }
}
