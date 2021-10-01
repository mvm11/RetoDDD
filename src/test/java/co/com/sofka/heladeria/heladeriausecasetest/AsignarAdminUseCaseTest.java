package co.com.sofka.heladeria.heladeriausecasetest;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.command.AsignarAdmin;
import co.com.sofka.heladeria.domain.heladeria.events.AdminAsignado;
import co.com.sofka.heladeria.domain.heladeria.values.AdminId;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.usecase.heladeria.AsignarAdminUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;


import static org.mockito.Mockito.mock;


public class AsignarAdminUseCaseTest  {

    private AsignarAdminUseCase asignarAdminUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        asignarAdminUseCase = new AsignarAdminUseCase();
        repository = mock(DomainEventRepository.class);
        asignarAdminUseCase.addRepository(repository);
    }

    @Test
    public void asignarAdmin(){
        var command = new AsignarAdmin(
                HeladeriaId.of("41"),
                AdminId.of("1"),
                new Nombre("Fausto"),
                new Telefono("3112304564"),
                new Funcion("Pagar salarios"));

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(asignarAdminUseCase, new RequestCommand<>(command))
                .orElseThrow();

        List<DomainEvent> events = response.getDomainEvents();
        AdminAsignado adminAsignado = (AdminAsignado) events.get(0);
        Assertions.assertEquals("Fausto", adminAsignado.getNombre().value());
        Assertions.assertEquals("3112304564", adminAsignado.getTelefono().value());
        Assertions.assertEquals("Pagar salarios", adminAsignado.getFuncion().value());
     }
}

