package co.com.sofka.heladeria.domain.heladeria.values;

import co.com.sofka.domain.generic.Identity;

public class MesaId extends Identity {

    public MesaId() {
    }

    public MesaId(String id) {
        super(id);
    }

    public static MesaId of(String id) {
        return new MesaId();
    }
}