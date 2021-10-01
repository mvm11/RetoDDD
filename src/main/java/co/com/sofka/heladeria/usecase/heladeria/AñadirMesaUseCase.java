package co.com.sofka.heladeria.usecase.heladeria;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.heladeria.Heladeria;
import co.com.sofka.heladeria.domain.heladeria.command.AñadirMesa;

public class AñadirMesaUseCase extends UseCase<RequestCommand<AñadirMesa>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AñadirMesa> añadirMesaRequestCommand) {
        var command = añadirMesaRequestCommand.getCommand();
        var heladeria = Heladeria.from(command.getIdheladeria(), retrieveEvents(command.getIdheladeria().value()));
        heladeria.añadirMesa(command.getIdMesa(), command.getColor(), command.getUbicacion());
        emit().onSuccess(new ResponseEvents(heladeria.getUncommittedChanges()));
    }
}
