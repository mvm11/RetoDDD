package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.Identity;

public class MeseroId extends Identity {

    public MeseroId() {
    }

    public MeseroId(String id) {
        super(id);
    }

    public static MeseroId of(String id) {
        return new MeseroId();
    }
}
