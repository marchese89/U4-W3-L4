package antoniogiovanni.marchese.entities;

import javax.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String citta;


    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public Location() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
//                ", evento=" + evento +
                '}';
    }
}
