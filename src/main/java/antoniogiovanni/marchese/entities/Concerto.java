package antoniogiovanni.marchese.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "concerti")
public class Concerto extends Evento{

    @Enumerated(EnumType.STRING)
    @Column(name = "genere_concerto")
    private GenereConcerto genereConcerto;

    @Column(name = "in_streaming")
    private Boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, GenereConcerto genereConcerto, Boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genereConcerto = genereConcerto;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenereConcerto() {
        return genereConcerto;
    }

    public void setGenereConcerto(GenereConcerto genereConcerto) {
        this.genereConcerto = genereConcerto;
    }

    public Boolean getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(Boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return super.toString()+" Concerto{" +
                "genereConcerto=" + genereConcerto +
                ", inStreaming=" + inStreaming +
                "} ";
    }
}
