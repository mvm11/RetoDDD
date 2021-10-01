package co.com.sofka.heladeria.heladeriausecasetest;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.command.EliminarMesa;
import co.com.sofka.heladeria.domain.heladeria.events.HeladeriaCreada;
import co.com.sofka.heladeria.domain.heladeria.events.MesaAñadida;
import co.com.sofka.heladeria.domain.heladeria.events.MesaEliminada;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.usecase.heladeria.EliminarMesaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EliminarMesaUseCaseTest{

     private EliminarMesaUseCase eliminarMesaUseCase;

     @Mock
     private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        eliminarMesaUseCase = new EliminarMesaUseCase();
        repository = mock(DomainEventRepository.class);
        eliminarMesaUseCase.addRepository(repository);
    }

    @Test
    public void eliminarMesa(){
        //Arrange
        var command = new EliminarMesa(
                        HeladeriaId.of("4"),
                        new MesaId("4"));
        when(repository.getEventsBy("4")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("4")
                .syncExecutor(eliminarMesaUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        MesaEliminada mesaEliminada = (MesaEliminada) events.get(0);

        Assertions.assertEquals("4", mesaEliminada.getIdMesa().value());
    }

    private List<DomainEvent> events() {
       return List.of(

        // se crea heladeria
        new HeladeriaCreada(
                HeladeriaId.of("9"),
                new NombreHeladeria("ARTE DOLCE"),
                new TelefonoHeladeria("3147449819")
                ),
                new MesaAñadida(
                                new MesaId("4"),
                                new Color("Rojo"),
                                new Ubicacion("Esquina inferior derecha"))
       );

    }
}


