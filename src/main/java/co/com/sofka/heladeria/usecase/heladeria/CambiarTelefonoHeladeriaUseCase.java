package co.com.sofka.heladeria.usecase.heladeria;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.Heladeria;
import co.com.sofka.heladeria.domain.heladeria.command.CambiarTelefonoHeladeria;

public class CambiarTelefonoHeladeriaUseCase extends UseCase<RequestCommand<CambiarTelefonoHeladeria>, ResponseEvents> implements Command {

    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoHeladeria> cambiarTelefonoHeladeriaRequestCommand) {
        var command = cambiarTelefonoHeladeriaRequestCommand.getCommand();
        var heladeria = Heladeria.from(command.getIdheladeria(), retrieveEvents(command.getIdheladeria().value()));
        heladeria.cambiarTelefonoHeladeria(command.getIdheladeria(), command.getTelefonoHeladeria());
        emit().onSuccess(new ResponseEvents(heladeria.getUncommittedChanges()));
    }
}
