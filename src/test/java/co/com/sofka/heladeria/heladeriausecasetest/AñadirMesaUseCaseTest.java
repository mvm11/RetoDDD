package co.com.sofka.heladeria.heladeriausecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.command.AñadirMesa;
import co.com.sofka.heladeria.domain.heladeria.events.MesaAñadida;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.usecase.heladeria.AñadirMesaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;

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
            var command = new AñadirMesa(
                    HeladeriaId.of("22"),
                    MesaId.of("2"),
        new Color("Azul"),
        new Ubicacion("Esquina superior Izquierda"));

            var response = UseCaseHandler
                    .getInstance()
                    .setIdentifyExecutor("2")
                    .syncExecutor(añadirMesaUseCase, new RequestCommand<>(command))
                    .orElseThrow();

            List<DomainEvent> events = response.getDomainEvents();

            MesaAñadida mesaAñadida = (MesaAñadida)events.get(0);
            Assertions.assertEquals("Azul", mesaAñadida.getColor().value());
            Assertions.assertEquals("squina superior Izquierda", mesaAñadida.getUbicacion().value());
    }
}

