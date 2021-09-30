package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.Identity;

public class IdMesa extends Identity {

    public IdMesa() {
    }

    public IdMesa(String id) {
        super(id);
    }

    public static IdMesa of(String id) {
        return new IdMesa();
    }
}