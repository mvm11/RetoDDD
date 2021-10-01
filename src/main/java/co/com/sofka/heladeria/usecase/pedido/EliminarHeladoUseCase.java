package co.com.sofka.heladeria.usecase.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.pedido.Pedido;
import co.com.sofka.heladeria.domain.pedido.command.EliminarHelado;

public class EliminarHeladoUseCase extends UseCase<RequestCommand<EliminarHelado>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EliminarHelado> eliminarHeladoRequestCommand) {
        var command = eliminarHeladoRequestCommand.getCommand();
        var pedido = Pedido.from(command.getIdPedido(), retrieveEvents(command.getIdHelado().value()));
        pedido.eliminarHelado(command.getIdPedido(), command.getIdHelado());
        emit().onSuccess(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
