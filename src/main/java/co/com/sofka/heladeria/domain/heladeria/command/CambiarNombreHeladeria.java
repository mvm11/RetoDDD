package co.com.sofka.heladeria.domain.heladeria.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.heladeria.domain.heladeria.values.HeladeriaId;
import co.com.sofka.heladeria.domain.heladeria.values.NombreHeladeria;

public class CambiarNombreHeladeria implements Command {

    private final HeladeriaId idheladeria;
    private final NombreHeladeria nombreHeladeria;

    public CambiarNombreHeladeria(HeladeriaId idheladeria, NombreHeladeria nombreHeladeria) {
        this.idheladeria = idheladeria;
        this.nombreHeladeria = nombreHeladeria;
    }

    public HeladeriaId getIdheladeria() {
        return idheladeria;
    }

    public NombreHeladeria getNombreHeladeria() {
        return nombreHeladeria;
    }
}
