package co.com.sofka.heladeria.domain.heladeria;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.heladeria.domain.genericValues.Funcion;
import co.com.sofka.heladeria.domain.genericValues.Nombre;
import co.com.sofka.heladeria.domain.genericValues.Telefono;
import co.com.sofka.heladeria.domain.heladeria.events.*;
import co.com.sofka.heladeria.domain.heladeria.values.*;
import co.com.sofka.heladeria.domain.heladeria.entity.Admin;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesa;
import co.com.sofka.heladeria.domain.heladeria.entity.Mesero;
import co.com.sofka.heladeria.domain.pedido.PedidoChange;
import co.com.sofka.heladeria.domain.pedido.values.IdPedido;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Heladeria extends AggregateEvent<IdHeladeria> {

    protected IdHeladeria idheladeria;
    protected Set <IdPedido> idPedidos;
    protected NombreHeladeria nombreHeladeria;
    protected TelefonoHeladeria telefonoHeladeria;
    protected Admin admin;
    protected List <Mesa> mesas;
    protected List <Mesero> meseros;

    private Heladeria(IdHeladeria idheladeria) {
        super(idheladeria);
        subscribe(new HeladeriaChange(this));
    }

    public Heladeria(IdHeladeria idheladeria, NombreHeladeria nombreHeladeria, TelefonoHeladeria telefonoHeladeria) {
        super(idheladeria);
        appendChange(new HeladeriaCreada(idheladeria, nombreHeladeria, telefonoHeladeria)).apply();
    }

    public static Heladeria from(IdHeladeria idheladeria, List<DomainEvent> events) {
        var heladeria = new Heladeria(idheladeria);
        events.forEach(heladeria::applyEvent);
        return heladeria;
    }

    public void asignarAdmin(IdHeladeria idheladeria, IdAdmin idAdmin, Nombre nombre, Telefono telefono, Funcion funcion){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(idAdmin);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(funcion);
        appendChange(new AdminAsignado(idheladeria, idAdmin,nombre,telefono,funcion)).apply();
    }

    public void añadirMesero(IdHeladeria idheladeria, IdMesero idMesero, Nombre nombre, Telefono telefono, Funcion funcion){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(idMesero);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(funcion);
        appendChange(new MeseroAñadido(idheladeria,idMesero,nombre,telefono,funcion)).apply();
    }

    public void eliminarMesero(IdHeladeria idheladeria, IdMesero idMesero){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(idMesero);
        appendChange(new MeseroEliminado(idheladeria, idMesero)).apply();
    }

    public void añadirMesa(IdHeladeria idheladeria, IdMesa idMesa, Color color, Ubicacion ubicacion){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(idMesa);
        Objects.requireNonNull(color);
        Objects.requireNonNull(ubicacion);
        appendChange(new MesaAñadida(idheladeria,idMesa,color,ubicacion)).apply();
    }

    public void eliminarMesa(IdHeladeria idheladeria, IdMesa idMesa){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(idMesa);
        appendChange(new MesaEliminada(idheladeria, idMesa)).apply();
    }

    public void cambiarNombreHeladeria(IdHeladeria idheladeria, NombreHeladeria nombreHeladeria){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(nombreHeladeria);
        appendChange(new NombreHeladeriaCambiado(idheladeria, nombreHeladeria)).apply();
    }

    public void cambiarNombreTelefono(IdHeladeria idheladeria, TelefonoHeladeria telefonoHeladeria){
        Objects.requireNonNull(idheladeria);
        Objects.requireNonNull(telefonoHeladeria);
        appendChange(new TelefonoHeladeriaCambiado(idheladeria, telefonoHeladeria)).apply();
    }

    public IdHeladeria getIdheladeria() {
        return idheladeria;
    }

    public Set<IdPedido> getIdPedidos() {
        return idPedidos;
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
