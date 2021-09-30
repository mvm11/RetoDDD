package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.Identity;

public class AdminId extends Identity {

    public AdminId() {
    }

    public AdminId(String id) {
        super(id);
    }

    public static AdminId of(String id) {
        return new AdminId();
    }

}
