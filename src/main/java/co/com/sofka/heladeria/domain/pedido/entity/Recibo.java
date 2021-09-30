package co.com.sofka.heladeria.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.pedido.values.IdRecibo;
import co.com.sofka.heladeria.domain.pedido.values.Precio;

import java.util.Objects;


public class Recibo extends Entity<IdRecibo> {

    private Precio precio;

    public Recibo(IdRecibo idRecibo, Precio precio) {
        super(idRecibo);
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void cambiarPrecio(Precio precio) {
        this.precio = Objects.requireNonNull(precio);
    }
}
