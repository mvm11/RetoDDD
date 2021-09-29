package co.com.sofka.heladeria.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.pedido.values.IdHelado;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;

public class Helado extends Entity<IdHelado> {

    private Sabor sabor;

    public Helado(IdHelado idHelado, Sabor sabor) {
        super(idHelado);
        this.sabor = sabor;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public void cambiarSabor(Sabor sabor) {
        setSabor(sabor);
    }

}
