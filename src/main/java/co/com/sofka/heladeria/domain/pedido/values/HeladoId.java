package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class HeladoId extends Identity {

    public HeladoId() {
    }

    public HeladoId(String id) {
        super(id);
    }

    public static HeladoId of(String id) {
        return new HeladoId();
    }
}
