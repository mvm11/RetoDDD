package co.com.sofka.heladeria.heladeriausecasetest;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.command.EliminarMesero;
import co.com.sofka.heladeria.domain.heladeria.events.*;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.usecase.heladeria.EliminarMeseroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EliminarMeseroUseCaseTest {

     private EliminarMeseroUseCase eliminarMeseroUseCase;

     @Mock
     private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        eliminarMeseroUseCase = new EliminarMeseroUseCase();
        repository = mock(DomainEventRepository.class);
        eliminarMeseroUseCase.addRepository(repository);
    }

    @Test
    public void eliminarMesa(){
        //Arrange
        var command = new EliminarMesero(
                        HeladeriaId.of("4"),
                        new MeseroId("4"));
        when(repository.getEventsBy("4")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("4")
                .syncExecutor(eliminarMeseroUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        MeseroEliminado meseroEliminada = (MeseroEliminado) events.get(0);

        // Assertions
        Assertions.assertEquals("4", meseroEliminada.getIdMesero().value());
    }

    private List<DomainEvent> events() {
       return List.of(

        new HeladeriaCreada(
                HeladeriaId.of("9"),
                new NombreHeladeria("ARTE DOLCE"),
                new TelefonoHeladeria("3147449819")
                ),
                new MeseroAñadido(
                                new MeseroId("4"),
                                new Nombre("Pablo"),
                                new Telefono("3147449819"),
                                new Funcion("Tomar pedidos"))
       );

    }
}


