package antoniogiovanni.marchese.dao;

import antoniogiovanni.marchese.entities.Evento;
import antoniogiovanni.marchese.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Location " + location.getNome() + " aggiunta correttamente!");
    }

    public Location findById(long id) {
        return em.find(Location.class,id);
    }


    public void findByIdAndDelete(long id) {
        Location found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Location " + found.getNome() + " eliminata correttamente!");
        } else {
            System.out.println("Location con id " + id + " non trovata");
        }


    }
}
