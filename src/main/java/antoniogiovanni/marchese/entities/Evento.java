package antoniogiovanni.marchese.entities;

import org.hibernate.type.DateType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "getEventiSoldOut",query = "SELECT e FROM Evento e WHERE (SELECT COUNT(p) FROM Partecipazione p WHERE p.evento = e) = e.numeroMassimoPartecipanti")
public class Evento {
    @Id
    @GeneratedValue
    private long id;
    private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    private String descrizione;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    // Di default gli enum vengono convertiti in numeri interi, se voglio che essi siano invece Stringhe devo usare @Enumerated
    private TipoEvento tipoEvento;
    @Column(name = "num_max_partecipanti")
    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
    private List<Partecipazione> listaPartecipazioni;
    @ManyToOne
    @JoinColumn(name = "luogo_evento_id")
    private Location location;

    public Evento(){

    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
