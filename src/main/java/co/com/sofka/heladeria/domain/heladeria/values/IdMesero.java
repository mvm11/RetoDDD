package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.Identity;

public class IdMesero extends Identity {

    public IdMesero() {
    }

    public IdMesero(String id) {
        super(id);
    }

    public static IdMesero of(String id) {
        return new IdMesero();
    }
}
