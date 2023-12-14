package antoniogiovanni.marchese.dao;

import antoniogiovanni.marchese.entities.Evento;
import antoniogiovanni.marchese.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione di " + partecipazione.getPersona().getNome() + " per l'evento "+ partecipazione.getEvento().getTitolo() +" aggiunto correttamente!");
    }

    public Partecipazione findById(long id) {
        return em.find(Partecipazione.class,id);
    }


    public void findByIdAndDelete(long id) {
        Partecipazione found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Partecipazione di " + found.getPersona().getNome() + " eliminata correttamente!");
        } else {
            System.out.println("Partecipazione con id " + id + " non trovata");
        }


    }
}
