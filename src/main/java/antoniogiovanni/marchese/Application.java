package antoniogiovanni.marchese;

import antoniogiovanni.marchese.dao.EventoDAO;
import antoniogiovanni.marchese.dao.LocationDAO;
import antoniogiovanni.marchese.dao.PartecipazioneDAO;
import antoniogiovanni.marchese.dao.PersonaDAO;
import antoniogiovanni.marchese.entities.*;
import org.hibernate.type.DateType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-l2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager(); // Entity Manager è responsabile della gestione delle interazioni col DB
        EventoDAO ed = new EventoDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PartecipazioneDAO ppd = new PartecipazioneDAO(em);
        //salvo la persona
        Persona persona = new Persona("NomePersona","CognomePersona","email@email.it",LocalDate.now(), Sesso.M);
        //pd.save(persona);
        //creo un evento
        Evento evento = new Evento("TitoloEvento",LocalDate.now().plusWeeks(3),"descrizione evento",TipoEvento.PUBBLICO,50);

        //aggiungo la location

        Location location = new Location("Location 1","Parigi");
        evento.setLocation(location);
        //ld.save(location);
        //ed.save(evento);

        //trovo la persona con id 2
        //Persona personaFromDB = pd.findById(7);
        //Evento eventoFromDB = ed.findById(9);
        //Partecipazione partecipazione = new Partecipazione(personaFromDB,eventoFromDB,StatoPartecipazione.DA_CONFERMARE);
        //ppd.save(partecipazione);

        //ed.findByIdAndDelete(9);

        //creo un concerto in streaming
        Concerto concerto = new Concerto("Concerto1",LocalDate.now().plusWeeks(3),"descrizione concerto",TipoEvento.PUBBLICO,9000,GenereConcerto.POP,true);
//        ed.save(concerto);
        //concerti in streaming
        System.out.println("-------------------- CONCERTI IN STREAMING -----------------------------");
        ed.getConcertiInStreaming(true).forEach(System.out::println);
        //concerti per genere
        System.out.println("-------------------- CONCERTI PER GENRE (POP) -----------------------------");
        ed.getConcertiPerGenere(GenereConcerto.POP).forEach(System.out::println);

        PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio("Partita di Calcio 1",LocalDate.now().plusMonths(2),"descrizione partita",TipoEvento.PUBBLICO,3000,"Samp","Torino");
        partitaDiCalcio.setGolSquadraDiCasa(3);
        partitaDiCalcio.setGolSquadraOspite(3);
        partitaDiCalcio.setSquadraVincente(null);
        //ed.save(partitaDiCalcio);
        System.out.println("------------------------------ PARTITE VINTE IN CASA ---------------------");
        ed.getPartiteVinteInCasa().forEach(System.out::println);

        System.out.println("------------------------------ PARTITE VINTE IN TRASFERTA ---------------------");

        ed.getPartiteVinteInTrasferta().forEach(System.out::println);

        System.out.println("------------------------------ PARTITE PAREGGIATE ---------------------");

        ed.getPartitePareggiate().forEach(System.out::println);

        //nuova gara di atletica

        GaraDiAtletica garaDiAtletica = new GaraDiAtletica("Gara di atletica",LocalDate.now().plusWeeks(3),"descrizione gara",TipoEvento.PUBBLICO,90);
        //ed.save(garaDiAtletica);
        System.out.println("----------------------------- GARE DI ATLETICA PER VINCITORE -------------------------------");
        ed.getGareDiAtleticaPerVincitore(pd.findById(7)).forEach(System.out::println);

        System.out.println("----------------------------- GARE DI ATLETICA PER PARTECIPANTE -------------------------------");
        ed.getGareDiAtleticaPerPartecipante(pd.findById(7)).forEach(System.out::println);
    }
}
