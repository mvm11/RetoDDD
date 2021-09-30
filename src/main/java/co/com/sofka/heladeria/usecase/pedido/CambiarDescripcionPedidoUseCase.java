package co.com.sofka.heladeria.usecase.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.heladeria.domain.pedido.Pedido;
import co.com.sofka.heladeria.domain.pedido.events.DescripcionOrdenCambiada;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class CambiarDescripcionPedidoUseCase extends UseCase<TriggeredEvent<DescripcionOrdenCambiada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<DescripcionOrdenCambiada> descripcionOrdenCambiadaTriggeredEvent) {
        var event = descripcionOrdenCambiadaTriggeredEvent.getDomainEvent();
        var pedido = Pedido.from(IdPedido.of(event.aggregateRootId()), retrieveEvents());
        pedido.cambiarDescripcionPedido(event.getIdPedido(), event.getDescripcionPedido());
        emit().onSuccess(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
