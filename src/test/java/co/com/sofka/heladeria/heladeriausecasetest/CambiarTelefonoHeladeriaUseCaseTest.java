package co.com.sofka.heladeria.heladeriausecasetest;

import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.heladeria.domain.heladeria.command.CambiarTelefonoHeladeria;
import co.com.sofka.heladeria.usecase.heladeria.CambiarNombreHeladeriaUseCase;
import co.com.sofka.heladeria.usecase.heladeria.CambiarTelefonoHeladeriaUseCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class CambiarTelefonoHeladeriaUseCaseTest  {


    private CambiarTelefonoHeladeriaUseCase cambiarNombreHeladeriaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        cambiarNombreHeladeriaUseCase = new CambiarNombreHeladeriaUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarNombreHeladeriaUseCase.addRepository(repository);
    }

}
