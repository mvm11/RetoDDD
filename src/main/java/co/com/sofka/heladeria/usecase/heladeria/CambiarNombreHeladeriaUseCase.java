package co.com.sofka.heladeria.usecase.heladeria;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.heladeria.Heladeria;
import co.com.sofka.heladeria.domain.heladeria.command.CambiarNombreHeladeria;

public class CambiarNombreHeladeriaUseCase extends UseCase<RequestCommand<CambiarNombreHeladeria>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarNombreHeladeria> cambiarNombreHeladeriaRequestCommand) {
        var command = cambiarNombreHeladeriaRequestCommand.getCommand();
        var heladeria = Heladeria.from(command.getIdheladeria(), retrieveEvents(command.getNombreHeladeria().value()));
        heladeria.cambiarNombreHeladeria(command.getIdheladeria(), command.getNombreHeladeria());
        emit().onSuccess(new ResponseEvents(heladeria.getUncommittedChanges()));
    }
}
