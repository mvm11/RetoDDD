package co.com.sofka.heladeria.usecase.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.heladeria.domain.pedido.Pedido;
import co.com.sofka.heladeria.domain.pedido.events.FechaCambiada;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

public class CambiarFechaUseCase extends UseCase<TriggeredEvent<FechaCambiada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<FechaCambiada> fechaCambiadaTriggeredEvent) {
        var event = fechaCambiadaTriggeredEvent.getDomainEvent();
        var pedido = Pedido.from(IdPedido.of(event.aggregateRootId()), retrieveEvents());
        pedido.cambiarFecha(event.getIdPedido(), event.getFecha());
        emit().onSuccess(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
