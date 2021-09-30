package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class ReciboId extends Identity{

    public ReciboId() {
    }

    public ReciboId(String id) {
        super(id);
    }

    public static ReciboId of(String id) {
        return new ReciboId();
    }

}
