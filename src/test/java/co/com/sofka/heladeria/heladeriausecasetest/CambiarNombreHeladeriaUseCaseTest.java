package co.com.sofka.heladeria.heladeriausecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.command.CambiarNombreHeladeria;
import co.com.sofka.heladeria.domain.heladeria.events.HeladeriaCreada;
import co.com.sofka.heladeria.domain.heladeria.events.NombreHeladeriaCambiado;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;
import co.com.sofka.heladeria.usecase.heladeria.CambiarNombreHeladeriaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CambiarNombreHeladeriaUseCaseTest {

    private CambiarNombreHeladeriaUseCase cambiarNombreHeladeriaUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        cambiarNombreHeladeriaUseCase = new CambiarNombreHeladeriaUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarNombreHeladeriaUseCase.addRepository(repository);
    }

    @Test
     void cambiarNombreHeladeria() {

        var command = new CambiarNombreHeladeria(
                HeladeriaId.of("11"),
                new NombreHeladeria("Soft Touch")
        );

        when(repository.getEventsBy("11")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("11")
                .syncExecutor(cambiarNombreHeladeriaUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();
        NombreHeladeriaCambiado nombreHeladeriaCambiado = (NombreHeladeriaCambiado) events.get(0);
        Assertions.assertEquals("Soft Touch", nombreHeladeriaCambiado.getNombreHeladeria().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new HeladeriaCreada(HeladeriaId.of("11"),
                        new NombreHeladeria("Almos"),
                        new TelefonoHeladeria("3006107833")
                ));
    }
}
