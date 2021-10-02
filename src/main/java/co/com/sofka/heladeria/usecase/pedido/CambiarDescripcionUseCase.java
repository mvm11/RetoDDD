package co.com.sofka.heladeria.usecase.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.heladeria.domain.pedido.Pedido;
import co.com.sofka.heladeria.domain.pedido.events.DescripcionCambiada;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;

public class CambiarDescripcionUseCase extends UseCase<TriggeredEvent<DescripcionCambiada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<DescripcionCambiada> descripcionCambiadaTriggeredEvent) {
        var event = descripcionCambiadaTriggeredEvent.getDomainEvent();
        var pedido = Pedido.from(PedidoId.of(event.aggregateRootId()), retrieveEvents());
        pedido.cambiarDescripcion(event.getIdPedido(), event.getDescripcionPedido());
        emit().onSuccess(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
