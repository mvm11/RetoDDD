package co.com.sofka.heladeria.domain.heladeria;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.heladeria.domain.heladeria.entity.Admin;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesa;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesero;
import co.com.sofka.heladeria.domain.heladeria.events.*;

import java.util.ArrayList;


public class HeladeriaChange extends EventChange {

    public HeladeriaChange(Heladeria heladeria) {

        apply((HeladeriaCreada event) -> {
            heladeria.idheladeria = event.getIdHeladeria();
            heladeria.nombreHeladeria = event.getNombreHeladeria();
            heladeria.telefonoHeladeria = event.getTelefonoHeladeria();
            heladeria.mesas = new ArrayList<>();
            heladeria.meseros = new ArrayList<>();
        });

        apply((AdminAsignado event) -> {
            heladeria.admin = new Admin(event.getIdAdmin(), event.getNombre(), event.getTelefono(), event.getFuncion());
        });

        apply((MeseroAñadido event) -> {
            int numMeseros = heladeria.meseros.size();
            if (numMeseros == 8) {
                throw new IllegalArgumentException("No puedes agregar más de 8 meseros");
            }
            heladeria.meseros.add(new Mesero(event.getIdMesero(), event.getNombre(), event.getTelefono(), event.getFuncion()));
        });

        apply((MeseroEliminado event) -> {
            heladeria.meseros.removeIf(mesero -> mesero.identity().equals(event.getIdMesero()));
        });

        apply((MesaAñadida event) -> {
            heladeria.mesas.add(new Mesa(event.getIdMesa(), event.getColor(), event.getUbicacion()));
            heladeria.mesas.add(new Mesa(event.getIdMesa(), event.getColor(), event.getUbicacion()));
            heladeria.mesas.add(new Mesa(event.getIdMesa(), event.getColor(), event.getUbicacion()));
        });

        apply((MesaEliminada event) -> {
            heladeria.mesas.removeIf(mesa -> mesa.identity().equals(event.getIdMesa()));
        });

        apply((NombreHeladeriaCambiado event) -> {
            heladeria.nombreHeladeria = event.getNombreHeladeria();
        });

        apply((TelefonoHeladeriaCambiado event) -> {
            heladeria.telefonoHeladeria = event.getTelefonoHeladeria();
        });
    }
}
