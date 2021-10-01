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
    public void añadirMesero(){
        var command = new AñadirMesero(
                HeladeriaId.of("9"),
                MeseroId.of("32"),
                new Nombre("Sara"),
                new Telefono("3213213212"),
                new Funcion("Tomar pedidos"));

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("2")
                .syncExecutor(añadirMeseroUseCase, new RequestCommand<>(command))
                .orElseThrow();

        List<DomainEvent> events = response.getDomainEvents();

        MeseroAñadido meseroAñadido = (MeseroAñadido) events.get(0);
        Assertions.assertEquals("Sara", meseroAñadido.getNombre().value());
        Assertions.assertEquals("3213213212", meseroAñadido.getTelefono().value());
        Assertions.assertEquals("Tomar pedidos", meseroAñadido.getFuncion().value());
    }

}
