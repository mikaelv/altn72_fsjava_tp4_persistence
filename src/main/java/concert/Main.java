package concert;

import concert.entity.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {
        startH2TCP();
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("concert-pu")) {

            // Peupler la base de données
            populateDatabase(emf);

            // TODO: Appeler les méthodes de requêtes JPQL

            // Attends pour ne pas terminer le programme. Cela permet d'accéder à la BDD
            Thread.sleep(Long.MAX_VALUE);
        }

    }

    private static void startH2TCP() throws SQLException {
        // Démarrer le serveur TCP H2 (pour connexion externe)
        org.h2.tools.Server tcpServer = org.h2.tools.Server
                .createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092")
                .start();

        System.out.println("Serveur H2 TCP démarré sur le port 9092");
        System.out.println("JDBC URL pour IntelliJ: jdbc:h2:tcp://localhost:9092/mem:concertdb");
    }

    private static void populateDatabase(EntityManagerFactory emf) throws SQLException {
        // TODO décommenter le code
        /*
        EntityTransaction tx = null;
        try (EntityManager em = emf.createEntityManager()) {
            tx = em.getTransaction();
            tx.begin();

            // Créer des artistes
            Artist artist1 = new Artist("The Rolling Stones", "Rock", "UK");
            Artist artist2 = new Artist("Daft Punk", "Electronic", "France");
            Artist artist3 = new Artist("Beyoncé", "Pop/R&B", "USA");
            Artist artist4 = new Artist("Metallica", "Metal", "USA");

            // Créer des concerts
            Concert concert1 = new Concert(
                    "The Rolling Stones World Tour",
                    LocalDateTime.of(2025, 6, 15, 20, 0),
                    "Stade de France",
                    "Paris",
                    80000
            );
            artist1.addConcert(concert1);

            Concert concert2 = new Concert(
                    "Daft Punk Reunion",
                    LocalDateTime.of(2025, 7, 20, 21, 0),
                    "Accor Arena",
                    "Paris",
                    20000
            );
            artist2.addConcert(concert2);

            Concert concert3 = new Concert(
                    "Beyoncé Renaissance Tour",
                    LocalDateTime.of(2025, 8, 5, 19, 30),
                    "Groupama Stadium",
                    "Lyon",
                    60000
            );
            artist3.addConcert(concert3);

            Concert concert4 = new Concert(
                    "Metallica - 72 Seasons Tour",
                    LocalDateTime.of(2025, 9, 10, 19, 0),
                    "Paris La Défense Arena",
                    "Paris",
                    40000
            );
            artist4.addConcert(concert4);

            Concert concert5 = new Concert(
                    "The Rolling Stones Acoustic Night",
                    LocalDateTime.of(2025, 6, 17, 20, 30),
                    "Zénith Paris",
                    "Paris",
                    6800
            );
            artist1.addConcert(concert5);

            // Créer des clients
            Customer customer1 = new Customer("Jean", "Dupont", "jean.dupont@email.com");
            customer1.setPhoneNumber("0601020304");

            Customer customer2 = new Customer("Marie", "Martin", "marie.martin@email.com");
            customer2.setPhoneNumber("0612345678");

            Customer customer3 = new Customer("Pierre", "Bernard", "pierre.bernard@email.com");

            Customer customer4 = new Customer("Sophie", "Petit", "sophie.petit@email.com");
            customer4.setPhoneNumber("0698765432");

            // Créer des billets
            Ticket ticket1 = new Ticket("TKT-RS-001", TicketCategory.VIP,
                    new BigDecimal("250.00"), "A12");
            concert1.addTicket(ticket1);
            customer1.addTicket(ticket1);

            Ticket ticket2 = new Ticket("TKT-RS-002", TicketCategory.STANDARD,
                    new BigDecimal("85.00"), "B45");
            concert1.addTicket(ticket2);
            customer1.addTicket(ticket2);

            Ticket ticket3 = new Ticket("TKT-DP-001", TicketCategory.PREMIUM,
                    new BigDecimal("180.00"), "VIP-5");
            concert2.addTicket(ticket3);
            customer2.addTicket(ticket3);

            Ticket ticket4 = new Ticket("TKT-BY-001", TicketCategory.VIP,
                    new BigDecimal("300.00"), "A1");
            concert3.addTicket(ticket4);
            customer3.addTicket(ticket4);

            Ticket ticket5 = new Ticket("TKT-BY-002", TicketCategory.STANDING,
                    new BigDecimal("60.00"), null);
            concert3.addTicket(ticket5);
            customer4.addTicket(ticket5);

            Ticket ticket6 = new Ticket("TKT-MT-001", TicketCategory.PREMIUM,
                    new BigDecimal("150.00"), "C23");
            concert4.addTicket(ticket6);
            customer2.addTicket(ticket6);

            Ticket ticket7 = new Ticket("TKT-RS-003", TicketCategory.STANDARD,
                    new BigDecimal("95.00"), "D12");
            concert5.addTicket(ticket7);
            customer3.addTicket(ticket7);

            // Persister les entités
            em.persist(artist1);
            em.persist(artist2);
            em.persist(artist3);
            em.persist(artist4);
            em.persist(customer1);
            em.persist(customer2);
            em.persist(customer3);
            em.persist(customer4);

            em.getTransaction().commit();
            System.out.println("✓ Base de données peuplée avec succès !");
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            throw e;
        }
         */
    }
}