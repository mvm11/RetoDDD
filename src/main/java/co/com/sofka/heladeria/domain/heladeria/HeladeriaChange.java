package co.com.sofka.heladeria.domain.heladeria;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.heladeria.domain.heladeria.entity.Admin;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesa;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesero;
import co.com.sofka.heladeria.domain.heladeria.events.*;


public class HeladeriaChange extends EventChange {

    public HeladeriaChange(Heladeria heladeria) {

        apply((HeladeriaCreada event) -> {
            heladeria.idheladeria = event.getIdHeladeria();
            heladeria.nombreHeladeria = event.getNombreHeladeria();
            heladeria.telefonoHeladeria = event.getTelefonoHeladeria();
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
            heladeria.meseros.removeIf(mesero -> mesero.equals(event.getIdMesero()));
        });

        apply((MesaAñadida event) -> {
            int numMesas = heladeria.meseros.size();
            if (numMesas == 8) {
                throw new IllegalArgumentException("No puedes agregar más de 8 mesas");
            }
            heladeria.mesas.add(new Mesa(event.getIdMesa(), event.getColor(), event.getUbicacion()));
        });

        apply((MesaEliminada event) -> {
            heladeria.mesas.removeIf(mesa -> mesa.equals(event.getIdMesa()));
        });

        apply((NombreHeladeriaCambiado event) -> {
            heladeria.nombreHeladeria = event.getNombreHeladeria();
        });

        apply((TelefonoHeladeriaCambiado event) -> {
            heladeria.telefonoHeladeria = event.getTelefonoHeladeria();
        });
    }
}
