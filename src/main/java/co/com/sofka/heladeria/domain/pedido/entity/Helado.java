package co.com.sofka.heladeria.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.pedido.values.HeladoId;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;

import java.util.Objects;

public class Helado extends Entity<HeladoId> {

    private Sabor sabor;

    public Helado(HeladoId heladoId, Sabor sabor) {
        super(heladoId);
        this.sabor = sabor;
    }


    public Sabor getSabor() {
        return sabor;
    }

    public void cambiarSabor(Sabor sabor) {
        this.sabor = Objects.requireNonNull(sabor);
    }

}
