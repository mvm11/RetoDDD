package co.com.sofka.heladeria.heladeriausecasetest;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.command.EliminarMesa;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesa;
import co.com.sofka.heladeria.domain.heladeria.events.HeladeriaCreada;
import co.com.sofka.heladeria.domain.heladeria.events.MesaEliminada;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.usecase.heladeria.EliminarMesaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
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
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(new Mesa(
                MesaId.of("1"),
                new Color("Rojo"),
                new Ubicacion("Esquina inferior derecha")));
        when(repository.getEventsBy("4")).thenReturn(events());

        var command = new RequestCommand<>(
                new EliminarMesa(
                        HeladeriaId.of("4"),
                        MesaId.of("4")));

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("4")
                .syncExecutor(eliminarMesaUseCase, command)
                .orElseThrow();

        var events = response.getDomainEvents();
        MesaEliminada mesaEliminada = (MesaEliminada) events.get(0);
    }

    private List<DomainEvent> events() {
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(new Mesa(
                MesaId.of("1"),
                new Color("Rojo"),
                new Ubicacion("Esquina inferior derecha")));
        return List.of(new HeladeriaCreada(HeladeriaId.of("4"),
                new NombreHeladeria("Cono de nieve"),
                new TelefonoHeladeria("1234567890")
                ));
    }
}


