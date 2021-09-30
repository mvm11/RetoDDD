package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.Identity;

public class IdAdmin extends Identity {

    public IdAdmin() {
    }

    public IdAdmin(String id) {
        super(id);
    }

    public static IdAdmin of(String id) {
        return new IdAdmin();
    }
}
