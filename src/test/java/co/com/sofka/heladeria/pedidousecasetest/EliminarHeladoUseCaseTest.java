package co.com.sofka.heladeria.pedidousecasetest;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.command.EliminarMesa;
import co.com.sofka.heladeria.domain.heladeria.events.HeladeriaCreada;
import co.com.sofka.heladeria.domain.heladeria.events.MesaAñadida;
import co.com.sofka.heladeria.domain.heladeria.events.MesaEliminada;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.domain.pedido.command.EliminarHelado;
import co.com.sofka.heladeria.domain.pedido.events.HeladoEliminado;
import co.com.sofka.heladeria.domain.pedido.values.HeladoId;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.usecase.heladeria.EliminarMesaUseCase;
import co.com.sofka.heladeria.usecase.pedido.EliminarHeladoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EliminarHeladoUseCaseTest {

     private EliminarHeladoUseCase eliminarHeladoUseCase;

     @Mock
     private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        eliminarHeladoUseCase = new EliminarHeladoUseCase();
        repository = mock(DomainEventRepository.class);
        eliminarHeladoUseCase.addRepository(repository);
    }

    @Test
    public void eliminarHelado(){
        //Arrange
        var command = new EliminarHelado(
                        PedidoId.of("4"),
                        new HeladoId("4"));
        when(repository.getEventsBy("4")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("4")
                .syncExecutor(eliminarHeladoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        HeladoEliminado heladoEliminado = (HeladoEliminado) events.get(0);
        Assertions.assertEquals("4", heladoEliminado.getIdHelado().value());
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


