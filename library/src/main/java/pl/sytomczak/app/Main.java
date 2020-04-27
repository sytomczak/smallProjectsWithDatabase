package pl.sytomczak.app;


import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import pl.sytomczak.app.mappings.Book;
import pl.sytomczak.app.mappings.Reader;
import pl.sytomczak.app.mappings.Rental;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;

public class Main {

    @Getter
    private static Session session;

    @Getter
    private static SessionFactory sessionFactory;


    private static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(Book.class);
        configObj.addAnnotatedClass(Reader.class);
        configObj.addAnnotatedClass(Rental.class);
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactory;
    }

    public static void main(String[] args) {
        session = buildSessionFactory().openSession();
        if (session.isConnected()) {
            System.out.println("Connected to database");
        }

        Book book = getBookById(42);
        Reader reader = getReaderById(38);

        Rental rental = new Rental();
        rental.setBook(book);
        rental.setReader(reader);
        rental.setRentalDate(LocalDateTime.now());

        getSession().beginTransaction();
        getSession().saveOrUpdate(rental);
        getSession().getTransaction().commit();
        getSession().saveOrUpdate(rental);

    }

    private static Book getBookById(int id) {
        try {
            Query<Book> query = getSession().createNamedQuery("getBookById", Book.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    private static Reader getReaderById(int id) {
        try {
            Query<Reader> query = getSession().createNamedQuery("getReaderById", Reader.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
