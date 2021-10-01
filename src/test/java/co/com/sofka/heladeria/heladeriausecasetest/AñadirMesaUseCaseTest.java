package co.com.sofka.heladeria.heladeriausecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.command.AñadirMesa;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesa;
import co.com.sofka.heladeria.domain.heladeria.events.HeladeriaCreada;
import co.com.sofka.heladeria.domain.heladeria.events.MesaAñadida;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.usecase.heladeria.AñadirMesaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AñadirMesaUseCaseTest {
    private AñadirMesaUseCase añadirMesaUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        añadirMesaUseCase = new AñadirMesaUseCase();
        repository = mock(DomainEventRepository.class);
        añadirMesaUseCase.addRepository(repository);
    }

        @Test
        public void añadirMesa(){

        //Arrange
        var command = new AñadirMesa(
                HeladeriaId.of("22"),
                new MesaId("2"),
                new Color("Azul"),
                new Ubicacion("Esquina superior Izquierda"));
        when(repository.getEventsBy("22")).thenReturn(events());

        // Act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("22")
                .syncExecutor(añadirMesaUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        MesaAñadida mesaAñadida = (MesaAñadida)events.get(0);
        Assertions.assertEquals("2", mesaAñadida.getIdMesa().value());
        Assertions.assertEquals("Azul", mesaAñadida.getColor().value());
        Assertions.assertEquals("Esquina superior Izquierda", mesaAñadida.getUbicacion().value());
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

