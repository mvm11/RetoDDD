package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdHeladero  extends Identity {

    public IdHeladero() {
    }

    public IdHeladero(String id) {
        super(id);
    }

    public static IdHeladero of(String id) {
        return new IdHeladero();
    }
}
