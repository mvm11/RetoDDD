package co.com.sofka.heladeria.heladeriausecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.heladeria.command.CrearHeladeria;
import co.com.sofka.heladeria.domain.heladeria.events.HeladeriaCreada;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;
import co.com.sofka.heladeria.domain.heladeria.values.TelefonoHeladeria;
import co.com.sofka.heladeria.usecase.heladeria.CrearHeladeriaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrearHeladeriaUseCaseTest {

    private CrearHeladeriaUseCase crearHeladeriaUseCase;

    @BeforeEach
    public void setup() {
        crearHeladeriaUseCase = new CrearHeladeriaUseCase();
    }

    @Test
    public void crearHeladeria() {
        var command = new CrearHeladeria(
                HeladeriaId.of("13"),
                new NombreHeladeria("Crepes & Waffles"),
                new TelefonoHeladeria("3003452213"));

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("13")
                .syncExecutor(crearHeladeriaUseCase, new RequestCommand<>(command))
                .orElseThrow();

        List<DomainEvent> events = response.getDomainEvents();
        HeladeriaCreada heladeriaCreada = (HeladeriaCreada) events.get(0);
        Assertions.assertEquals("Crepes & Waffles", heladeriaCreada.getNombreHeladeria().value());
        Assertions.assertEquals("3003452213", heladeriaCreada.getTelefonoHeladeria().value());
    }
}
