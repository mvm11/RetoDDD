package co.com.sofka.heladeria.heladeriausecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.command.AñadirMesa;
import co.com.sofka.heladeria.domain.heladeria.command.AñadirMesero;
import co.com.sofka.heladeria.domain.heladeria.events.HeladeriaCreada;
import co.com.sofka.heladeria.domain.heladeria.events.MesaAñadida;
import co.com.sofka.heladeria.domain.heladeria.events.MeseroAñadido;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.usecase.heladeria.AñadirMesaUseCase;
import co.com.sofka.heladeria.usecase.heladeria.AñadirMeseroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AñadirMeseroUseCaseTest {
    private AñadirMeseroUseCase añadirMeseroUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        añadirMeseroUseCase = new AñadirMeseroUseCase();
        repository = mock(DomainEventRepository.class);
        añadirMeseroUseCase.addRepository(repository);
    }

        @Test
        public void añadirMesa(){

        //Arrange
        var command = new AñadirMesero(
                HeladeriaId.of("22"),
                new MeseroId("2"),
                new Nombre("Azul"),
                new Telefono("3216102121"),
                new Funcion("Barrer"));

        when(repository.getEventsBy("22")).thenReturn(events());

        // Act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("22")
                .syncExecutor(añadirMeseroUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //Asserts
        MeseroAñadido meseroAñadido = (MeseroAñadido) events.get(0);
        Assertions.assertEquals("2", meseroAñadido.getIdMesero().value());
        Assertions.assertEquals("Azul", meseroAñadido.getNombre().value());
        Assertions.assertEquals("3216102121", meseroAñadido.getTelefono().value());
        Assertions.assertEquals("Barrer", meseroAñadido.getFuncion().value());
    }

    private List<DomainEvent> events() {
        return List.of(new HeladeriaCreada(
                HeladeriaId.of("9"),
                new NombreHeladeria("ARTE DOLCE"),
                new TelefonoHeladeria("3216102121")
        )
        );
    }
}

