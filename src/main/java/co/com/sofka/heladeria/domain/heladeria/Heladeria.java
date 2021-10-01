package co.com.sofka.heladeria.domain.heladeria;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericvalues.Funcion;
import co.com.sofka.heladeria.domain.genericvalues.Nombre;
import co.com.sofka.heladeria.domain.genericvalues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.events.*;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.domain.heladeria.entity.Admin;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesa;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesero;
import co.com.sofka.heladeria.domain.pedido.values.PedidoId;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Heladeria extends AggregateEvent<HeladeriaId> {

    protected HeladeriaId idheladeria;
    protected Set <PedidoId> pedidoIds;
    protected NombreHeladeria nombreHeladeria;
    protected TelefonoHeladeria telefonoHeladeria;
    protected Admin admin;
    protected List <Mesa> mesas;
    protected List <Mesero> meseros;

    private Heladeria(HeladeriaId idheladeria) {
        super(idheladeria);
        subscribe(new HeladeriaChange(this));
    }

    public Heladeria(HeladeriaId idheladeria, NombreHeladeria nombreHeladeria, TelefonoHeladeria telefonoHeladeria) {
        super(idheladeria);
        appendChange(new HeladeriaCreada(idheladeria, nombreHeladeria, telefonoHeladeria)).apply();
    }

    public static Heladeria from(HeladeriaId idheladeria, List<DomainEvent> events) {
        var heladeria = new Heladeria(idheladeria);
        events.forEach(heladeria::applyEvent);
        return heladeria;
    }

    public void asignarAdmin(AdminId adminId, Nombre nombre, Telefono telefono, Funcion funcion){
        Objects.requireNonNull(adminId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(funcion);
        appendChange(new AdminAsignado(adminId,nombre,telefono,funcion)).apply();
    }

    public void añadirMesero(HeladeriaId idheladeria, MeseroId meseroId, Nombre nombre, Telefono telefono, Funcion funcion){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(meseroId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(funcion);
        appendChange(new MeseroAñadido(idheladeria, meseroId,nombre,telefono,funcion)).apply();
    }

    public void eliminarMesero(HeladeriaId idheladeria, MeseroId meseroId){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(meseroId);
        appendChange(new MeseroEliminado(idheladeria, meseroId)).apply();
    }

    public void añadirMesa(MesaId mesaId, Color color, Ubicacion ubicacion){
        Objects.requireNonNull(mesaId);
        Objects.requireNonNull(color);
        Objects.requireNonNull(ubicacion);
        appendChange(new MesaAñadida(mesaId,color,ubicacion)).apply();
    }

    public void eliminarMesa(HeladeriaId idheladeria, MesaId mesaId){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(mesaId);
        appendChange(new MesaEliminada(idheladeria, mesaId)).apply();
    }

    public void cambiarNombreHeladeria(HeladeriaId idheladeria, NombreHeladeria nombreHeladeria){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(nombreHeladeria);
        appendChange(new NombreHeladeriaCambiado(idheladeria, nombreHeladeria)).apply();
    }

    public void cambiarTelefonoHeladeria(HeladeriaId idheladeria, TelefonoHeladeria telefonoHeladeria){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(telefonoHeladeria);
        appendChange(new TelefonoHeladeriaCambiado(idheladeria, telefonoHeladeria)).apply();
    }

    public HeladeriaId getIdheladeria() {
        return idheladeria;
    }

    public Set<PedidoId> getIdPedidos() {
        return pedidoIds;
    }

    public NombreHeladeria getNombreHeladeria() {
        return nombreHeladeria;
    }

    public TelefonoHeladeria getTelefonoHeladeria() {
        return telefonoHeladeria;
    }

    public Admin getAdmin() {
        return admin;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public List<Mesero> getMeseros() {
        return meseros;
    }
}
