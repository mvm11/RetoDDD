package co.com.sofka.heladeria.usecase.heladeria;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.heladeria.Heladeria;
import co.com.sofka.heladeria.domain.heladeria.command.EliminarMesa;

public class EliminarMesaUseCase extends UseCase<RequestCommand<EliminarMesa>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EliminarMesa> eliminarMesaRequestCommand) {
        var command = eliminarMesaRequestCommand.getCommand();
        var heladeria = Heladeria.from(command.getIdheladeria(), retrieveEvents(command.getIdMesa().value()));
        heladeria.eliminarMesa(command.getIdheladeria(), command.getIdMesa());
        emit().onSuccess(new ResponseEvents(heladeria.getUncommittedChanges()));
    }
}


