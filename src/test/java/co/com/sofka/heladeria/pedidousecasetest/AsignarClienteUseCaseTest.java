package co.com.sofka.heladeria.pedidousecasetest;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
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
import co.com.sofka.heladeria.domain.pedido.command.AsignarCliente;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.events.ClienteAsignado;
import co.com.sofka.heladeria.domain.pedido.events.PedidoCreado;
import co.com.sofka.heladeria.domain.pedido.values.ClienteId;
import co.com.sofka.heladeria.domain.pedido.values.Descripcion;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.usecase.heladeria.AsignarAdminUseCase;
import co.com.sofka.heladeria.usecase.pedido.AsignarClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AsignarClienteUseCaseTest {
    private AsignarClienteUseCase asignarClienteUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        asignarClienteUseCase = new AsignarClienteUseCase();
        repository = mock(DomainEventRepository.class);
        asignarClienteUseCase.addRepository(repository);
    }

    @Test
    public void asignarAdmin() {

        //Arrange
        var command = new AsignarCliente(
                PedidoId.of("41"),
                new ClienteId("1"),
                new Nombre("Fausto"),
                new Telefono("3112304564"));
        when(repository.getEventsBy("1")).thenReturn(events());

        //Act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(asignarClienteUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        ClienteAsignado clienteAsignado = (ClienteAsignado) events.get(0);
        Assertions.assertEquals("1", clienteAsignado.getIdCliente().value());
        Assertions.assertEquals("Fausto", clienteAsignado.getNombre().value());
        Assertions.assertEquals("3112304564", clienteAsignado.getTelefono().value());

    }
    private List<DomainEvent> events(){
        return List.of(new PedidoCreado(
                PedidoId.of("21"),
                new Fecha(1, 10, 2021),
                new Descripcion("Hola"),
                new Cliente(
                        new ClienteId("1"),
                        new Nombre("Mariana"),
                        new Telefono("3216107879")
                )
        ));
    }
}

