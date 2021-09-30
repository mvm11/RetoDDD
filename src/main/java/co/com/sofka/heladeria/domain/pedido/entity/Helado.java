package co.com.sofka.heladeria.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.pedido.values.IdHelado;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;

import java.util.Objects;

public class Helado extends Entity<IdHelado> {

    private Sabor sabor;

    public Helado(IdHelado idHelado, Sabor sabor) {
        super(idHelado);
        this.sabor = sabor;
    }


    public Sabor getSabor() {
        return sabor;
    }

    public void cambiarSabor(Sabor sabor) {
        this.sabor = Objects.requireNonNull(sabor);
    }

}
