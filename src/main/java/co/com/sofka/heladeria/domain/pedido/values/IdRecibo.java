package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdRecibo extends Identity{

    public IdRecibo() {
    }

    public IdRecibo(String id) {
        super(id);
    }

    public static IdRecibo of(String id) {
        return new IdRecibo();
    }

}
