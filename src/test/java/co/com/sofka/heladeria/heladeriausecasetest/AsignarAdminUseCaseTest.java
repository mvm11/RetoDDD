package co.com.sofka.heladeria.heladeriausecasetest;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.command.AsignarAdmin;
import co.com.sofka.heladeria.domain.heladeria.events.AdminAsignado;
import co.com.sofka.heladeria.domain.heladeria.events.HeladeriaCreada;
import co.com.sofka.heladeria.domain.heladeria.values.AdminId;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;
import co.com.sofka.heladeria.domain.pedido.Pedido;
import co.com.sofka.heladeria.domain.pedido.events.DescripcionCambiada;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.usecase.heladeria.AsignarAdminUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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
    public void asignarAdmin() {

        //Arrange
        var command = new AsignarAdmin(
                HeladeriaId.of("41"),
                new AdminId("1"),
                new Nombre("Fausto"),
                new Telefono("3112304564"),
                new Funcion("Pagar salarios"));
        when(repository.getEventsBy("41")).thenReturn(events());

        //Act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("41")
                .syncExecutor(asignarAdminUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        AdminAsignado adminAsignado = (AdminAsignado) events.get(0);
        Assertions.assertEquals("1", adminAsignado.getIdAdmin().value());
        Assertions.assertEquals("Fausto", adminAsignado.getNombre().value());
        Assertions.assertEquals("3112304564", adminAsignado.getTelefono().value());
        Assertions.assertEquals("Pagar salarios", adminAsignado.getFuncion().value());

    }
    private List<DomainEvent> events(){
        return List.of(new HeladeriaCreada(
                HeladeriaId.of("21"),
                new NombreHeladeria("Amor-Acuyá Gelato"),
                new TelefonoHeladeria("3147449815")
        ));
    }

    public static class CambiarDescripcionUseCase extends UseCase<TriggeredEvent<DescripcionCambiada>, ResponseEvents> {

        @Override
        public void executeUseCase(TriggeredEvent<DescripcionCambiada> descripcionCambiadaTriggeredEvent) {
            var event = descripcionCambiadaTriggeredEvent.getDomainEvent();
            var pedido = Pedido.from(PedidoId.of(event.aggregateRootId()), retrieveEvents());
            pedido.cambiarDescripcion(event.getIdPedido(), event.getDescripcionPedido());
            emit().onSuccess(new ResponseEvents(pedido.getUncommittedChanges()));
        }
    }
}

