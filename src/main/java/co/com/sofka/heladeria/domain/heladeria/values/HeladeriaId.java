package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.Identity;

public class HeladeriaId extends Identity {

    public HeladeriaId() {
    }
    public HeladeriaId(String id) {
        super(id);
    }
    public static HeladeriaId of(String id) {
        return new HeladeriaId();
    }

}
