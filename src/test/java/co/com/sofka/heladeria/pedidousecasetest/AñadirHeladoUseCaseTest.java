package co.com.sofka.heladeria.pedidousecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.command.AñadirMesa;
import co.com.sofka.heladeria.domain.heladeria.events.HeladeriaCreada;
import co.com.sofka.heladeria.domain.heladeria.events.MesaAñadida;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.domain.pedido.command.AñadirHelado;
import co.com.sofka.heladeria.domain.pedido.events.HeladoAñadido;
import co.com.sofka.heladeria.domain.pedido.values.HeladoId;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.domain.pedido.values.Sabor;
import co.com.sofka.heladeria.usecase.heladeria.AñadirMesaUseCase;
import co.com.sofka.heladeria.usecase.pedido.AñadirHeladoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AñadirHeladoUseCaseTest {
    private AñadirHeladoUseCase añadirHeladoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        añadirHeladoUseCase = new AñadirHeladoUseCase();
        repository = mock(DomainEventRepository.class);
        añadirHeladoUseCase.addRepository(repository);
    }
        @Test
        public void añadirHelado(){

        //Arrange
        var command = new AñadirHelado(
                PedidoId.of("22"),
                new HeladoId("2"),
                new Sabor("chocolate"));
        when(repository.getEventsBy("2")).thenReturn(events());

        // Act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("2")
                .syncExecutor(añadirHeladoUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        HeladoAñadido heladoAñadido = (HeladoAñadido) events.get(0);
        Assertions.assertEquals("2", heladoAñadido.getIdHelado().value());
        Assertions.assertEquals("chocolate", heladoAñadido.getSabor().value());
    }

    private List<DomainEvent> events() {
        return List.of(new HeladeriaCreada(
                HeladeriaId.of("9"),
                new NombreHeladeria("ARTE DOLCE"),
                new TelefonoHeladeria("3147449819")
        )
        );
    }
}

