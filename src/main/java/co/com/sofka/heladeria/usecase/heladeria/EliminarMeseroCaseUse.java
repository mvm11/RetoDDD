package co.com.sofka.heladeria.usecase.heladeria;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.heladeria.Heladeria;
import co.com.sofka.heladeria.domain.heladeria.command.EliminarMesero;


public class EliminarMeseroCaseUse extends UseCase<RequestCommand<EliminarMesero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EliminarMesero> eliminarMeseroRequestCommand) {
        var command = eliminarMeseroRequestCommand.getCommand();
        var heladeria = Heladeria.from(command.getIdheladeria(), retrieveEvents(command.getIdMesero().value()));
        heladeria.eliminarMesero(command.getIdheladeria(), command.getIdMesero());
        emit().onSuccess(new ResponseEvents(heladeria.getUncommittedChanges()));
    }
}
