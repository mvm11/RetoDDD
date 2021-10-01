package co.com.sofka.heladeria.pedidousecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.pedido.command.CrearPedido;
import co.com.sofka.heladeria.domain.pedido.entity.Cliente;
import co.com.sofka.heladeria.domain.pedido.events.PedidoCreado;
import co.com.sofka.heladeria.domain.pedido.values.ClienteId;
import co.com.sofka.heladeria.domain.pedido.values.Descripcion;
import co.com.sofka.heladeria.domain.pedido.values.Fecha;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;
import co.com.sofka.heladeria.usecase.pedido.CrearPedidoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrearPedidoUseCaseTest {

    private CrearPedidoUseCase crearPedidoUseCase;

    @BeforeEach
    public void setup() {
        crearPedidoUseCase = new CrearPedidoUseCase();
    }

    @Test
    public void crearHeladeria() {
        var command = new CrearPedido(
                PedidoId.of("13"),
                new Fecha(01, 10, 21),
                new Descripcion("Hola"),
        new Cliente(
                new ClienteId("13"),
                new Nombre("Laura"),
                new Telefono("3216107878")));

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("13")
                .syncExecutor(crearPedidoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //Assetions
        List<DomainEvent> events = response.getDomainEvents();
        PedidoCreado pedidoCreado = (PedidoCreado) events.get(0);
        Assertions.assertEquals(01, 10, 21, pedidoCreado.getFecha().value());
        Assertions.assertEquals("Hola", pedidoCreado.getDescripcion().value());
    }
}
