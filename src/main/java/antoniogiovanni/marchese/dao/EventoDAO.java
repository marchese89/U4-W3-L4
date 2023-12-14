package antoniogiovanni.marchese.dao;

import antoniogiovanni.marchese.entities.Evento;
import antoniogiovanni.marchese.entities.GenereConcerto;
import antoniogiovanni.marchese.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " aggiunto correttamente!");
    }

    public Evento findById(long id) {
        return em.find(Evento.class,id);
    }


    public void findByIdAndDelete(long id) {
        Evento found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Evento " + found.getTitolo() + " eliminato correttamente!");
        } else {
            System.out.println("L'evento con id " + id + " non è stato trovato");
        }


    }

    public List<Evento> getConcertiInStreaming(boolean inStreaming){
        TypedQuery<Evento> getConcertiInStreamQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming",Evento.class);
        getConcertiInStreamQuery.setParameter("inStreaming",inStreaming);
        return getConcertiInStreamQuery.getResultList();
    }

    public List<Evento> getConcertiPerGenere(GenereConcerto genereConcerto){
        TypedQuery<Evento> getConcertiInStreamQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.genereConcerto = :genereConcerto",Evento.class);
        getConcertiInStreamQuery.setParameter("genereConcerto",genereConcerto);
        return getConcertiInStreamQuery.getResultList();
    }

    public List<Evento> getPartiteVinteInCasa(){
        TypedQuery<Evento> getPartiteVinteInCasa = em.createNamedQuery("getPartiteVinteInCasa", Evento.class);
        return getPartiteVinteInCasa.getResultList();
    }
    public List<Evento> getPartiteVinteInTrasferta(){
        TypedQuery<Evento> getPartiteVinteInTrasferta = em.createNamedQuery("getPartiteVinteInTrasferta", Evento.class);
        return getPartiteVinteInTrasferta.getResultList();
    }


    public List<Evento> getPartitePareggiate(){
        TypedQuery<Evento> partitePareggiate = em.createNamedQuery("getPartitePareggiate", Evento.class);
        return partitePareggiate.getResultList();
    }

    public List<Evento> getGareDiAtleticaPerVincitore(Persona vincitore){
        TypedQuery<Evento> gareDiAtleticaPerVincitore = em.createNamedQuery("getGareDiAtleticaPerVincitore", Evento.class);
        gareDiAtleticaPerVincitore.setParameter("vincitore",vincitore);
        return gareDiAtleticaPerVincitore.getResultList();
    }

    public List<Evento> getGareDiAtleticaPerPartecipante(Persona partecipante){
        TypedQuery<Evento> gareDiAtleticaPerPartecipante = em.createNamedQuery("getGareDiAtleticaPerPartecipante", Evento.class);
        gareDiAtleticaPerPartecipante.setParameter("partecipante",partecipante);
        return gareDiAtleticaPerPartecipante.getResultList();
    }

    public List<Evento> getEventiSoldOut(){
        TypedQuery<Evento> eventiSoldOut = em.createNamedQuery("getEventiSoldOut", Evento.class);
        return eventiSoldOut.getResultList();
    }

}
