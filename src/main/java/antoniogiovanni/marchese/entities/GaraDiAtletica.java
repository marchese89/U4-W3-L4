package antoniogiovanni.marchese.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "gare_atletica")
@NamedQuery(name = "getGareDiAtleticaPerVincitore",query = "SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore")
@NamedQuery(name = "getGareDiAtleticaPerPartecipante",query = "SELECT g FROM GaraDiAtletica g WHERE :partecipante MEMBER OF g.atleti")
public class GaraDiAtletica extends Evento{

    @ManyToMany
    @JoinTable(name = "persone_gare_altetica",
    joinColumns = @JoinColumn(name = "gara_atletica_id"),
    inverseJoinColumns = @JoinColumn(name = "persona_id"))
    Set<Persona> atleti;

    @OneToMany
    @JoinColumn(name = "vincitore_id")
    Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
    }

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
