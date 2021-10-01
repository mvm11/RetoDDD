package co.com.sofka.heladeria.usecase.heladeria;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.heladeria.Heladeria;
import co.com.sofka.heladeria.domain.heladeria.command.AñadirMesero;

public class AñadirMeseroUseCase extends UseCase<RequestCommand<AñadirMesero>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AñadirMesero> añadirMeseroRequestCommand) {
        var command = añadirMeseroRequestCommand.getCommand();
        var heladeria = Heladeria.from(command.getIdheladeria(), retrieveEvents(command.getIdheladeria().value()));
        heladeria.añadirMesero(command.getIdMesero(), command.getNombre(), command.getTelefono(), command.getFuncion());
        emit().onSuccess(new ResponseEvents(heladeria.getUncommittedChanges()));
    }
}
