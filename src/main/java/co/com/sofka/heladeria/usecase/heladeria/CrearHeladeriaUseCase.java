package co.com.sofka.heladeria.usecase.heladeria;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.heladeria.Heladeria;
import co.com.sofka.heladeria.domain.heladeria.command.CrearHeladeria;

public class CrearHeladeriaUseCase extends UseCase<RequestCommand<CrearHeladeria>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearHeladeria> crearHeladeriaRequestCommand) {
        var command = crearHeladeriaRequestCommand.getCommand();
        var heladeria = new Heladeria(command.getIdHeladeria(), command.getNombreHeladeria(), command.getTelefonoHeladeria());
        emit().onSuccess(new ResponseEvents(heladeria.getUncommittedChanges()));
    }
}
