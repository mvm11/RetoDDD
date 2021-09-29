package co.com.sofka.heladeria.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.pedido.values.IdHelado;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;

public class HeladoAñadido extends DomainEvent {

    private final IdHelado idHelado;
    private final Sabor sabor;

    public HeladoAñadido(IdHelado idHelado, Sabor sabor) {
        super("sofka.heladeria.domain.pedido.heladoañadido");
        this.idHelado = idHelado;
        this.sabor = sabor;
    }

    public IdHelado getIdHelado() {
        return idHelado;
    }

    public Sabor getSabor() {
        return sabor;
    }
}
