package co.com.sofka.heladeria.usecase.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.pedido.Pedido;
import co.com.sofka.heladeria.domain.pedido.command.AsignarCliente;


public class AsignarClienteUseCase  extends UseCase<RequestCommand<AsignarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarCliente> asignarClienteRequestCommand) {
        var command = asignarClienteRequestCommand.getCommand();
        var pedido = Pedido.from(command.getIdPedido(), retrieveEvents(command.getIdCliente().value()));
        pedido.asignarCliente(command.getIdPedido(), command.getIdCliente(), command.getNombre(), command.getTelefono());
        emit().onSuccess(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
