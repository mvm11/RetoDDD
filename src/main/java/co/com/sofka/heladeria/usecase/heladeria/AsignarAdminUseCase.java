package co.com.sofka.heladeria.usecase.heladeria;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.heladeria.domain.heladeria.Heladeria;
import co.com.sofka.heladeria.domain.heladeria.command.AsignarAdmin;

public class AsignarAdminUseCase extends UseCase<RequestCommand<AsignarAdmin>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarAdmin> asignarAdminRequestCommand) {
        var command = asignarAdminRequestCommand.getCommand();
        var heladeria = Heladeria.from(command.getIdheladeria(), retrieveEvents(command.getIdheladeria().value()));
        heladeria.asignarAdmin(command.getIdheladeria(), command.getIdAdmin(), command.getNombre(), command.getTelefono(), command.getFuncion());
        emit().onSuccess(new ResponseEvents(heladeria.getUncommittedChanges()));
    }
}
