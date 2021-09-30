package co.com.sofka.heladeria.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.heladeria.domain.pedido.values.ReciboId;
import co.com.sofka.heladeria.domain.pedido.values.Precio;

import java.util.Objects;


public class Recibo extends Entity<ReciboId> {

    private Precio precio;

    public Recibo(ReciboId reciboId, Precio precio) {
        super(reciboId);
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void cambiarPrecio(Precio precio) {
        this.precio = Objects.requireNonNull(precio);
    }
}
