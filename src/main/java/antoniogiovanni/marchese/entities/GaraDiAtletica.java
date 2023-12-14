package antoniogiovanni.marchese.entities;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "gare_atletica")
public class GaraDiAtletica extends Evento{

    @ManyToMany
    @JoinTable(name = "persone_gare_altetica",
    joinColumns = @JoinColumn(name = "gara_atletica_id"),
    inverseJoinColumns = @JoinColumn(name = "persona_id"))
    Set<Persona> atleti;

    @OneToOne
    @JoinColumn(name = "persona_id")
    Persona vincitore;

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
