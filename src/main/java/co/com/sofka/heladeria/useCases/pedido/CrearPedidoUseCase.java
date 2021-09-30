package co.com.sofka.heladeria.useCases.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.pedido.Pedido;
import co.com.sofka.heladeria.domain.pedido.command.CrearPedido;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedido>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearPedido> crearPedidoRequestCommand) {
        var command = crearPedidoRequestCommand.getCommand();
        var pedido = new Pedido(command.getIdPedido(), command.getFecha(), command.getOrden(), command.getCliente());
        pedido.asignarCliente(command.getIdPedido(), command.getCliente().identity(), command.getCliente().getNombre(), command.getCliente().getTelefono());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
