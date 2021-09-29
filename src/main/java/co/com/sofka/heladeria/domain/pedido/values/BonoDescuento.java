package co.com.sofka.heladeria.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class BonoDescuento implements ValueObject<Integer> {

    private final int bonoDescuento;

    public BonoDescuento(int bonoDescuento){
        this.bonoDescuento = bonoDescuento;
    }

    @Override
    public Integer value() {
        return bonoDescuento;
    }
}
