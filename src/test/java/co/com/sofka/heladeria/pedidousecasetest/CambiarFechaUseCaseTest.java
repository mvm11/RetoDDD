package co.com.sofka.heladeria.pedidousecasetest;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.events.DescripcionCambiada;
import co.com.sofka.heladeria.domain.pedido.events.FechaCambiada;
import co.com.sofka.heladeria.domain.pedido.events.PedidoCreado;
import co.com.sofka.heladeria.domain.pedido.values.ClienteId;
import co.com.sofka.heladeria.domain.pedido.values.Descripcion;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.usecase.pedido.CambiarDescripcionUseCase;
import co.com.sofka.heladeria.usecase.pedido.CambiarFechaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CambiarFechaUseCaseTest {
    private CambiarFechaUseCase cambiarFechaUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        cambiarFechaUseCase = new CambiarFechaUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarFechaUseCase.addRepository(repository);
    }

    @Test
    public void cambiarFecha(){
        var pedidoId = PedidoId.of("1");
        var event = new FechaCambiada(
                PedidoId.of("1"),
                new Fecha(01, 10, 2021)
        );
        event.setAggregateName(pedidoId.value());

        when(repository.getEventsBy("1")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(cambiarFechaUseCase, new TriggeredEvent<>(event))
                .orElseThrow();
        var events = response.getDomainEvents();
        FechaCambiada fechaCambiada = (FechaCambiada) events.get(0);
        Assertions.assertEquals(01, 10, 2021, fechaCambiada.getFecha().value());
    }

    public List<DomainEvent> events(){
        return List.of(new PedidoCreado(
                PedidoId.of("9"),
                new Fecha(01, 10, 2021),
                new Descripcion("chocolate"),
                new Cliente(
                        new ClienteId("1"),
                        new Nombre("Liz"),
                        new Telefono("3216107878")
                ))
        );
    }
}
