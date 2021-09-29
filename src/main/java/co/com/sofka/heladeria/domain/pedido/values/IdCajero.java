package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdCajero extends Identity{

    public IdCajero() {
    }

    public IdCajero(String id) {
        super(id);
    }

    public static IdCajero of(String id) {
        return new IdCajero();
    }

}
