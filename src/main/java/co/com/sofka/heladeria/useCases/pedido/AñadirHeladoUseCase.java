package co.com.sofka.heladeria.useCases.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.pedido.Pedido;
import co.com.sofka.heladeria.domain.pedido.command.AñadirHelado;

public class AñadirHeladoUseCase extends UseCase<RequestCommand<AñadirHelado>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AñadirHelado> añadirHeladoRequestCommand) {
        var command = añadirHeladoRequestCommand.getCommand();
        var pedido = Pedido.from(command.getIdPedido(), retrieveEvents(command.getIdHelado().value()));
        pedido.añadirHelado(command.getIdPedido(), command.getIdHelado(), command.getSabor());
        emit().onSuccess(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
